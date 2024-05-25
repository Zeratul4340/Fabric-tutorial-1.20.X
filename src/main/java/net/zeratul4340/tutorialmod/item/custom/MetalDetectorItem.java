package net.zeratul4340.tutorialmod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

/**
 * First ever implementation of a custom functional item
 *
 * I would add an author tag, but I followed a tutorial on this...
 */
public class MetalDetectorItem extends Item {
    public MetalDetectorItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(!context.getWorld().isClient()) {
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;

            for (int i = 0; i <= positionClicked.getY() + 64; i++) {
                BlockState state = context.getWorld().getBlockState(positionClicked.down(i));

                if (i == 0 && isValuableBlock(state)) {
                    player.sendMessage(Text.literal("You're looking at an exposed metal ore..."));
                    continue;
                }
                /*
                Displays valuable metals.

                Maybe for later I should make it scan tags instead of specific blocks,
                and also just store the scanned ores in list. Also remove coords because they're moot.

                Intent: "Found 2 Iron ores, 0 Copper ores, 1 Gold ores"
                */
                if(isValuableBlock(state)) {
                    outputValuableCoordinates(positionClicked.down(i), player, state.getBlock());
                    foundBlock = true;
                }
                /*
                stop iterating on hitting bedrock or void (probably useless)
                */
                if(hitBedrock(state)) {
                    break;
                }
            }
            if(!foundBlock) {
                assert player != null;
                player.sendMessage(Text.literal("No metals found..."));
            }
        }
        /*
          Note for later: This handles damage to the durability
         */
        if (context.getPlayer() != null) {
            context.getStack().damage(1, context.getPlayer(), LivingEntity.getSlotForHand(context.getHand()));
        }
        return super.useOnBlock(context);
    }

    private boolean hitBedrock(BlockState state) {
        return state.isOf(Blocks.BEDROCK) || state.isOf(Blocks.VOID_AIR);
    }

    private void outputValuableCoordinates(BlockPos blockPos, PlayerEntity player, Block block) {
        player.sendMessage(Text.literal("Found " + block.asItem().getName().getString() + " at " +
                "(" + blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ() + ")"), false);
    }

    private boolean isValuableBlock(BlockState state) {
        return state.isOf(Blocks.IRON_ORE) || state.isOf(Blocks.DEEPSLATE_IRON_ORE) || state.isOf(Blocks.COPPER_ORE) || state.isOf(Blocks.DEEPSLATE_COPPER_ORE) || state.isOf(Blocks.GOLD_ORE) || state.isOf(Blocks.DEEPSLATE_GOLD_ORE);
    }
}
