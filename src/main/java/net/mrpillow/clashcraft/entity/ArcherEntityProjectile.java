
package net.mrpillow.clashcraft.entity;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class ArcherEntityProjectile extends AbstractArrow implements ItemSupplier {

	public static final ItemStack PROJECTILE_ITEM = new ItemStack(ClashCraftModItems.ARROWS.get());

	public ArcherEntityProjectile(EntityType<? extends ArcherEntityProjectile> type, Level world) {
		super(type, world);
	}

	public ArcherEntityProjectile(EntityType<? extends ArcherEntityProjectile> type, double x, double y, double z, Level world) {
		super(type, x, y, z, world, PROJECTILE_ITEM, null);
	}

	public ArcherEntityProjectile(EntityType<? extends ArcherEntityProjectile> type, LivingEntity entity, Level world) {
		super(type, entity, world, PROJECTILE_ITEM, null);
	}

	@Override
	protected void doPostHurtEffects(LivingEntity livingEntity) {
		super.doPostHurtEffects(livingEntity);
		livingEntity.setArrowCount(livingEntity.getArrowCount() - 1);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public ItemStack getItem() {
		return PROJECTILE_ITEM;
	}

	@Override
	protected ItemStack getDefaultPickupItem() {
		return new ItemStack(ClashCraftModItems.ARROWS.get());
	}
}
