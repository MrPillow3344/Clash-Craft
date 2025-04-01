package net.mrpillow.clashcraft.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.mrpillow.clashcraft.entity.KindLarryEntity;

import net.minecraft.resources.ResourceLocation;

public class KindLarryModel extends GeoModel<KindLarryEntity> {
	@Override
	public ResourceLocation getAnimationResource(KindLarryEntity entity) {
		return ResourceLocation.parse("clash_craft:animations/larry.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(KindLarryEntity entity) {
		return ResourceLocation.parse("clash_craft:geo/larry.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(KindLarryEntity entity) {
		return ResourceLocation.parse("clash_craft:textures/entities/" + entity.getTexture() + ".png");
	}

}
