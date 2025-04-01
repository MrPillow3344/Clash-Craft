
package net.mrpillow.clashcraft.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class GraveyardItem extends Item {
	public GraveyardItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.RARE));
	}
}
