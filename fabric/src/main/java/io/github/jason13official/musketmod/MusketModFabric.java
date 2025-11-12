package io.github.jason13official.musketmod;

import io.github.jason13official.musketmod.impl.common.DeferredDamage;
import io.github.jason13official.musketmod.impl.common.SmokeEffectPacket;
import io.github.jason13official.musketmod.impl.common.VanillaHelper;
import io.github.jason13official.musketmod.impl.common.entity.BulletEntity;
import io.github.jason13official.musketmod.impl.common.registry.Items;
import io.github.jason13official.musketmod.impl.common.registry.Sounds;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.item.v1.EnchantmentEvents;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.util.TriState;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.Unit;
import net.minecraft.util.profiling.ProfilerFiller;

public class MusketModFabric implements ModInitializer {

  @Override
  public void onInitialize() {

    Config.load();

    bind(BuiltInRegistries.DATA_COMPONENT_TYPE, Items::registerDataComponentTypes);
    bind(BuiltInRegistries.ITEM, Items::registerItems);
    bind(BuiltInRegistries.SOUND_EVENT, Sounds::registerSoundEvents);

    BulletEntity.register((string, entityType) -> {
      Registry.register(BuiltInRegistries.ENTITY_TYPE, MusketMod.resource(string), entityType);
    });

    MusketMod.init();

    EnchantmentEvents.ALLOW_ENCHANTING.register((enchantment, stack, context) -> {
      return VanillaHelper.canEnchant(enchantment, stack)
          ? TriState.TRUE
          : TriState.DEFAULT;
    });

    ServerTickEvents.END_WORLD_TICK.register((world) -> {
      DeferredDamage.apply();
    });

    PayloadTypeRegistry.playS2C().register(SmokeEffectPacket.TYPE, SmokeEffectPacket.CODEC);

    ResourceManagerHelper.get(PackType.SERVER_DATA).registerReloadListener(new IdentifiableResourceReloadListener() {
      @Override
      public ResourceLocation getFabricId() {
        return MusketMod.resource("reload");
      }

      @Override
      public CompletableFuture<Void> reload(PreparationBarrier stage, ResourceManager manager, Executor backgroundExecutor, Executor gameExecutor) {
        return stage.wait(Unit.INSTANCE).thenRunAsync(() -> {
          Config.load();
        }, gameExecutor);
      }
    });
  }

  public static <T> void bind(Registry<T> registry, Consumer<BiConsumer<T, ResourceLocation>> source) {
    source.accept((t, rl) -> Registry.register(registry, rl, t));
  }
}
