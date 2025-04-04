package net.mrpillow.clashcraft.procedures;

import net.mrpillow.clashcraft.init.ClashCraftModEntities;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class SkeletonSpawnProcedure {
	public static void execute(LevelAccessor world, double x, double z) {
		double skeletonsToSpawn = 0;
		double spawnX = 0;
		double spawnZ = 0;
		skeletonsToSpawn = 20;
		for (int index0 = 0; index0 < (int) skeletonsToSpawn; index0++) {
			spawnX = x + Mth.nextDouble(RandomSource.create(), -4, 4);
			spawnZ = z + Mth.nextDouble(RandomSource.create(), -4, 4);
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = ClashCraftModEntities.KIND_LARRY.get().spawn(_level, BlockPos.containing(spawnX, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) spawnX, (int) spawnZ), spawnZ), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		}
	}
}
