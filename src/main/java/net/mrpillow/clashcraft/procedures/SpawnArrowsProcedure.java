package net.mrpillow.clashcraft.procedures;

import net.mrpillow.clashcraft.ClashCraftMod;

import net.mrpillow.clashcraft.ClashCraftMod;
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
		double xOffset = 6;
		double yOffset = 20;
		double r = 3;
		
		for (int i = 0; i <= 3; i++) {
			ClashCraftMod.queueServerWork(9*i, () -> {
				for (int xLoop = 0; xLoop <= (int) (r * 2); xLoop++) {
					for (int zLoop = 0; zLoop <= (int) (r * 2); zLoop++) {
				
					//distance
					if (dSquared(xLoop, zLoop, r, r) <= Math.pow(r, 2)) {

						//Spawn Arrows
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
							}.getArrow(projectileLevel, 4, 1, (byte) 0);
							_entityToSpawn.setPos(x + xLoop - r -xOffset + 2, (y + yOffset), z- zLoop + r + 0.5);
							_entityToSpawn.shoot((xOffset / yOffset), (-1), 0, (float) 1.2, (float) 0.1);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}

						
					}

				}
			}
				
			});

			
		}
	}

	public static double dSquared(double x1, double y1, double x2, double y2) { 
		return Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2); 
	}
}
