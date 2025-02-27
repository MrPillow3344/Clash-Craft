package net.mrpillow.clashcraft.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.mrpillow.clashcraft.entity.MiniPekkaEntity;

import net.minecraft.resources.ResourceLocation;

public class MiniPekkaModel extends GeoModel<MiniPekkaEntity> {
	@Override
	public ResourceLocation getAnimationResource(MiniPekkaEntity entity) {
		return ResourceLocation.parse("clash_craft:animations/minipekka.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MiniPekkaEntity entity) {
		return ResourceLocation.parse("clash_craft:geo/minipekka.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MiniPekkaEntity entity) {
		return ResourceLocation.parse("clash_craft:textures/entities/" + entity.getTexture() + ".png");
	}

}
