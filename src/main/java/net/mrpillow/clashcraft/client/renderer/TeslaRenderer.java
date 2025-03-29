
package net.mrpillow.clashcraft.client.renderer;

public class TeslaRenderer extends GeoEntityRenderer<TeslaEntity> {
	public TeslaRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new TeslaModel());
		this.shadowRadius = 0.8f;
	}

	@Override
	public RenderType getRenderType(TeslaEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, TeslaEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int color) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, color);
	}

	@Override
	protected float getDeathMaxRotation(TeslaEntity entityLivingBaseIn) {
		return 0.0F;
	}
}