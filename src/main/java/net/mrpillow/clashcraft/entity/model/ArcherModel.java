package net.mrpillow.clashcraft.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;

import net.mrpillow.clashcraft.entity.ArcherEntity;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

public class ArcherModel extends GeoModel<ArcherEntity> {
	@Override
	public ResourceLocation getAnimationResource(ArcherEntity entity) {
		return ResourceLocation.parse("clash_craft:animations/archers.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ArcherEntity entity) {
		return ResourceLocation.parse("clash_craft:geo/archers.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ArcherEntity entity) {
		return ResourceLocation.parse("clash_craft:textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(ArcherEntity animatable, long instanceId, AnimationState animationState) {
		GeoBone head = getAnimationProcessor().getBone("Head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
