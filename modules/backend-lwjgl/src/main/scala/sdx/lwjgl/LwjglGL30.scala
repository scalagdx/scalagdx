package sdx.lwjgl

import cats.effect.kernel.Sync
import com.badlogic.gdx.graphics.{GL20 => GdxGL20}
import com.badlogic.gdx.graphics.{GL30 => GdxGL30}
import sdx.graphics.GL30

import java.nio.Buffer
import java.nio.FloatBuffer
import java.nio.IntBuffer
import java.nio.LongBuffer

class LwjglGL30[F[_]: Sync](
    gl20: GdxGL20,
    gl: GdxGL30,
) extends LwjglGL20[F](gl20)
    with GL30[F] {

  override def glReadBuffer(mode: Int): F[Unit] = Sync[F].delay(gl.glReadBuffer(mode))

  override def glDrawRangeElements(mode: Int, start: Int, end: Int, count: Int, `type`: Int, indices: Buffer): F[Unit] =
    Sync[F].delay(gl.glDrawRangeElements(mode, start, end, count, `type`, indices))

  override def glDrawRangeElements(mode: Int, start: Int, end: Int, count: Int, `type`: Int, offset: Int): F[Unit] =
    Sync[F].delay(gl.glDrawRangeElements(mode, start, end, count, `type`, offset))

  override def glTexImage3D(
      target: Int,
      level: Int,
      internalformat: Int,
      width: Int,
      height: Int,
      depth: Int,
      border: Int,
      format: Int,
      `type`: Int,
      pixels: Buffer,
  ): F[Unit] =
    Sync[F].delay(gl.glTexImage3D(target, level, internalformat, width, height, depth, border, format, `type`, pixels))

  override def glTexImage3D(
      target: Int,
      level: Int,
      internalformat: Int,
      width: Int,
      height: Int,
      depth: Int,
      border: Int,
      format: Int,
      `type`: Int,
      offset: Int,
  ): F[Unit] =
    Sync[F].delay(gl.glTexImage3D(target, level, internalformat, width, height, depth, border, format, `type`, offset))

  override def glTexSubImage3D(
      target: Int,
      level: Int,
      xoffset: Int,
      yoffset: Int,
      zoffset: Int,
      width: Int,
      height: Int,
      depth: Int,
      format: Int,
      `type`: Int,
      pixels: Buffer,
  ): F[Unit] =
    Sync[F].delay(
      gl.glTexSubImage3D(target, level, xoffset, yoffset, zoffset, width, height, depth, format, `type`, pixels),
    )

  override def glTexSubImage3D(
      target: Int,
      level: Int,
      xoffset: Int,
      yoffset: Int,
      zoffset: Int,
      width: Int,
      height: Int,
      depth: Int,
      format: Int,
      `type`: Int,
      offset: Int,
  ): F[Unit] =
    Sync[F].delay(
      gl.glTexSubImage3D(target, level, xoffset, yoffset, zoffset, width, height, depth, format, `type`, offset),
    )

  override def glCopyTexSubImage3D(
      target: Int,
      level: Int,
      xoffset: Int,
      yoffset: Int,
      zoffset: Int,
      x: Int,
      y: Int,
      width: Int,
      height: Int,
  ): F[Unit] =
    Sync[F].delay(gl.glCopyTexSubImage3D(target, level, xoffset, yoffset, zoffset, x, y, width, height))

  override def glGenQueries(n: Int, ids: Array[Int], offset: Int): F[Unit] =
    Sync[F].delay(gl.glGenQueries(n, ids, offset))

  override def glGenQueries(n: Int, ids: IntBuffer): F[Unit] = Sync[F].delay(gl.glGenQueries(n, ids))

  override def glDeleteQueries(n: Int, ids: Array[Int], offset: Int): F[Unit] =
    Sync[F].delay(gl.glDeleteQueries(n, ids, offset))

  override def glDeleteQueries(n: Int, ids: IntBuffer): F[Unit] = Sync[F].delay(gl.glDeleteQueries(n, ids))

  override def glIsQuery(id: Int): F[Boolean] = Sync[F].delay(gl.glIsQuery(id))

  override def glBeginQuery(target: Int, id: Int): F[Unit] = Sync[F].delay(gl.glBeginQuery(target, id))

  override def glEndQuery(target: Int): F[Unit] = Sync[F].delay(gl.glEndQuery(target))

  override def glGetQueryiv(target: Int, pname: Int, params: IntBuffer): F[Unit] =
    Sync[F].delay(gl.glGetQueryiv(target, pname, params))

  override def glGetQueryObjectuiv(id: Int, pname: Int, params: IntBuffer): F[Unit] =
    Sync[F].delay(gl.glGetQueryObjectuiv(id, pname, params))

  override def glUnmapBuffer(target: Int): F[Boolean] =
    Sync[F].delay(gl.glUnmapBuffer(target))

  override def glGetBufferPointerv(target: Int, pname: Int): F[Buffer] =
    Sync[F].delay(gl.glGetBufferPointerv(target, pname))

  override def glDrawBuffers(n: Int, bufs: IntBuffer): F[Unit] =
    Sync[F].delay(gl.glDrawBuffers(n, bufs))

  override def glUniformMatrix2x3fv(location: Int, count: Int, transpose: Boolean, value: FloatBuffer): F[Unit] =
    Sync[F].delay(gl.glUniformMatrix2x3fv(location, count, transpose, value))

  override def glUniformMatrix3x2fv(location: Int, count: Int, transpose: Boolean, value: FloatBuffer): F[Unit] =
    Sync[F].delay(gl.glUniformMatrix3x2fv(location, count, transpose, value))

  override def glUniformMatrix2x4fv(location: Int, count: Int, transpose: Boolean, value: FloatBuffer): F[Unit] =
    Sync[F].delay(gl.glUniformMatrix2x4fv(location, count, transpose, value))

  override def glUniformMatrix4x2fv(location: Int, count: Int, transpose: Boolean, value: FloatBuffer): F[Unit] =
    Sync[F].delay(gl.glUniformMatrix4x2fv(location, count, transpose, value))

  override def glUniformMatrix3x4fv(location: Int, count: Int, transpose: Boolean, value: FloatBuffer): F[Unit] =
    Sync[F].delay(gl.glUniformMatrix3x4fv(location, count, transpose, value))

  override def glUniformMatrix4x3fv(location: Int, count: Int, transpose: Boolean, value: FloatBuffer): F[Unit] =
    Sync[F].delay(gl.glUniformMatrix4x3fv(location, count, transpose, value))

  override def glBlitFramebuffer(
      srcX0: Int,
      srcY0: Int,
      srcX1: Int,
      srcY1: Int,
      dstX0: Int,
      dstY0: Int,
      dstX1: Int,
      dstY1: Int,
      mask: Int,
      filter: Int,
  ): F[Unit] =
    Sync[F].delay(gl.glBlitFramebuffer(srcX0, srcY0, srcX1, srcY1, dstX0, dstY0, dstX1, dstY1, mask, filter))

  override def glRenderbufferStorageMultisample(
      target: Int,
      samples: Int,
      internalformat: Int,
      width: Int,
      height: Int,
  ): F[Unit] = Sync[F].delay(gl.glRenderbufferStorageMultisample(target, samples, internalformat, width, height))

  override def glFramebufferTextureLayer(target: Int, attachment: Int, texture: Int, level: Int, layer: Int): F[Unit] =
    Sync[F].delay(gl.glFramebufferTextureLayer(target, attachment, texture, level, layer))

  override def glMapBufferRange(target: Int, offset: Int, length: Int, access: Int): F[Buffer] =
    Sync[F].delay(gl.glMapBufferRange(target, offset, length, access))

  override def glFlushMappedBufferRange(target: Int, offset: Int, length: Int): F[Unit] =
    Sync[F].delay(gl.glFlushMappedBufferRange(target, offset, length))

  override def glBindVertexArray(array: Int): F[Unit] = Sync[F].delay(gl.glBindVertexArray(array))

  override def glDeleteVertexArrays(n: Int, arrays: Array[Int], offset: Int): F[Unit] =
    Sync[F].delay(gl.glDeleteVertexArrays(n, arrays, offset))

  override def glDeleteVertexArrays(n: Int, arrays: IntBuffer): F[Unit] =
    Sync[F].delay(gl.glDeleteVertexArrays(n, arrays))

  override def glGenVertexArrays(n: Int, arrays: Array[Int], offset: Int): F[Unit] =
    Sync[F].delay(gl.glGenVertexArrays(n, arrays, offset))

  override def glGenVertexArrays(n: Int, arrays: IntBuffer): F[Unit] = Sync[F].delay(gl.glGenVertexArrays(n, arrays))

  override def glIsVertexArray(array: Int): F[Boolean] = Sync[F].delay(gl.glIsVertexArray(array))

  override def glBeginTransformFeedback(primitiveMode: Int): F[Unit] =
    Sync[F].delay(gl.glBeginTransformFeedback(primitiveMode))

  override def glEndTransformFeedback: F[Unit] = Sync[F].delay(gl.glEndTransformFeedback())

  override def glBindBufferRange(target: Int, index: Int, buffer: Int, offset: Int, size: Int): F[Unit] =
    Sync[F].delay(gl.glBindBufferRange(target, index, buffer, offset, size))

  override def glBindBufferBase(target: Int, index: Int, buffer: Int): F[Unit] =
    Sync[F].delay(gl.glBindBufferBase(target, index, buffer))

  override def glTransformFeedbackVaryings(program: Int, varyings: Array[String], bufferMode: Int): F[Unit] =
    Sync[F].delay(gl.glTransformFeedbackVaryings(program, varyings, bufferMode))

  override def glVertexAttribIPointer(index: Int, size: Int, `type`: Int, stride: Int, offset: Int): F[Unit] =
    Sync[F].delay(gl.glVertexAttribIPointer(index, size, `type`, stride, offset))

  override def glGetVertexAttribIiv(index: Int, pname: Int, params: IntBuffer): F[Unit] =
    Sync[F].delay(gl.glGetVertexAttribIiv(index, pname, params))

  override def glGetVertexAttribIuiv(index: Int, pname: Int, params: IntBuffer): F[Unit] =
    Sync[F].delay(gl.glGetVertexAttribIuiv(index, pname, params))

  override def glVertexAttribI4i(index: Int, x: Int, y: Int, z: Int, w: Int): F[Unit] =
    Sync[F].delay(gl.glVertexAttribI4i(index, x, y, z, w))

  override def glVertexAttribI4ui(index: Int, x: Int, y: Int, z: Int, w: Int): F[Unit] =
    Sync[F].delay(gl.glVertexAttribI4ui(index, x, y, z, w))

  override def glGetUniformuiv(program: Int, location: Int, params: IntBuffer): F[Unit] =
    Sync[F].delay(gl.glGetUniformuiv(program, location, params))

  override def glGetFragDataLocation(program: Int, name: String): F[Int] =
    Sync[F].delay(gl.glGetFragDataLocation(program, name))

  override def glUniform1uiv(location: Int, count: Int, value: IntBuffer): F[Unit] =
    Sync[F].delay(gl.glUniform1uiv(location, count, value))

  override def glUniform3uiv(location: Int, count: Int, value: IntBuffer): F[Unit] =
    Sync[F].delay(gl.glUniform3uiv(location, count, value))

  override def glUniform4uiv(location: Int, count: Int, value: IntBuffer): F[Unit] =
    Sync[F].delay(gl.glUniform4uiv(location, count, value))

  override def glClearBufferiv(buffer: Int, drawbuffer: Int, value: IntBuffer): F[Unit] =
    Sync[F].delay(gl.glClearBufferiv(buffer, drawbuffer, value))

  override def glClearBufferuiv(buffer: Int, drawbuffer: Int, value: IntBuffer): F[Unit] =
    Sync[F].delay(gl.glClearBufferuiv(buffer, drawbuffer, value))

  override def glClearBufferfv(buffer: Int, drawbuffer: Int, value: FloatBuffer): F[Unit] =
    Sync[F].delay(gl.glClearBufferfv(buffer, drawbuffer, value))

  override def glClearBufferfi(buffer: Int, drawbuffer: Int, depth: Float, stencil: Int): F[Unit] =
    Sync[F].delay(gl.glClearBufferfi(buffer, drawbuffer, depth, stencil))

  override def glGetStringi(name: Int, index: Int): F[String] =
    Sync[F].delay(gl.glGetStringi(name, index))

  override def glCopyBufferSubData(
      readTarget: Int,
      writeTarget: Int,
      readOffset: Int,
      writeOffset: Int,
      size: Int,
  ): F[Unit] = Sync[F].delay(gl.glCopyBufferSubData(readTarget, writeTarget, readOffset, writeOffset, size))

  override def glGetUniformIndices(program: Int, uniformNames: Array[String], uniformIndices: IntBuffer): F[Unit] =
    Sync[F].delay(gl.glGetUniformIndices(program, uniformNames, uniformIndices))

  override def glGetActiveUniformsiv(
      program: Int,
      uniformCount: Int,
      uniformIndices: IntBuffer,
      pname: Int,
      params: IntBuffer,
  ): F[Unit] = Sync[F].delay(gl.glGetActiveUniformsiv(program, uniformCount, uniformIndices, pname, params))

  override def glGetUniformBlockIndex(program: Int, uniformBlockName: String): F[Int] =
    Sync[F].delay(gl.glGetUniformBlockIndex(program, uniformBlockName))

  override def glGetActiveUniformBlockiv(program: Int, uniformBlockIndex: Int, pname: Int, params: IntBuffer): F[Unit] =
    Sync[F].delay(gl.glGetActiveUniformBlockiv(program, uniformBlockIndex, pname, params))

  override def glGetActiveUniformBlockName(
      program: Int,
      uniformBlockIndex: Int,
      length: Buffer,
      uniformBlockName: Buffer,
  ): F[Unit] =
    Sync[F].delay(gl.glGetActiveUniformBlockName(program, uniformBlockIndex, length, uniformBlockName))

  override def glGetActiveUniformBlockName(program: Int, uniformBlockIndex: Int): F[String] =
    Sync[F].delay(gl.glGetActiveUniformBlockName(program, uniformBlockIndex))

  override def glUniformBlockBinding(program: Int, uniformBlockIndex: Int, uniformBlockBinding: Int): F[Unit] =
    Sync[F].delay(gl.glUniformBlockBinding(program, uniformBlockIndex, uniformBlockBinding))

  override def glDrawArraysInstanced(mode: Int, first: Int, count: Int, instanceCount: Int): F[Unit] =
    Sync[F].delay(gl.glDrawArraysInstanced(mode, first, count, instanceCount))

  override def glDrawElementsInstanced(
      mode: Int,
      count: Int,
      `type`: Int,
      indicesOffset: Int,
      instanceCount: Int,
  ): F[Unit] =
    Sync[F].delay(gl.glDrawElementsInstanced(mode, count, `type`, indicesOffset, instanceCount))

  override def glGetInteger64v(pname: Int, params: LongBuffer): F[Unit] =
    Sync[F].delay(gl.glGetInteger64v(pname, params))

  override def glGetBufferParameteri64v(target: Int, pname: Int, params: LongBuffer): F[Unit] =
    Sync[F].delay(gl.glGetBufferParameteri64v(target, pname, params))

  override def glGenSamplers(count: Int, samplers: Array[Int], offset: Int): F[Unit] =
    Sync[F].delay(gl.glGenSamplers(count, samplers, offset))

  override def glGenSamplers(count: Int, samplers: IntBuffer): F[Unit] =
    Sync[F].delay(gl.glGenSamplers(count, samplers))

  override def glDeleteSamplers(count: Int, samplers: Array[Int], offset: Int): F[Unit] =
    Sync[F].delay(gl.glDeleteSamplers(count, samplers, offset))

  override def glDeleteSamplers(count: Int, samplers: IntBuffer): F[Unit] =
    Sync[F].delay(gl.glDeleteSamplers(count, samplers))

  override def glIsSampler(sampler: Int): F[Boolean] = Sync[F].delay(gl.glIsSampler(sampler))

  override def glBindSampler(unit: Int, sampler: Int): F[Unit] =
    Sync[F].delay(gl.glBindSampler(unit, sampler))

  override def glSamplerParameteri(sampler: Int, pname: Int, param: Int): F[Unit] =
    Sync[F].delay(gl.glSamplerParameteri(sampler, pname, param))

  override def glSamplerParameteriv(sampler: Int, pname: Int, param: IntBuffer): F[Unit] =
    Sync[F].delay(gl.glSamplerParameteriv(sampler, pname, param))

  override def glSamplerParameterf(sampler: Int, pname: Int, param: Float): F[Unit] =
    Sync[F].delay(gl.glSamplerParameterf(sampler, pname, param))

  override def glSamplerParameterfv(sampler: Int, pname: Int, param: FloatBuffer): F[Unit] =
    Sync[F].delay(gl.glSamplerParameterfv(sampler, pname, param))

  override def glGetSamplerParameteriv(sampler: Int, pname: Int, params: IntBuffer): F[Unit] =
    Sync[F].delay(gl.glGetSamplerParameteriv(sampler, pname, params))

  override def glGetSamplerParameterfv(sampler: Int, pname: Int, params: FloatBuffer): F[Unit] =
    Sync[F].delay(gl.glGetSamplerParameterfv(sampler, pname, params))

  override def glVertexAttribDivisor(index: Int, divisor: Int): F[Unit] =
    Sync[F].delay(gl.glVertexAttribDivisor(index, divisor))

  override def glBindTransformFeedback(target: Int, id: Int): F[Unit] =
    Sync[F].delay(gl.glBindTransformFeedback(target, id))

  override def glDeleteTransformFeedbacks(n: Int, ids: Array[Int], offset: Int): F[Unit] =
    Sync[F].delay(gl.glDeleteTransformFeedbacks(n, ids, offset))

  override def glDeleteTransformFeedbacks(n: Int, ids: IntBuffer): F[Unit] =
    Sync[F].delay(gl.glDeleteTransformFeedbacks(n, ids))

  override def glGenTransformFeedbacks(n: Int, ids: Array[Int], offset: Int): F[Unit] =
    Sync[F].delay(gl.glGenTransformFeedbacks(n, ids, offset))

  override def glGenTransformFeedbacks(n: Int, ids: IntBuffer): F[Unit] =
    Sync[F].delay(gl.glGenTransformFeedbacks(n, ids))

  override def glIsTransformFeedback(id: Int): F[Boolean] = Sync[F].delay(gl.glIsTransformFeedback(id))

  override val glPauseTransformFeedback: F[Unit] = Sync[F].delay(gl.glPauseTransformFeedback())

  override val glResumeTransformFeedback: F[Unit] = Sync[F].delay(gl.glResumeTransformFeedback())

  override def glProgramParameteri(program: Int, pname: Int, value: Int): F[Unit] =
    Sync[F].delay(gl.glProgramParameteri(program, pname, value))

  override def glInvalidateFramebuffer(target: Int, numAttachments: Int, attachments: IntBuffer): F[Unit] =
    Sync[F].delay(gl.glInvalidateFramebuffer(target, numAttachments, attachments))

  override def glInvalidateSubFramebuffer(
      target: Int,
      numAttachments: Int,
      attachments: IntBuffer,
      x: Int,
      y: Int,
      width: Int,
      height: Int,
  ): F[Unit] = Sync[F].delay(gl.glInvalidateSubFramebuffer(target, numAttachments, attachments, x, y, width, height))
}
