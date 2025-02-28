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
import net.minecraft.server.commands.SpawnArmorTrimsCommand;

public class SpawnArrowsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		short xOffset = 6;
		short yOffset = 20;
		int r = 4;
		
			summonWave()
			ClashCraftMod.queueServerWork(10, () -> {
				summonWave()
			ClashCraftMod.queueServerWork(10, () -> {
				summonWave()
			});
			});
	}

	public static void summonWave() {
		for (int xLoop = 0; xLoop <=  (r * 2); xLoop++) {
				for (int zLoop = 0; zLoop <= (r * 2); zLoop++) {
					if (dSquared(xLoop, zLoop, r, r) <= Math.pow(r, 2)) {
						spawnArrows(world, x, y, z, r, xOffset, yOffset, xLoop, zLoop);
					}
				}
			}
		
		}

	public static double dSquared(double x1, double y1, double x2, double y2) {
		return Math.pow(x1- x2, 2) + Math.pow(y1 - y2, 2);
		}
	
	public static void summonArrows(LevelAccessor world, double x, double y, double z, float r, short xOffset, short yOffset, int xLoop, int zLoop) {
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
							}.getArrow(projectileLevel, 1, 1, (byte) 0);
							_entityToSpawn.setPos(x + xLoop  -r+0.5, y + yOffset, z + zLoop - r+0.5);
							_entityToSpawn.shoot(0, -1, 0, 1, 0);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}

		}
}
