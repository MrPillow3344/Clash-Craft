package net.mrpillow.clashcraft.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.entity.EntityType;
import net.minecraft.server.level.ServerLevel;

public class FireballProjectileProjectileHitsBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel projectileLevel) {
			Projectile _entityToSpawn = new LargeFireball(EntityType.FIREBALL, projectileLevel);
			_entityToSpawn.setPos(x, (y + 20), z);
			_entityToSpawn.shoot(0, (-1), 0, 1, 0);
			projectileLevel.addFreshEntity(_entityToSpawn);
		}
	}
}
