
package net.mrpillow.clashcraft.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class SpearItem extends Item {
	public SpearItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
