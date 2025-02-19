
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mrpillow.clashcraft.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.mrpillow.clashcraft.ClashCraftMod;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class ClashCraftModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ClashCraftMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CLASH_CRAFT_SPAWN_EGGS = REGISTRY.register("clash_craft_spawn_eggs",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.clash_craft.clash_craft_spawn_eggs")).icon(() -> new ItemStack(ClashCraftModItems.GIANT_SPAWN_EGG.get())).displayItems((parameters, tabData) -> {
				tabData.accept(ClashCraftModItems.GIANT_SPAWN_EGG.get());
				tabData.accept(ClashCraftModItems.KNIGHT_SPAWN_EGG.get());
			}).build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(ClashCraftModItems.CLASH_DIMENSION.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.COMBAT) {
			tabData.accept(ClashCraftModItems.GIANT_SHIRT_CHESTPLATE.get());
		}
	}
}
