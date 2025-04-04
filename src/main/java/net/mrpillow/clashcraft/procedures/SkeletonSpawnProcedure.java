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

public class SkeletonSpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double skeletonsToSpawn = 0;
		double spawnX = 0;
		double spawnZ = 0;
		double i = 0;
		ParticlesSpawnProcedure.execute();
		skeletonsToSpawn = 20;
		i = 0;
		for (int index0 = 0; index0 < (int) skeletonsToSpawn; index0++) {
			spawnX = x + Mth.nextDouble(RandomSource.create(), -4, 4);
			spawnZ = z + Mth.nextDouble(RandomSource.create(), -4, 4);
			ClashCraftMod.queueServerWork((int) (Mth.nextInt(RandomSource.create(), 3, 8) - i), () -> {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = ClashCraftModEntities.KIND_LARRY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			});
			i = 1 + i;
		}
	}
}
