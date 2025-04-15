
package net.mrpillow.clashcraft.potion;

import net.mrpillow.clashcraft.procedures.PoisonEffectOnEffectActiveTickProcedure;
import net.mrpillow.clashcraft.ClashCraftMod;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.resources.ResourceLocation;

public class PoisonEffectMobEffect extends InstantenousMobEffect {
	public PoisonEffectMobEffect() {
		super(MobEffectCategory.HARMFUL, -3394816);
		this.addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(ClashCraftMod.MODID, "effect.poison_effect_0"), -0.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
	}

	@Override
	public void applyInstantenousEffect(Entity source, Entity indirectSource, LivingEntity entity, int amplifier, double health) {
		PoisonEffectOnEffectActiveTickProcedure.execute(entity.level(), entity);
	}
}
