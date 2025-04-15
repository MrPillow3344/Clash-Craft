
package net.mrpillow.clashcraft.item;

public class GraveyardItemItem extends Item {
	public GraveyardItemItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.RARE));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		GraveyardItemRightclickedProcedure.execute(world, entity, ar.getObject());
		return ar;
	}
}