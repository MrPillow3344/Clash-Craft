package net.mrpillow.clashcraft.procedures;

import net.neoforged.bus.api.Event;

public class NotTooHighMinionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getY() - 5 > world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)) {
			{
				Entity _ent = entity;
				_ent.teleportTo(x, (y - 0.2), z);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(x, (y - 0.2), z, _ent.getYRot(), _ent.getXRot());
			}
		}
	}
}
