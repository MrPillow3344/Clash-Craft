
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mrpillow.clashcraft.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.mrpillow.clashcraft.ClashCraftMod;

import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraft.world.entity.ai.attributes.DefaultAttributes;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.core.registries.BuiltInRegistries;

import java.util.stream.Collectors;
import java.util.List;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class ClashCraftModAttributes {
	public static final DeferredRegister<Attribute> REGISTRY = DeferredRegister.create(BuiltInRegistries.ATTRIBUTE, ClashCraftMod.MODID);
	public static final DeferredHolder<Attribute, Attribute> WIN_CONDITION = REGISTRY.register("win_condition", () -> new RangedAttribute("attribute.clash_craft.win_condition", 0, 0, 1).setSyncable(true));
	public static final DeferredHolder<Attribute, Attribute> BUILDING = REGISTRY.register("building", () -> new RangedAttribute("attribute.clash_craft.building", 1, 0, 1).setSyncable(true));

	@SubscribeEvent
	public static void addAttributes(EntityAttributeModificationEvent event) {
		event.getTypes().forEach(entity -> event.add(entity, WIN_CONDITION));
		List.of(ClashCraftModEntities.GOBLIN_HUT.get(), ClashCraftModEntities.TOMBSTONE.get(), ClashCraftModEntities.TESLA.get()).stream().filter(DefaultAttributes::hasSupplier).map(entityType -> (EntityType<? extends LivingEntity>) entityType)
				.collect(Collectors.toList()).forEach(entity -> event.add(entity, BUILDING));
	}
}
