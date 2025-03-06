
package net.mrpillow.clashcraft.client.renderer;

import net.mrpillow.clashcraft.entity.GoblinHutEntity;
import net.mrpillow.clashcraft.client.model.Modelgoblin_hut;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class GoblinHutRenderer extends MobRenderer<GoblinHutEntity, Modelgoblin_hut<GoblinHutEntity>> {
	public GoblinHutRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelgoblin_hut<GoblinHutEntity>(context.bakeLayer(Modelgoblin_hut.LAYER_LOCATION)), 3f);
	}

	@Override
	public ResourceLocation getTextureLocation(GoblinHutEntity entity) {
		return ResourceLocation.parse("clash_craft:textures/entities/goblin_hut.png");
	}
}
