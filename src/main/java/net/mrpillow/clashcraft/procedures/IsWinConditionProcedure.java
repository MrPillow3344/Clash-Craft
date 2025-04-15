package net.mrpillow.clashcraft.procedures;

import net.mrpillow.clashcraft.init.ClashCraftModAttributes;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class IsWinConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(ClashCraftModAttributes.WIN_CONDITION)
				&& (entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(ClashCraftModAttributes.WIN_CONDITION) ? _livingEntity1.getAttribute(ClashCraftModAttributes.WIN_CONDITION).getValue() : 0) == 1) {
			return true;
		}
		return false;
	}
}
