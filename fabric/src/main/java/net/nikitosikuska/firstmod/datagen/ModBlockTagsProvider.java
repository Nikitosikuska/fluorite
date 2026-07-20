package net.nikitosikuska.firstmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.BlockTags;
import net.nikitosikuska.firstmod.block.ModBlocks;
import net.nikitosikuska.firstmod.tags.ModTags;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends FabricTagsProvider.BlockTagsProvider {
    public ModBlockTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }


    @Override
    protected void addTags(HolderLookup.@NonNull Provider registries) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.FLUORITE_BLOCK).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.FLUORITE_ORE).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.FLUORITE_DEEPSLATE_ORE).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.FLUORITE_END_ORE).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.FLUORITE_NETHER_ORE).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.RAW_FLUORITE_BLOCK).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.FLUORITE_STAIRS).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.FLUORITE_SLAB).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.FLUORITE_FENCE).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.FLUORITE_FENCE_GATE).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.FLUORITE_WALL).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.FLUORITE_DOOR).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.FLUORITE_TRAPDOOR).orElseThrow());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.FLUORITE_DEEPSLATE_ORE).orElseThrow());
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.FLUORITE_NETHER_ORE).orElseThrow())
                .add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.FLUORITE_END_ORE).orElseThrow());
        tag(BlockTags.STAIRS).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.FLUORITE_STAIRS).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.RAW_FLUORITE_STAIRS).orElseThrow());
        tag(BlockTags.SLABS).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.FLUORITE_SLAB).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.RAW_FLUORITE_SLAB).orElseThrow());
        tag(BlockTags.BUTTONS).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.FLUORITE_BUTTON).orElseThrow());
        tag(BlockTags.PRESSURE_PLATES).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.FLUORITE_PRESSURE_PLATE).orElseThrow());
        tag(BlockTags.FENCES).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.FLUORITE_FENCE).orElseThrow());
        tag(BlockTags.FENCE_GATES).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.FLUORITE_FENCE_GATE).orElseThrow());
        tag(BlockTags.WALLS).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.FLUORITE_WALL).orElseThrow()).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.RAW_FLUORITE_WALL).orElseThrow());
        tag(BlockTags.DOORS).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.FLUORITE_DOOR).orElseThrow());
        tag(BlockTags.TRAPDOORS).add(BuiltInRegistries.BLOCK.getResourceKey(ModBlocks.FLUORITE_TRAPDOOR).orElseThrow());
        tag(ModTags.Blocks.NEEDS_FLUORITE_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL);
        tag(ModTags.Blocks.INCORRECT_FOR_FLUORITE_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);
    }
}
