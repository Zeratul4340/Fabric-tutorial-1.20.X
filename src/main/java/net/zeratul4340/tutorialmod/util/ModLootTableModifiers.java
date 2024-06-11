package net.zeratul4340.tutorialmod.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.zeratul4340.tutorialmod.item.ModItems;

public class ModLootTableModifiers {
    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source) -> {
            if (LootTables.JUNGLE_TEMPLE_CHEST == key && source.isBuiltin()) {
                LootPool.Builder pool = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        //add ruby
                        .with(ItemEntry.builder(ModItems.RUBY))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                //this thing actually adds the loot to loot table
                tableBuilder.pool(pool);
            }
            if (EntityType.CREEPER.getLootTableId() == key && source.isBuiltin()) {
                LootPool.Builder pool = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        //add funny coal
                        .with(ItemEntry.builder(ModItems.COMPACTED_COAL))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                //this thing actually adds the loot to loot table
                tableBuilder.pool(pool);
            }

        });
    }
}
