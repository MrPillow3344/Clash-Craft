
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mrpillow.clashcraft.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.mrpillow.clashcraft.potion.PoisonEffectMobEffect;
import net.mrpillow.clashcraft.ClashCraftMod;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

public class ClashCraftModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, ClashCraftMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> POISON_EFFECT = REGISTRY.register("poison_effect", () -> new PoisonEffectMobEffect());
}
