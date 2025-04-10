package net.mrpillow.clashcraft.procedures;

import net.mrpillow.clashcraft.init.ClashCraftModParticleTypes;
import net.mrpillow.clashcraft.entity.TeslaEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.client.Minecraft;

import java.util.Comparator;

public class TeslaAttackProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity enemy = null;
		if (0 >= (entity instanceof TeslaEntity _datEntI ? _datEntI.getEntityData().get(TeslaEntity.DATA_attackCooldown) : 0) && EntityCloseToTeslaProcedure.execute(world, x, y, z, entity)) {
			enemy = (Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 14, 14, 14), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null);
			if (new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayer _serverPlayer) {
						return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.ADVENTURE;
					} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
						return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
								&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.ADVENTURE;
					}
					return false;
				}
			}.checkGamemode(enemy) || new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayer _serverPlayer) {
						return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
					} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
						return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
								&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
					}
					return false;
				}
			}.checkGamemode(enemy)) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (ClashCraftModParticleTypes.ELECTRICITY.get()), x, (y + 3.25), z, 100, 0.1, 0.1, 0.1, 0);
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (ClashCraftModParticleTypes.ELECTRICITY.get()), (enemy.getX()), (enemy.getY() + 1.6), (enemy.getZ()), 100, 0.1, 0.1, 0.1, 0);
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (ClashCraftModParticleTypes.ELECTRICITY.get()), ((x + enemy.getX()) / 2), ((y + 3.25 + enemy.getY() + 1.6) / 2), ((z + enemy.getZ()) / 2), 100, 0.1, 0.1, 0.1, 0);
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (ClashCraftModParticleTypes.ELECTRICITY.get()), (((x + enemy.getX()) / 2 + x) / 2), (((y + 3.25 + enemy.getY() + 1.6) / 2 + y + 3.25) / 2), (((z + enemy.getZ()) / 2 + z) / 2), 100, 0.1,
							0.1, 0.15, 0);
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (ClashCraftModParticleTypes.ELECTRICITY.get()), (((x + enemy.getX()) / 2 + enemy.getX()) / 2), (((y + 3.25 + enemy.getY() + 1.6) / 2 + enemy.getY() + 1.6) / 2),
							(((z + enemy.getZ()) / 2 + enemy.getZ()) / 2), 100, 0.1, 0.1, 0.1, 0);
				enemy.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MOB_ATTACK), entity), 3);
				if (entity instanceof TeslaEntity _datEntSetI)
					_datEntSetI.getEntityData().set(TeslaEntity.DATA_attackCooldown, 30);
			}
		}
		if (!(entity instanceof TeslaEntity _datEntL27 && _datEntL27.getEntityData().get(TeslaEntity.DATA_isItUp))) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 3, 255, false, false));
		}
		if (entity instanceof TeslaEntity _datEntSetI)
			_datEntSetI.getEntityData().set(TeslaEntity.DATA_attackCooldown, (int) ((entity instanceof TeslaEntity _datEntI ? _datEntI.getEntityData().get(TeslaEntity.DATA_attackCooldown) : 0) - 1));
	}
}
