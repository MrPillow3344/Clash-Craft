package net.mrpillow.clashcraft.procedures;

import net.mrpillow.clashcraft.ClashCraftMod;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;

public class BalutaProcedure {
	public static void execute(LevelAccessor world) {
		ClashCraftMod.queueServerWork(10, () -> {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("1"), false);
			ClashCraftMod.queueServerWork(10, () -> {
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("2"), false);
				ClashCraftMod.queueServerWork(10, () -> {
					if (!world.isClientSide() && world.getServer() != null)
						world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("3"), false);
					ClashCraftMod.queueServerWork(20, () -> {
						if (world.isClientSide())
							Minecraft.getInstance().gameRenderer.displayItemActivation(new ItemStack(Blocks.SNIFFER_EGG));
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Baluta Al Harosh"), false);
					});
				});
			});
		});
	}
}
