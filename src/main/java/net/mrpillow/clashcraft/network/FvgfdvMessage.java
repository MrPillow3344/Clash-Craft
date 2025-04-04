
package net.mrpillow.clashcraft.network;

import net.mrpillow.clashcraft.ClashCraftMod;

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

			SkeletonSpawnProcedure.execute();
		}

	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		ClashCraftMod.addNetworkMessage(FvgfdvMessage.TYPE, FvgfdvMessage.STREAM_CODEC, FvgfdvMessage::handleData);
	}

}
