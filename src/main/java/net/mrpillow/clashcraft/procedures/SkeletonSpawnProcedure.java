package net.mrpillow.clashcraft.procedures;

import net.mrpillow.clashcraft.init.ClashCraftModEntities;
import net.mrpillow.clashcraft.ClashCraftMod;
import net.mrpillow.clashcraft.init.ClashCraftModParticleTypes;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.Blocks;


public class SkeletonSpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		int skeletonsToSpawn = 20;
		spawnParticles(world, x, z);
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

	public static void spawnParticles(LevelAccessor world, double x, double z) {
		double r = 4;
		double particlePerBlock = 4;
		particlePerBlock = 1 / particlePerBlock;
		
		for (double i = -r; i <= r; i += particlePerBlock) {
			for (double j = -r; j <= r; j += particlePerBlock) {
	
				if (dFromZ(i, j) <= r*r) {
					//double y = getHeight(world, x+i, z+j) + 0.2;
					
					world.addParticle((SimpleParticleType) (ClashCraftModParticleTypes.GRAVEYARD_PARTICLE.get()), 
					(x + i), 
					world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x+i), (int) (z+j)), 
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
