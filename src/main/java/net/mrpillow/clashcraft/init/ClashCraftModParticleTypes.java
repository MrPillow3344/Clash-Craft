
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mrpillow.clashcraft.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.mrpillow.clashcraft.ClashCraftMod;

import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

public class ClashCraftModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(Registries.PARTICLE_TYPE, ClashCraftMod.MODID);
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> ELECTRICITY = REGISTRY.register("electricity", () -> new SimpleParticleType(true));
}
