package net.mrpillow.clashcraft.procedures;

import net.neoforged.bus.api.Event;

public class GoblinHutEntityDiesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		for (int index0 = 0; index0 < 2; index0++) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = ClashCraftModEntities.KNIGHT.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		}
	}
}
