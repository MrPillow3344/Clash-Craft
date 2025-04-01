
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mrpillow.clashcraft.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mrpillow.clashcraft.client.renderer.TombstoneRenderer;
import net.mrpillow.clashcraft.client.renderer.TeslaRenderer;
import net.mrpillow.clashcraft.client.renderer.SpearProjectileRenderer;
import net.mrpillow.clashcraft.client.renderer.SpearGoblinRenderer;
import net.mrpillow.clashcraft.client.renderer.MinionRenderer;
import net.mrpillow.clashcraft.client.renderer.MiniPekkaRenderer;
import net.mrpillow.clashcraft.client.renderer.LarryRenderer;
import net.mrpillow.clashcraft.client.renderer.KnightRenderer;
import net.mrpillow.clashcraft.client.renderer.KindLarryRenderer;
import net.mrpillow.clashcraft.client.renderer.GoblinHutRenderer;
import net.mrpillow.clashcraft.client.renderer.GiantRenderer;
import net.mrpillow.clashcraft.client.renderer.ArcherRenderer;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClashCraftModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(ClashCraftModEntities.GIANT.get(), GiantRenderer::new);
		event.registerEntityRenderer(ClashCraftModEntities.KNIGHT.get(), KnightRenderer::new);
		event.registerEntityRenderer(ClashCraftModEntities.MINION.get(), MinionRenderer::new);
		event.registerEntityRenderer(ClashCraftModEntities.MINIONS_IRON_BALL.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(ClashCraftModEntities.FIREBALL_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(ClashCraftModEntities.ARROWS_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(ClashCraftModEntities.MINI_PEKKA.get(), MiniPekkaRenderer::new);
		event.registerEntityRenderer(ClashCraftModEntities.ARCHER.get(), ArcherRenderer::new);
		event.registerEntityRenderer(ClashCraftModEntities.ARCHER_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(ClashCraftModEntities.SPEAR_GOBLIN.get(), SpearGoblinRenderer::new);
		event.registerEntityRenderer(ClashCraftModEntities.SPEAR_PROJECTILE.get(), SpearProjectileRenderer::new);
		event.registerEntityRenderer(ClashCraftModEntities.LARRY.get(), LarryRenderer::new);
		event.registerEntityRenderer(ClashCraftModEntities.GOBLIN_HUT.get(), GoblinHutRenderer::new);
		event.registerEntityRenderer(ClashCraftModEntities.TOMBSTONE.get(), TombstoneRenderer::new);
		event.registerEntityRenderer(ClashCraftModEntities.TESLA.get(), TeslaRenderer::new);
		event.registerEntityRenderer(ClashCraftModEntities.KIND_LARRY.get(), KindLarryRenderer::new);
	}
}
