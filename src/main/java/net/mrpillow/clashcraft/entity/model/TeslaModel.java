package net.mrpillow.clashcraft.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.mrpillow.clashcraft.entity.TeslaEntity;

import net.minecraft.resources.ResourceLocation;

public class TeslaModel extends GeoModel<TeslaEntity> {
	@Override
	public ResourceLocation getAnimationResource(TeslaEntity entity) {
		return ResourceLocation.parse("clash_craft:animations/tesla.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(TeslaEntity entity) {
		return ResourceLocation.parse("clash_craft:geo/tesla.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(TeslaEntity entity) {
		return ResourceLocation.parse("clash_craft:textures/entities/" + entity.getTexture() + ".png");
	}

}
