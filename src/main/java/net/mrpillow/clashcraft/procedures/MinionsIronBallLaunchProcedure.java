package net.mrpillow.clashcraft.procedures;

import net.neoforged.bus.api.Event;

public class MinionsIronBallLaunchProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel projectileLevel) {
			Projectile _entityToSpawn = new Object() {
				public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
					AbstractArrow entityToSpawn = new MinionsIronBallEntity(ClashCraftModEntities.MINIONS_IRON_BALL.get(), level) {
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
					entityToSpawn.setOwner(shooter);
					entityToSpawn.setBaseDamage(damage);
					entityToSpawn.setSilent(true);
					return entityToSpawn;
				}
			}.getArrow(projectileLevel, entity, 4, 1, (byte) 0);
			_entityToSpawn.setPos(x, y, z);
			_entityToSpawn.shoot((entity.getLookAngle().x), (entity.getLookAngle().y), (entity.getLookAngle().z), 1, 0);
			projectileLevel.addFreshEntity(_entityToSpawn);
		}
	}
}
