package net.mrpillow.clashcraft.procedures;

import net.neoforged.bus.api.Event;

public class SpearItemShootsProjectileProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			Entity _shootFrom = entity;
			Level projectileLevel = _shootFrom.level();
			if (!projectileLevel.isClientSide()) {
				Projectile _entityToSpawn = new Object() {
					public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
						AbstractArrow entityToSpawn = new SpearProjectileEntity(ClashCraftModEntities.SPEAR_PROJECTILE.get(), level) {
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
				}.getArrow(projectileLevel, entity, 2, (int) 0.1, (byte) 0);
				_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
				_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 0);
				projectileLevel.addFreshEntity(_entityToSpawn);
			}
		}
	}
}
