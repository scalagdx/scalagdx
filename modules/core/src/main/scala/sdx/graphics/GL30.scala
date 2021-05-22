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
package sdx.graphics

import java.nio.Buffer
import java.nio.FloatBuffer
import java.nio.IntBuffer

/**
 * Wrapper for all the methods of OpenGL ES 2.0
 */
trait GL30[F[_]] extends GL20[F] {

  val GL_READ_BUFFER: Int = 0x0c02
  val GL_UNPACK_ROW_LENGTH: Int = 0x0cf2
  val GL_UNPACK_SKIP_ROWS: Int = 0x0cf3
  val GL_UNPACK_SKIP_PIXELS: Int = 0x0cf4
  val GL_PACK_ROW_LENGTH: Int = 0x0d02
  val GL_PACK_SKIP_ROWS: Int = 0x0d03
  val GL_PACK_SKIP_PIXELS: Int = 0x0d04
  val GL_COLOR: Int = 0x1800
  val GL_DEPTH: Int = 0x1801
  val GL_STENCIL: Int = 0x1802
  val GL_RED: Int = 0x1903
  val GL_RGB8: Int = 0x8051
  val GL_RGBA8: Int = 0x8058
  val GL_RGB10_A2: Int = 0x8059
  val GL_TEXTURE_BINDING_3D: Int = 0x806a
  val GL_UNPACK_SKIP_IMAGES: Int = 0x806d
  val GL_UNPACK_IMAGE_HEIGHT: Int = 0x806e
  val GL_TEXTURE_3D: Int = 0x806f
  val GL_TEXTURE_WRAP_R: Int = 0x8072
  val GL_MAX_3D_TEXTURE_SIZE: Int = 0x8073
  val GL_UNSIGNED_INT_2_10_10_10_REV: Int = 0x8368
  val GL_MAX_ELEMENTS_VERTICES: Int = 0x80e8
  val GL_MAX_ELEMENTS_INDICES: Int = 0x80e9
  val GL_TEXTURE_MIN_LOD: Int = 0x813a
  val GL_TEXTURE_MAX_LOD: Int = 0x813b
  val GL_TEXTURE_BASE_LEVEL: Int = 0x813c
  val GL_TEXTURE_MAX_LEVEL: Int = 0x813d
  val GL_MIN: Int = 0x8007
  val GL_MAX: Int = 0x8008
  val GL_DEPTH_COMPONENT24: Int = 0x81a6
  val GL_MAX_TEXTURE_LOD_BIAS: Int = 0x84fd
  val GL_TEXTURE_COMPARE_MODE: Int = 0x884c
  val GL_TEXTURE_COMPARE_FUNC: Int = 0x884d
  val GL_CURRENT_QUERY: Int = 0x8865
  val GL_QUERY_RESULT: Int = 0x8866
  val GL_QUERY_RESULT_AVAILABLE: Int = 0x8867
  val GL_BUFFER_MAPPED: Int = 0x88bc
  val GL_BUFFER_MAP_POINTER: Int = 0x88bd
  val GL_STREAM_READ: Int = 0x88e1
  val GL_STREAM_COPY: Int = 0x88e2
  val GL_STATIC_READ: Int = 0x88e5
  val GL_STATIC_COPY: Int = 0x88e6
  val GL_DYNAMIC_READ: Int = 0x88e9
  val GL_DYNAMIC_COPY: Int = 0x88ea
  val GL_MAX_DRAW_BUFFERS: Int = 0x8824
  val GL_DRAW_BUFFER0: Int = 0x8825
  val GL_DRAW_BUFFER1: Int = 0x8826
  val GL_DRAW_BUFFER2: Int = 0x8827
  val GL_DRAW_BUFFER3: Int = 0x8828
  val GL_DRAW_BUFFER4: Int = 0x8829
  val GL_DRAW_BUFFER5: Int = 0x882a
  val GL_DRAW_BUFFER6: Int = 0x882b
  val GL_DRAW_BUFFER7: Int = 0x882c
  val GL_DRAW_BUFFER8: Int = 0x882d
  val GL_DRAW_BUFFER9: Int = 0x882e
  val GL_DRAW_BUFFER10: Int = 0x882f
  val GL_DRAW_BUFFER11: Int = 0x8830
  val GL_DRAW_BUFFER12: Int = 0x8831
  val GL_DRAW_BUFFER13: Int = 0x8832
  val GL_DRAW_BUFFER14: Int = 0x8833
  val GL_DRAW_BUFFER15: Int = 0x8834
  val GL_MAX_FRAGMENT_UNIFORM_COMPONENTS: Int = 0x8b49
  val GL_MAX_VERTEX_UNIFORM_COMPONENTS: Int = 0x8b4a
  val GL_SAMPLER_3D: Int = 0x8b5f
  val GL_SAMPLER_2D_SHADOW: Int = 0x8b62
  val GL_FRAGMENT_SHADER_DERIVATIVE_HINT: Int = 0x8b8b
  val GL_PIXEL_PACK_BUFFER: Int = 0x88eb
  val GL_PIXEL_UNPACK_BUFFER: Int = 0x88ec
  val GL_PIXEL_PACK_BUFFER_BINDING: Int = 0x88ed
  val GL_PIXEL_UNPACK_BUFFER_BINDING: Int = 0x88ef
  val GL_FLOAT_MAT2x3: Int = 0x8b65
  val GL_FLOAT_MAT2x4: Int = 0x8b66
  val GL_FLOAT_MAT3x2: Int = 0x8b67
  val GL_FLOAT_MAT3x4: Int = 0x8b68
  val GL_FLOAT_MAT4x2: Int = 0x8b69
  val GL_FLOAT_MAT4x3: Int = 0x8b6a
  val GL_SRGB: Int = 0x8c40
  val GL_SRGB8: Int = 0x8c41
  val GL_SRGB8_ALPHA8: Int = 0x8c43
  val GL_COMPARE_REF_TO_TEXTURE: Int = 0x884e
  val GL_MAJOR_VERSION: Int = 0x821b
  val GL_MINOR_VERSION: Int = 0x821c
  val GL_NUM_EXTENSIONS: Int = 0x821d
  val GL_RGBA32F: Int = 0x8814
  val GL_RGB32F: Int = 0x8815
  val GL_RGBA16F: Int = 0x881a
  val GL_RGB16F: Int = 0x881b
  val GL_VERTEX_ATTRIB_ARRAY_INTEGER: Int = 0x88fd
  val GL_MAX_ARRAY_TEXTURE_LAYERS: Int = 0x88ff
  val GL_MIN_PROGRAM_TEXEL_OFFSET: Int = 0x8904
  val GL_MAX_PROGRAM_TEXEL_OFFSET: Int = 0x8905
  val GL_MAX_VARYING_COMPONENTS: Int = 0x8b4b
  val GL_TEXTURE_2D_ARRAY: Int = 0x8c1a
  val GL_TEXTURE_BINDING_2D_ARRAY: Int = 0x8c1d
  val GL_R11F_G11F_B10F: Int = 0x8c3a
  val GL_UNSIGNED_INT_10F_11F_11F_REV: Int = 0x8c3b
  val GL_RGB9_E5: Int = 0x8c3d
  val GL_UNSIGNED_INT_5_9_9_9_REV: Int = 0x8c3e
  val GL_TRANSFORM_FEEDBACK_VARYING_MAX_LENGTH: Int = 0x8c76
  val GL_TRANSFORM_FEEDBACK_BUFFER_MODE: Int = 0x8c7f
  val GL_MAX_TRANSFORM_FEEDBACK_SEPARATE_COMPONENTS: Int = 0x8c80
  val GL_TRANSFORM_FEEDBACK_VARYINGS: Int = 0x8c83
  val GL_TRANSFORM_FEEDBACK_BUFFER_START: Int = 0x8c84
  val GL_TRANSFORM_FEEDBACK_BUFFER_SIZE: Int = 0x8c85
  val GL_TRANSFORM_FEEDBACK_PRIMITIVES_WRITTEN: Int = 0x8c88
  val GL_RASTERIZER_DISCARD: Int = 0x8c89
  val GL_MAX_TRANSFORM_FEEDBACK_INTERLEAVED_COMPONENTS: Int = 0x8c8a
  val GL_MAX_TRANSFORM_FEEDBACK_SEPARATE_ATTRIBS: Int = 0x8c8b
  val GL_INTERLEAVED_ATTRIBS: Int = 0x8c8c
  val GL_SEPARATE_ATTRIBS: Int = 0x8c8d
  val GL_TRANSFORM_FEEDBACK_BUFFER: Int = 0x8c8e
  val GL_TRANSFORM_FEEDBACK_BUFFER_BINDING: Int = 0x8c8f
  val GL_RGBA32UI: Int = 0x8d70
  val GL_RGB32UI: Int = 0x8d71
  val GL_RGBA16UI: Int = 0x8d76
  val GL_RGB16UI: Int = 0x8d77
  val GL_RGBA8UI: Int = 0x8d7c
  val GL_RGB8UI: Int = 0x8d7d
  val GL_RGBA32I: Int = 0x8d82
  val GL_RGB32I: Int = 0x8d83
  val GL_RGBA16I: Int = 0x8d88
  val GL_RGB16I: Int = 0x8d89
  val GL_RGBA8I: Int = 0x8d8e
  val GL_RGB8I: Int = 0x8d8f
  val GL_RED_INTEGER: Int = 0x8d94
  val GL_RGB_INTEGER: Int = 0x8d98
  val GL_RGBA_INTEGER: Int = 0x8d99
  val GL_SAMPLER_2D_ARRAY: Int = 0x8dc1
  val GL_SAMPLER_2D_ARRAY_SHADOW: Int = 0x8dc4
  val GL_SAMPLER_CUBE_SHADOW: Int = 0x8dc5
  val GL_UNSIGNED_INT_VEC2: Int = 0x8dc6
  val GL_UNSIGNED_INT_VEC3: Int = 0x8dc7
  val GL_UNSIGNED_INT_VEC4: Int = 0x8dc8
  val GL_INT_SAMPLER_2D: Int = 0x8dca
  val GL_INT_SAMPLER_3D: Int = 0x8dcb
  val GL_INT_SAMPLER_CUBE: Int = 0x8dcc
  val GL_INT_SAMPLER_2D_ARRAY: Int = 0x8dcf
  val GL_UNSIGNED_INT_SAMPLER_2D: Int = 0x8dd2
  val GL_UNSIGNED_INT_SAMPLER_3D: Int = 0x8dd3
  val GL_UNSIGNED_INT_SAMPLER_CUBE: Int = 0x8dd4
  val GL_UNSIGNED_INT_SAMPLER_2D_ARRAY: Int = 0x8dd7
  val GL_BUFFER_ACCESS_FLAGS: Int = 0x911f
  val GL_BUFFER_MAP_LENGTH: Int = 0x9120
  val GL_BUFFER_MAP_OFFSET: Int = 0x9121
  val GL_DEPTH_COMPONENT32F: Int = 0x8cac
  val GL_DEPTH32F_STENCIL8: Int = 0x8cad
  val GL_FLOAT_32_UNSIGNED_INT_24_8_REV: Int = 0x8dad
  val GL_FRAMEBUFFER_ATTACHMENT_COLOR_ENCODING: Int = 0x8210
  val GL_FRAMEBUFFER_ATTACHMENT_COMPONENT_TYPE: Int = 0x8211
  val GL_FRAMEBUFFER_ATTACHMENT_RED_SIZE: Int = 0x8212
  val GL_FRAMEBUFFER_ATTACHMENT_GREEN_SIZE: Int = 0x8213
  val GL_FRAMEBUFFER_ATTACHMENT_BLUE_SIZE: Int = 0x8214
  val GL_FRAMEBUFFER_ATTACHMENT_ALPHA_SIZE: Int = 0x8215
  val GL_FRAMEBUFFER_ATTACHMENT_DEPTH_SIZE: Int = 0x8216
  val GL_FRAMEBUFFER_ATTACHMENT_STENCIL_SIZE: Int = 0x8217
  val GL_FRAMEBUFFER_DEFAULT: Int = 0x8218
  val GL_FRAMEBUFFER_UNDEFINED: Int = 0x8219
  val GL_DEPTH_STENCIL_ATTACHMENT: Int = 0x821a
  val GL_DEPTH_STENCIL: Int = 0x84f9
  val GL_UNSIGNED_INT_24_8: Int = 0x84fa
  val GL_DEPTH24_STENCIL8: Int = 0x88f0
  val GL_UNSIGNED_NORMALIZED: Int = 0x8c17
  val GL_DRAW_FRAMEBUFFER_BINDING: Int = GL20.GL_FRAMEBUFFER_BINDING
  val GL_READ_FRAMEBUFFER: Int = 0x8ca8
  val GL_DRAW_FRAMEBUFFER: Int = 0x8ca9
  val GL_READ_FRAMEBUFFER_BINDING: Int = 0x8caa
  val GL_RENDERBUFFER_SAMPLES: Int = 0x8cab
  val GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LAYER: Int = 0x8cd4
  val GL_MAX_COLOR_ATTACHMENTS: Int = 0x8cdf
  val GL_COLOR_ATTACHMENT1: Int = 0x8ce1
  val GL_COLOR_ATTACHMENT2: Int = 0x8ce2
  val GL_COLOR_ATTACHMENT3: Int = 0x8ce3
  val GL_COLOR_ATTACHMENT4: Int = 0x8ce4
  val GL_COLOR_ATTACHMENT5: Int = 0x8ce5
  val GL_COLOR_ATTACHMENT6: Int = 0x8ce6
  val GL_COLOR_ATTACHMENT7: Int = 0x8ce7
  val GL_COLOR_ATTACHMENT8: Int = 0x8ce8
  val GL_COLOR_ATTACHMENT9: Int = 0x8ce9
  val GL_COLOR_ATTACHMENT10: Int = 0x8cea
  val GL_COLOR_ATTACHMENT11: Int = 0x8ceb
  val GL_COLOR_ATTACHMENT12: Int = 0x8cec
  val GL_COLOR_ATTACHMENT13: Int = 0x8ced
  val GL_COLOR_ATTACHMENT14: Int = 0x8cee
  val GL_COLOR_ATTACHMENT15: Int = 0x8cef
  val GL_FRAMEBUFFER_INCOMPLETE_MULTISAMPLE: Int = 0x8d56
  val GL_MAX_SAMPLES: Int = 0x8d57
  val GL_HALF_FLOAT: Int = 0x140b
  val GL_MAP_READ_BIT: Int = 0x0001
  val GL_MAP_WRITE_BIT: Int = 0x0002
  val GL_MAP_INVALIDATE_RANGE_BIT: Int = 0x0004
  val GL_MAP_INVALIDATE_BUFFER_BIT: Int = 0x0008
  val GL_MAP_FLUSH_EXPLICIT_BIT: Int = 0x0010
  val GL_MAP_UNSYNCHRONIZED_BIT: Int = 0x0020
  val GL_RG: Int = 0x8227
  val GL_RG_INTEGER: Int = 0x8228
  val GL_R8: Int = 0x8229
  val GL_RG8: Int = 0x822b
  val GL_R16F: Int = 0x822d
  val GL_R32F: Int = 0x822e
  val GL_RG16F: Int = 0x822f
  val GL_RG32F: Int = 0x8230
  val GL_R8I: Int = 0x8231
  val GL_R8UI: Int = 0x8232
  val GL_R16I: Int = 0x8233
  val GL_R16UI: Int = 0x8234
  val GL_R32I: Int = 0x8235
  val GL_R32UI: Int = 0x8236
  val GL_RG8I: Int = 0x8237
  val GL_RG8UI: Int = 0x8238
  val GL_RG16I: Int = 0x8239
  val GL_RG16UI: Int = 0x823a
  val GL_RG32I: Int = 0x823b
  val GL_RG32UI: Int = 0x823c
  val GL_VERTEX_ARRAY_BINDING: Int = 0x85b5
  val GL_R8_SNORM: Int = 0x8f94
  val GL_RG8_SNORM: Int = 0x8f95
  val GL_RGB8_SNORM: Int = 0x8f96
  val GL_RGBA8_SNORM: Int = 0x8f97
  val GL_SIGNED_NORMALIZED: Int = 0x8f9c
  val GL_PRIMITIVE_RESTART_FIXED_INDEX: Int = 0x8d69
  val GL_COPY_READ_BUFFER: Int = 0x8f36
  val GL_COPY_WRITE_BUFFER: Int = 0x8f37
  val GL_COPY_READ_BUFFER_BINDING: Int = GL_COPY_READ_BUFFER
  val GL_COPY_WRITE_BUFFER_BINDING: Int = GL_COPY_WRITE_BUFFER
  val GL_UNIFORM_BUFFER: Int = 0x8a11
  val GL_UNIFORM_BUFFER_BINDING: Int = 0x8a28
  val GL_UNIFORM_BUFFER_START: Int = 0x8a29
  val GL_UNIFORM_BUFFER_SIZE: Int = 0x8a2a
  val GL_MAX_VERTEX_UNIFORM_BLOCKS: Int = 0x8a2b
  val GL_MAX_FRAGMENT_UNIFORM_BLOCKS: Int = 0x8a2d
  val GL_MAX_COMBINED_UNIFORM_BLOCKS: Int = 0x8a2e
  val GL_MAX_UNIFORM_BUFFER_BINDINGS: Int = 0x8a2f
  val GL_MAX_UNIFORM_BLOCK_SIZE: Int = 0x8a30
  val GL_MAX_COMBINED_VERTEX_UNIFORM_COMPONENTS: Int = 0x8a31
  val GL_MAX_COMBINED_FRAGMENT_UNIFORM_COMPONENTS: Int = 0x8a33
  val GL_UNIFORM_BUFFER_OFFSET_ALIGNMENT: Int = 0x8a34
  val GL_ACTIVE_UNIFORM_BLOCK_MAX_NAME_LENGTH: Int = 0x8a35
  val GL_ACTIVE_UNIFORM_BLOCKS: Int = 0x8a36
  val GL_UNIFORM_TYPE: Int = 0x8a37
  val GL_UNIFORM_SIZE: Int = 0x8a38
  val GL_UNIFORM_NAME_LENGTH: Int = 0x8a39
  val GL_UNIFORM_BLOCK_INDEX: Int = 0x8a3a
  val GL_UNIFORM_OFFSET: Int = 0x8a3b
  val GL_UNIFORM_ARRAY_STRIDE: Int = 0x8a3c
  val GL_UNIFORM_MATRIX_STRIDE: Int = 0x8a3d
  val GL_UNIFORM_IS_ROW_MAJOR: Int = 0x8a3e
  val GL_UNIFORM_BLOCK_BINDING: Int = 0x8a3f
  val GL_UNIFORM_BLOCK_DATA_SIZE: Int = 0x8a40
  val GL_UNIFORM_BLOCK_NAME_LENGTH: Int = 0x8a41
  val GL_UNIFORM_BLOCK_ACTIVE_UNIFORMS: Int = 0x8a42
  val GL_UNIFORM_BLOCK_ACTIVE_UNIFORM_INDICES: Int = 0x8a43
  val GL_UNIFORM_BLOCK_REFERENCED_BY_VERTEX_SHADER: Int = 0x8a44
  val GL_UNIFORM_BLOCK_REFERENCED_BY_FRAGMENT_SHADER: Int = 0x8a46
  val GL_INVALID_INDEX: Int = -1
  val GL_MAX_VERTEX_OUTPUT_COMPONENTS: Int = 0x9122
  val GL_MAX_FRAGMENT_INPUT_COMPONENTS: Int = 0x9125
  val GL_MAX_SERVER_WAIT_TIMEOUT: Int = 0x9111
  val GL_OBJECT_TYPE: Int = 0x9112
  val GL_SYNC_CONDITION: Int = 0x9113
  val GL_SYNC_STATUS: Int = 0x9114
  val GL_SYNC_FLAGS: Int = 0x9115
  val GL_SYNC_FENCE: Int = 0x9116
  val GL_SYNC_GPU_COMMANDS_COMPLETE: Int = 0x9117
  val GL_UNSIGNALED: Int = 0x9118
  val GL_SIGNALED: Int = 0x9119
  val GL_ALREADY_SIGNALED: Int = 0x911a
  val GL_TIMEOUT_EXPIRED: Int = 0x911b
  val GL_CONDITION_SATISFIED: Int = 0x911c
  val GL_WAIT_FAILED: Int = 0x911d
  val GL_SYNC_FLUSH_COMMANDS_BIT: Int = 0x00000001
  val GL_TIMEOUT_IGNORED: Long = -1
  val GL_VERTEX_ATTRIB_ARRAY_DIVISOR: Int = 0x88fe
  val GL_ANY_SAMPLES_PASSED: Int = 0x8c2f
  val GL_ANY_SAMPLES_PASSED_CONSERVATIVE: Int = 0x8d6a
  val GL_SAMPLER_BINDING: Int = 0x8919
  val GL_RGB10_A2UI: Int = 0x906f
  val GL_TEXTURE_SWIZZLE_R: Int = 0x8e42
  val GL_TEXTURE_SWIZZLE_G: Int = 0x8e43
  val GL_TEXTURE_SWIZZLE_B: Int = 0x8e44
  val GL_TEXTURE_SWIZZLE_A: Int = 0x8e45
  val GL_GREEN: Int = 0x1904
  val GL_BLUE: Int = 0x1905
  val GL_INT_2_10_10_10_REV: Int = 0x8d9f
  val GL_TRANSFORM_FEEDBACK: Int = 0x8e22
  val GL_TRANSFORM_FEEDBACK_PAUSED: Int = 0x8e23
  val GL_TRANSFORM_FEEDBACK_ACTIVE: Int = 0x8e24
  val GL_TRANSFORM_FEEDBACK_BINDING: Int = 0x8e25
  val GL_PROGRAM_BINARY_RETRIEVABLE_HINT: Int = 0x8257
  val GL_PROGRAM_BINARY_LENGTH: Int = 0x8741
  val GL_NUM_PROGRAM_BINARY_FORMATS: Int = 0x87fe
  val GL_PROGRAM_BINARY_FORMATS: Int = 0x87ff
  val GL_COMPRESSED_R11_EAC: Int = 0x9270
  val GL_COMPRESSED_SIGNED_R11_EAC: Int = 0x9271
  val GL_COMPRESSED_RG11_EAC: Int = 0x9272
  val GL_COMPRESSED_SIGNED_RG11_EAC: Int = 0x9273
  val GL_COMPRESSED_RGB8_ETC2: Int = 0x9274
  val GL_COMPRESSED_SRGB8_ETC2: Int = 0x9275
  val GL_COMPRESSED_RGB8_PUNCHTHROUGH_ALPHA1_ETC2: Int = 0x9276
  val GL_COMPRESSED_SRGB8_PUNCHTHROUGH_ALPHA1_ETC2: Int = 0x9277
  val GL_COMPRESSED_RGBA8_ETC2_EAC: Int = 0x9278
  val GL_COMPRESSED_SRGB8_ALPHA8_ETC2_EAC: Int = 0x9279
  val GL_TEXTURE_IMMUTABLE_FORMAT: Int = 0x912f
  val GL_MAX_ELEMENT_INDEX: Int = 0x8d6b
  val GL_NUM_SAMPLE_COUNTS: Int = 0x9380
  val GL_TEXTURE_IMMUTABLE_LEVELS: Int = 0x82df

  def glReadBuffer(mode: Int): F[Unit]

  def glDrawRangeElements(mode: Int, start: Int, end: Int, count: Int, `type`: Int, indices: Buffer): F[Unit]

  def glDrawRangeElements(mode: Int, start: Int, end: Int, count: Int, `type`: Int, offset: Int): F[Unit]

  def glTexImage3D(
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
  ): F[Unit]

  def glTexImage3D(
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
  ): F[Unit]

  def glTexSubImage3D(
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
  ): F[Unit]

  def glTexSubImage3D(
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
  ): F[Unit]

  def glCopyTexSubImage3D(
      target: Int,
      level: Int,
      xoffset: Int,
      yoffset: Int,
      zoffset: Int,
      x: Int,
      y: Int,
      width: Int,
      height: Int,
  ): F[Unit]

  def glGenQueries(n: Int, ids: Array[Int], offset: Int): F[Unit]

  def glGenQueries(n: Int, ids: IntBuffer): F[Unit]

  def glDeleteQueries(n: Int, ids: Array[Int], offset: Int): F[Unit]

  def glDeleteQueries(n: Int, ids: IntBuffer): F[Unit]

  def glIsQuery(id: Int): F[Boolean]

  def glBeginQuery(target: Int, id: Int): F[Unit]

  def glEndQuery(target: Int): F[Unit]

  def glGetQueryiv(target: Int, pname: Int, params: IntBuffer): F[Unit]

  def glGetQueryObjectuiv(id: Int, pname: Int, params: IntBuffer): F[Unit]

  def glUnmapBuffer(target: Int): F[Boolean]

  def glGetBufferPointerv(target: Int, pname: Int): F[Buffer]

  def glDrawBuffers(n: Int, bufs: IntBuffer): F[Unit]

  def glUniformMatrix2x3fv(location: Int, count: Int, transpose: Boolean, value: FloatBuffer): F[Unit]

  def glUniformMatrix3x2fv(location: Int, count: Int, transpose: Boolean, value: FloatBuffer): F[Unit]

  def glUniformMatrix2x4fv(location: Int, count: Int, transpose: Boolean, value: FloatBuffer): F[Unit]

  def glUniformMatrix4x2fv(location: Int, count: Int, transpose: Boolean, value: FloatBuffer): F[Unit]

  def glUniformMatrix3x4fv(location: Int, count: Int, transpose: Boolean, value: FloatBuffer): F[Unit]

  def glUniformMatrix4x3fv(location: Int, count: Int, transpose: Boolean, value: FloatBuffer): F[Unit]

  def glBlitFramebuffer(
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
  ): F[Unit]

  def glRenderbufferStorageMultisample(target: Int, samples: Int, internalformat: Int, width: Int, height: Int): F[Unit]

  def glFramebufferTextureLayer(target: Int, attachment: Int, texture: Int, level: Int, layer: Int): F[Unit]

  def glMapBufferRange(target: Int, offset: Int, length: Int, access: Int): F[Buffer]

  def glFlushMappedBufferRange(target: Int, offset: Int, length: Int): F[Unit]

  def glBindVertexArray(array: Int): F[Unit]

  def glDeleteVertexArrays(n: Int, arrays: Array[Int], offset: Int): F[Unit]

  def glDeleteVertexArrays(n: Int, arrays: IntBuffer): F[Unit]

  def glGenVertexArrays(n: Int, arrays: Array[Int], offset: Int): F[Unit]

  def glGenVertexArrays(n: Int, arrays: IntBuffer): F[Unit]

  def glIsVertexArray(array: Int): F[Boolean]

  def glBeginTransformFeedback(primitiveMode: Int): F[Unit]

  def glEndTransformFeedback: F[Unit]

  def glBindBufferRange(target: Int, index: Int, buffer: Int, offset: Int, size: Int): F[Unit]

  def glBindBufferBase(target: Int, index: Int, buffer: Int): F[Unit]

  def glTransformFeedbackVaryings(program: Int, varyings: Array[String], bufferMode: Int): F[Unit]

  def glVertexAttribIPointer(index: Int, size: Int, `type`: Int, stride: Int, offset: Int): F[Unit]

  def glGetVertexAttribIiv(index: Int, pname: Int, params: IntBuffer): F[Unit]

  def glGetVertexAttribIuiv(index: Int, pname: Int, params: IntBuffer): F[Unit]

  def glVertexAttribI4i(index: Int, x: Int, y: Int, z: Int, w: Int): F[Unit]

  def glVertexAttribI4ui(index: Int, x: Int, y: Int, z: Int, w: Int): F[Unit]

  def glGetUniformuiv(program: Int, location: Int, params: IntBuffer): F[Unit]

  def glGetFragDataLocation(program: Int, name: String): F[Int]

  def glUniform1uiv(location: Int, count: Int, value: IntBuffer): F[Unit]

  def glUniform3uiv(location: Int, count: Int, value: IntBuffer): F[Unit]

  def glUniform4uiv(location: Int, count: Int, value: IntBuffer): F[Unit]

  def glClearBufferiv(buffer: Int, drawbuffer: Int, value: IntBuffer): F[Unit]

  def glClearBufferuiv(buffer: Int, drawbuffer: Int, value: IntBuffer): F[Unit]

  def glClearBufferfv(buffer: Int, drawbuffer: Int, value: FloatBuffer): F[Unit]

  def glClearBufferfi(buffer: Int, drawbuffer: Int, depth: Float, stencil: Int): F[Unit]

  def glGetStringi(name: Int, index: Int): F[String]

  def glCopyBufferSubData(readTarget: Int, writeTarget: Int, readOffset: Int, writeOffset: Int, size: Int): F[Unit]

  def glGetUniformIndices(program: Int, uniformNames: Array[String], uniformIndices: IntBuffer): F[Unit]

  def glGetActiveUniformsiv(
      program: Int,
      uniformCount: Int,
      uniformIndices: IntBuffer,
      pname: Int,
      params: IntBuffer,
  ): F[Unit]

  def glGetUniformBlockIndex(program: Int, uniformBlockName: String): F[Int]

  def glGetActiveUniformBlockiv(program: Int, uniformBlockIndex: Int, pname: Int, params: IntBuffer): F[Unit]

  def glGetActiveUniformBlockName(
      program: Int,
      uniformBlockIndex: Int,
      length: Buffer,
      uniformBlockName: Buffer,
  ): F[Unit]

  def glGetActiveUniformBlockName(program: Int, uniformBlockIndex: Int): F[String]

  def glUniformBlockBinding(program: Int, uniformBlockIndex: Int, uniformBlockBinding: Int): F[Unit]

  def glDrawArraysInstanced(mode: Int, first: Int, count: Int, instanceCount: Int): F[Unit]

  def glDrawElementsInstanced(mode: Int, count: Int, `type`: Int, indicesOffset: Int, instanceCount: Int): F[Unit]

  def glGetInteger64v(pname: Int, params: java.nio.LongBuffer): F[Unit]

  def glGetBufferParameteri64v(target: Int, pname: Int, params: java.nio.LongBuffer): F[Unit]

  def glGenSamplers(count: Int, samplers: Array[Int], offset: Int): F[Unit]

  def glGenSamplers(count: Int, samplers: IntBuffer): F[Unit]

  def glDeleteSamplers(count: Int, samplers: Array[Int], offset: Int): F[Unit]

  def glDeleteSamplers(count: Int, samplers: IntBuffer): F[Unit]

  def glIsSampler(sampler: Int): F[Boolean]

  def glBindSampler(unit: Int, sampler: Int): F[Unit]

  def glSamplerParameteri(sampler: Int, pname: Int, param: Int): F[Unit]

  def glSamplerParameteriv(sampler: Int, pname: Int, param: IntBuffer): F[Unit]

  def glSamplerParameterf(sampler: Int, pname: Int, param: Float): F[Unit]

  def glSamplerParameterfv(sampler: Int, pname: Int, param: FloatBuffer): F[Unit]

  def glGetSamplerParameteriv(sampler: Int, pname: Int, params: IntBuffer): F[Unit]

  def glGetSamplerParameterfv(sampler: Int, pname: Int, params: FloatBuffer): F[Unit]

  def glVertexAttribDivisor(index: Int, divisor: Int): F[Unit]

  def glBindTransformFeedback(target: Int, id: Int): F[Unit]

  def glDeleteTransformFeedbacks(n: Int, ids: Array[Int], offset: Int): F[Unit]

  def glDeleteTransformFeedbacks(n: Int, ids: IntBuffer): F[Unit]

  def glGenTransformFeedbacks(n: Int, ids: Array[Int], offset: Int): F[Unit]

  def glGenTransformFeedbacks(n: Int, ids: IntBuffer): F[Unit]

  def glIsTransformFeedback(id: Int): F[Boolean]

  def glPauseTransformFeedback: F[Unit]

  def glResumeTransformFeedback: F[Unit]

  def glProgramParameteri(program: Int, pname: Int, value: Int): F[Unit]

  def glInvalidateFramebuffer(target: Int, numAttachments: Int, attachments: IntBuffer): F[Unit]

  def glInvalidateSubFramebuffer(
      target: Int,
      numAttachments: Int,
      attachments: IntBuffer,
      x: Int,
      y: Int,
      width: Int,
      height: Int,
  ): F[Unit]
}
