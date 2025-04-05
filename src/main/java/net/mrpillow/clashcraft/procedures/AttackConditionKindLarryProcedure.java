package net.mrpillow.clashcraft.procedures;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.BuiltInRegistries;

public class AttackConditionKindLarryProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).equals(BuiltInRegistries.ENTITY_TYPE.getKey((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getType()).toString())) {
			return false;
		}
		return true;
	}
}
