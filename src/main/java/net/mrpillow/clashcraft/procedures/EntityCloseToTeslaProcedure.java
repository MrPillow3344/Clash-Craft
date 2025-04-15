package net.mrpillow.clashcraft.procedures;

import net.mrpillow.clashcraft.entity.TeslaEntity;
import net.mrpillow.clashcraft.entity.KindLarryEntity;
import net.mrpillow.clashcraft.entity.GiantEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class EntityCloseToTeslaProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return false;
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 14, 14, 14), e -> true).isEmpty() || !world.getEntitiesOfClass(KindLarryEntity.class, AABB.ofSize(new Vec3(x, y, z), 14, 14, 14), e -> true).isEmpty()
				|| !world.getEntitiesOfClass(GiantEntity.class, AABB.ofSize(new Vec3(x, y, z), 14, 14, 14), e -> true).isEmpty()) {
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
