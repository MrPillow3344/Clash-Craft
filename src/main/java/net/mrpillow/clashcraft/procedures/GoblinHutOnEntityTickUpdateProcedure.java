package net.mrpillow.clashcraft.procedures;

import net.mrpillow.clashcraft.init.ClashCraftModEntities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class GoblinHutOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof GoblinHutEntity _datEntI ? _datEntI.getEntityData().get(GoblinHutEntity.DATA_goblinsLeft) : 0) < 0 && Math.random() < 0.002) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = ClashCraftModEntities.SPEAR_GOBLIN.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
				}
			}
			if (entity instanceof GoblinHutEntity _datEntSetI)
				_datEntSetI.getEntityData().set(GoblinHutEntity.DATA_goblinsLeft, (int) ((entity instanceof GoblinHutEntity _datEntI ? _datEntI.getEntityData().get(GoblinHutEntity.DATA_goblinsLeft) : 0) - 1));
		}
	}
}
