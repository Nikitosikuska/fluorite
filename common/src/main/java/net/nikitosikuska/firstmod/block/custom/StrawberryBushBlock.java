package net.nikitosikuska.firstmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.nikitosikuska.firstmod.item.ModItems;
import org.jspecify.annotations.NonNull;

public class StrawberryBushBlock extends SweetBerryBushBlock {

    private static final int WATER_CHECK_RADIUS = 4;

    public StrawberryBushBlock(Properties properties) {
        super(properties);
    }

    @Override
    public @NonNull ItemStack getCloneItemStack(@NonNull LevelReader level, @NonNull BlockPos pos, @NonNull BlockState state, boolean includeData) {
        return new ItemStack(ModItems.STRAWBERRY);
    }

    @Override
    protected @NonNull InteractionResult useWithoutItem(BlockState state, @NonNull Level level, @NonNull BlockPos pos, @NonNull Player player, @NonNull BlockHitResult hit) {
        int i = state.getValue(AGE);
        boolean fullyGrown = i == 3;
        if (i > 1) {
            int j = 1 + level.getRandom().nextInt(2);
            popResource(level, pos, new ItemStack(ModItems.STRAWBERRY, j + (fullyGrown ? 1 : 0)));
            level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.getRandom().nextFloat() * 0.4F);
            BlockState blockState = state.setValue(AGE, 1);
            level.setBlock(pos, blockState, Block.UPDATE_CLIENTS);
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, blockState));
            return InteractionResult.SUCCESS;
        } else {
            return super.useWithoutItem(state, level, pos, player, hit);
        }
    }

    @Override
    public void randomTick(@NonNull BlockState state, @NonNull ServerLevel level, @NonNull BlockPos pos, @NonNull RandomSource random) {
        int age = state.getValue(AGE);
        if (age < 3) {
            int growthChance = isNearWater(level, pos) ? 2 : 5;
            if (random.nextInt(growthChance) == 0) {
                BlockState newState = state.setValue(AGE, age + 1);
                level.setBlock(pos, newState, Block.UPDATE_CLIENTS);
                level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(newState));
            }
        }
    }

    private boolean isNearWater(ServerLevel level, BlockPos pos) {
        for (BlockPos checkPos : BlockPos.betweenClosed(
                pos.offset(-WATER_CHECK_RADIUS, -1, -WATER_CHECK_RADIUS),
                pos.offset(WATER_CHECK_RADIUS, 1, WATER_CHECK_RADIUS))) {
            if (level.getFluidState(checkPos).is(FluidTags.WATER)) {
                return true;
            }
        }
        return false;
    }
}