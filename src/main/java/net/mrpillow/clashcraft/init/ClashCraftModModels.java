
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mrpillow.clashcraft.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mrpillow.clashcraft.client.model.Modelgoblin_hut;
import net.mrpillow.clashcraft.client.model.ModelSpear_Converted;
import net.mrpillow.clashcraft.client.model.ModelGiantShirt;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class ClashCraftModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelgoblin_hut.LAYER_LOCATION, Modelgoblin_hut::createBodyLayer);
		event.registerLayerDefinition(ModelGiantShirt.LAYER_LOCATION, ModelGiantShirt::createBodyLayer);
		event.registerLayerDefinition(ModelSpear_Converted.LAYER_LOCATION, ModelSpear_Converted::createBodyLayer);
	}
}
