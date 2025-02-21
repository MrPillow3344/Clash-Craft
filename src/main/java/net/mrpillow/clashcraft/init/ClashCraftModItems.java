
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mrpillow.clashcraft.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;

import net.mrpillow.clashcraft.item.KnightsSwordItem;
import net.mrpillow.clashcraft.item.GiantShirtItem;
import net.mrpillow.clashcraft.item.ClashDimensionItem;
import net.mrpillow.clashcraft.ClashCraftMod;

import net.minecraft.world.item.Item;

public class ClashCraftModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(ClashCraftMod.MODID);
	public static final DeferredItem<Item> CLASH_DIMENSION = REGISTRY.register("clash_dimension", ClashDimensionItem::new);
	public static final DeferredItem<Item> GIANT_SPAWN_EGG = REGISTRY.register("giant_spawn_egg", () -> new DeferredSpawnEggItem(ClashCraftModEntities.GIANT, -10079488, -26368, new Item.Properties()));
	public static final DeferredItem<Item> GIANT_SHIRT_CHESTPLATE = REGISTRY.register("giant_shirt_chestplate", GiantShirtItem.Chestplate::new);
	public static final DeferredItem<Item> KNIGHT_SPAWN_EGG = REGISTRY.register("knight_spawn_egg", () -> new DeferredSpawnEggItem(ClashCraftModEntities.KNIGHT, -3355444, -256, new Item.Properties()));
	public static final DeferredItem<Item> KNIGHTS_SWORD = REGISTRY.register("knights_sword", KnightsSwordItem::new);
	// Start of user code block custom items
	// End of user code block custom items
}
