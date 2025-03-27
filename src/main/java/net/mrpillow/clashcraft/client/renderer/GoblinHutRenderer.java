
package net.mrpillow.clashcraft.client.renderer;

import net.mrpillow.clashcraft.entity.GoblinHutEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

public class GoblinHutRenderer extends HumanoidMobRenderer<GoblinHutEntity, HumanoidModel<GoblinHutEntity>> {
	public GoblinHutRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<GoblinHutEntity>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	public ResourceLocation getTextureLocation(GoblinHutEntity entity) {
		return ResourceLocation.parse("clash_craft:textures/entities/goblin_hut.png");
	}
}
