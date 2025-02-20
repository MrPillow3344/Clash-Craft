package net.mrpillow.clashcraft.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.mrpillow.clashcraft.init.ClashCraftModItems;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class GiantShirtSetHPProcedureProcedure {
	@SubscribeEvent
	public static void onEntityTick(EntityTickEvent.Pre event) {
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
		}.getItemStack(102, entity)).getItem() == ClashCraftModItems.GIANT_SHIRT_CHESTPLATE.get()) {
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth(24);
		} else {
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth(20);
		}
	}
}
