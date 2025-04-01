
package net.mrpillow.clashcraft.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class LarrysBoneItem extends Item {
	public LarrysBoneItem() {
		super(new Item.Properties().durability(40).fireResistant().rarity(Rarity.EPIC));
	}
}
