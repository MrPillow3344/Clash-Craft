
package net.mrpillow.clashcraft.item;

import net.neoforged.neoforge.registries.RegisterEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.mrpillow.clashcraft.init.ClashCraftModItems;
import net.mrpillow.clashcraft.client.model.ModelGiantShirt;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Holder;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.Minecraft;
import net.minecraft.Util;

import java.util.Map;
import java.util.List;
import java.util.EnumMap;
import java.util.Collections;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public abstract class GiantShirtItem extends ArmorItem {
	public static Holder<ArmorMaterial> ARMOR_MATERIAL = null;

	@SubscribeEvent
	public static void registerArmorMaterial(RegisterEvent event) {
		event.register(Registries.ARMOR_MATERIAL, registerHelper -> {
			ArmorMaterial armorMaterial = new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
				map.put(ArmorItem.Type.BOOTS, 0);
				map.put(ArmorItem.Type.LEGGINGS, 0);
				map.put(ArmorItem.Type.CHESTPLATE, 4);
				map.put(ArmorItem.Type.HELMET, 0);
				map.put(ArmorItem.Type.BODY, 4);
			}), 1, DeferredHolder.create(Registries.SOUND_EVENT, ResourceLocation.parse("item.armor.equip_leather")), () -> Ingredient.of(new ItemStack(Blocks.BROWN_WOOL)),
					List.of(new ArmorMaterial.Layer(ResourceLocation.parse("clash_craft:blank_shirt"))), 0.3f, 0f);
			registerHelper.register(ResourceLocation.parse("clash_craft:giant_shirt"), armorMaterial);
			ARMOR_MATERIAL = BuiltInRegistries.ARMOR_MATERIAL.wrapAsHolder(armorMaterial);
		});
	}

	@SubscribeEvent
	public static void registerItemExtensions(RegisterClientExtensionsEvent event) {
		event.registerItem(new IClientItemExtensions() {
			@Override
			@OnlyIn(Dist.CLIENT)
			public HumanoidModel getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
				HumanoidModel armorModel = new HumanoidModel(new ModelPart(Collections.emptyList(), Map.of("body", new ModelGiantShirt(Minecraft.getInstance().getEntityModels().bakeLayer(ModelGiantShirt.LAYER_LOCATION)).Shirt, "left_arm",
						new ModelGiantShirt(Minecraft.getInstance().getEntityModels().bakeLayer(ModelGiantShirt.LAYER_LOCATION)).HandLeft, "right_arm",
						new ModelGiantShirt(Minecraft.getInstance().getEntityModels().bakeLayer(ModelGiantShirt.LAYER_LOCATION)).HandRight, "head", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "hat",
						new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
				armorModel.crouching = living.isShiftKeyDown();
				armorModel.riding = defaultModel.riding;
				armorModel.young = living.isBaby();
				return armorModel;
			}
		}, ClashCraftModItems.GIANT_SHIRT_CHESTPLATE.get());
	}

	public GiantShirtItem(ArmorItem.Type type, Item.Properties properties) {
		super(ARMOR_MATERIAL, type, properties);
	}

	public static class Chestplate extends GiantShirtItem {
		public Chestplate() {
			super(ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(0)));
		}

		@Override
		public ResourceLocation getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, ArmorMaterial.Layer layer, boolean innerModel) {
			return ResourceLocation.parse("clash_craft:textures/entities/giant_shirt.png");
		}
	}
}
