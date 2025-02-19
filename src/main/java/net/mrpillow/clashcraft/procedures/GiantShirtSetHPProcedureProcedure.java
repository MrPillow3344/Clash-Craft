package net.mrpillow.clashcraft.procedures;

import net.neoforged.bus.api.Event;

@EventBusSubscriber
public class GiantShirtSetHPProcedureProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((new Object() {
			public ItemStack getItemStack(int sltid, Entity entity) {
				if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
					return _modHandler.getStackInSlot(sltid).copy();
				}
				return ItemStack.EMPTY;
			}
		}.getItemStack(102, entity)).getItem() == ClashCraftModItems.DELETED_MOD_ELEMENT_CHESTPLATE.get()) {
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth(50);
		}
	}
}
