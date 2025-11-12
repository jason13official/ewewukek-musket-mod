package io.github.jason13official.musketmod.impl.common.registry;

import io.github.jason13official.musketmod.Config;
import io.github.jason13official.musketmod.MusketMod;
import io.github.jason13official.musketmod.impl.common.item.BlunderbussItem;
import io.github.jason13official.musketmod.impl.common.item.CartridgeItem;
import io.github.jason13official.musketmod.impl.common.item.GunItem;
import io.github.jason13official.musketmod.impl.common.item.MusketItem;
import io.github.jason13official.musketmod.impl.common.item.PistolItem;
import io.github.jason13official.musketmod.impl.common.item.ScopedMusketItem;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.SmithingTemplateItem;

public class Items {

  public static final Item MUSKET = new MusketItem(new Item.Properties().durability(Config.musketDurability).setId(ResourceKey.create(Registries.ITEM, MusketMod.resource("musket"))));
  public static final Item MUSKET_WITH_BAYONET = new MusketItem(new Item.Properties().durability(Config.musketDurability).attributes(MusketItem.createBayonetAttributes()).setId(ResourceKey.create(Registries.ITEM, MusketMod.resource("musket_with_bayonet"))));
  public static final Item MUSKET_WITH_SCOPE = new ScopedMusketItem(new Item.Properties().durability(Config.scopedMusketDurability).setId(ResourceKey.create(Registries.ITEM, MusketMod.resource("musket_with_scope"))));
  public static final Item BLUNDERBUSS = new BlunderbussItem(new Item.Properties().durability(Config.blunderbussDurability).setId(ResourceKey.create(Registries.ITEM, MusketMod.resource("blunderbuss"))));
  public static final Item PISTOL = new PistolItem(new Item.Properties().durability(Config.pistolDurability).setId(ResourceKey.create(Registries.ITEM, MusketMod.resource("pistol"))));
  public static final Item CARTRIDGE = new CartridgeItem(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, MusketMod.resource("cartridge"))));

  public static final ResourceLocation EMPTY_SLOT_MUSKET = MusketMod.resource("item/empty_slot_musket");
  public static final ResourceLocation EMPTY_SLOT_SPYGLASS = ResourceLocation.withDefaultNamespace("item/empty_slot_spyglass");

  static ResourceLocation EMPTY_SLOT_SWORD = ResourceLocation.withDefaultNamespace("container/slot/sword");
  static ChatFormatting DESCRIPTION_FORMAT = ChatFormatting.BLUE;

  public static final Item MUSKET_UPGRADE = new SmithingTemplateItem(Component.translatable(Util.makeDescriptionId("item", MusketMod.resource("musket"))).withStyle(DESCRIPTION_FORMAT),

      Component.translatable(Util.makeDescriptionId("item", MusketMod.resource("musket_upgrade.ingredients"))).withStyle(DESCRIPTION_FORMAT),

      Component.translatable(Util.makeDescriptionId("item", MusketMod.resource("musket_upgrade.base_slot_description"))),

      Component.translatable(Util.makeDescriptionId("item", MusketMod.resource("musket_upgrade.additions_slot_description"))),

      List.of(EMPTY_SLOT_MUSKET), List.of(EMPTY_SLOT_SWORD, EMPTY_SLOT_SPYGLASS),

      new Properties().setId(ResourceKey.create(Registries.ITEM, MusketMod.resource("musket_upgrade"))));

  public static void registerDataComponentTypes(BiConsumer<DataComponentType<?>, ResourceLocation> consumer) {
    consumer.accept(GunItem.LOADED, MusketMod.resource("loaded"));
    consumer.accept(GunItem.LOADING_STAGE, MusketMod.resource("loading_stage"));
  }

  public static void registerItems(BiConsumer<Item, ResourceLocation> helper) {
    helper.accept(MUSKET, MusketMod.resource("musket"));
    helper.accept(MUSKET_WITH_BAYONET, MusketMod.resource("musket_with_bayonet"));
    helper.accept(MUSKET_WITH_SCOPE, MusketMod.resource("musket_with_scope"));
    helper.accept(BLUNDERBUSS, MusketMod.resource("blunderbuss"));
    helper.accept(PISTOL, MusketMod.resource("pistol"));
    helper.accept(CARTRIDGE, MusketMod.resource("cartridge"));
    helper.accept(MUSKET_UPGRADE, MusketMod.resource("musket_upgrade_smithing_template"));
  }

  public static void addToCreativeTab(ResourceKey<CreativeModeTab> tab, Consumer<Item> helper) {
//        if (tab == CreativeModeTabs.COMBAT) {
//            helper.accept(MUSKET);
//            helper.accept(MUSKET_WITH_BAYONET);
//            helper.accept(MUSKET_WITH_SCOPE);
//            helper.accept(BLUNDERBUSS);
//            helper.accept(PISTOL);
//            helper.accept(CARTRIDGE);
//        }
//        if (tab == CreativeModeTabs.INGREDIENTS) {
//            helper.accept(MUSKET_UPGRADE);
//        }
  }
}
