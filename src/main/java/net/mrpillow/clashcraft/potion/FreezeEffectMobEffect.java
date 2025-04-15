
package net.mrpillow.clashcraft.potion;

import net.mrpillow.clashcraft.ClashCraftMod;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

public class FreezeEffectMobEffect extends MobEffect {
	public FreezeEffectMobEffect() {
		super(MobEffectCategory.HARMFUL, -6684673);
		this.addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(ClashCraftMod.MODID, "effect.freeze_effect_0"), 0, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
		this.addAttributeModifier(Attributes.JUMP_STRENGTH, ResourceLocation.fromNamespaceAndPath(ClashCraftMod.MODID, "effect.freeze_effect_1"), 0, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
		this.addAttributeModifier(Attributes.BLOCK_BREAK_SPEED, ResourceLocation.fromNamespaceAndPath(ClashCraftMod.MODID, "effect.freeze_effect_2"), 0, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
		this.addAttributeModifier(Attributes.ATTACK_SPEED, ResourceLocation.fromNamespaceAndPath(ClashCraftMod.MODID, "effect.freeze_effect_3"), 0, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
	}
}
