package net.nikitosikuska.firstmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.ItemTags;
import net.nikitosikuska.firstmod.item.ModItems;
import net.nikitosikuska.firstmod.tags.ModTags;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends FabricTagsProvider.ItemTagsProvider {
    public ModItemTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture, @Nullable BlockTagsProvider blockTagsProvider) {
        super(output, registryLookupFuture, blockTagsProvider);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider registries) {
        tag(ItemTags.SWORDS).add(BuiltInRegistries.ITEM.getResourceKey(ModItems.FLUORITE_SWORD).orElseThrow());
        tag(ItemTags.PICKAXES).add(BuiltInRegistries.ITEM.getResourceKey(ModItems.FLUORITE_PICKAXE).orElseThrow());
        tag(ItemTags.SHOVELS).add(BuiltInRegistries.ITEM.getResourceKey(ModItems.FLUORITE_SHOVEL).orElseThrow());
        tag(ItemTags.AXES).add(BuiltInRegistries.ITEM.getResourceKey(ModItems.FLUORITE_AXE).orElseThrow());
        tag(ItemTags.HOES).add(BuiltInRegistries.ITEM.getResourceKey(ModItems.FLUORITE_HOE).orElseThrow());
        tag(ItemTags.SPEARS).add(BuiltInRegistries.ITEM.getResourceKey(ModItems.FLUORITE_SPEAR).orElseThrow());
        tag(ItemTags.HEAD_ARMOR).add(BuiltInRegistries.ITEM.getResourceKey(ModItems.FLUORITE_HELMET).orElseThrow());
        tag(ItemTags.CHEST_ARMOR).add(BuiltInRegistries.ITEM.getResourceKey(ModItems.FLUORITE_CHESTPLATE).orElseThrow());
        tag(ItemTags.LEG_ARMOR).add(BuiltInRegistries.ITEM.getResourceKey(ModItems.FLUORITE_LEGGINGS).orElseThrow());
        tag(ItemTags.FOOT_ARMOR).add(BuiltInRegistries.ITEM.getResourceKey(ModItems.FLUORITE_BOOTS).orElseThrow());
        tag(ModTags.Items.FLUORITE_REPAIR).add(BuiltInRegistries.ITEM.getResourceKey(ModItems.FLUORITE).orElseThrow());
    }


}
