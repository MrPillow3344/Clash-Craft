package net.mrpillow.clashcraft.procedures;

import net.mrpillow.clashcraft.init.ClashCraftModEntities;
import net.mrpillow.clashcraft.entity.MinionsIronBallEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;

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
			}.getArrow(projectileLevel, entity, 3, 0, (byte) 0);
			_entityToSpawn.setPos(x, y, z);
			_entityToSpawn.shoot((entity.getLookAngle().x), (entity.getLookAngle().y), (entity.getLookAngle().z), 1, 0);
			projectileLevel.addFreshEntity(_entityToSpawn);
		}
	}
}
