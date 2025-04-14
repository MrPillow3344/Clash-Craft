
package net.mrpillow.clashcraft.potion;

public class PoisonEffectMobEffect extends MobEffect {
	public PoisonEffectMobEffect() {
		super(MobEffectCategory.HARMFUL, -3394816);
		this.addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(ClashCraftMod.MODID, "effect.poison_effect_0"), -0.15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		PoisonEffectOnEffectActiveTickProcedure.execute(entity.level(), entity);
		return super.applyEffectTick(entity, amplifier);
	}
}