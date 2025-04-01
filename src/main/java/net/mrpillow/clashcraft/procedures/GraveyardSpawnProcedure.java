package net.mrpillow.clashcraft.procedures;

import net.mrpillow.clashcraft.init.ClashCraftModParticleTypes;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.SimpleParticleType;

public class GraveyardSpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double r = 4;

		for (double i = -r; i <= r; i += 0.1) {
			for (double j = -r; i <= r; j += 0.1) {
				
				if (dSquared(i, j, r, r) <= r*r) {
					world.addParticle((SimpleParticleType) (ClashCraftModParticleTypes.GRAVEYARD_PARTICLE.get()), x+i, y+0.5, x+j, 0, 0, 0);
				}
				
			}
		}
		
	}

	public static double dSquared(double x1, double y1, double x2, double y2) { 
		return Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2); 
	}

}
