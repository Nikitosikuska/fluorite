package net.nikitosikuska.firstmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.advancements.predicates.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.nikitosikuska.firstmod.block.ModBlocks;
import net.nikitosikuska.firstmod.block.custom.StrawberryBushBlock;
import net.nikitosikuska.firstmod.item.ModItems;

import java.util.concurrent.CompletableFuture;

import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition.Builder;
public class ModBlockLootTableProvider extends FabricBlockLootSubProvider {
    public ModBlockLootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {
        HolderLookup.RegistryLookup<Enchantment> impl = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        dropSelf(ModBlocks.FLUORITE_BLOCK);
        dropSelf(ModBlocks.RAW_FLUORITE_BLOCK);

        add(ModBlocks.FLUORITE_ORE, createOreDrop(ModBlocks.FLUORITE_ORE, ModItems.RAW_FLUORITE));
        add(ModBlocks.FLUORITE_DEEPSLATE_ORE, createOreDrop(ModBlocks.FLUORITE_DEEPSLATE_ORE, ModItems.RAW_FLUORITE));

        add(ModBlocks.FLUORITE_NETHER_ORE, createMultipleOreDrops(ModBlocks.FLUORITE_NETHER_ORE, ModItems.RAW_FLUORITE, 3, 6));
        add(ModBlocks.FLUORITE_END_ORE, createMultipleOreDrops(ModBlocks.FLUORITE_END_ORE, ModItems.RAW_FLUORITE, 5, 8));
        dropSelf(ModBlocks.FLUORITE_STAIRS);
        add(ModBlocks.FLUORITE_SLAB, this::createSlabItemTable);
        dropSelf(ModBlocks.FLUORITE_PRESSURE_PLATE);
        dropSelf(ModBlocks.FLUORITE_BUTTON);
        dropSelf(ModBlocks.FLUORITE_FENCE);
        dropSelf(ModBlocks.FLUORITE_FENCE_GATE);
        dropSelf(ModBlocks.FLUORITE_WALL);
        dropSelf(ModBlocks.FLUORITE_TRAPDOOR);
        add(ModBlocks.FLUORITE_DOOR, this::createDoorTable);
        add(ModBlocks.RAW_FLUORITE_SLAB, this::createSlabItemTable);
        dropSelf(ModBlocks.RAW_FLUORITE_STAIRS);
        dropSelf(ModBlocks.RAW_FLUORITE_WALL);

        this.add(
                ModBlocks.STRAWBERRY_BUSH,
                block -> this.applyExplosionDecay(
                        block,
                        LootTable.lootTable()
                                .withPool(
                                        LootPool.lootPool()
                                                .when(
                                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.STRAWBERRY_BUSH)
                                                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                                                        .hasProperty(StrawberryBushBlock.AGE, 3))
                                                )
                                                .add(LootItem.lootTableItem(ModItems.STRAWBERRY))
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F)))
                                                .apply(ApplyBonusCount.addUniformBonusCount(
                                                        impl.getOrThrow(Enchantments.FORTUNE)))
                                )
                                .withPool(
                                        LootPool.lootPool()
                                                .when(
                                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.STRAWBERRY_BUSH)
                                                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                                                        .hasProperty(StrawberryBushBlock.AGE, 2))
                                                )
                                                .add(LootItem.lootTableItem(ModItems.STRAWBERRY))
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                                                .apply(ApplyBonusCount.addUniformBonusCount(
                                                        impl.getOrThrow(Enchantments.FORTUNE)))
                                )
                )
        );
    }

    public LootTable.Builder createMultipleOreDrops(final Block block, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> enchantments = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                block,
                (LootPoolEntryContainer.Builder<?>)this.applyExplosionDecay(
                        block,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                                .apply(ApplyBonusCount.addOreBonusCount(enchantments.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }
}
