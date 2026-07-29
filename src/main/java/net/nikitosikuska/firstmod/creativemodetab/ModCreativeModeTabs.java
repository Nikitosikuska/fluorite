package net.nikitosikuska.firstmod.creativemodetab;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.nikitosikuska.firstmod.FirstMod;
import net.nikitosikuska.firstmod.block.ModBlocks;
import net.nikitosikuska.firstmod.item.ModItems;

public class ModCreativeModeTabs {
    public static final CreativeModeTab FLUORITE_ITEM_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
        Identifier.fromNamespaceAndPath(FirstMod.MOD_ID, "fluorite"),
        FabricCreativeModeTab.builder().icon(() -> new ItemStack(ModItems.FLUORITE)).title(Component.translatable("creativemodetab.firstmod.fluorite")).displayItems((parameters, output) -> {
            output.accept(ModItems.FLUORITE);
            output.accept(ModItems.RAW_FLUORITE);
            output.accept(ModItems.FLUORITE_SWORD);
            output.accept(ModItems.FLUORITE_PICKAXE);
            output.accept(ModItems.FLUORITE_SHOVEL);
            output.accept(ModItems.FLUORITE_AXE);
            output.accept(ModItems.FLUORITE_HOE);
            output.accept(ModItems.FLUORITE_BOW);
            output.accept(ModItems.FLUORITE_SPEAR);
            output.accept(ModItems.FLUORITE_HELMET);
            output.accept(ModItems.FLUORITE_CHESTPLATE);
            output.accept(ModItems.FLUORITE_LEGGINGS);
            output.accept(ModItems.FLUORITE_BOOTS);
            output.accept(ModItems.FLUORITE_HORSE_ARMOR);
            output.accept(ModBlocks.RAW_FLUORITE_BLOCK);
            output.accept(ModBlocks.RAW_FLUORITE_STAIRS);
            output.accept(ModBlocks.RAW_FLUORITE_SLAB);
            output.accept(ModBlocks.RAW_FLUORITE_WALL);
            output.accept(ModBlocks.FLUORITE_BLOCK);
            output.accept(ModBlocks.FLUORITE_STAIRS);
            output.accept(ModBlocks.FLUORITE_SLAB);
            output.accept(ModBlocks.FLUORITE_DOOR);
            output.accept(ModBlocks.FLUORITE_TRAPDOOR);
            output.accept(ModBlocks.FLUORITE_FENCE);
            output.accept(ModBlocks.FLUORITE_FENCE_GATE);
            output.accept(ModBlocks.FLUORITE_WALL);
            output.accept(ModBlocks.FLUORITE_BUTTON);
            output.accept(ModBlocks.FLUORITE_PRESSURE_PLATE);
            output.accept(ModBlocks.FLUORITE_LAMP);
            output.accept(ModBlocks.FLUORITE_ORE);
            output.accept(ModBlocks.FLUORITE_DEEPSLATE_ORE);
            output.accept(ModBlocks.FLUORITE_NETHER_ORE);
            output.accept(ModBlocks.FLUORITE_END_ORE);
            output.accept(ModItems.STRAWBERRY);
            output.accept(ModItems.COMBUSTIBLE_SPORES);
        }).build());

    public static void registerModCreativeModeTabs() {
    }
}
