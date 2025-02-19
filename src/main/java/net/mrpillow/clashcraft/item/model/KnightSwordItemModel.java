package net.mrpillow.clashcraft.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.mrpillow.clashcraft.item.KnightSwordItem;

import net.minecraft.resources.ResourceLocation;

public class KnightSwordItemModel extends GeoModel<KnightSwordItem> {
	@Override
	public ResourceLocation getAnimationResource(KnightSwordItem animatable) {
		return ResourceLocation.parse("clash_craft:animations/knight's_sword.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(KnightSwordItem animatable) {
		return ResourceLocation.parse("clash_craft:geo/knight's_sword.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(KnightSwordItem animatable) {
		return ResourceLocation.parse("clash_craft:textures/item/knights_sword.png");
	}
}
