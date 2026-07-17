package net.nikitosikuska.firstmod.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.world.item.Item;
import net.nikitosikuska.firstmod.block.ModBlocks;
import net.nikitosikuska.firstmod.block.custom.StrawberryBushBlock;
import net.nikitosikuska.firstmod.item.ModArmorMaterials;
import net.nikitosikuska.firstmod.item.ModItems;
import org.jspecify.annotations.NonNull;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(@NonNull BlockModelGenerators blockModelGenerators) {
        blockModelGenerators.createTrivialCube(ModBlocks.FLUORITE_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.FLUORITE_DEEPSLATE_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.FLUORITE_NETHER_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.FLUORITE_END_ORE);
        blockModelGenerators.createCrossBlock(ModBlocks.STRAWBERRY_BUSH, BlockModelGenerators.PlantType.NOT_TINTED, StrawberryBushBlock.AGE, 0, 1, 2, 3);
        blockModelGenerators.family(ModBlocks.FLUORITE_BLOCK)
                .stairs(ModBlocks.FLUORITE_STAIRS)
                .slab(ModBlocks.FLUORITE_SLAB)
                .button(ModBlocks.FLUORITE_BUTTON)
                .pressurePlate(ModBlocks.FLUORITE_PRESSURE_PLATE)
                .fence(ModBlocks.FLUORITE_FENCE)
                .fenceGate(ModBlocks.FLUORITE_FENCE_GATE)
                .wall(ModBlocks.FLUORITE_WALL);
        blockModelGenerators.family(ModBlocks.RAW_FLUORITE_BLOCK)
                .stairs(ModBlocks.RAW_FLUORITE_STAIRS)
                .slab(ModBlocks.RAW_FLUORITE_SLAB)
                .wall(ModBlocks.RAW_FLUORITE_WALL);
        blockModelGenerators.createDoor(ModBlocks.FLUORITE_DOOR);
        blockModelGenerators.createTrapdoor(ModBlocks.FLUORITE_TRAPDOOR);

    }

    @Override
    public void generateItemModels(@NonNull ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(ModItems.FLUORITE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RAW_FLUORITE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.COMBUSTIBLE_SPORES, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.FLUORITE_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.FLUORITE_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.FLUORITE_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.FLUORITE_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.FLUORITE_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateSpear(ModItems.FLUORITE_SPEAR);
        itemModelGenerators.generateTrimmableItem(ModItems.FLUORITE_HELMET, ModArmorMaterials.FLUORITE_KEY, ItemModelGenerators.TRIM_PREFIX_HELMET, false);
        itemModelGenerators.generateTrimmableItem(ModItems.FLUORITE_CHESTPLATE, ModArmorMaterials.FLUORITE_KEY, ItemModelGenerators.TRIM_PREFIX_CHESTPLATE, false);
        itemModelGenerators.generateTrimmableItem(ModItems.FLUORITE_LEGGINGS, ModArmorMaterials.FLUORITE_KEY, ItemModelGenerators.TRIM_PREFIX_LEGGINGS, false);
        itemModelGenerators.generateTrimmableItem(ModItems.FLUORITE_BOOTS, ModArmorMaterials.FLUORITE_KEY, ItemModelGenerators.TRIM_PREFIX_BOOTS, false);
        itemModelGenerators.generateFlatItem(ModItems.FLUORITE_HORSE_ARMOR, ModelTemplates.FLAT_ITEM);
    }
}
