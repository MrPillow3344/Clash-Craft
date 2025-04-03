package net.mrpillow.clashcraft.procedures;

import net.mrpillow.clashcraft.init.ClashCraftModParticleTypes;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.particles.SimpleParticleType;
import java.util.Random;

public class GraveyardSpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (entity == null)
			return;

		double r = 4;
		int skeletonsLeft = 20;
		
		for (double i = -r; i < r; i += 0.5) {
			for (double j = -r; j < r; j += 0.5) {
			
				if (i * i + j * j <= 16) {
					world.addParticle((SimpleParticleType) (ClashCraftModParticleTypes.GRAVEYARD_PARTICLE.get()), (x + i), y, (z + j), 0, 1, 0);
				}
				
			}
		}

		ClashCraftMod.queueServerWork(10, () -> {
			int k=0;
			while (0 <= skeletonsLeft) {
				ClashCraftMod.queueServerWork(randInt(0, 8)-k, () -> {
					
				
					if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = ClashCraftModEntities.LARRY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}}
				});
				k+=0.25
			}
		});
	}

	public int randInt(int min, int max) {
		return (int) Math.Random * (1 + min + max)
	}
}
