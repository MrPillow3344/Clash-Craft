
package net.mrpillow.clashcraft.client.renderer;

public class GiantRenderer extends GeoEntityRenderer<GiantEntity> {
	public GiantRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new GiantModel());
		this.shadowRadius = 2f;
	}

	@Override
	public RenderType getRenderType(GiantEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, GiantEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int color) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, color);
	}

}