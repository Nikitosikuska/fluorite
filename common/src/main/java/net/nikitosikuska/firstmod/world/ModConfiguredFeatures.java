package net.nikitosikuska.firstmod.world;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.nikitosikuska.firstmod.FirstMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.nikitosikuska.firstmod.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLUORITE_ORE_KEY = registerKey("fluorite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLUORITE_NETHER_ORE_KEY = registerKey("fluorite_nether_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLUORITE_END_ORE_KEY = registerKey("fluorite_end_ore");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplaceables = new TagMatchTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> overworldFluoriteOres =
                List.of(OreConfiguration.target(stoneReplaceables, ModBlocks.FLUORITE_ORE.defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceables, ModBlocks.FLUORITE_DEEPSLATE_ORE.defaultBlockState()));
        List<OreConfiguration.TargetBlockState> netherFluoriteOres =
                List.of(OreConfiguration.target(netherReplaceables, ModBlocks.FLUORITE_NETHER_ORE.defaultBlockState()));
        List<OreConfiguration.TargetBlockState> endFluoriteOres =
                List.of(OreConfiguration.target(endReplaceables, ModBlocks.FLUORITE_END_ORE.defaultBlockState()));

        register(context, FLUORITE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldFluoriteOres, 6));
        register(context, FLUORITE_NETHER_ORE_KEY, Feature.ORE, new OreConfiguration(netherFluoriteOres, 6));
        register(context, FLUORITE_END_ORE_KEY, Feature.ORE, new OreConfiguration(endFluoriteOres, 6));

    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Identifier.fromNamespaceAndPath(FirstMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}