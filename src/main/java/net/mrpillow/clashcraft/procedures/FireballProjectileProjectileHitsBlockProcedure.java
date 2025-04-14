package net.mrpillow.clashcraft.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

public class FireballProjectileProjectileHitsBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double yOffset = 0;
		double zOffset = 0;
		yOffset = 20;
		zOffset = 6;
		if (world instanceof ServerLevel projectileLevel) {
			Projectile _entityToSpawn = new Object() {
				public Projectile getFireball(Level level, Entity shooter) {
					AbstractHurtingProjectile entityToSpawn = new LargeFireball(EntityType.FIREBALL, level);
					entityToSpawn.setOwner(shooter);
					return entityToSpawn;
				}
			}.getFireball(projectileLevel, entity);
			_entityToSpawn.setPos(x, (y + 20), z);
			_entityToSpawn.shoot(0, (-1), 0, (float) 0.6, 0);
			projectileLevel.addFreshEntity(_entityToSpawn);
		}
	}
}
