package net.mrpillow.clashcraft.procedures;

import net.mrpillow.clashcraft.entity.TeslaEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class EntityCloseToTeslaProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return false;
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).isEmpty()) {
			if (entity instanceof TeslaEntity) {
				((TeslaEntity) entity).setAnimation("Attack");
			}
			return true;
		}
		if (entity instanceof TeslaEntity) {
			((TeslaEntity) entity).setAnimation("Idle");
		}
		return false;
	}
}
