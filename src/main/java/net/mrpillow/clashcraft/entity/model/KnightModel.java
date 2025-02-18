package net.mrpillow.clashcraft.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.mrpillow.clashcraft.entity.KnightEntity;

import net.minecraft.resources.ResourceLocation;

public class KnightModel extends GeoModel<KnightEntity> {
	@Override
	public ResourceLocation getAnimationResource(KnightEntity entity) {
		return ResourceLocation.parse("clash_craft:animations/knight.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(KnightEntity entity) {
		return ResourceLocation.parse("clash_craft:geo/knight.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(KnightEntity entity) {
		return ResourceLocation.parse("clash_craft:textures/entities/" + entity.getTexture() + ".png");
	}

}
