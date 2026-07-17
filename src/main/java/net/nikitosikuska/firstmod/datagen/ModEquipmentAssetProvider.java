package net.nikitosikuska.firstmod.datagen;

import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.nikitosikuska.firstmod.FirstMod;
import net.nikitosikuska.firstmod.item.ModArmorMaterials;
import org.jspecify.annotations.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class ModEquipmentAssetProvider implements DataProvider {
    private final PackOutput.PathProvider pathProvider;

    public ModEquipmentAssetProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture) {
        this.pathProvider = packOutput.createPathProvider(PackOutput.Target.RESOURCE_PACK, "equipment");
    }

    private static void bootstrap(BiConsumer<ResourceKey<EquipmentAsset>, EquipmentClientInfo> consumer) {
        consumer.accept(ModArmorMaterials.FLUORITE_KEY,
                EquipmentClientInfo.builder()
                        .addHumanoidLayers(Identifier.fromNamespaceAndPath(FirstMod.MOD_ID, "fluorite"))
                        .addLayers(EquipmentClientInfo.LayerType.HORSE_BODY, new EquipmentClientInfo.Layer(Identifier.fromNamespaceAndPath(FirstMod.MOD_ID, "fluorite")))
                        .build());
    }

    @Override
    public @NonNull CompletableFuture<?> run(final @NonNull CachedOutput cache) {
        Map<ResourceKey<EquipmentAsset>, EquipmentClientInfo> equipmentAssets = new HashMap<>();
        bootstrap((id, asset) -> {
            if (equipmentAssets.putIfAbsent(id, asset) != null) {
                throw new IllegalStateException("Tried to register equipment asset twice for id: " + id);
            }
        });
        return DataProvider.saveAll(cache, EquipmentClientInfo.CODEC, this.pathProvider::json, equipmentAssets);
    }
    @Override
    public @NonNull String getName() {
        return "First Mod Equipment Assets";
    }
}
