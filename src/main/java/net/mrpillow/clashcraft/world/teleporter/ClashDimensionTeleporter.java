
package net.mrpillow.clashcraft.world.teleporter;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class ClashDimensionTeleporter {

	public static Holder<PoiType> poi = null;

	@SubscribeEvent
	public static void registerPointOfInterest(RegisterEvent event) {
		event.register(Registries.POINT_OF_INTEREST_TYPE, registerHelper -> {
			PoiType poiType = new PoiType(ImmutableSet.copyOf(ClashCraftModBlocks.CLASH_DIMENSION_PORTAL.get().getStateDefinition().getPossibleStates()), 0, 1);
			registerHelper.register(ResourceLocation.parse("clash_craft:clash_dimension_portal"), poiType);
			poi = BuiltInRegistries.POINT_OF_INTEREST_TYPE.wrapAsHolder(poiType);
		});
	}

	private final ServerLevel level;

	public ClashDimensionTeleporter(ServerLevel level) {
		this.level = level;
	}

	/* failed to load code for net.minecraft.world.level.portal.PortalForcer */

	/* failed to load code for net.minecraft.world.level.portal.PortalForcer */

	/* failed to load code for net.minecraft.world.level.portal.PortalForcer */

	private boolean canPortalReplaceBlock(BlockPos.MutableBlockPos pos) {
		BlockState blockstate = this.level.getBlockState(pos);
		return blockstate.canBeReplaced() && blockstate.getFluidState().isEmpty();
	}

}
