
package net.mrpillow.clashcraft.client.renderer;

public class ArcherRenderer extends GeoEntityRenderer<ArcherEntity> {
	public ArcherRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new ArcherModel());
		this.shadowRadius = 0.5f;
		this.addRenderLayer(new ArcherLayer(this));
	}

	@Override
	public RenderType getRenderType(ArcherEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, ArcherEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int color) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, color);
	}

}