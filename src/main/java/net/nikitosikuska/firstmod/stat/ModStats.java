package net.nikitosikuska.firstmod.stat;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.stats.Stat;
import net.minecraft.stats.StatFormatter;
import net.minecraft.stats.Stats;
import net.nikitosikuska.firstmod.FirstMod;

public class ModStats {
    public static final Stat<?> BROKEN_FLUORITE_ORE = makeCustomStat("broken_fluorite_ore");

    private static Stat<?> makeCustomStat(String key) {
        Identifier identifier = Identifier.fromNamespaceAndPath(FirstMod.MOD_ID, key);
        Identifier newStat = Registry.register(BuiltInRegistries.CUSTOM_STAT, key, identifier);

        return Stats.CUSTOM.get(newStat, StatFormatter.DEFAULT);
    }

    public static void registerStats() {
        FirstMod.LOGGER.info("Registering Stats for" + FirstMod.MOD_ID);
    }

}
