package io.github.jason13official.musketmod;

import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Constants.MOD_ID)
public class MusketModForge {

  static BusGroup busGroup;

  public MusketModForge(final FMLJavaModLoadingContext context) {

    MusketModForge.busGroup = context.getModBusGroup();

    MusketMod.init();
  }
}