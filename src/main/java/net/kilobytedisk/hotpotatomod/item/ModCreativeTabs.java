package net.kilobytedisk.hotpotatomod.item;

import net.kilobytedisk.hotpotatomod.PotatoMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {
    
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(
        Registries.CREATIVE_MODE_TAB,
        PotatoMod.MODID
    );

    public static final RegistryObject<CreativeModeTab> POTATO_TAB = CREATIVE_MODE_TABS.register(
        "potato_tab",
        () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.HOT_POTATO.get()))
            .title(Component.translatable("creativetab.potato_tab"))
            .displayItems((parameters, output) -> {

                output.accept(ModItems.HOT_POTATO.get());
            })
            .build());

    
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
