
package net.mrpillow.clashcraft.client.renderer;

public class GoblinHutRenderer extends MobRenderer<GoblinHutEntity, Modelgoblin_hut<GoblinHutEntity>> {
	public GoblinHutRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelgoblin_hut<GoblinHutEntity>(context.bakeLayer(Modelgoblin_hut.LAYER_LOCATION)), 1.5f);
	}

	@Override
	protected void scale(GoblinHutEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(1.3f, 1.3f, 1.3f);
	}

	@Override
	public ResourceLocation getTextureLocation(GoblinHutEntity entity) {
		return ResourceLocation.parse("clash_craft:textures/entities/goblin_hut.png");
	}
}