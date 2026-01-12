package net.kilobytedisk.hotpotatomod.item;

import net.kilobytedisk.hotpotatomod.PotatoMod;
import net.kilobytedisk.hotpotatomod.item.throwable.HotPotatoItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(
        ForgeRegistries.ITEMS,
        PotatoMod.MODID
    );

    public static final RegistryObject<Item> HOT_POTATO = ITEMS.register(
        "hot_potato",
        () -> new HotPotatoItem(new Item.Properties().durability(0).stacksTo(16))
    );


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
