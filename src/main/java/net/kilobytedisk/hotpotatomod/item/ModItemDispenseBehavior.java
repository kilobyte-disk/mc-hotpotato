package net.kilobytedisk.hotpotatomod.item;


import net.kilobytedisk.hotpotatomod.entity.projectile.PotatoProjectile;
import net.kilobytedisk.hotpotatomod.item.ModItems;
import net.minecraft.core.Position;
import net.minecraft.core.dispenser.AbstractProjectileDispenseBehavior;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.item.ItemStack;

public class ModItemDispenseBehavior {
    
    public static void bootStrap() {

        DispenserBlock.registerBehavior(ModItems.HOT_POTATO.get(), new AbstractProjectileDispenseBehavior() {
            protected Projectile getProjectile(Level level, Position position, ItemStack itemStack) {
                PotatoProjectile proj = new PotatoProjectile(level, position.x(), position.y(), position.z());
                proj.setItem(itemStack);

                return proj;
            }
        });
    }
}
