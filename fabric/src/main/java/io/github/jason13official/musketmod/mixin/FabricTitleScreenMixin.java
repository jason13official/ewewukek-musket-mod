package io.github.jason13official.musketmod.mixin;

import io.github.jason13official.musketmod.MusketMod;
import io.github.jason13official.musketmod.platform.Services;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class FabricTitleScreenMixin {

  @Inject(at = @At("HEAD"), method = "init()V")
  private void init(CallbackInfo info) {

    if (Services.PLATFORM.isDevelopmentEnvironment()) {
      MusketMod.LOG.info("This line is printed by an example mixin from Fabric!");
      MusketMod.LOG.info("MC Version: {}", Minecraft.getInstance().getVersionType());
    }
  }
}