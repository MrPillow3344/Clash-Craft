
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mrpillow.clashcraft.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.mrpillow.clashcraft.ClashCraftMod;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.registries.Registries;

public class ClashCraftModPotions {
	public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(Registries.POTION, ClashCraftMod.MODID);
	public static final DeferredHolder<Potion, Potion> POISON_POTION = REGISTRY.register("poison_potion", () -> new Potion(new MobEffectInstance(ClashCraftModMobEffects.POISON_EFFECT, 15, 0, false, true)));
	public static final DeferredHolder<Potion, Potion> FREEZE = REGISTRY.register("freeze", () -> new Potion(new MobEffectInstance(ClashCraftModMobEffects.FREEZE_EFFECT, 320, 0, false, true)));
}
