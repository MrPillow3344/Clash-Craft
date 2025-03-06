package net.mrpillow.clashcraft.procedures;

import net.mrpillow.clashcraft.init.ClashCraftModEntities;
import net.mrpillow.clashcraft.entity.GoblinHutEntity;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class GoblinHutOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (Math.random() < 0.0006 && (entity instanceof GoblinHutEntity _datEntI ? _datEntI.getEntityData().get(GoblinHutEntity.DATA_goblinsLeft) : 0) < 0) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = ClashCraftModEntities.KNIGHT.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
			if (entity instanceof GoblinHutEntity _datEntSetI)
				_datEntSetI.getEntityData().set(GoblinHutEntity.DATA_goblinsLeft, (entity instanceof GoblinHutEntity _datEntI ? _datEntI.getEntityData().get(GoblinHutEntity.DATA_goblinsLeft) : 0) - 1);
		}
	}
}
