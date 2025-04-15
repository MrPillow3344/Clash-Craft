package net.mrpillow.clashcraft.procedures;

import net.mrpillow.clashcraft.init.ClashCraftModEntities;
import net.mrpillow.clashcraft.ClashCraftMod;
import net.mrpillow.clashcraft.init.ClashCraftModParticleTypes;
import net.mrpillow.clashcraft.entity.KindLarryEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
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

import java.util.Comparator;

public class SkeletonSpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
	
		spawnParticles(world, x, z);
			
		for (float i=0f; i<=9f; i+=0.5f) {
			int t;
			if (i==0f) {
				t=44;
			}
			else {
				t = (int) (20f * i+44f);
			}
			
			ClashCraftMod.queueServerWork(t, () -> {
				double d;
				if (t==44) {
					d = Mth.nextDouble(RandomSource.create(), 0, 4);
				} else {
					d=4;
				}
	
				final float theta = Mth.nextFloat(RandomSource.create(), -180, 180);
				final double spawnX = x + Mth.cos(theta)*d;
				final double spawnZ = z + Mth.sin(theta)*d;
				final double spawnY = getHeight(world, spawnX, spawnZ)+1;

				if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = ClashCraftModEntities.KIND_LARRY.get().spawn(_level, BlockPos.containing(
						spawnX,
						spawnY,
						spawnZ
						),
						MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
				}
	
				final Entity e = (Entity) world.getEntitiesOfClass(KindLarryEntity.class, AABB.ofSize(new Vec3(spawnX, spawnY, spawnZ), 0.2, 0.2, 0.2)).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}}.compareDistOf(spawnX, spawnY, spawnZ)).findFirst().orElse(null);
				if (e instanceof KindLarryEntity) {
					((KindLarryEntity) e).setAnimation("GraveyardAppears");
				}
			});
		}
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
