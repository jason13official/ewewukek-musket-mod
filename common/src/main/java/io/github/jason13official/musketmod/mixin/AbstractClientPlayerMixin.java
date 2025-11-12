package io.github.jason13official.musketmod.mixin;

import io.github.jason13official.musketmod.Config;
import io.github.jason13official.musketmod.impl.common.item.ScopedMusketItem;
import net.minecraft.client.player.AbstractClientPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractClientPlayer.class)
abstract class AbstractClientPlayerMixin {
    @Inject(method = "getFieldOfViewModifier", at = @At("HEAD"), cancellable = true)
    private void getFieldOfViewModifier(CallbackInfoReturnable<Float> ci) {
        if (ScopedMusketItem.isScoping) {
            ci.setReturnValue(1.0f / Config.scopeZoom);
            ci.cancel();
        }
    }
}
