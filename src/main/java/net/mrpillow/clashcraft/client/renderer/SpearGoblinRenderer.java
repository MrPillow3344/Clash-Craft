
package net.mrpillow.clashcraft.client.renderer;

public class SpearGoblinRenderer extends GeoEntityRenderer<SpearGoblinEntity> {
	public SpearGoblinRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new SpearGoblinModel());
		this.shadowRadius = 0.5f;
	}

	@Override
	public RenderType getRenderType(SpearGoblinEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, SpearGoblinEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int color) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, color);
	}

}