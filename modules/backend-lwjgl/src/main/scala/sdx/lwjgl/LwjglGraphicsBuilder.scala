package sdx.lwjgl

import cats.effect.kernel.Ref
import cats.effect.kernel.Sync
import cats.syntax.all._
import com.badlogic.gdx.Application.ApplicationType
import com.badlogic.gdx.Graphics.BufferFormat
import com.badlogic.gdx.backends.lwjgl.newLwjglGL20
import com.badlogic.gdx.backends.lwjgl.newLwjglGL30
import com.badlogic.gdx.graphics.glutils.GLVersion
import com.badlogic.gdx.utils.GdxRuntimeException
import org.lwjgl.opengl
import org.lwjgl.opengl.GL11
import sdx.graphics.GL20
import sdx.graphics.GL30

import java.awt.Canvas
import scala.annotation.tailrec

final class LwjglGraphicsBuilder[F[_]: Sync](
    canvas: Option[Canvas],
    isUndecorated: Boolean,
    isVSyncEnabled: Boolean,
    isResizable: Boolean,
    isGL30Enabled: Boolean,
    gles30ContextMinorVersion: Int,
    gles30ContextMajorVersion: Int,
    width: Int,
    height: Int,
) {

  private def extractVersion: F[GLVersion] = for {
    version <- Sync[F].delay(GL11.glGetString(GL11.GL_VERSION))
    vendor <- Sync[F].delay(GL11.glGetString(GL11.GL_VENDOR))
    renderer <- Sync[F].delay(GL11.glGetString(GL11.GL_RENDERER))
  } yield new GLVersion(ApplicationType.Desktop, version, vendor, renderer)

  private def extractExtensions(glVersion: GLVersion): F[Set[String]] = {
    @tailrec def extract(i: Int, max: Int, extensions: List[F[String]]): List[F[String]] =
      if (i < max)
        extract(i + 1, max, Sync[F].delay(opengl.GL30.glGetStringi(GL20.GL_EXTENSIONS, i)) :: extensions)
      else
        extensions

    if (glVersion.isVersionEqualToOrHigher(3, 2))
      Sync[F]
        .delay(GL11.glGetInteger(opengl.GL30.GL_NUM_EXTENSIONS))
        .flatMap(extensions => extract(0, extensions, Nil).sequence.map(_.toSet))
    else
      Sync[F]
        .delay(GL11.glGetString(GL20.GL_EXTENSIONS).split(" "))
        .map(_.toSet)
  }

  private def supportsFBO(glVersion: GLVersion, extensions: Set[String]) =
    glVersion.isVersionEqualToOrHigher(3, 0) ||
      extensions.contains("GL_EXT_framebuffer_object") ||
      extensions.contains("GL_ARB_framebuffer_object")

  private def initiateGLInstances(
      glVersion: GLVersion,
      extensions: Set[String],
  ): F[(Ref[F, Option[GL20[F]]], Ref[F, Option[GL30[F]]])] =
    if (isGL30Enabled) {
      val gl30: GL30[F] = new LwjglGL30[F](newLwjglGL20, newLwjglGL30)
      val gl20: GL20[F] = gl30
      for {
        x <- Ref[F].of(gl20.some)
        y <- Ref[F].of(Some[GL30[F]](gl30): Option[GL30[F]])
      } yield x -> y
    } else if (!glVersion.isVersionEqualToOrHigher(2, 0))
      Sync[F].raiseError(
        new GdxRuntimeException(s"OpenGL 2.0 or higher with the FBO extension is required. OpenGL version: ${GL11
          .glGetString(GL11.GL_VERSION)}\n${glVersion.getDebugVersionString}"),
      )
    else if (!supportsFBO(glVersion, extensions))
      Sync[F].raiseError(
        new GdxRuntimeException(s"OpenGL 2.0 or higher with the FBO extension is required. OpenGL version: ${GL11
          .glGetString(GL11.GL_VERSION)}, FBO extension: false${glVersion.getDebugVersionString}"),
      )
    else
      for {
        gl20 <- Ref[F].of(Some(new LwjglGL20[F](newLwjglGL20)): Option[GL20[F]])
        gl30 <- Ref[F].of(None: Option[GL30[F]])
      } yield gl20 -> gl30

  private def createDisplayPixelFormat(
      useGL30: Boolean,
      gles30ContextMajor: Int,
      gles30ContextMinor: Int,
  ): F[BufferFormat] = ???

  def build: F[LwjglGraphics[F]] = for {
    frameId <- Ref[F].of(0L)
    shouldResetDeltaTime <- Ref[F].of(false)
    shouldResize <- Ref[F].of(false)
    shouldForceDisplayModeChange <- Ref[F].of(false)
    isUndecorated <- Ref[F].of(this.isUndecorated)
    isVSyncEnabled <- Ref[F].of(this.isVSyncEnabled)
    isContinuous <- Ref[F].of(true)
    isRenderingRequested <- Ref[F].of(false)
    isSoftwareMode <- Ref[F].of(false)
    isResizable <- Ref[F].of(this.isResizable)
    deltaTime <- Ref[F].of(0f)
    width <- Ref[F].of(this.width)
    height <- Ref[F].of(this.height)
    frames <- Ref[F].of(0)
    framesPerSecond <- Ref[F].of(0)
    frameStart <- Ref[F].of(0L)
    lastTime <- Ref[F].of(0L)
    foregroundFPS <- Ref[F].of(0)
    glVersion <- extractVersion
    extensions <- extractExtensions(glVersion)
    (gl20, gl30) <- initiateGLInstances(glVersion, extensions)
    bufferFormat <- createDisplayPixelFormat(isGL30Enabled, gles30ContextMajorVersion, gles30ContextMinorVersion)
  } yield new LwjglGraphics[F](
    canvas = this.canvas,
    frameId = frameId,
    shouldResetDeltaTime = shouldResetDeltaTime,
    shouldResize = shouldResize,
    shouldForceDisplayModeChange = shouldForceDisplayModeChange,
    isUndecorated = isUndecorated,
    isVSyncEnabled = isVSyncEnabled,
    isContinuous = isContinuous,
    isRenderingRequested = isRenderingRequested,
    isInSoftwareMode = isSoftwareMode,
    isResizable = isResizable,
    deltaTime = deltaTime,
    width = width,
    height = height,
    frames = frames,
    framesPerSecond = framesPerSecond,
    frameStart = frameStart,
    lastTime = lastTime,
    foregroundFPS = foregroundFPS,
    glVersion = glVersion,
    extensions = extensions,
    gl20 = gl20,
    gl30 = gl30,
    bufferFormat = bufferFormat,
  )
}

object LwjglGraphicsBuilder {

  def default[F[_]: Sync]: LwjglGraphicsBuilder[F] = new LwjglGraphicsBuilder[F](
    canvas = None,
    isUndecorated = false,
    isVSyncEnabled = true,
    isResizable = true,
    isGL30Enabled = false,
    gles30ContextMinorVersion = 2,
    gles30ContextMajorVersion = 3,
    width = 640,
    height = 480,
  )
}
