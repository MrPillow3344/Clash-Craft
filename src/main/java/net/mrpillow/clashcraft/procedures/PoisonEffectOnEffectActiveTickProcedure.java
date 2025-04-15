package net.mrpillow.clashcraft.procedures;

import net.mrpillow.clashcraft.network.ClashCraftModVariables;
import net.mrpillow.clashcraft.init.ClashCraftModMobEffects;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;

public class PoisonEffectOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double p = 0;
		p = entity.getData(ClashCraftModVariables.PLAYER_VARIABLES).poisonCounter;
		if (p == 160) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(ClashCraftModMobEffects.POISON_EFFECT);
		} else if (p % 20 == 0) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MAGIC)), 1);
		}
		{
			ClashCraftModVariables.PlayerVariables _vars = entity.getData(ClashCraftModVariables.PLAYER_VARIABLES);
			_vars.poisonCounter = p + 1;
			_vars.syncPlayerVariables(entity);
		}
	}
}
