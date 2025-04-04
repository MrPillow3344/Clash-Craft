package net.mrpillow.clashcraft.procedures;

import net.mrpillow.clashcraft.network.ClashCraftModVariables;
import net.mrpillow.clashcraft.init.ClashCraftModParticleTypes;
import net.mrpillow.clashcraft.init.ClashCraftModEntities;
import net.mrpillow.clashcraft.ClashCraftMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

public class ParticlesSpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double r = 4;
		double particlePerBlock = 0.5;
		int skeletonsLeft = 20;
		
		for (double i = -r; i < r; i += particlePerBlock) {
			for (double j = -r; j < r; j += particlePerBlock) {
			
				if (dFromZ(i, j) <= r*r) {
					world.addParticle((SimpleParticleType) (ClashCraftModParticleTypes.GRAVEYARD_PARTICLE.get()), (x + i), y, (z + j), 0, 1, 0);
				}
				
			}
		}

		ClashCraftMod.queueServerWork(10, () -> {
			SkeletonSpawnProcedure.execute(world, x, z);
		});
	}

	public static double dFromZ(double x, double y) {
		return x*x +y*y;
	}
}
