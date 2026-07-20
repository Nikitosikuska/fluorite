package net.nikitosikuska.firstmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

import static net.nikitosikuska.firstmod.item.ModItems.registerItem;

public class ModFoodComponents {
    public static final FoodProperties STRAWBERRY = new FoodProperties.Builder()
            .nutrition(3)
            .saturationModifier(0.25f)
            .build();
}
