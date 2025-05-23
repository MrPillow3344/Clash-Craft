package net.mrpillow.clashcraft.procedures;

import net.neoforged.bus.api.Event;

@EventBusSubscriber
public class PlayerJoinsWorldProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(ClashCraftModAttributes.WIN_CONDITION))
			_livingEntity0.getAttribute(ClashCraftModAttributes.WIN_CONDITION).setBaseValue(1);
	}
}
