package net.mrpillow.clashcraft.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.mrpillow.clashcraft.network.ClashCraftModVariables;
import net.mrpillow.clashcraft.init.ClashCraftModItems;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ShirtVarUpdateProcedure {
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
		if (entity.getData(ClashCraftModVariables.PLAYER_VARIABLES).hasGiantShirt && !entity.getData(ClashCraftModVariables.PLAYER_VARIABLES).hasGiantShirt
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == ClashCraftModItems.GIANT_SHIRT_CHESTPLATE.get()) {
			{
				ClashCraftModVariables.PlayerVariables _vars = entity.getData(ClashCraftModVariables.PLAYER_VARIABLES);
				_vars.hasGiantShirt = false;
				_vars.syncPlayerVariables(entity);
			}
			{
				ClashCraftModVariables.PlayerVariables _vars = entity.getData(ClashCraftModVariables.PLAYER_VARIABLES);
				_vars.ignoreGiantShirt = true;
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 20, 0, false, false));
		} else if (!entity.getData(ClashCraftModVariables.PLAYER_VARIABLES).hasGiantShirt == ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY)
				.getItem() == ClashCraftModItems.GIANT_SHIRT_CHESTPLATE.get())) {
			{
				ClashCraftModVariables.PlayerVariables _vars = entity.getData(ClashCraftModVariables.PLAYER_VARIABLES);
				_vars.hasGiantShirt = true;
				_vars.syncPlayerVariables(entity);
			}
		} else {
			{
				ClashCraftModVariables.PlayerVariables _vars = entity.getData(ClashCraftModVariables.PLAYER_VARIABLES);
				_vars.hasGiantShirt = false;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
