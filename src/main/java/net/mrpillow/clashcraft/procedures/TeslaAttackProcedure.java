package net.mrpillow.clashcraft.procedures;

import net.mrpillow.clashcraft.init.ClashCraftModAttributes;
import net.mrpillow.clashcraft.entity.TeslaEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ambient.AmbientCreature;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;

import java.util.Comparator;

public class TeslaAttackProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity enemy = null;
		if (0 >= (entity instanceof TeslaEntity _datEntI ? _datEntI.getEntityData().get(TeslaEntity.DATA_attackCooldown) : 0) && EntityCloseToTeslaProcedure.execute(world, x, y, z, entity)) {
			if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 14, 14, 14), e -> true).isEmpty()) {
				enemy = (Entity) world.getEntitiesOfClass(AmbientCreature.class, AABB.ofSize(new Vec3(x, y, z), 14, 14, 14), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null);
			}
			if (entity instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(ClashCraftModAttributes.WIN_CONDITION)) {
				enemy.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MOB_ATTACK)), 5);
				if (entity instanceof TeslaEntity _datEntSetI)
					_datEntSetI.getEntityData().set(TeslaEntity.DATA_attackCooldown, 30);
			}
		}
		if (entity instanceof TeslaEntity _datEntSetI)
			_datEntSetI.getEntityData().set(TeslaEntity.DATA_attackCooldown, (int) ((entity instanceof TeslaEntity _datEntI ? _datEntI.getEntityData().get(TeslaEntity.DATA_attackCooldown) : 0) - 1));
	}
}
