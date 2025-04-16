package net.mrpillow.clashcraft.procedures;

import net.mrpillow.clashcraft.init.ClashCraftModAttributes;
import net.mrpillow.clashcraft.entity.TeslaEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class EntityCloseToTeslaProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return false;
		if (!world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(x, y, z), 14, 14, 14), e -> true).isEmpty() && entity instanceof LivingEntity _livingEntity2
				&& _livingEntity2.getAttributes().hasAttribute(ClashCraftModAttributes.WIN_CONDITION)) {
			if (entity instanceof TeslaEntity) {
				((TeslaEntity) entity).setAnimation("2");
			}
			if (entity instanceof TeslaEntity) {
				((TeslaEntity) entity).setAnimation("Attack");
			}
			if (entity instanceof TeslaEntity _datEntSetL)
				_datEntSetL.getEntityData().set(TeslaEntity.DATA_isItUp, true);
			return true;
		}
		if (entity instanceof TeslaEntity) {
			((TeslaEntity) entity).setAnimation("3");
		}
		if (entity instanceof TeslaEntity) {
			((TeslaEntity) entity).setAnimation("Idle");
		}
		if (entity instanceof TeslaEntity _datEntSetL)
			_datEntSetL.getEntityData().set(TeslaEntity.DATA_isItUp, false);
		return false;
	}
}
