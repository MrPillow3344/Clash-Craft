package net.mrpillow.clashcraft.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.mrpillow.clashcraft.entity.GoblinHutEntity;

import net.minecraft.resources.ResourceLocation;

public class GoblinHutModel extends GeoModel<GoblinHutEntity> {
	@Override
	public ResourceLocation getAnimationResource(GoblinHutEntity entity) {
		return ResourceLocation.parse("clash_craft:animations/spear_goblin.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GoblinHutEntity entity) {
		return ResourceLocation.parse("clash_craft:geo/spear_goblin.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GoblinHutEntity entity) {
		return ResourceLocation.parse("clash_craft:textures/entities/" + entity.getTexture() + ".png");
	}

}
