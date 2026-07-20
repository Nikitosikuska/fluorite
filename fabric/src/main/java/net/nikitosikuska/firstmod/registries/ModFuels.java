package net.nikitosikuska.firstmod.registries;

import net.fabricmc.fabric.api.registry.FuelValueEvents;
import net.nikitosikuska.firstmod.item.ModItems;

public class ModFuels {
    public static void registerFuels() {
        FuelValueEvents.BUILD.register((builder, context) -> {
            builder.add(ModItems.COMBUSTIBLE_SPORES, 1200);
        });
    }
}
