/**
 * Copyright (c) 2021 scalagdx
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 * This product includes software developed at libGDX (https://libgdx.com/).
 */
package sdx.lwjgl

import cats.effect.kernel.Ref
import cats.effect.kernel.Sync
import cats.syntax.all._
import com.badlogic.gdx.Graphics.BufferFormat
import com.badlogic.gdx.Graphics.DisplayMode
import com.badlogic.gdx.Graphics.GraphicsType
import com.badlogic.gdx.Graphics.Monitor
import com.badlogic.gdx.backends.lwjgl.LwjglCursor
import com.badlogic.gdx.backends.lwjgl.LwjglCursorOps
import com.badlogic.gdx.graphics.Cursor
import com.badlogic.gdx.graphics.Pixmap
import com.badlogic.gdx.graphics.glutils.GLVersion
import com.badlogic.gdx.utils.GdxRuntimeException
import com.badlogic.gdx.utils.SharedLibraryLoader
import fs2.Stream
import org.lwjgl.LWJGLException
import org.lwjgl.input.Mouse
import org.lwjgl.opengl.Display
import org.lwjgl.opengl.{DisplayMode => GLDisplayMode}
import sdx.AbstractGraphics
import sdx.graphics.GL20
import sdx.graphics.GL30

import java.awt.Canvas
import java.awt.Toolkit

/**
 * The lwjgl2 implementation which encapsulates communication with the graphics processor.
 *
 * @param canvas The awt canvas, if it is being used.
 * @param frameId A reference to the current frame id.
 * @param shouldResetDeltaTime A flag for keeping track of resetting the delta time.
 * @param shouldResize A flag for keeping track if the window should resize.
 * @param shouldForceDisplayModeChange A flag for keeping track if the display mode needs to be changed.
 * @param isResizable A flag for if the window is resizable or not.
 * @param isUndecorated A flag for if the window is undecorated or not.
 * @param isVSyncEnabled A flag for if vsync is enabled.
 * @param isContinuous A flag for if rendering should be continuous.
 * @param isRenderingRequested A flag for if rendering is requested.
 * @param isInSoftwareMode A flag for if openGL is in software mode
 * @param deltaTime A reference to the time between the previous and current frame.
 * @param width The width of the window.
 * @param height The height of the window.
 * @param gl20 The gl20 instance.
 * @param gl30 The gl30 instance.
 * @param frames A reference to a frame counter.
 * @param framesPerSecond A reference to the average number of frames per second.
 * @param frameStart A reference to the starting time of a frame.
 * @param lastTime A reference to the last frame's time.
 * @param foregroundFPS A reference to the desired foreground FPS.
 * @param glVersion The GL version.
 * @param bufferFormat The buffer format.
 * @param extensions The extensions.
 */
final class LwjglGraphics[F[_]: Sync](
    canvas: Option[Canvas],
    frameId: Ref[F, Long],
    shouldResetDeltaTime: Ref[F, Boolean],
    shouldResize: Ref[F, Boolean],
    shouldForceDisplayModeChange: Ref[F, Boolean],
    isResizable: Ref[F, Boolean],
    isUndecorated: Ref[F, Boolean],
    isVSyncEnabled: Ref[F, Boolean],
    isContinuous: Ref[F, Boolean],
    isRenderingRequested: Ref[F, Boolean],
    isInSoftwareMode: Ref[F, Boolean],
    deltaTime: Ref[F, Float],
    width: Ref[F, Int],
    height: Ref[F, Int],
    gl20: Ref[F, Option[GL20[F]]],
    gl30: Ref[F, Option[GL30[F]]],
    frames: Ref[F, Int],
    framesPerSecond: Ref[F, Int],
    frameStart: Ref[F, Long],
    lastTime: Ref[F, Long],
    foregroundFPS: Ref[F, Int],
    glVersion: GLVersion,
    bufferFormat: BufferFormat,
    extensions: Set[String],
) extends AbstractGraphics[F] {

  /**
   * Sets the delta time to 0 on the next frame.
   */
  val resetDeltaTime: F[Unit] = shouldResetDeltaTime.set(true)

  /**
   * Sets hte width of the window.
   *
   * @param width The new width.
   */
  def setWidth(width: Int): F[Unit] = this.width.set(width)

  /**
   * Sets the height of the window.
   *
   * @param height The new height.
   */
  def setHeight(height: Int): F[Unit] = this.height.set(height)

  /**
   * Checks if GL20 is available.
   *
   * @return True if OpenGL ES 2.0 is available, false otherwise.
   */
  val isGL20Available: F[Boolean] = gl20.get.map(_.isDefined)

  /**
   * Updates the previous time, current time, and frames
   */
  val updateTime: F[Unit] = for {
    shouldReset <- shouldResetDeltaTime.get
    lastTime <- this.lastTime.get
    currentTime <- Sync[F].delay(System.nanoTime())
    time = if (shouldReset) lastTime else currentTime
    frameStart <- this.frameStart.get
    frames <- this.frames.get
    _ <- deltaTime.set((time - lastTime) / 1000000000f)
    _ <- this.lastTime.set(time)
    _ <-
      if (time - frameStart >= 1000000000)
        for {
          _ <- this.framesPerSecond.set(frames)
          _ <- this.frames.set(0)
          _ <- this.frameStart.set(time)
        } yield ()
      else Sync[F].unit
    _ <- this.frames.update(_ + 1)
  } yield ()

  /**
   * Checks if rendering is required.
   */
  val shouldRender: F[Boolean] = for {
    requestRendering <- isRenderingRequested.getAndSet(false)
    isContinuous <- this.isContinuous.get
    isDirty <- Sync[F].delay(Display.isDirty())
  } yield requestRendering || isContinuous || isDirty

  /**
   * Checks if openGL is in software mode.
   */
  val isSoftwareMode: F[Boolean] = isInSoftwareMode.get

  override val isGL30Available: F[Boolean] = gl30.get.map(_.isDefined)

  override val getGL20: F[Option[GL20[F]]] = gl20.get

  override val getGL30: F[Option[GL30[F]]] = gl30.get

  override def setGL20(gl20: GL20[F]): F[Unit] = this.gl20.set(Some(gl20))

  override def setGL30(gl30: GL30[F]): F[Unit] = this.gl30.set(Some(gl30))

  override def getWidth: F[Int] = ???

  override val getHeight: F[Int] = canvas match {
    case Some(value) =>
      Sync[F].delay(value.getHeight()).map(math.max(1, _))
    case None =>
      for {
        height <- Sync[F].delay(Display.getHeight())
        pixelScaleFactor <- Sync[F].delay(Display.getPixelScaleFactor())
      } yield (height * pixelScaleFactor).toInt
  }

  override val getBackBufferWidth: F[Int] = getWidth

  override val getBackBufferHeight: F[Int] = getHeight

  override val getSafeInsetLeft: F[Int] = Sync[F].pure(0)

  override val getSafeInsetTop: F[Int] = Sync[F].pure(0)

  override val getSafeInsetBottom: F[Int] = Sync[F].pure(0)

  override val getSafeInsetRight: F[Int] = Sync[F].pure(0)

  override val getFrameId: F[Long] = frameId.get

  override val getDeltaTime: F[Float] = deltaTime.get

  override val getFramesPerSecond: F[Int] = framesPerSecond.get

  override val getType: GraphicsType = GraphicsType.LWJGL

  override val getGLVersion: GLVersion = glVersion

  private val screenResolution =
    Sync[F]
      .delay(Toolkit.getDefaultToolkit())
      .map(_.getScreenResolution().toFloat)

  override val getPpiX: F[Float] = screenResolution

  override val getPpiY: F[Float] = screenResolution

  override val getPpcX: F[Float] = getPpiX.map(_ / 2.54f)

  override val getPpcY: F[Float] = getPpiY.map(_ / 2.54f)

  override val supportsDisplayModeChange: Boolean = true

  override val getPrimaryMonitor: F[Monitor] = Sync[F].pure(new LwjglMonitor(0, 0, "Primary Monitor"))

  override val getMonitor: F[Monitor] = getPrimaryMonitor

  override val getMonitors: Stream[F, Monitor] = Stream.eval(getPrimaryMonitor)

  private def toLwjglDisplayMode(mode: GLDisplayMode) =
    new LwjglDisplayMode(mode.getWidth, mode.getHeight, mode.getFrequency, mode.getBitsPerPixel, mode)

  override val getDisplayModes: Stream[F, DisplayMode] =
    Stream
      .eval(Sync[F].delay(Display.getAvailableDisplayModes()))
      .flatMap { availableDisplayModes =>
        val displayModes = availableDisplayModes
          .withFilter(_.isFullscreenCapable)
          .map(toLwjglDisplayMode)
        Stream(displayModes.toSeq: _*)
      }
      .recoverWith { case _: LWJGLException =>
        Stream.raiseError(new GdxRuntimeException("Couldn't fetch available display modes."))
      }

  override def getDisplayModes(monitor: Monitor): Stream[F, DisplayMode] = getDisplayModes

  override val getDisplayMode: F[DisplayMode] =
    Sync[F]
      .delay(Display.getDesktopDisplayMode())
      .map(toLwjglDisplayMode)

  override def getDisplayMode(monitor: Monitor): F[DisplayMode] = getDisplayMode

  override def setFullscreenMode(displayMode: DisplayMode): F[Boolean] = displayMode match {
    case LwjglDisplayMode(_, _, _, _, mode) =>
      (
        for {
          _ <-
            if (mode.isFullscreenCapable) Sync[F].delay(Display.setDisplayMode(mode))
            else Sync[F].delay(Display.setDisplayModeAndFullscreen(mode))
          scaleFactor <- Sync[F].delay(Display.getPixelScaleFactor())
          _ <- setWidth((mode.getWidth * scaleFactor).toInt)
          width <- getWidth
          height <- getHeight
          gl20 <- getGL20
          _ <- shouldResize.set(true)
          _ <- gl20 match {
            case Some(value) => value.glViewport(0, 0, width, height)
            case None => Sync[F].unit
          }
        } yield true
      ).recover { case _: LWJGLException => false }
    case _ => Sync[F].pure(false)
  }

  override def setWindowedMode(width: Int, height: Int): F[Boolean] = for {
    currentWidth <- getWidth
    currentHeight <- getHeight
    isFullScreen <- Sync[F].delay(Display.isFullscreen())
    displaySizeUnchanged = width === currentWidth && height === currentHeight && !isFullScreen
    shouldForceDisplayModeChange <- this.shouldForceDisplayModeChange.get
    result <-
      if (displaySizeUnchanged && !shouldForceDisplayModeChange) true.pure
      else
        (
          for {
            _ <- this.shouldForceDisplayModeChange.set(false)
            displayMode = new GLDisplayMode(width, height)
            isResizable <- this.isResizable.getAndSet(true)
            _ <- Sync[F].delay(Display.setDisplayMode(displayMode))
            _ <- Sync[F].delay(Display.setFullscreen(false))
            _ <- Sync[F].delay(Display.setResizable(isResizable))
            scaleFactor <- Sync[F].delay(Display.getPixelScaleFactor())
            newWidth = (displayMode.getWidth * scaleFactor).toInt
            newHeight = (displayMode.getHeight * scaleFactor).toInt
            _ <- this.width.set(newWidth)
            _ <- this.height.set(newHeight)
            gl20 <- this.gl20.get
            _ <- gl20 match {
              case Some(value) => value.glViewport(0, 0, newWidth, newHeight)
              case None => Sync[F].unit
            }
          } yield true
        ).recover { case _: LWJGLException => false }
  } yield result

  override def setTitle(title: String): F[Unit] = Sync[F].delay(Display.setTitle(title))

  override def setUndecorated(undecorated: Boolean): F[Unit] = for {
    _ <- Sync[F].delay(System.setProperty("org.lwjgl.opengl.Window.undecorated", undecorated.show))
    _ <- isUndecorated.set(undecorated)
    _ <- shouldForceDisplayModeChange.set(true)
  } yield ()

  override def setResizable(resizable: Boolean): F[Unit] =
    isResizable.set(resizable) *> Sync[F].delay(Display.setResizable(resizable))

  override def setVSync(vsync: Boolean): F[Unit] =
    isVSyncEnabled.set(vsync) *> Sync[F].delay(Display.setVSyncEnabled(vsync))

  override def setForegroundFPS(fps: Int): F[Unit] = foregroundFPS.set(fps)

  override val getBufferFormat: BufferFormat = bufferFormat

  override def supportsExtension(extension: String): F[Boolean] = extensions.contains(extension).pure

  override def setContinuousRendering(isContinuous: Boolean): F[Unit] = this.isContinuous.set(isContinuous)

  override val isContinuousRendering: F[Boolean] = isContinuous.get

  override val requestRendering: F[Unit] = isRenderingRequested.set(true)

  override val isFullscreen: F[Boolean] = Sync[F].delay(Display.isFullscreen())

  override def newCursor(pixmap: Pixmap, xHotspot: Int, yHotspot: Int): Cursor =
    new LwjglCursor(pixmap, xHotspot, yHotspot)

  override def setCursor(cursor: Cursor): F[Unit] = for {
    nativeCursor <- cursor match {
      case c: LwjglCursor => c.pure
      case _ => Sync[F].raiseError(new GdxRuntimeException("Invalid cursor."))
    }
    isMac <- Sync[F].delay(SharedLibraryLoader.isMac)
    _ <-
      if (isMac) Sync[F].unit
      else
        Sync[F]
          .delay(Mouse.setNativeCursor(nativeCursor.lwjglCursor))
          .recoverWith { case _: LWJGLException =>
            Sync[F].raiseError(new GdxRuntimeException("Couldn't set system cursor."))
          }
  } yield ()

  @SuppressWarnings(Array("org.wartremover.warts.Null"))
  override def setSystemCursor(systemCursor: Cursor.SystemCursor): F[Unit] = for {
    isMac <- Sync[F].delay(SharedLibraryLoader.isMac)
    _ <-
      if (isMac) Sync[F].unit
      else
        Sync[F]
          .delay(Mouse.setNativeCursor(null))
          .recoverWith { case _: LWJGLException =>
            Sync[F].raiseError(new GdxRuntimeException("Couldn't set system cursor."))
          }
  } yield ()
}
