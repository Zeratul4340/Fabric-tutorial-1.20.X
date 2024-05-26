package net.zeratul4340.tutorialmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SoundBlock extends Block {
    public SoundBlock(Settings settings) {
        super(settings);
    }

    /*
    Note for later: THIS IS A VERY BASIC FUNCTIONAL BLOCK. REMEMBER TO LOOK BACK HERE WHEN MAKING THE WORMHOLE PAD.

    Also make sure to check net.minecraft.entity and figure out how requestTeleport works.
     */
    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_XYLOPHONE.value(), SoundCategory.BLOCKS, 1f, 1f);
        return ActionResult.SUCCESS;
    }

}
