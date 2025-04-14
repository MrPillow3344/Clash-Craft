package net.mrpillow.clashcraft.procedures;

import net.neoforged.bus.api.Event;

public class PoisonEffectOnEffectActiveTickProcedure {
public static void execute(
LevelAccessor world,
Entity entity ) {
if (
entity == null ) return ;
double p = 0;
p = ;if (p==160) {if (entity instanceof LivingEntity _entity) _entity.removeEffect(ClashCraftModMobEffects.DELETED_MOD_ELEMENT);}else if (p%20==0) {entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MAGIC)), 1);}
}
}
