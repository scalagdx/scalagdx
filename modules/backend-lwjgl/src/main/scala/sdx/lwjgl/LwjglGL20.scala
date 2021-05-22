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

import cats.effect.kernel.Sync
import com.badlogic.gdx.graphics.{GL20 => GdxGL20}
import sdx.graphics.GL20

import java.nio.Buffer
import java.nio.FloatBuffer
import java.nio.IntBuffer

class LwjglGL20[F[_]: Sync](gl: GdxGL20) extends GL20[F] {

  override def glActiveTexture(texture: Int): F[Unit] = Sync[F].delay(gl.glActiveTexture(texture))

  override def glBindTexture(target: Int, texture: Int): F[Unit] = Sync[F].delay(gl.glBindTexture(target, texture))

  override def glClear(mask: Int): F[Unit] = Sync[F].delay(gl.glClear(mask))

  override def glClearColor(r: Float, g: Float, b: Float, a: Float): F[Unit] =
    Sync[F].delay(gl.glClearColor(r, g, b, a))

  override def glClearDepthf(depth: Float): F[Unit] = Sync[F].delay(gl.glClearDepthf(depth))

  override def glClearStencil(s: Int): F[Unit] = Sync[F].delay(gl.glClearStencil(s))

  override def glColorMask(r: Boolean, g: Boolean, b: Boolean, a: Boolean): F[Unit] =
    Sync[F].delay(gl.glColorMask(r, g, b, a))

  override def glCompressedTexImage2D(
      target: Int,
      level: Int,
      internalFormat: Int,
      width: Int,
      height: Int,
      format: Int,
      imageSize: Int,
      data: Buffer,
  ): F[Unit] =
    Sync[F].delay(gl.glCompressedTexImage2D(target, level, internalFormat, width, height, format, imageSize, data))

  override def glCompressedTexSubImage2D(
      target: Int,
      level: Int,
      xOffset: Int,
      yOffset: Int,
      width: Int,
      height: Int,
      format: Int,
      imageSize: Int,
      data: Buffer,
  ): F[Unit] =
    Sync[F].delay(gl.glCompressedTexSubImage2D(target, level, xOffset, yOffset, width, height, format, imageSize, data))

  override def glCopyTexImage2D(
      target: Int,
      level: Int,
      intervalFormat: Int,
      x: Int,
      y: Int,
      width: Int,
      height: Int,
      border: Int,
  ): F[Unit] =
    Sync[F].delay(gl.glCopyTexImage2D(target, level, intervalFormat, x, y, width, height, border))

  override def glCopyTexSubImage2D(
      target: Int,
      level: Int,
      xOffset: Int,
      yOffset: Int,
      x: Int,
      y: Int,
      width: Int,
      height: Int,
  ): F[Unit] =
    Sync[F].delay(gl.glCopyTexSubImage2D(target, level, xOffset, yOffset, x, y, width, height))

  override def glCullFace(mode: Int): F[Unit] = Sync[F].delay(gl.glCullFace(mode))

  override def glDeleteTextures(n: Int, textures: IntBuffer): F[Unit] = Sync[F].delay(gl.glDeleteTextures(n, textures))

  override def glDeleteTexture(texture: Int): F[Unit] = Sync[F].delay(gl.glDeleteTexture(texture))

  override def glDepthFunc(func: Int): F[Unit] = Sync[F].delay(gl.glDepthFunc(func))

  override def glDepthMask(flag: Boolean): F[Unit] = Sync[F].delay(gl.glDepthMask(flag))

  override def glDepthRangef(zNear: Float, zFar: Float): F[Unit] = Sync[F].delay(gl.glDepthRangef(zNear, zFar))

  override def glDisable(cap: Int): F[Unit] = Sync[F].delay(gl.glDisable(cap))

  override def glDrawArrays(mode: Int, first: Int, count: Int): F[Unit] =
    Sync[F].delay(gl.glDrawArrays(mode, first, count))

  override def glDrawElements(mode: Int, count: Int, `type`: Int, indices: Buffer): F[Unit] =
    Sync[F].delay(gl.glDrawElements(mode, count, `type`, indices))

  override def glEnable(cap: Int): F[Unit] = Sync[F].delay(gl.glEnable(cap))

  override val glFinish: F[Unit] = Sync[F].delay(gl.glFinish())

  override val glFlush: F[Unit] = Sync[F].delay(gl.glFlush())

  override def glFrontFace(mode: Int): F[Unit] = Sync[F].delay(gl.glFrontFace(mode))

  override def glGenTextures(n: Int, textures: IntBuffer): F[Unit] = Sync[F].delay(gl.glGenTextures(n, textures))

  override val glGenTexture: F[Int] = Sync[F].delay(gl.glGenTexture())

  override val glGetError: F[Int] = Sync[F].delay(gl.glGetError())

  override def glGetIntegerv(pname: Int, params: IntBuffer): F[Unit] = Sync[F].delay(gl.glGetIntegerv(pname, params))

  override def glGetString(name: Int): F[String] = Sync[F].delay(gl.glGetString(name))

  override def glHint(target: Int, mode: Int): F[Unit] = Sync[F].delay(gl.glHint(target, mode))

  override def glLineWidth(width: Float): F[Unit] = Sync[F].delay(gl.glLineWidth(width))

  override def glPixelStorei(pname: Int, param: Int): F[Unit] = Sync[F].delay(gl.glPixelStorei(pname, param))

  override def glPolygonOffset(factor: Float, units: Float): F[Unit] = Sync[F].delay(gl.glPolygonOffset(factor, units))

  override def glReadPixels(
      x: Int,
      y: Int,
      width: Int,
      height: Int,
      format: Int,
      `type`: Int,
      pixels: Buffer,
  ): F[Unit] = Sync[F].delay(gl.glReadPixels(x, y, width, height, format, `type`, pixels))

  override def glScissor(x: Int, y: Int, width: Int, height: Int): F[Unit] =
    Sync[F].delay(gl.glScissor(x, y, width, height))

  override def glStencilFunc(func: Int, ref: Int, mask: Int): F[Unit] =
    Sync[F].delay(gl.glStencilFunc(func, ref, mask))

  override def glStencilMask(mask: Int): F[Unit] = Sync[F].delay(gl.glStencilMask(mask))

  override def glStencilOp(fail: Int, zfail: Int, zpass: Int): F[Unit] =
    Sync[F].delay(gl.glStencilOp(fail, zfail, zpass))

  override def glTexImage2D(
      target: Int,
      level: Int,
      internalFormat: Int,
      width: Int,
      height: Int,
      border: Int,
      format: Int,
      `type`: Int,
      pixels: Buffer,
  ): F[Unit] =
    Sync[F].delay(gl.glTexImage2D(target, level, internalFormat, width, height, border, format, `type`, pixels))

  override def glTexParameterf(target: Int, pname: Int, param: Float): F[Unit] =
    Sync[F].delay(gl.glTexParameterf(target, pname, param))

  override def glTexSubImage2D(
      target: Int,
      level: Int,
      xOffset: Int,
      yOffset: Int,
      width: Int,
      height: Int,
      format: Int,
      `type`: Int,
      pixels: Buffer,
  ): F[Unit] =
    Sync[F].delay(gl.glTexSubImage2D(target, level, xOffset, yOffset, width, height, format, `type`, pixels))

  override def glViewport(x: Int, y: Int, width: Int, height: Int): F[Unit] =
    Sync[F].delay(gl.glViewport(x, y, width, height))

  override def glAttachShader(program: Int, shader: Int): F[Unit] =
    Sync[F].delay(gl.glAttachShader(program, shader))

  override def glBindAttribLocation(program: Int, index: Int, name: String): F[Unit] =
    Sync[F].delay(gl.glBindAttribLocation(program, index, name))

  override def glBindBuffer(target: Int, buffer: Int): F[Unit] = Sync[F].delay(gl.glBindBuffer(target, buffer))

  override def glBindFramebuffer(target: Int, framebuffer: Int): F[Unit] =
    Sync[F].delay(gl.glBindFramebuffer(target, framebuffer))

  override def glBindRenderbuffer(target: Int, renderbuffer: Int): F[Unit] =
    Sync[F].delay(gl.glBindRenderbuffer(target, renderbuffer))

  override def glBlendColor(r: Float, g: Float, b: Float, a: Float): F[Unit] =
    Sync[F].delay(gl.glBlendColor(r, g, b, a))

  override def glBlendEquation(mode: Int): F[Unit] = Sync[F].delay(gl.glBlendEquation(mode))

  override def glBlendEquationSeparate(modeRGB: Int, modeAlpha: Int): F[Unit] =
    Sync[F].delay(gl.glBlendEquationSeparate(modeRGB, modeAlpha))

  override def glBlendFuncSeparate(srcRGB: Int, dstRGB: Int, srcAlpha: Int, dstAlpha: Int): F[Unit] =
    Sync[F].delay(gl.glBlendFuncSeparate(srcRGB, dstRGB, srcAlpha, dstAlpha))

  override def glBufferData(target: Int, size: Int, data: Buffer, usage: Int): F[Unit] =
    Sync[F].delay(gl.glBufferData(target, size, data, usage))

  override def glBufferSubData(target: Int, offset: Int, size: Int, data: Buffer): F[Unit] =
    Sync[F].delay(gl.glBufferSubData(target, offset, size, data))

  override def glCheckFramebufferStatus(target: Int): F[Int] =
    Sync[F].delay(gl.glCheckFramebufferStatus(target))

  override def glCompileShader(shader: Int): F[Unit] = Sync[F].delay(gl.glCompileShader(shader))

  override def glCreateProgram: F[Int] = Sync[F].delay(gl.glCreateProgram)

  override def glCreateShader(`type`: Int): F[Int] = Sync[F].delay(gl.glCreateShader(`type`))

  override def glDeleteBuffer(buffer: Int): F[Unit] = Sync[F].delay(gl.glDeleteBuffer(buffer))

  override def glDeleteBuffers(n: Int, buffers: IntBuffer): F[Unit] = Sync[F].delay(gl.glDeleteBuffers(n, buffers))

  override def glDeleteFramebuffer(framebuffer: Int): F[Unit] = Sync[F].delay(gl.glDeleteFramebuffer(framebuffer))

  override def glDeleteFramebuffers(n: Int, framebuffers: IntBuffer): F[Unit] =
    Sync[F].delay(gl.glDeleteFramebuffers(n, framebuffers))

  override def glDeleteProgram(program: Int): F[Unit] = Sync[F].delay(gl.glDeleteProgram(program))

  override def glDeleteRenderbuffer(renderbuffer: Int): F[Unit] = Sync[F].delay(gl.glDeleteRenderbuffer(renderbuffer))

  override def glDeleteRenderbuffers(n: Int, renderbuffers: IntBuffer): F[Unit] =
    Sync[F].delay(gl.glDeleteRenderbuffers(n, renderbuffers))

  override def glDeleteShader(shader: Int): F[Unit] = Sync[F].delay(gl.glDeleteShader(shader))

  override def glDetachShader(program: Int, shader: Int): F[Unit] = Sync[F].delay(gl.glDetachShader(program, shader))

  override def glDisableVertexAttribArray(index: Int): F[Unit] = Sync[F].delay(gl.glDisableVertexAttribArray(index))

  override def glDrawElements(mode: Int, count: Int, `type`: Int, indices: Int): F[Unit] =
    Sync[F].delay(gl.glDrawElements(mode, count, `type`, indices))

  override def glEnableVertexAttribArray(index: Int): F[Unit] =
    Sync[F].delay(gl.glEnableVertexAttribArray(index))

  override def glFramebufferRenderbuffer(
      target: Int,
      attachment: Int,
      renderbuffertarget: Int,
      renderbuffer: Int,
  ): F[Unit] =
    Sync[F].delay(gl.glFramebufferRenderbuffer(target, attachment, renderbuffertarget, renderbuffer))

  override def glFramebufferTexture2D(target: Int, attachment: Int, textarget: Int, texture: Int, level: Int): F[Unit] =
    Sync[F].delay(gl.glFramebufferTexture2D(target, attachment, textarget, texture, level))

  override def glGenBuffer: F[Int] = Sync[F].delay(gl.glGenBuffer())

  override def glGenBuffers(n: Int, buffers: IntBuffer): F[Unit] = Sync[F].delay(gl.glGenBuffers(n, buffers))

  override def glGenerateMipmap(target: Int): F[Unit] = Sync[F].delay(gl.glGenerateMipmap(target))

  override def glGenFramebuffer: F[Int] = Sync[F].delay(gl.glGenFramebuffer())

  override def glGenFramebuffers(n: Int, framebuffers: IntBuffer): F[Unit] =
    Sync[F].delay(gl.glGenFramebuffers(n, framebuffers))

  override def glGenRenderbuffer: F[Int] = Sync[F].delay(gl.glGenRenderbuffer())

  override def glGenRenderbuffers(n: Int, renderbuffers: IntBuffer): F[Unit] =
    Sync[F].delay(gl.glGenRenderbuffers(n, renderbuffers))

  override def glGetActiveAttrib(program: Int, index: Int, size: IntBuffer, `type`: IntBuffer): F[String] =
    Sync[F].delay(gl.glGetActiveAttrib(program, index, size, `type`))

  override def glGetActiveUniform(program: Int, index: Int, size: IntBuffer, `type`: IntBuffer): F[String] =
    Sync[F].delay(gl.glGetActiveUniform(program, index, size, `type`))

  override def glGetAttachedShaders(program: Int, maxcount: Int, count: Buffer, shaders: IntBuffer): F[Unit] =
    Sync[F].delay(gl.glGetAttachedShaders(program, maxcount, count, shaders))

  override def glGetAttribLocation(program: Int, name: String): F[Int] =
    Sync[F].delay(gl.glGetAttribLocation(program, name))

  override def glBooleanv(pname: Int, params: Buffer): F[Unit] = Sync[F].delay(gl.glGetBooleanv(pname, params))

  override def glGetBufferParameteriv(target: Int, pname: Int, params: IntBuffer): F[Unit] =
    Sync[F].delay(gl.glGetBufferParameteriv(target, pname, params))

  override def glGetFloatv(pname: Int, params: FloatBuffer): F[Unit] =
    Sync[F].delay(gl.glGetFloatv(pname, params))

  override def glGetFramebufferAttachmentParameteriv(
      target: Int,
      attachment: Int,
      pname: Int,
      params: IntBuffer,
  ): F[Unit] = Sync[F].delay(gl.glGetFramebufferAttachmentParameteriv(target, attachment, pname, params))

  override def glGetProgramiv(program: Int, pname: Int, params: IntBuffer): F[Unit] =
    Sync[F].delay(gl.glGetProgramiv(program, pname, params))

  override def glGetProgramInfoLog(program: Int): F[String] = Sync[F].delay(gl.glGetProgramInfoLog(program))

  override def glGetRenderbufferParameteriv(target: Int, pname: Int, params: IntBuffer): F[Unit] =
    Sync[F].delay(gl.glGetRenderbufferParameteriv(target, pname, params))

  override def glGetShaderiv(shader: Int, pname: Int, params: IntBuffer): F[Unit] =
    Sync[F].delay(gl.glGetShaderiv(shader, pname, params))

  override def glGetShaderInfoLog(shader: Int): F[String] = Sync[F].delay(gl.glGetShaderInfoLog(shader))

  override def glGetShaderPrecisionFormat(
      shaderType: Int,
      precisionType: Int,
      range: IntBuffer,
      precision: IntBuffer,
  ): F[Unit] = Sync[F].delay(gl.glGetShaderPrecisionFormat(shaderType, precisionType, range, precision))

  override def glGetTexParameterfv(target: Int, pname: Int, params: FloatBuffer): F[Unit] =
    Sync[F].delay(gl.glGetTexParameterfv(target, pname, params))

  override def glGetTexParameteriv(target: Int, pname: Int, params: IntBuffer): F[Unit] =
    Sync[F].delay(gl.glGetTexParameteriv(target, pname, params))

  override def glGetUniformfv(program: Int, location: Int, params: FloatBuffer): F[Unit] =
    Sync[F].delay(gl.glGetUniformfv(program, location, params))

  override def glGetUniformiv(program: Int, location: Int, params: IntBuffer): F[Unit] =
    Sync[F].delay(gl.glGetUniformiv(program, location, params))

  override def glGetUniformLocation(program: Int, name: String): F[Int] =
    Sync[F].delay(gl.glGetUniformLocation(program, name))

  override def glGetVertexAttribfv(index: Int, pname: Int, params: FloatBuffer): F[Unit] =
    Sync[F].delay(gl.glGetVertexAttribfv(index, pname, params))

  override def glGetVertexAttribiv(index: Int, pname: Int, params: IntBuffer): F[Unit] =
    Sync[F].delay(gl.glGetVertexAttribiv(index, pname, params))

  override def glGetVertexAttribPointerv(index: Int, pname: Int, pointer: Buffer): F[Unit] =
    Sync[F].delay(gl.glGetVertexAttribPointerv(index, pname, pointer))

  override def glIsBuffer(buffer: Int): F[Boolean] = Sync[F].delay(gl.glIsBuffer(buffer))

  override def glIsEnabled(cap: Int): F[Boolean] = Sync[F].delay(gl.glIsEnabled(cap))

  override def glIsFramebuffer(framebuffer: Int): F[Boolean] = Sync[F].delay(gl.glIsFramebuffer(framebuffer))

  override def glIsProgram(program: Int): F[Boolean] = Sync[F].delay(gl.glIsProgram(program))

  override def glIsRenderbuffer(renderbuffer: Int): F[Boolean] = Sync[F].delay(gl.glIsRenderbuffer(renderbuffer))

  override def glIsShader(shader: Int): F[Boolean] = Sync[F].delay(gl.glIsShader(shader))

  override def glIsTexture(texture: Int): F[Boolean] = Sync[F].delay(gl.glIsTexture(texture))

  override def glLinkProgram(program: Int): F[Unit] = Sync[F].delay(gl.glLinkProgram(program))

  override def glReleaseShaderCompiler: F[Unit] = Sync[F].delay(gl.glReleaseShaderCompiler())

  override def glRenderbufferStorage(target: Int, internalFormat: Int, width: Int, height: Int): F[Unit] =
    Sync[F].delay(gl.glRenderbufferStorage(target, internalFormat, width, height))

  override def glSampleCoverage(value: Float, invert: Boolean): F[Unit] =
    Sync[F].delay(gl.glSampleCoverage(value, invert))

  override def glShaderBinary(n: Int, shader: IntBuffer, binaryFormat: Int, binary: Buffer, length: Int): F[Unit] =
    Sync[F].delay(gl.glShaderBinary(n, shader, binaryFormat, binary, length))

  override def glShaderSource(shader: Int, string: String): F[Unit] = Sync[F].delay(gl.glShaderSource(shader, string))

  override def glStencilFuncSeparate(face: Int, func: Int, ref: Int, mask: Int): F[Unit] =
    Sync[F].delay(gl.glStencilFuncSeparate(face, func, ref, mask))

  override def glStencilMaskSeparate(face: Int, mask: Int): F[Unit] =
    Sync[F].delay(gl.glStencilMaskSeparate(face, mask))

  override def glStencilOpSeparate(face: Int, fail: Int, zfail: Int, zpass: Int): F[Unit] =
    Sync[F].delay(gl.glStencilOpSeparate(face, fail, zfail, zpass))

  override def glTexParameterfv(target: Int, pname: Int, params: FloatBuffer): F[Unit] =
    Sync[F].delay(gl.glTexParameterfv(target, pname, params))

  override def glTexParameteri(target: Int, pname: Int, param: Int): F[Unit] =
    Sync[F].delay(gl.glTexParameteri(target, pname, param))

  override def glTexParameteriv(target: Int, pname: Int, params: IntBuffer): F[Unit] =
    Sync[F].delay(gl.glTexParameteriv(target, pname, params))

  override def glUniform1f(location: Int, x: Float): F[Unit] = Sync[F].delay(gl.glUniform1f(location, x))

  override def glUniform1fv(location: Int, count: Int, v: FloatBuffer): F[Unit] =
    Sync[F].delay(gl.glUniform1fv(location, count, v))

  override def glUniform1fv(location: Int, count: Int, v: Array[Float], offset: Int): F[Unit] =
    Sync[F].delay(gl.glUniform1fv(location, count, v, offset))

  override def glUniform1i(location: Int, x: Int): F[Unit] = Sync[F].delay(gl.glUniform1i(location, x))

  override def glUniform1iv(location: Int, count: Int, v: IntBuffer): F[Unit] =
    Sync[F].delay(gl.glUniform1iv(location, count, v))

  override def glUniform1iv(location: Int, count: Int, v: Array[Int], offset: Int): F[Unit] =
    Sync[F].delay(gl.glUniform1iv(location, count, v, offset))

  override def glUniform2f(location: Int, x: Float, y: Float): F[Unit] =
    Sync[F].delay(gl.glUniform2f(location, x, y))

  override def glUniform2fv(location: Int, count: Int, v: FloatBuffer): F[Unit] =
    Sync[F].delay(gl.glUniform2fv(location, count, v))

  override def glUniform2fv(location: Int, count: Int, v: Array[Float], offset: Int): F[Unit] =
    Sync[F].delay(gl.glUniform2fv(location, count, v, offset))

  override def glUniform2i(location: Int, x: Int, y: Int): F[Unit] =
    Sync[F].delay(gl.glUniform2i(location, x, y))

  override def glUniform2iv(location: Int, count: Int, v: IntBuffer): F[Unit] =
    Sync[F].delay(gl.glUniform2iv(location, count, v))

  override def glUniform2iv(location: Int, count: Int, v: Array[Int], offset: Int): F[Unit] =
    Sync[F].delay(gl.glUniform2iv(location, count, v, offset))

  override def glUniform3f(location: Int, x: Float, y: Float, z: Float): F[Unit] =
    Sync[F].delay(gl.glUniform3f(location, x, y, z))

  override def glUniform3fv(location: Int, count: Int, v: FloatBuffer): F[Unit] =
    Sync[F].delay(gl.glUniform3fv(location, count, v))

  override def glUniform3fv(location: Int, count: Int, v: Array[Float], offset: Int): F[Unit] =
    Sync[F].delay(gl.glUniform3fv(location, count, v, offset))

  override def glUniform3i(location: Int, x: Int, y: Int, z: Int): F[Unit] =
    Sync[F].delay(gl.glUniform3i(location, x, y, z))

  override def glUniform3iv(location: Int, count: Int, v: IntBuffer): F[Unit] =
    Sync[F].delay(gl.glUniform3iv(location, count, v))

  override def glUniform3iv(location: Int, count: Int, v: Array[Int], offset: Int): F[Unit] =
    Sync[F].delay(gl.glUniform3iv(location, count, v, offset))

  override def glUniform4f(location: Int, x: Float, y: Float, z: Float, w: Float): F[Unit] =
    Sync[F].delay(gl.glUniform4f(location, x, y, z, w))

  override def glUniform4fv(location: Int, count: Int, v: FloatBuffer): F[Unit] =
    Sync[F].delay(gl.glUniform4fv(location, count, v))

  override def glUniform4fv(location: Int, count: Int, v: Array[Float], offset: Int): F[Unit] =
    Sync[F].delay(gl.glUniform4fv(location, count, v, offset))

  override def glUniform4i(location: Int, x: Int, y: Int, z: Int, w: Int): F[Unit] =
    Sync[F].delay(gl.glUniform4i(location, x, y, z, w))

  override def glUniform4iv(location: Int, count: Int, v: IntBuffer): F[Unit] =
    Sync[F].delay(gl.glUniform4iv(location, count, v))

  override def glUniform4iv(location: Int, count: Int, v: Array[Int], offset: Int): F[Unit] =
    Sync[F].delay(gl.glUniform4iv(location, count, v, offset))

  override def glUniformMatrix2fv(location: Int, count: Int, transpose: Boolean, value: FloatBuffer): F[Unit] =
    Sync[F].delay(gl.glUniformMatrix2fv(location, count, transpose, value))

  override def glUniformMatrix2fv(
      location: Int,
      count: Int,
      transpose: Boolean,
      value: Array[Float],
      offset: Int,
  ): F[Unit] = Sync[F].delay(gl.glUniformMatrix2fv(location, count, transpose, value, offset))

  override def glUniformMatrix3fv(location: Int, count: Int, transpose: Boolean, value: FloatBuffer): F[Unit] =
    Sync[F].delay(gl.glUniformMatrix3fv(location, count, transpose, value))

  override def glUniformMatrix3fv(
      location: Int,
      count: Int,
      transpose: Boolean,
      value: Array[Float],
      offset: Int,
  ): F[Unit] = Sync[F].delay(gl.glUniformMatrix3fv(location, count, transpose, value, offset))

  override def glUniformMatrix4fv(location: Int, count: Int, transpose: Boolean, value: FloatBuffer): F[Unit] =
    Sync[F].delay(gl.glUniformMatrix4fv(location, count, transpose, value))

  override def glUniformMatrix4fv(
      location: Int,
      count: Int,
      transpose: Boolean,
      value: Array[Float],
      offset: Int,
  ): F[Unit] = Sync[F].delay(gl.glUniformMatrix4fv(location, count, transpose, value, offset))

  override def glUseProgram(program: Int): F[Unit] = Sync[F].delay(gl.glUseProgram(program))

  override def glValidateProgram(program: Int): F[Unit] = Sync[F].delay(gl.glValidateProgram(program))

  override def glVertexAttrib1f(indx: Int, x: Float): F[Unit] = Sync[F].delay(gl.glVertexAttrib1f(indx, x))

  override def glVertexAttrib1fv(indx: Int, values: FloatBuffer): F[Unit] =
    Sync[F].delay(gl.glVertexAttrib1fv(indx, values))

  override def glVertexAttrib2f(indx: Int, x: Float, y: Float): F[Unit] =
    Sync[F].delay(gl.glVertexAttrib2f(indx, x, y))

  override def glVertexAttrib2fv(indx: Int, values: FloatBuffer): F[Unit] =
    Sync[F].delay(gl.glVertexAttrib2fv(indx, values))

  override def glVertexAttrib3f(indx: Int, x: Float, y: Float, z: Float): F[Unit] =
    Sync[F].delay(gl.glVertexAttrib3f(indx, x, y, z))

  override def glVertexAttrib3fv(indx: Int, values: FloatBuffer): F[Unit] =
    Sync[F].delay(gl.glVertexAttrib3fv(indx, values))

  override def glVertexAttrib4f(indx: Int, x: Float, y: Float, z: Float, w: Float): F[Unit] =
    Sync[F].delay(gl.glVertexAttrib4f(indx, x, y, z, w))

  override def glVertexAttrib4fv(indx: Int, values: FloatBuffer): F[Unit] =
    Sync[F].delay(gl.glVertexAttrib4fv(indx, values))

  override def glVertexAttribPointer(
      indx: Int,
      size: Int,
      `type`: Int,
      normalized: Boolean,
      stride: Int,
      ptr: Buffer,
  ): F[Unit] =
    Sync[F].delay(gl.glVertexAttribPointer(indx, size, `type`, normalized, stride, ptr))

  override def glVertexAttribPointer(
      indx: Int,
      size: Int,
      `type`: Int,
      normalized: Boolean,
      stride: Int,
      ptr: Int,
  ): F[Unit] =
    Sync[F].delay(gl.glVertexAttribPointer(indx, size, `type`, normalized, stride, ptr))
}
