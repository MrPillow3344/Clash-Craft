package net.mrpillow.clashcraft.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.mrpillow.clashcraft.entity.LarryEntity;

import net.minecraft.resources.ResourceLocation;

public class LarryModel extends GeoModel<LarryEntity> {
	@Override
	public ResourceLocation getAnimationResource(LarryEntity entity) {
		return ResourceLocation.parse("clash_craft:animations/larry.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(LarryEntity entity) {
		return ResourceLocation.parse("clash_craft:geo/larry.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(LarryEntity entity) {
		return ResourceLocation.parse("clash_craft:textures/entities/" + entity.getTexture() + ".png");
	}

}
