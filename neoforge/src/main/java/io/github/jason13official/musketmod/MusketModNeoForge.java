package io.github.jason13official.musketmod;


import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class MusketModNeoForge {

  static IEventBus eventBus;

  public MusketModNeoForge(final IEventBus eventBus) {

    MusketModNeoForge.eventBus = eventBus;

    MusketMod.init();
  }
}