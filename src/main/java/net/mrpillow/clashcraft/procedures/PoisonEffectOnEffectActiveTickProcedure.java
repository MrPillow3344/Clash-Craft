package net.mrpillow.clashcraft.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;

public class PoisonEffectOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double p = 0;
		entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MAGIC)), 1);
	}
}
