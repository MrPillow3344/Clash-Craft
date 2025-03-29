package net.mrpillow.clashcraft.procedures;

import net.neoforged.bus.api.Event;

public class GoblinHutOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof GoblinHutEntity _datEntI ? _datEntI.getEntityData().get(GoblinHutEntity.DATA_goblinsLeft) : 0) > 0 && Math.random() <= 0.02) {
			if (entity instanceof GoblinHutEntity _datEntSetI)
				_datEntSetI.getEntityData().set(GoblinHutEntity.DATA_goblinsLeft, (int) ((entity instanceof GoblinHutEntity _datEntI ? _datEntI.getEntityData().get(GoblinHutEntity.DATA_goblinsLeft) : 0) - 1));
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = ClashCraftModEntities.SPEAR_GOBLIN.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		}
	}
}
