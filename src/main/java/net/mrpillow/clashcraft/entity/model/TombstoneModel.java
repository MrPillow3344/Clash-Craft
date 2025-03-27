package net.mrpillow.clashcraft.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.mrpillow.clashcraft.entity.TombstoneEntity;

import net.minecraft.resources.ResourceLocation;

public class TombstoneModel extends GeoModel<TombstoneEntity> {
	@Override
	public ResourceLocation getAnimationResource(TombstoneEntity entity) {
		return ResourceLocation.parse("clash_craft:animations/tombstone.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(TombstoneEntity entity) {
		return ResourceLocation.parse("clash_craft:geo/tombstone.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(TombstoneEntity entity) {
		return ResourceLocation.parse("clash_craft:textures/entities/" + entity.getTexture() + ".png");
	}

}
