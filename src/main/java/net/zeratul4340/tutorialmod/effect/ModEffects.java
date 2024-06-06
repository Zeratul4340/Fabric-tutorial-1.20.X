package net.zeratul4340.tutorialmod.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.zeratul4340.tutorialmod.TutorialMod;

public class ModEffects {
    public static final RegistryEntry<StatusEffect> DISINTEGRATION = ModEffects.registerStatusEffect("disintegration", new DisintegrationStatusEffect(StatusEffectCategory.HARMFUL,  303030 ));

    public static RegistryEntry<StatusEffect> registerStatusEffect(String id, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, new Identifier(TutorialMod.MOD_ID, id), statusEffect);
    }

    public static void registerEffects() {
        //something in my ass...
        TutorialMod.LOGGER.info("Registering effects for " + TutorialMod.MOD_ID);
    }
}
