
package net.mrpillow.clashcraft.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.mrpillow.clashcraft.procedures.SkeletonSpawnProcedure;
import net.mrpillow.clashcraft.ClashCraftMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record FvgfdvMessage(int eventType, int pressedms) implements CustomPacketPayload {
	public static final Type<FvgfdvMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(ClashCraftMod.MODID, "key_fvgfdv"));
	public static final StreamCodec<RegistryFriendlyByteBuf, FvgfdvMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, FvgfdvMessage message) -> {
		buffer.writeInt(message.eventType);
		buffer.writeInt(message.pressedms);
	}, (RegistryFriendlyByteBuf buffer) -> new FvgfdvMessage(buffer.readInt(), buffer.readInt()));

	@Override
	public Type<FvgfdvMessage> type() {
		return TYPE;
	}

	public static void handleData(final FvgfdvMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				pressAction(context.player(), message.eventType, message.pressedms);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void pressAction(Player entity, int type, int pressedms) {
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(entity.blockPosition()))
			return;
		if (type == 0) {

			SkeletonSpawnProcedure.execute(world, x, y, z);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		ClashCraftMod.addNetworkMessage(FvgfdvMessage.TYPE, FvgfdvMessage.STREAM_CODEC, FvgfdvMessage::handleData);
	}
}
