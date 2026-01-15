package net.kilobytedisk.hotpotatomod.entity.projectile;

import net.kilobytedisk.hotpotatomod.entity.ModEntities;
import net.kilobytedisk.hotpotatomod.item.ModItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class PotatoProjectile extends ThrowableItemProjectile {

    private float explosiveRadius;

    public PotatoProjectile(EntityType<? extends PotatoProjectile> entity, Level level) {
        super(entity, level);
    }

    public PotatoProjectile(Level level, LivingEntity shooter) {
        super(ModEntities.POTATO_PROJECTILE.get(), shooter, level);
    }

    public PotatoProjectile(Level level, double x, double y, double z) {
        super(ModEntities.POTATO_PROJECTILE.get(), x, y, z, level);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.HOT_POTATO.get();
    }

    public void setExplosiveRadius(float r) {
        explosiveRadius = r;
    }


    public void onHitEntity(EntityHitResult entity) {
        // do nothing
    }
    
    public void onHit(HitResult hit) {
        super.onHit(hit);

        if (!this.level().isClientSide) {
            // boom
            this.level().explode(
                null,
                hit.getLocation().x,
                hit.getLocation().y,
                hit.getLocation().z,
                explosiveRadius, // Radius
                Level.ExplosionInteraction.TNT
            );

            this.level().broadcastEntityEvent(this, (byte)3);
            this.discard();
        }
    }
}
