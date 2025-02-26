package net.mrpillow.clashcraft.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;

public class SpawnArrowsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double xOffset = 0;
		double yOffset = 0;
		double xLoop = 0;
		double yLoop = 0;
		double r = 0;
		xOffset = 20;
		yOffset = 6;
		r = 5;
		for (int index0 = 0; index0 < 3; index0++) {
			for (int index1 = 0; index1 < (int) (r * 2); index1++) {
				for (int index2 = 0; index2 < (int) (r * 2); index2++) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new Arrow(EntityType.ARROW, level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 5, 1, (byte) 0);
						_entityToSpawn.setPos(x, y, z);
						_entityToSpawn.shoot(1, 1, 1, 1, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
			}
		}
	}
}
