package net.zeratul4340.tutorialmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.zeratul4340.tutorialmod.block.ModBlocks;
import net.zeratul4340.tutorialmod.effect.ModEffects;
import net.zeratul4340.tutorialmod.item.ModItemGroups;
import net.zeratul4340.tutorialmod.item.ModItems;
import net.zeratul4340.tutorialmod.sound.ModSounds;
import net.zeratul4340.tutorialmod.util.ModLootTableModifiers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Knowledge through... disintegration");

		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModEffects.registerEffects();

		ModLootTableModifiers.modifyLootTables();
		ModSounds.registerSounds();

		FuelRegistry.INSTANCE.add(ModItems.COMPACTED_COAL, 16000);
	}
}