package io.github.jason13official.musketmod.mixin;

import io.github.jason13official.musketmod.impl.common.item.ScopedMusketItem;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
abstract class PlayerMixin {
    @Inject(method = "isScoping", at = @At("HEAD"), cancellable = true)
    private void isScoping(CallbackInfoReturnable<Boolean> ci) {
        if (ScopedMusketItem.isScoping) {
            ci.setReturnValue(true);
            ci.cancel();
        }
    }
}
