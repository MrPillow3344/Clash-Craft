
package net.mrpillow.clashcraft.potion;

import net.mrpillow.clashcraft.procedures.PoisonEffectOnEffectActiveTickProcedure;
import net.mrpillow.clashcraft.ClashCraftMod;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

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
