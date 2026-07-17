package net.nikitosikuska.firstmod.item;

import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorMaterials;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.nikitosikuska.firstmod.FirstMod;
import net.nikitosikuska.firstmod.tags.ModTags;

public class ModArmorMaterials {
    public static final ResourceKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY = ResourceKey.createRegistryKey(Identifier.withDefaultNamespace("equipment_asset"));
    public static final ResourceKey<EquipmentAsset> FLUORITE_KEY = ResourceKey.create(REGISTRY_KEY, Identifier.fromNamespaceAndPath(FirstMod.MOD_ID, "fluorite"));
    public static final ArmorMaterial FLUORITE_ARMOR_MATERIAL = new ArmorMaterial(750, ArmorMaterials.makeDefense(2, 5, 7, 3, 9), 12, SoundEvents.ARMOR_EQUIP_CHAIN, 1.0f, 0.0f, ModTags.Items.FLUORITE_REPAIR, FLUORITE_KEY);
}
