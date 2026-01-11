package net.kilobytedisk.hotpotatomod.entity;

import net.kilobytedisk.hotpotatomod.PotatoMod;
import net.kilobytedisk.hotpotatomod.entity.projectile.PotatoProjectile;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(
        ForgeRegistries.ENTITY_TYPES,
        PotatoMod.MODID
    );

    public static final RegistryObject<EntityType<PotatoProjectile>> POTATOPROJECTILE = ENTITY_TYPES.register(
        "potatoprojectile",
        () -> EntityType.Builder.<PotatoProjectile>of(PotatoProjectile::new, MobCategory.MISC).sized(1.0F, 2.0F).build("minecraft:baked_potato")

    );

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
    
}
