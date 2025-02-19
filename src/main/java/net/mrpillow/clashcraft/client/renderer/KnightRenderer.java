
package net.mrpillow.clashcraft.client.renderer;

public class KnightRenderer extends GeoEntityRenderer<KnightEntity> {
	public KnightRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new KnightModel());
		this.shadowRadius = 0.5f;
	}

	@Override
	public RenderType getRenderType(KnightEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, KnightEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int color) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, color);
	}

}