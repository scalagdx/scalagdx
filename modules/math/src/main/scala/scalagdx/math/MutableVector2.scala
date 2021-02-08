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
 */
package scalagdx.math

import eu.timepit.refined.api.Refined
import eu.timepit.refined.auto._

object MutableVector2 {

  import scalagdx.math.Vector2.XY

  /**
   * Constructs a new [[MutableVector2]] using the given (x, y) values.
   */
  def apply(x: Float = 0f, y: Float = 0f): MutableVector2 = new MutableVector2(x, y)

  /**
   * Destructure the [[MutableVector2]] for pattern-matching.
   */
  def unapply(vector: MutableVector2): Option[(Float, Float)] = Some(vector.x -> vector.y)

  /**
   * Creates a new [[MutableVector2]] from a string with the format (x,y).
   */
  def fromString(value: String Refined XY): MutableVector2 = MutableVector2().fromString(value)
}
