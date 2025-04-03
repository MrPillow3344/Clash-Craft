package net.mrpillow.clashcraft.procedures;

import net.mrpillow.clashcraft.init.ClashCraftModParticleTypes;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.particles.SimpleParticleType;

public class GraveyardSpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double r = 4;
		
		for (double i = -r; i < r; i += 0.5) {
			for (double j = -r; j < r; j += 0.5) {
			
				if (i * i + j * j <= 16) {
					world.addParticle((SimpleParticleType) (ClashCraftModParticleTypes.GRAVEYARD_PARTICLE.get()), (x + i), y, (z + j), 0, 1, 0);
				}
				
			}
		}
	}
}
