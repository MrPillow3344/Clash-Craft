
package net.mrpillow.clashcraft.client.renderer;

public class GoblinHutRenderer extends MobRenderer<GoblinHutEntity, Modelgoblin_hut<GoblinHutEntity>> {
	public GoblinHutRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelgoblin_hut<GoblinHutEntity>(context.bakeLayer(Modelgoblin_hut.LAYER_LOCATION)), 3f);
		this.addLayer(new RenderLayer<GoblinHutEntity, Modelgoblin_hut<GoblinHutEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("clash_craft:textures/entities/goblin_hut.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, GoblinHutEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
				EntityModel model = new Modelgoblin_hut(Minecraft.getInstance().getEntityModels().bakeLayer(Modelgoblin_hut.LAYER_LOCATION));
				this.getParentModel().copyPropertiesTo(model);
				model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
				model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
				model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(GoblinHutEntity entity) {
		return ResourceLocation.parse("clash_craft:textures/entities/goblin_hut.png");
	}
}