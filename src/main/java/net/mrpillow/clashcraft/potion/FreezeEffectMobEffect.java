
package net.mrpillow.clashcraft.potion;

import net.mrpillow.clashcraft.procedures.FreezeEffectStartProcedure;
import net.mrpillow.clashcraft.ClashCraftMod;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

public class FreezeEffectMobEffect extends MobEffect {
	public FreezeEffectMobEffect() {
		super(MobEffectCategory.HARMFUL, -6684673);
		this.addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(ClashCraftMod.MODID, "effect.freeze_effect_0"), -999, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.JUMP_STRENGTH, ResourceLocation.fromNamespaceAndPath(ClashCraftMod.MODID, "effect.freeze_effect_1"), -999, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.BLOCK_BREAK_SPEED, ResourceLocation.fromNamespaceAndPath(ClashCraftMod.MODID, "effect.freeze_effect_2"), -999, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.ATTACK_SPEED, ResourceLocation.fromNamespaceAndPath(ClashCraftMod.MODID, "effect.freeze_effect_3"), -999, AttributeModifier.Operation.ADD_VALUE);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		FreezeEffectStartProcedure.execute(entity.level(), entity);
	}
}
