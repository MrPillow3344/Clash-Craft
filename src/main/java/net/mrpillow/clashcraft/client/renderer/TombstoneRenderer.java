
package net.mrpillow.clashcraft.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.mrpillow.clashcraft.entity.model.TombstoneModel;
import net.mrpillow.clashcraft.entity.TombstoneEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class TombstoneRenderer extends GeoEntityRenderer<TombstoneEntity> {
	public TombstoneRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new TombstoneModel());
		this.shadowRadius = 1.1f;
	}

	@Override
	public RenderType getRenderType(TombstoneEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, TombstoneEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int color) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, color);
	}

	@Override
	protected float getDeathMaxRotation(TombstoneEntity entityLivingBaseIn) {
		return 0.0F;
	}
}
