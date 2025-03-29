package net.mrpillow.clashcraft.procedures;

import net.neoforged.bus.api.Event;

public class TombstoneEntityDiesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = ClashCraftModEntities.LARRY.get().spawn(_level, BlockPos.containing(x + 1, y, z + 1), MobSpawnType.MOB_SUMMONED);
			if (entityToSpawn != null) {
				entityToSpawn.setDeltaMovement(0, 0, 0);
			}
		}
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = ClashCraftModEntities.LARRY.get().spawn(_level, BlockPos.containing(x + 1, y, z - 1), MobSpawnType.MOB_SUMMONED);
			if (entityToSpawn != null) {
				entityToSpawn.setDeltaMovement(0, 0, 0);
			}
		}
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = ClashCraftModEntities.LARRY.get().spawn(_level, BlockPos.containing(x - 1, y, z + 1), MobSpawnType.MOB_SUMMONED);
			if (entityToSpawn != null) {
				entityToSpawn.setDeltaMovement(0, 0, 0);
			}
		}
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = ClashCraftModEntities.LARRY.get().spawn(_level, BlockPos.containing(x - 1, y, z - 1), MobSpawnType.MOB_SUMMONED);
			if (entityToSpawn != null) {
				entityToSpawn.setDeltaMovement(0, 0, 0);
			}
		}
	}
}
