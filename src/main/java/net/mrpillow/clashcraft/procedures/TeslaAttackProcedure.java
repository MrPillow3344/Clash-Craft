package net.mrpillow.clashcraft.procedures;

import net.mrpillow.clashcraft.init.ClashCraftModParticleTypes;
import net.mrpillow.clashcraft.init.ClashCraftModAttributes;
import net.mrpillow.clashcraft.entity.TeslaEntity;
import net.mrpillow.clashcraft.entity.KindLarryEntity;
import net.mrpillow.clashcraft.entity.GiantEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;

public class TeslaAttackProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity enemy = null;
		if (0 >= (entity instanceof TeslaEntity _datEntI ? _datEntI.getEntityData().get(TeslaEntity.DATA_attackCooldown) : 0) && EntityCloseToTeslaProcedure.execute(world, x, y, z, entity)) {
			if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 14, 14, 14), e -> true).isEmpty()) {
				enemy = (Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 14, 14, 14), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null);
			} else if (!world.getEntitiesOfClass(GiantEntity.class, AABB.ofSize(new Vec3(x, y, z), 14, 14, 14), e -> true).isEmpty()) {
				enemy = (Entity) world.getEntitiesOfClass(GiantEntity.class, AABB.ofSize(new Vec3(x, y, z), 14, 14, 14), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null);
			} else if (!world.getEntitiesOfClass(KindLarryEntity.class, AABB.ofSize(new Vec3(x, y, z), 14, 14, 14), e -> true).isEmpty()) {
				enemy = (Entity) world.getEntitiesOfClass(KindLarryEntity.class, AABB.ofSize(new Vec3(x, y, z), 14, 14, 14), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null);
			}
			if ((enemy instanceof LivingEntity _livingEntity7 && _livingEntity7.getAttributes().hasAttribute(ClashCraftModAttributes.WIN_CONDITION) ? _livingEntity7.getAttribute(ClashCraftModAttributes.WIN_CONDITION).getBaseValue() : 0) == 1) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (ClashCraftModParticleTypes.ELECTRICITY.get()), x, (y + 3.25), z, 100, 0.1, 0.1, 0.1, 0);
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (ClashCraftModParticleTypes.ELECTRICITY.get()), (enemy.getX()), (enemy.getY() + 1.6), (enemy.getZ()), 100, 0.1, 0.1, 0.1, 0);
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (ClashCraftModParticleTypes.ELECTRICITY.get()), ((x + enemy.getX()) / 2), ((y + 3.25 + enemy.getY() + 1.6) / 2), ((z + enemy.getZ()) / 2), 100, 0.1, 0.1, 0.1, 0);
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (ClashCraftModParticleTypes.ELECTRICITY.get()), (((x + enemy.getX()) / 2 + x) / 2), (((y + 3.25 + enemy.getY() + 1.6) / 2 + y + 3.25) / 2), (((z + enemy.getZ()) / 2 + z) / 2), 100, 0.1,
							0.1, 0.15, 0);
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (ClashCraftModParticleTypes.ELECTRICITY.get()), (((x + enemy.getX()) / 2 + enemy.getX()) / 2), (((y + 3.25 + enemy.getY() + 1.6) / 2 + enemy.getY() + 1.6) / 2),
							(((z + enemy.getZ()) / 2 + enemy.getZ()) / 2), 100, 0.1, 0.1, 0.1, 0);
				enemy.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MOB_ATTACK)), 5);
				if (entity instanceof TeslaEntity _datEntSetI)
					_datEntSetI.getEntityData().set(TeslaEntity.DATA_attackCooldown, 30);
			}
		}
		if (entity instanceof TeslaEntity _datEntSetI)
			_datEntSetI.getEntityData().set(TeslaEntity.DATA_attackCooldown, (int) ((entity instanceof TeslaEntity _datEntI ? _datEntI.getEntityData().get(TeslaEntity.DATA_attackCooldown) : 0) - 1));
	}

	public static List<List<Integer>> Bresenham3D(int x1, int y1, int z1, int x2, int y2, int z2) {
    List<List<Integer>> ListOfPoints = new ArrayList<>();
    ListOfPoints.add(List.of(x1, y1, z1));
    int dx = Math.abs(x2 - x1);
    int dy = Math.abs(y2 - y1);
    int dz = Math.abs(z2 - z1);
    int xs;
    int ys;
    int zs;
    if (x2 > x1) {
      xs = 1;
    } else {
      xs = -1;
    }
    if (y2 > y1) {
      ys = 1;
    } else {
      ys = -1;
    }
    if (z2 > z1) {
      zs = 1;
    } else {
      zs = -1;
    }

    // Driving axis is X-axis"
    if (dx >= dy && dx >= dz) {
      int p1 = 2 * dy - dx;
      int p2 = 2 * dz - dx;
      while (x1 != x2) {
        x1 += xs;
        if (p1 >= 0) {
          y1 += ys;
          p1 -= 2 * dx;
        }
        if (p2 >= 0) {
          z1 += zs;
          p2 -= 2 * dx;
        }
        p1 += 2 * dy;
        p2 += 2 * dz;
        ListOfPoints.add(List.of(x1, y1, z1));
      }

      // Driving axis is Y-axis"
    } else if (dy >= dx && dy >= dz) {
      int p1 = 2 * dx - dy;
      int p2 = 2 * dz - dy;
      while (y1 != y2) {
        y1 += ys;
        if (p1 >= 0) {
          x1 += xs;
          p1 -= 2 * dy;
        }
        if (p2 >= 0) {
          z1 += zs;
          p2 -= 2 * dy;
        }
        p1 += 2 * dx;
        p2 += 2 * dz;
        ListOfPoints.add(List.of(x1, y1, z1));
      }

      // Driving axis is Z-axis"
    } else {
      int p1 = 2 * dy - dz;
      int p2 = 2 * dx - dz;
      while (z1 != z2) {
        z1 += zs;
        if (p1 >= 0) {
          y1 += ys;
          p1 -= 2 * dz;
        }
        if (p2 >= 0) {
          x1 += xs;
          p2 -= 2 * dz;
        }
        p1 += 2 * dy;
        p2 += 2 * dx;
        ListOfPoints.add(List.of(x1, y1, z1));
      }
    }
    return ListOfPoints;
}

	public static void plotLine(double x1, double y1, double z1, double x2, double y2, double z2) {
		int scalar = 100;
		x1 *= scalar; y1 *= scalar; z1 *= scalar; x2 *= scalar; y2 *= scalar; z2 *= scalar;

		List<List<Integar> dots = Bresenham3D(x1, y1, z1, x2, y2, z2);
		for (List<Integar> coords: dots) {
			
		}
		
		}
}
