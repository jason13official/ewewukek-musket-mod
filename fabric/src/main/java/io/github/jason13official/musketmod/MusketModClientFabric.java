package io.github.jason13official.musketmod;

import io.github.jason13official.musketmod.impl.client.BulletRenderer;
import io.github.jason13official.musketmod.impl.client.ClientUtilities;
import io.github.jason13official.musketmod.impl.common.SmokeEffectPacket;
import io.github.jason13official.musketmod.impl.common.entity.BulletEntity;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class MusketModClientFabric implements ClientModInitializer {

  @Override
  public void onInitializeClient() {
    EntityRendererRegistry.register(BulletEntity.ENTITY_TYPE, (context) -> new BulletRenderer(context));

    ClientPlayNetworking.registerGlobalReceiver(SmokeEffectPacket.TYPE, (packet, context) -> {
      context.client().execute(() -> {
        ClientUtilities.handleSmokeEffectPacket(packet);
      });
    });
  }
}
