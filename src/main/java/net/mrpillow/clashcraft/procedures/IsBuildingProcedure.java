package net.mrpillow.clashcraft.procedures;

import net.mrpillow.clashcraft.init.ClashCraftModAttributes;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class IsBuildingProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(ClashCraftModAttributes.BUILDING)
				&& (entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(ClashCraftModAttributes.BUILDING) ? _livingEntity1.getAttribute(ClashCraftModAttributes.BUILDING).getValue() : 0) == 1) {
			return true;
		}
		return false;
	}
}
