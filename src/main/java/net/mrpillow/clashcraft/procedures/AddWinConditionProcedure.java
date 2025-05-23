package net.mrpillow.clashcraft.procedures;

import net.neoforged.bus.api.Event;

public class AddWinConditionProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(ClashCraftModAttributes.WIN_CONDITION))
			_livingEntity0.getAttribute(ClashCraftModAttributes.WIN_CONDITION).setBaseValue(1);
	}
}
