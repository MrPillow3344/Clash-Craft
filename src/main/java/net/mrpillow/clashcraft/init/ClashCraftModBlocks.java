
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mrpillow.clashcraft.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.mrpillow.clashcraft.block.ClashDimensionPortalBlock;
import net.mrpillow.clashcraft.ClashCraftMod;

import net.minecraft.world.level.block.Block;

public class ClashCraftModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(ClashCraftMod.MODID);
	public static final DeferredBlock<Block> CLASH_DIMENSION_PORTAL = REGISTRY.register("clash_dimension_portal", ClashDimensionPortalBlock::new);
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
