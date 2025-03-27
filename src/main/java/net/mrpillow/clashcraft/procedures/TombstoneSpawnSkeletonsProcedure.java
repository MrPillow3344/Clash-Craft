package net.mrpillow.clashcraft.procedures;

import net.neoforged.bus.api.Event;

public class TombstoneSpawnSkeletonsProcedure {
public static void execute(
LevelAccessor world,
double x,
double y,
double z,
Entity entity ) {
if (
entity == null ) return ;
if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(MobEffects.LUCK)) {if (>15) {ClashCraftMod.queueServerWork(200, () -> {
entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.DRY_OUT)), 20);
});
}}else{if (world instanceof ServerLevel _level) {
Entity entityToSpawn = ClashCraftModEntities.LARRY.get().spawn(_level, BlockPos.containing(x+0.25,y+2,z), MobSpawnType.MOB_SUMMONED);
if (entityToSpawn != null) {
entityToSpawn.setDeltaMovement(0, 0, 0);
}
}
if (world instanceof ServerLevel _level) {
Entity entityToSpawn = ClashCraftModEntities.LARRY.get().spawn(_level, BlockPos.containing(x+0.25,y+2,z), MobSpawnType.MOB_SUMMONED);
if (entityToSpawn != null) {
entityToSpawn.setDeltaMovement(0, 0, 0);
}
}
if(entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
_entity.addEffect(new MobEffectInstance(MobEffects.LUCK, 400, 1, false, false));}
}
}
