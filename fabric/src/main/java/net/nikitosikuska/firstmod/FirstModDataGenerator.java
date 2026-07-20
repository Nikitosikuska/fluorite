package net.nikitosikuska.firstmod;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.nikitosikuska.firstmod.datagen.*;
import net.nikitosikuska.firstmod.item.ModArmorMaterials;
import net.nikitosikuska.firstmod.world.ModConfiguredFeatures;
import net.nikitosikuska.firstmod.world.ModPlacedFeatures;
import org.jspecify.annotations.NonNull;

public class FirstModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(@NonNull FabricDataGenerator fabricDataGenerator) {
		var pack = fabricDataGenerator.createPack();
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModBlockLootTableProvider::new);
		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(ModRegistryDataGenerator::new);
		pack.addProvider(ModEquipmentAssetProvider::new);
		var blockTagsProvider = pack.addProvider(ModBlockTagsProvider::new);
		pack.addProvider((output, registriesFuture) ->
				new ModItemTagsProvider(output, registriesFuture, blockTagsProvider));
	}

	@Override
	public void buildRegistry(RegistrySetBuilder registryBuilder) {
		registryBuilder.add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
		registryBuilder.add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
	}
}