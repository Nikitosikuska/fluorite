package net.nikitosikuska.firstmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;

import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.nikitosikuska.firstmod.FirstMod;
import net.nikitosikuska.firstmod.FirstModDataGenerator;
import net.nikitosikuska.firstmod.block.ModBlocks;
import net.nikitosikuska.firstmod.item.ModItems;
import org.jspecify.annotations.NonNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected @NonNull RecipeProvider createRecipeProvider(HolderLookup.@NonNull Provider registries, @NonNull RecipeOutput output) {
        return new RecipeProvider(registries, output) {
            @Override
            public void buildRecipes() {
                List<ItemLike> FLOURITE_SMELTABLES = List.of(ModItems.RAW_FLUORITE, ModBlocks.FLUORITE_ORE, ModBlocks.FLUORITE_DEEPSLATE_ORE, ModBlocks.FLUORITE_NETHER_ORE, ModBlocks.FLUORITE_END_ORE);

                oreSmelting(FLOURITE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.FLUORITE, 0.25f, 200, "fluorite");
                oreBlasting(FLOURITE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.FLUORITE, 0.25f, 100, "fluorite");

                nineBlockStorageRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.FLUORITE, RecipeCategory.DECORATIONS, ModBlocks.FLUORITE_BLOCK);
                nineBlockStorageRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_FLUORITE, RecipeCategory.DECORATIONS, ModBlocks.RAW_FLUORITE_BLOCK);

                stairBuilder(ModBlocks.FLUORITE_STAIRS, Ingredient.of(ModBlocks.FLUORITE_BLOCK))
                        .unlockedBy(getHasName(ModBlocks.FLUORITE_BLOCK), has(ModBlocks.FLUORITE_BLOCK))
                        .group("fluorite")
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FLUORITE_SLAB, ModBlocks.FLUORITE_BLOCK);
                stairBuilder(ModBlocks.RAW_FLUORITE_STAIRS, Ingredient.of(ModBlocks.RAW_FLUORITE_BLOCK))
                        .unlockedBy(getHasName(ModBlocks.RAW_FLUORITE_BLOCK), has(ModBlocks.RAW_FLUORITE_BLOCK))
                        .group("fluorite")
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_FLUORITE_SLAB, ModBlocks.RAW_FLUORITE_BLOCK);
                buttonBuilder(ModBlocks.FLUORITE_BUTTON, Ingredient.of(ModItems.FLUORITE))
                        .unlockedBy(getHasName(ModItems.FLUORITE), has(ModItems.FLUORITE))
                        .group("fluorite")
                        .save(output);
                pressurePlate(ModBlocks.FLUORITE_PRESSURE_PLATE, ModItems.FLUORITE);
                fenceBuilder(ModBlocks.FLUORITE_FENCE, Ingredient.of(ModItems.FLUORITE))
                        .unlockedBy(getHasName(ModItems.FLUORITE), has(ModItems.FLUORITE))
                        .group("fluorite")
                        .save(output);
                fenceGateBuilder(ModBlocks.FLUORITE_FENCE_GATE, Ingredient.of(ModItems.FLUORITE))
                        .unlockedBy(getHasName(ModItems.FLUORITE), has(ModItems.FLUORITE))
                        .group("fluorite")
                        .save(output);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FLUORITE_WALL, ModBlocks.FLUORITE_BLOCK);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_FLUORITE_WALL, ModBlocks.RAW_FLUORITE_BLOCK);
                doorBuilder(ModBlocks.FLUORITE_DOOR, Ingredient.of(ModItems.FLUORITE))
                        .unlockedBy(getHasName(ModItems.FLUORITE), has(ModItems.FLUORITE))
                        .group("fluorite")
                        .save(output);
                trapdoorBuilder(ModBlocks.FLUORITE_TRAPDOOR, Ingredient.of(ModItems.FLUORITE))
                        .unlockedBy(getHasName(ModItems.FLUORITE), has(ModItems.FLUORITE))
                        .group("fluorite")
                        .save(output);

                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FLUORITE_SLAB, ModBlocks.FLUORITE_BLOCK, 2);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FLUORITE_STAIRS, ModBlocks.FLUORITE_BLOCK);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FLUORITE_WALL, ModBlocks.FLUORITE_BLOCK);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_FLUORITE_SLAB, ModBlocks.RAW_FLUORITE_BLOCK, 2);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_FLUORITE_STAIRS, ModBlocks.RAW_FLUORITE_BLOCK);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_FLUORITE_WALL, ModBlocks.RAW_FLUORITE_BLOCK);

                shaped(RecipeCategory.COMBAT, ModItems.FLUORITE_SWORD)
                        .pattern("F")
                        .pattern("F")
                        .pattern("S")
                        .define('F', ModItems.FLUORITE)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.FLUORITE), has(ModItems.FLUORITE))
                        .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                        .group("fluorite")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.FLUORITE_PICKAXE)
                        .pattern("FFF")
                        .pattern(" S ")
                        .pattern(" S ")
                        .define('F', ModItems.FLUORITE)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.FLUORITE), has(ModItems.FLUORITE))
                        .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                        .group("fluorite")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.FLUORITE_SHOVEL)
                        .pattern("F")
                        .pattern("S")
                        .pattern("S")
                        .define('F', ModItems.FLUORITE)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.FLUORITE), has(ModItems.FLUORITE))
                        .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                        .group("fluorite")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.FLUORITE_AXE)
                        .pattern("FF")
                        .pattern("SF")
                        .pattern("S ")
                        .define('F', ModItems.FLUORITE)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.FLUORITE), has(ModItems.FLUORITE))
                        .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                        .group("fluorite")
                        .save(output);
                shaped(RecipeCategory.TOOLS, ModItems.FLUORITE_HOE)
                        .pattern("FF")
                        .pattern("S ")
                        .pattern("S ")
                        .define('F', ModItems.FLUORITE)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.FLUORITE), has(ModItems.FLUORITE))
                        .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                        .group("fluorite")
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.FLUORITE_SPEAR)
                        .pattern("  F")
                        .pattern(" S ")
                        .pattern("S  ")
                        .define('F', ModItems.FLUORITE)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.FLUORITE), has(ModItems.FLUORITE))
                        .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                        .group("fluorite")
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.FLUORITE_HELMET)
                        .pattern("FFF")
                        .pattern("F F")
                        .define('F', ModItems.FLUORITE)
                        .unlockedBy(getHasName(ModItems.FLUORITE), has(ModItems.FLUORITE))
                        .group("fluorite")
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.FLUORITE_CHESTPLATE)
                        .pattern("F F")
                        .pattern("FFF")
                        .pattern("FFF")
                        .define('F', ModItems.FLUORITE)
                        .unlockedBy(getHasName(ModItems.FLUORITE), has(ModItems.FLUORITE))
                        .group("fluorite")
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.FLUORITE_LEGGINGS)
                        .pattern("FFF")
                        .pattern("F F")
                        .pattern("F F")
                        .define('F', ModItems.FLUORITE)
                        .unlockedBy(getHasName(ModItems.FLUORITE), has(ModItems.FLUORITE))
                        .group("fluorite")
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.FLUORITE_BOOTS)
                        .pattern("F F")
                        .pattern("F F")
                        .define('F', ModItems.FLUORITE)
                        .unlockedBy(getHasName(ModItems.FLUORITE), has(ModItems.FLUORITE))
                        .group("fluorite")
                        .save(output);
                shaped(RecipeCategory.MISC, ModItems.FLUORITE_HORSE_ARMOR)
                        .pattern(" SF")
                        .pattern("FFF")
                        .define('F', ModItems.FLUORITE)
                        .define('S', Items.SADDLE)
                        .unlockedBy(getHasName(ModItems.FLUORITE), has(ModItems.FLUORITE))
                        .unlockedBy(getHasName(Items.SADDLE), has(Items.SADDLE))
                        .group("fluorite")
                        .save(output);
                shaped(RecipeCategory.REDSTONE, ModBlocks.FLUORITE_LAMP)
                        .pattern("FRF")
                        .pattern("RLR")
                        .pattern("FEF")
                        .define('F', ModItems.FLUORITE)
                        .define('R', Items.REDSTONE)
                        .define('L', Blocks.REDSTONE_LAMP)
                        .define('E', Items.LEVER)
                        .unlockedBy(getHasName(ModItems.FLUORITE), has(ModItems.FLUORITE))
                        .unlockedBy(getHasName(Items.REDSTONE), has(Items.REDSTONE))
                        .group("fluorite")
                        .save(output);
                shaped(RecipeCategory.COMBAT, ModItems.FLUORITE_BOW)
                        .pattern(" FS")
                        .pattern("T S")
                        .pattern(" FS")
                        .define('F', ModItems.FLUORITE)
                        .define('S', Items.STRING)
                        .define('T', Items.STICK)
                        .unlockedBy(getHasName(ModItems.FLUORITE), has(ModItems.FLUORITE))
                        .unlockedBy(getHasName(Items.STRING), has(Items.STRING))
                        .group("fluorite")
                        .save(output);
            }
        };
    }

    @Override
    public @NonNull String getName() {
        return "First Mod Recipe";
    }
}