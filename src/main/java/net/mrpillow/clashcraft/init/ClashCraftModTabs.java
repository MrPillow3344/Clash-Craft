
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mrpillow.clashcraft.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.mrpillow.clashcraft.ClashCraftMod;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

public class ClashCraftModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ClashCraftMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CLASH_CRAFT_ITEMS = REGISTRY.register("clash_craft_items",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.clash_craft.clash_craft_items")).icon(() -> new ItemStack(ClashCraftModItems.GIANT_SHIRT_CHESTPLATE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(ClashCraftModItems.CLASH_DIMENSION.get());
				tabData.accept(ClashCraftModItems.GIANT_SHIRT_CHESTPLATE.get());
				tabData.accept(ClashCraftModItems.KNIGHTS_SWORD.get());
				tabData.accept(ClashCraftModItems.FIREBALL_ITEM.get());
				tabData.accept(ClashCraftModItems.ARROWS.get());
				tabData.accept(ClashCraftModItems.PANCAKE.get());
				tabData.accept(ClashCraftModItems.SPEAR.get());
			}).build());
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CLASH_CRAFT_SPAWN_EGGS = REGISTRY.register("clash_craft_spawn_eggs",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.clash_craft.clash_craft_spawn_eggs")).icon(() -> new ItemStack(ClashCraftModItems.GIANT_SPAWN_EGG.get())).displayItems((parameters, tabData) -> {
				tabData.accept(ClashCraftModItems.GIANT_SPAWN_EGG.get());
				tabData.accept(ClashCraftModItems.KNIGHT_SPAWN_EGG.get());
				tabData.accept(ClashCraftModItems.MINION_SPAWN_EGG.get());
				tabData.accept(ClashCraftModItems.MINI_PEKKA_SPAWN_EGG.get());
				tabData.accept(ClashCraftModItems.ARCHER_SPAWN_EGG.get());
				tabData.accept(ClashCraftModItems.SPEAR_GOBLIN_SPAWN_EGG.get());
				tabData.accept(ClashCraftModItems.GOBLIN_HUT_SPAWN_EGG.get());
			}).withTabsBefore(CLASH_CRAFT_ITEMS.getId()).build());
}
