package io.github.jason13official.musketmod.mixin;

import io.github.jason13official.musketmod.MusketMod;
import io.github.jason13official.musketmod.platform.Services;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class PLACEHOLDERMinecraftMixin {

  @Inject(at = @At("TAIL"), method = "<init>")
  private void init(CallbackInfo info) {

    if (Services.PLATFORM.isDevelopmentEnvironment()) {
      MusketMod.LOG.info("This line is printed by an example mixin from Common!");
      MusketMod.LOG.info("MC Version: {}", Minecraft.getInstance().getVersionType());
    }
  }
}