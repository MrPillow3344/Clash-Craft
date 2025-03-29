package net.mrpillow.clashcraft.procedures;

import net.mrpillow.clashcraft.init.ClashCraftModEntities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class GoblinHutOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double goblinsLeft = 0;
		if (entity.getPersistentData().getDouble("GoblinsLeft") > 0 && Math.random() < 0.002) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = ClashCraftModEntities.SPEAR_GOBLIN.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
				}
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = ClashCraftModEntities.SPEAR_GOBLIN.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
				}
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = ClashCraftModEntities.SPEAR_GOBLIN.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
				}
			}
			entity.getPersistentData().putDouble("GoblinsLeft", (entity.getPersistentData().getDouble("GoblinsLeft") - 1));
		}
		if (entity.getPersistentData().getDouble("GoblinsLeft") == 0) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.DRY_OUT)), 100);
		}
	}
}
