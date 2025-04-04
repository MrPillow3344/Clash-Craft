
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mrpillow.clashcraft.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;

import net.mrpillow.clashcraft.item.SpearItem;
import net.mrpillow.clashcraft.item.PancakeItem;
import net.mrpillow.clashcraft.item.MinionsIronBallItemItem;
import net.mrpillow.clashcraft.item.LarrysBoneItem;
import net.mrpillow.clashcraft.item.LarrySpawnerItem;
import net.mrpillow.clashcraft.item.KnightsSwordItem;
import net.mrpillow.clashcraft.item.GraveyardItemItem;
import net.mrpillow.clashcraft.item.GiantShirtItem;
import net.mrpillow.clashcraft.item.FireballItemItem;
import net.mrpillow.clashcraft.item.ClashDimensionItem;
import net.mrpillow.clashcraft.item.ArrowsItem;
import net.mrpillow.clashcraft.ClashCraftMod;

import net.minecraft.world.item.Item;

public class ClashCraftModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(ClashCraftMod.MODID);
	public static final DeferredItem<Item> CLASH_DIMENSION = REGISTRY.register("clash_dimension", ClashDimensionItem::new);
	public static final DeferredItem<Item> GIANT_SPAWN_EGG = REGISTRY.register("giant_spawn_egg", () -> new DeferredSpawnEggItem(ClashCraftModEntities.GIANT, -10079488, -26368, new Item.Properties()));
	public static final DeferredItem<Item> GIANT_SHIRT_CHESTPLATE = REGISTRY.register("giant_shirt_chestplate", GiantShirtItem.Chestplate::new);
	public static final DeferredItem<Item> KNIGHT_SPAWN_EGG = REGISTRY.register("knight_spawn_egg", () -> new DeferredSpawnEggItem(ClashCraftModEntities.KNIGHT, -3355444, -256, new Item.Properties()));
	public static final DeferredItem<Item> KNIGHTS_SWORD = REGISTRY.register("knights_sword", KnightsSwordItem::new);
	public static final DeferredItem<Item> MINION_SPAWN_EGG = REGISTRY.register("minion_spawn_egg", () -> new DeferredSpawnEggItem(ClashCraftModEntities.MINION, -16750951, -16777114, new Item.Properties()));
	public static final DeferredItem<Item> MINIONS_IRON_BALL_ITEM = REGISTRY.register("minions_iron_ball_item", MinionsIronBallItemItem::new);
	public static final DeferredItem<Item> FIREBALL_ITEM = REGISTRY.register("fireball_item", FireballItemItem::new);
	public static final DeferredItem<Item> ARROWS = REGISTRY.register("arrows", ArrowsItem::new);
	public static final DeferredItem<Item> MINI_PEKKA_SPAWN_EGG = REGISTRY.register("mini_pekka_spawn_egg", () -> new DeferredSpawnEggItem(ClashCraftModEntities.MINI_PEKKA, -13811623, -12627608, new Item.Properties()));
	public static final DeferredItem<Item> PANCAKE = REGISTRY.register("pancake", PancakeItem::new);
	public static final DeferredItem<Item> ARCHER_SPAWN_EGG = REGISTRY.register("archer_spawn_egg", () -> new DeferredSpawnEggItem(ClashCraftModEntities.ARCHER, -10027264, -39220, new Item.Properties()));
	public static final DeferredItem<Item> SPEAR_GOBLIN_SPAWN_EGG = REGISTRY.register("spear_goblin_spawn_egg", () -> new DeferredSpawnEggItem(ClashCraftModEntities.SPEAR_GOBLIN, -10040320, -6724096, new Item.Properties()));
	public static final DeferredItem<Item> SPEAR = REGISTRY.register("spear", SpearItem::new);
	public static final DeferredItem<Item> LARRY_SPAWN_EGG = REGISTRY.register("larry_spawn_egg", () -> new DeferredSpawnEggItem(ClashCraftModEntities.LARRY, -1, -3355444, new Item.Properties()));
	public static final DeferredItem<Item> GOBLIN_HUT_SPAWN_EGG = REGISTRY.register("goblin_hut_spawn_egg", () -> new DeferredSpawnEggItem(ClashCraftModEntities.GOBLIN_HUT, -10007004, -15306729, new Item.Properties()));
	public static final DeferredItem<Item> TOMBSTONE_SPAWN_EGG = REGISTRY.register("tombstone_spawn_egg", () -> new DeferredSpawnEggItem(ClashCraftModEntities.TOMBSTONE, -10066330, -3355444, new Item.Properties()));
	public static final DeferredItem<Item> TESLA_SPAWN_EGG = REGISTRY.register("tesla_spawn_egg", () -> new DeferredSpawnEggItem(ClashCraftModEntities.TESLA, -676542, -15514662, new Item.Properties()));
	public static final DeferredItem<Item> LARRYS_BONE = REGISTRY.register("larrys_bone", LarrysBoneItem::new);
	public static final DeferredItem<Item> LARRY_SPAWNER = REGISTRY.register("larry_spawner", LarrySpawnerItem::new);
	public static final DeferredItem<Item> KIND_LARRY_SPAWN_EGG = REGISTRY.register("kind_larry_spawn_egg", () -> new DeferredSpawnEggItem(ClashCraftModEntities.KIND_LARRY, -1, -1, new Item.Properties()));
	public static final DeferredItem<Item> GRAVEYARD_ITEM = REGISTRY.register("graveyard_item", GraveyardItemItem::new);
	// Start of user code block custom items
	// End of user code block custom items
}
