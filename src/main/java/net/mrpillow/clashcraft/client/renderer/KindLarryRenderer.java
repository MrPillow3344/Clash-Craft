
package net.mrpillow.clashcraft.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.mrpillow.clashcraft.entity.model.KindLarryModel;
import net.mrpillow.clashcraft.entity.layer.KindLarryLayer;
import net.mrpillow.clashcraft.entity.KindLarryEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class KindLarryRenderer extends GeoEntityRenderer<KindLarryEntity> {
	public KindLarryRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new KindLarryModel());
		this.shadowRadius = 0.5f;
		this.addRenderLayer(new KindLarryLayer(this));
	}

	@Override
	public RenderType getRenderType(KindLarryEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, KindLarryEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int color) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, color);
	}
}
