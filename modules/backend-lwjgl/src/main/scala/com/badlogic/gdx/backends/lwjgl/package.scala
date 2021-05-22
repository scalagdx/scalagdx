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
package com.badlogic.gdx.backends

import org.lwjgl.input.Cursor

package object lwjgl {

  implicit class LwjglCursorOps(private val instance: LwjglCursor) extends AnyVal {

    // Workaround to LwjglCursor#lwjglCursor being package private
    def lwjglCursor: Cursor = instance.lwjglCursor
  }

  // Workaround due to their constructors being package private
  def newLwjglGL20: LwjglGL20 = new LwjglGL20
  def newLwjglGL30: LwjglGL30 = new LwjglGL30
}
