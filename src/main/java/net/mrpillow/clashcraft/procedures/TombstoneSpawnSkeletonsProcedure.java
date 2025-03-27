package net.mrpillow.clashcraft.procedures;

import net.mrpillow.clashcraft.network.ClashCraftModVariables;
import net.mrpillow.clashcraft.init.ClashCraftModEntities;
import net.mrpillow.clashcraft.ClashCraftMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class TombstoneSpawnSkeletonsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(MobEffects.LUCK)) {
			if (entity.getData(ClashCraftModVariables.PLAYER_VARIABLES).SpawnerLeft > 15) {
				ClashCraftMod.queueServerWork(200, () -> {
					entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.DRY_OUT)), 20);
				});
			}
		} else {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = ClashCraftModEntities.LARRY.get().spawn(_level, BlockPos.containing(x + 0.25, y + 2, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setDeltaMovement(0, 0, 0);
				}
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = ClashCraftModEntities.LARRY.get().spawn(_level, BlockPos.containing(x + 0.25, y + 2, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setDeltaMovement(0, 0, 0);
				}
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.LUCK, 400, 1, false, false));
			{
				ClashCraftModVariables.PlayerVariables _vars = entity.getData(ClashCraftModVariables.PLAYER_VARIABLES);
				_vars.SpawnerLeft = entity.getData(ClashCraftModVariables.PLAYER_VARIABLES).SpawnerLeft + 2;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
