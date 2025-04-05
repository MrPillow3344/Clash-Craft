package net.mrpillow.clashcraft.procedures;

import net.mrpillow.clashcraft.init.ClashCraftModEntities;
import net.mrpillow.clashcraft.ClashCraftMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.Heightmap;


public class SkeletonSpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		int skeletonsToSpawn = 20;
		ParticlesSpawnProcedure.execute(world, x, z);
		/*
		ClashCraftMod.queueServerWork(10, () -> {
		for (int i = 0; i < (int) skeletonsToSpawn; i ++) {
		
			final double spawnX = x + Mth.nextDouble(RandomSource.create(), -4, 4);
			final double spawnZ = z + Mth.nextDouble(RandomSource.create(), -4, 4);
			
			ClashCraftMod.queueServerWork((int) Math.abs((Mth.nextInt(RandomSource.create(), i, 23) - i)), () -> {
			
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = ClashCraftModEntities.KIND_LARRY.get().spawn(_level, BlockPos.containing(
					spawnX,
					world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z),
					spawnZ
					),
					MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			});
		}
		});
	*/
	}
}
