
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mrpillow.clashcraft.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;

import net.mrpillow.clashcraft.ClashCraftMod;

import net.minecraft.world.item.Item;

public class ClashCraftModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(ClashCraftMod.MODID);
	public static final DeferredItem<Item> GIANT_SPAWN_EGG = REGISTRY.register("giant_spawn_egg", () -> new DeferredSpawnEggItem(ClashCraftModEntities.GIANT, -10079488, -26368, new Item.Properties()));
	// Start of user code block custom items
	// End of user code block custom items
}
