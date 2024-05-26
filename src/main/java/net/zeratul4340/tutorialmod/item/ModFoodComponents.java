package net.zeratul4340.tutorialmod.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent TOMATO = new FoodComponent.Builder().nutrition(3).saturationModifier(1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200, 5), 1).build();

}
