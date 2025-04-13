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
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.util.datafix.fixes.LeavesFix.LeavesSection;

public class SkeletonSpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
	
		spawnParticles(world, x, z);
		
		ClashCraftMod.queueServerWork(44, () -> {
			final float theta = Mth.nextFloat(RandomSource.create(), -180, 180);
			final double d = Mth.nextDouble(RandomSource.create(), 0, 4);
			final double spawnX = x + Mth.cos(theta)*d;
			final double spawnZ = z + Mth.sin(theta)*d;
			
			ClashCraftMod.queueServerWork(44, () -> {
			
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = ClashCraftModEntities.KIND_LARRY.get().spawn(_level, BlockPos.containing(
					spawnX,
					getHeight(world, spawnX, spawnZ)+1,
					spawnZ
					),
					MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			});
			
		for (float i=0.5f; i<=9f; i+=0.5f) {
			ClashCraftMod.queueServerWork((int) i*20, () -> {

			final float theta1 = Mth.nextFloat(RandomSource.create(), -180, 180);
			final double spawnX1 = x + Mth.cos(theta1)*r;
			final double spawnZ1 = z + Mth.sin(theta1)*r;

			if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = ClashCraftModEntities.KIND_LARRY.get().spawn(_level, BlockPos.containing(
					spawnX1,
					getHeight(world, spawnX1, spawnZ1)+1,
					spawnZ1
					),
					MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}

			});
		}
	});
	}

	public static void spawnParticles(LevelAccessor world, double x, double z) {
		double r = 4;
		double particlePerBlock = 5;
		particlePerBlock = 1 / particlePerBlock;
		
		for (double i = -r; i <= r; i += particlePerBlock) {
			for (double j = -r; j <= r; j += particlePerBlock) {
	
				if (dFromZ(i, j) <= r*r) {
					double y = getHeight(world, x+i, z+j) + 1.2;
					
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
		for (int i = 319; i > -64; i--){
			BlockState block = (world.getBlockState(BlockPos.containing(x, i, z)));
			BlockPos pos = new BlockPos((int)x, i,(int) z);
    		if (block.isSolid() && !((world.getBlockState(BlockPos.containing(x, i, z))).getBlock() == Blocks.OAK_LEAVES) && !world.isWaterAt(pos)) {
        		return (double) i;
    			}
			}
		return 63;
		}
}
