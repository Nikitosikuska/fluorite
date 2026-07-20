package net.nikitosikuska.firstmod;

import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.Identifier;

import net.nikitosikuska.firstmod.block.ModBlocks;
import net.nikitosikuska.firstmod.creativemodetab.ModCreativeModeTabs;
import net.nikitosikuska.firstmod.item.ModItems;
import net.nikitosikuska.firstmod.registries.ModFuels;
import net.nikitosikuska.firstmod.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FirstMod implements ModInitializer {
	public static final String MOD_ID = "first-mod";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModCreativeModeTabs.registerModCreativeModeTabs();

		ModItems.registerModItems();

		ModBlocks.registerModBlocks();

		ModWorldGeneration.generateModWorldGen();

		ModFuels.registerFuels();
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
