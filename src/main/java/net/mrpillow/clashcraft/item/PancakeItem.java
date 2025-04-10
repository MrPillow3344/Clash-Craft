
package net.mrpillow.clashcraft.item;

import net.mrpillow.clashcraft.procedures.PlayerFinishesEatingPancakeProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;

public class PancakeItem extends Item {
	public PancakeItem() {
		super(new Item.Properties().durability(2).rarity(Rarity.COMMON));
	}

	@Override
	public int getUseDuration(ItemStack itemstack, LivingEntity livingEntity) {
		return 10;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		entity.startUsingItem(hand);
		PlayerFinishesEatingPancakeProcedure.execute(world, entity, ar.getObject());
		return ar;
	}
}
