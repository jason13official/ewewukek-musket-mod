package io.github.jason13official.musketmod.impl.common.item;

import io.github.jason13official.musketmod.Config;
import io.github.jason13official.musketmod.impl.common.registry.Sounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.ItemStack;

public class BlunderbussItem extends GunItem {
    public BlunderbussItem(Properties properties) {
        super(properties);
    }

    @Override
    public float bulletStdDev() {
        return Config.blunderbussBulletStdDev;
    }

    @Override
    public float bulletSpeed() {
        return Config.blunderbussBulletSpeed;
    }

    @Override
    public int pelletCount() {
        return Config.blunderbussPelletCount;
    }

    @Override
    public float damage() {
        return Config.blunderbussDamage;
    }

    @Override
    public SoundEvent fireSound(ItemStack stack) {
        if (hasFlame(stack)) {
            return Sounds.BLUNDERBUSS_FIRE_FLAME;
        } else {
            return Sounds.BLUNDERBUSS_FIRE;
        }
    }
}
