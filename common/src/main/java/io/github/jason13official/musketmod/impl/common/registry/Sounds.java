package io.github.jason13official.musketmod.impl.common.registry;

import io.github.jason13official.musketmod.MusketMod;
import java.util.function.BiConsumer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

public class Sounds {
    public static final SoundEvent MUSKET_LOAD_0 = SoundEvent.createVariableRangeEvent(MusketMod.resource("musket_load0"));
    public static final SoundEvent MUSKET_LOAD_1 = SoundEvent.createVariableRangeEvent(MusketMod.resource("musket_load1"));
    public static final SoundEvent MUSKET_LOAD_2 = SoundEvent.createVariableRangeEvent(MusketMod.resource("musket_load2"));
    public static final SoundEvent MUSKET_READY = SoundEvent.createVariableRangeEvent(MusketMod.resource("musket_ready"));
    public static final SoundEvent MUSKET_FIRE = SoundEvent.createVariableRangeEvent(MusketMod.resource("musket_fire"));
    public static final SoundEvent BLUNDERBUSS_FIRE = SoundEvent.createVariableRangeEvent(MusketMod.resource("blunderbuss_fire"));
    public static final SoundEvent BLUNDERBUSS_FIRE_FLAME = SoundEvent.createVariableRangeEvent(MusketMod.resource("blunderbuss_fire_flame"));
    public static final SoundEvent PISTOL_FIRE = SoundEvent.createVariableRangeEvent(MusketMod.resource("pistol_fire"));
    public static final SoundEvent DISPENSER_FIRE = SoundEvent.createVariableRangeEvent(MusketMod.resource("dispenser_fire"));
    public static final SoundEvent BULLET_FLY_BY = SoundEvent.createVariableRangeEvent(MusketMod.resource("bullet_fly_by"));
    public static final SoundEvent BULLET_WATER_HIT = SoundEvent.createVariableRangeEvent(MusketMod.resource("bullet_water_hit"));

    public static void registerSoundEvents(BiConsumer<SoundEvent, ResourceLocation> consumer) {
        consumer.accept(MUSKET_LOAD_0, MusketMod.resource("musket_load0"));
        consumer.accept(MUSKET_LOAD_1, MusketMod.resource("musket_load1"));
        consumer.accept(MUSKET_LOAD_2, MusketMod.resource("musket_load2"));
        consumer.accept(MUSKET_READY, MusketMod.resource("musket_ready"));
        consumer.accept(MUSKET_FIRE, MusketMod.resource("musket_fire"));
        consumer.accept(BLUNDERBUSS_FIRE, MusketMod.resource("blunderbuss_fire"));
        consumer.accept(BLUNDERBUSS_FIRE_FLAME, MusketMod.resource("blunderbuss_fire_flame"));
        consumer.accept(PISTOL_FIRE, MusketMod.resource("pistol_fire"));
        consumer.accept(DISPENSER_FIRE, MusketMod.resource("dispenser_fire"));
        consumer.accept(BULLET_FLY_BY, MusketMod.resource("bullet_fly_by"));
        consumer.accept(BULLET_WATER_HIT, MusketMod.resource("bullet_water_hit"));
    }
}
