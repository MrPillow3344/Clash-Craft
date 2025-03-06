
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mrpillow.clashcraft.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.mrpillow.clashcraft.entity.MinionsIronBallEntity;
import net.mrpillow.clashcraft.entity.MinionEntity;
import net.mrpillow.clashcraft.entity.MiniPekkaEntity;
import net.mrpillow.clashcraft.entity.KnightEntity;
import net.mrpillow.clashcraft.entity.GoblinHutEntity;
import net.mrpillow.clashcraft.entity.GiantEntity;
import net.mrpillow.clashcraft.entity.FireballProjectileEntity;
import net.mrpillow.clashcraft.entity.ArrowsProjectileEntity;
import net.mrpillow.clashcraft.entity.ArcherEntityProjectile;
import net.mrpillow.clashcraft.entity.ArcherEntity;
import net.mrpillow.clashcraft.ClashCraftMod;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.Registries;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class ClashCraftModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, ClashCraftMod.MODID);
	public static final DeferredHolder<EntityType<?>, EntityType<GiantEntity>> GIANT = register("giant",
			EntityType.Builder.<GiantEntity>of(GiantEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(48).setUpdateInterval(3)

					.sized(1.9f, 4.3f));
	public static final DeferredHolder<EntityType<?>, EntityType<KnightEntity>> KNIGHT = register("knight",
			EntityType.Builder.<KnightEntity>of(KnightEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<MinionEntity>> MINION = register("minion",
			EntityType.Builder.<MinionEntity>of(MinionEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.2f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<MinionsIronBallEntity>> MINIONS_IRON_BALL = register("minions_iron_ball",
			EntityType.Builder.<MinionsIronBallEntity>of(MinionsIronBallEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<FireballProjectileEntity>> FIREBALL_PROJECTILE = register("fireball_projectile",
			EntityType.Builder.<FireballProjectileEntity>of(FireballProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<ArrowsProjectileEntity>> ARROWS_PROJECTILE = register("arrows_projectile",
			EntityType.Builder.<ArrowsProjectileEntity>of(ArrowsProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.2f, 0.2f));
	public static final DeferredHolder<EntityType<?>, EntityType<MiniPekkaEntity>> MINI_PEKKA = register("mini_pekka",
			EntityType.Builder.<MiniPekkaEntity>of(MiniPekkaEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<ArcherEntity>> ARCHER = register("archer",
			EntityType.Builder.<ArcherEntity>of(ArcherEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<ArcherEntityProjectile>> ARCHER_PROJECTILE = register("projectile_archer",
			EntityType.Builder.<ArcherEntityProjectile>of(ArcherEntityProjectile::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<GoblinHutEntity>> GOBLIN_HUT = register("goblin_hut",
			EntityType.Builder.<GoblinHutEntity>of(GoblinHutEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(0).setUpdateInterval(3).fireImmune().sized(3.5f, 4.2f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(RegisterSpawnPlacementsEvent event) {
		GiantEntity.init(event);
		KnightEntity.init(event);
		MinionEntity.init(event);
		MiniPekkaEntity.init(event);
		ArcherEntity.init(event);
		GoblinHutEntity.init(event);
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(GIANT.get(), GiantEntity.createAttributes().build());
		event.put(KNIGHT.get(), KnightEntity.createAttributes().build());
		event.put(MINION.get(), MinionEntity.createAttributes().build());
		event.put(MINI_PEKKA.get(), MiniPekkaEntity.createAttributes().build());
		event.put(ARCHER.get(), ArcherEntity.createAttributes().build());
		event.put(GOBLIN_HUT.get(), GoblinHutEntity.createAttributes().build());
	}
}
