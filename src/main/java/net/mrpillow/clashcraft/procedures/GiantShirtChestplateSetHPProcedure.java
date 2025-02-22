package net.mrpillow.clashcraft.procedures;

import net.mrpillow.clashcraft.network.ClashCraftModVariables;
import net.mrpillow.clashcraft.ClashCraftMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

public class GiantShirtChestplateSetHPProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(ClashCraftModVariables.PLAYER_VARIABLES).GiantShirtCooldown == 0) {
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.ABSORPTION) ? _livEnt.getEffect(MobEffects.ABSORPTION).getAmplifier() : 0) == 0) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 60, 0, false, false));
				{
					ClashCraftModVariables.PlayerVariables _vars = entity.getData(ClashCraftModVariables.PLAYER_VARIABLES);
					_vars.GiantShirtCooldown = 1;
					_vars.syncPlayerVariables(entity);
				}
				ClashCraftMod.queueServerWork(260, () -> {
					{
						ClashCraftModVariables.PlayerVariables _vars = entity.getData(ClashCraftModVariables.PLAYER_VARIABLES);
						_vars.GiantShirtCooldown = 0;
						_vars.syncPlayerVariables(entity);
					}
				});
			}
		}
	}
}
