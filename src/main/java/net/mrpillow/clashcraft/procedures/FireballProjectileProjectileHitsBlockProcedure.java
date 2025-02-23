package net.mrpillow.clashcraft.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.entity.EntityType;
import net.minecraft.server.level.ServerLevel;

public class FireballProjectileProjectileHitsBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double yOffset = 0;
		double zOffset = 0;
		yOffset = 20;
		zOffset = 6;
		if (world instanceof ServerLevel projectileLevel) {
			Projectile _entityToSpawn = new LargeFireball(EntityType.FIREBALL, projectileLevel);
			_entityToSpawn.setPos(x, (y + yOffset), (z - zOffset));
			_entityToSpawn.shoot(0, (-1), (zOffset / yOffset), (float) 1.2, 0);
			projectileLevel.addFreshEntity(_entityToSpawn);
		}
	}
}
