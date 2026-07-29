package net.nikitosikuska.firstmod.item;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorType;
import net.nikitosikuska.firstmod.FirstMod;
import net.nikitosikuska.firstmod.block.ModBlocks;

import java.util.function.Function;

public class ModItems {
    public static final Item FLUORITE = registerItem("fluorite", Item::new);
    public static final Item RAW_FLUORITE = registerItem("raw_fluorite", Item::new);
    public static final Item STRAWBERRY = registerItem("strawberry",
            properties -> new BlockItem(ModBlocks.STRAWBERRY_BUSH, properties.food(ModFoodComponents.STRAWBERRY)));
    public static final Item COMBUSTIBLE_SPORES = registerItem("combustible_spores", properties -> new Item(properties.stacksTo(16)));
    public static final Item FLUORITE_SWORD = registerItem("fluorite_sword", properties -> new Item(properties.sword(ModToolMaterials.FLUORITE, 3, -2.4f)));
    public static final Item FLUORITE_PICKAXE = registerItem("fluorite_pickaxe", properties -> new Item(properties.pickaxe(ModToolMaterials.FLUORITE, 1, -2.8f)));
    public static final Item FLUORITE_SHOVEL = registerItem("fluorite_shovel", properties -> new ShovelItem(ModToolMaterials.FLUORITE, 1.5f, -3.0f, properties));
    public static final Item FLUORITE_AXE = registerItem("fluorite_axe", properties -> new AxeItem(ModToolMaterials.FLUORITE, 3.0f, -3.2f, properties));
    public static final Item FLUORITE_HOE = registerItem("fluorite_hoe", properties -> new HoeItem(ModToolMaterials.FLUORITE, 0f, -0.5f, properties));
    public static final Item FLUORITE_SPEAR = registerItem("fluorite_spear", properties -> new Item(properties.spear(ModToolMaterials.FLUORITE, 0.95f, 0.95f, 0.6f, 2.5f, 11.0f, 6.75f, 5.1f, 11.25f, 4.6f)));

    public static final Item FLUORITE_HELMET = registerItem("fluorite_helmet", properties -> new Item(properties.humanoidArmor(ModArmorMaterials.FLUORITE_ARMOR_MATERIAL, ArmorType.HELMET)));
    public static final Item FLUORITE_CHESTPLATE = registerItem("fluorite_chestplate", properties -> new Item(properties.humanoidArmor(ModArmorMaterials.FLUORITE_ARMOR_MATERIAL, ArmorType.CHESTPLATE)));
    public static final Item FLUORITE_LEGGINGS = registerItem("fluorite_leggings", properties -> new Item(properties.humanoidArmor(ModArmorMaterials.FLUORITE_ARMOR_MATERIAL, ArmorType.LEGGINGS)));
    public static final Item FLUORITE_BOOTS = registerItem("fluorite_boots", properties -> new Item(properties.humanoidArmor(ModArmorMaterials.FLUORITE_ARMOR_MATERIAL, ArmorType.BOOTS)));

    public static final Item FLUORITE_HORSE_ARMOR = registerItem("fluorite_horse_armor", properties -> new Item(properties.horseArmor(ModArmorMaterials.FLUORITE_ARMOR_MATERIAL)));

    public static final Item FLUORITE_BOW = registerItem("fluorite_bow", properties -> new BowItem(properties.durability(500)));

    public static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(FirstMod.MOD_ID, name), function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(FirstMod.MOD_ID, name)))));
    }

    public static void registerModItems() {
    }

}
