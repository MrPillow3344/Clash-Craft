package net.mrpillow.clashcraft.procedures;

import net.mrpillow.clashcraft.init.ClashCraftModParticleTypes;
import net.mrpillow.clashcraft.init.ClashCraftModEntities;
import net.mrpillow.clashcraft.ClashCraftMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.Blocks;


public class ParticlesSpawnProcedure {
	public static void spawn(LevelAccessor world, double x, double z) {
		double r = 4;
		double particlePerBlock = 3;
		particlePerBlock = 1 / particlePerBlock;
		
		for (double i = -r; i < r; i += particlePerBlock) {
			for (double j = -r; j < r; j += particlePerBlock) {
	
				if (dFromZ(i, j) <= r*r) {
					double y = getHeight(world, x+i, z+j) + 0.2;
					
					world.addParticle((SimpleParticleType) (ClashCraftModParticleTypes.GRAVEYARD_PARTICLE.get()), 
					(x + i), 
					y, 
					(z + j), 
					0, 1, 0);
				}
				
			}
		}
	}

	public static double dFromZ(double x, double y) {
		return x*x +y*y;
	}

	public static double getHeight(LevelAccessor world, double x, double z) {
		for (int i = 320; i > -64; i--){
    		if ((world.getBlockState(BlockPos.containing(x, i, z))).getBlock() != Blocks.AIR) {
        		return (double) i;
    			}
			}
		return 63;
		}
}
