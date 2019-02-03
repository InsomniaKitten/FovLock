/*
 * Copyright (C) 2018 InsomniaKitten
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.insomniakitten.fovlock;

public interface FovModifierFunction {
  float NULL_MODIFIER = 1.0F;

  static FovModifierFunction constant(final float modifier) {
    return lastModifier -> modifier;
  }

  static FovModifierFunction adding(final float addition) {
    return lastModifier -> lastModifier + addition;
  }

  static FovModifierFunction subtracting(final float subtraction) {
    return lastModifier -> lastModifier - subtraction;
  }

  static FovModifierFunction multiplying(final float multiplier) {
    return lastModifier -> lastModifier * multiplier;
  }

  static FovModifierFunction dividing(final float divider) {
    return lastModifier -> lastModifier / divider;
  }

  float getFovModifier(final float lastModifier);
}
