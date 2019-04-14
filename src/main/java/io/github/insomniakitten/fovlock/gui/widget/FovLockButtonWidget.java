/*
 * Copyright (C) 2019 InsomniaKitten
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

package io.github.insomniakitten.fovlock.gui.widget;

import com.google.common.base.MoreObjects;
import io.github.insomniakitten.fovlock.FovLock;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.LockButtonWidget;

public final class FovLockButtonWidget extends LockButtonWidget {
  public FovLockButtonWidget(final int x, final int y) {
    super(x, y, FovLockButtonWidget::toggleLock);
    setLocked(FovLock.isEnabled());
  }

  private static void toggleLock(final ButtonWidget widget) {
    final LockButtonWidget lock = (LockButtonWidget) widget;
    lock.setLocked(!lock.isLocked());
  }

  @Override
  public void setLocked(final boolean state) {
    super.setLocked(state);
    FovLock.setEnabled(state);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
      .add("locked", isLocked())
      .toString();
  }
}
