package net.nikitosikuska.firstmod.block;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.nikitosikuska.firstmod.FirstMod;
import net.nikitosikuska.firstmod.block.custom.StrawberryBushBlock;

import java.util.function.Function;

public class ModBlocks {
    public static final Block FLUORITE_BLOCK = registerBlock("fluorite_block",
            properties -> new Block(properties
                    .strength(3f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST))

    );
    public static final Block RAW_FLUORITE_BLOCK = registerBlock("raw_fluorite_block",
            properties -> new Block(properties
                    .strength(3f)
                    .requiresCorrectToolForDrops()
                    )

    );
    public static final Block FLUORITE_DEEPSLATE_ORE = registerBlock("fluorite_deepslate_ore",
            properties -> new DropExperienceBlock(UniformInt.of(3, 6), properties
                    .strength(3f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.DEEPSLATE)
            )

    );
    public static final Block FLUORITE_END_ORE = registerBlock("fluorite_end_ore",
            properties -> new DropExperienceBlock(UniformInt.of(5, 8), properties
                    .strength(3f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)
            )

    );
    public static final Block FLUORITE_NETHER_ORE = registerBlock("fluorite_nether_ore",
            properties -> new DropExperienceBlock(UniformInt.of(3, 6), properties
                    .strength(3f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.NETHER_ORE)
            )

    );
    public static final Block FLUORITE_ORE = registerBlock("fluorite_ore",
            properties -> new DropExperienceBlock(UniformInt.of(2, 5), properties
                    .strength(3f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)
            )

    );
    public static final Block STRAWBERRY_BUSH = registerBlock("strawberry_bush",
            properties -> new StrawberryBushBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH)
                    .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(FirstMod.MOD_ID, "strawberry_bush"))))
    );
    public static final Block FLUORITE_STAIRS = registerBlock("fluorite_stairs",
            properties -> new StairBlock(ModBlocks.FLUORITE_BLOCK.defaultBlockState(), properties
                    .strength(3f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST))

    );
    public static final Block FLUORITE_SLAB = registerBlock("fluorite_slab",
            properties -> new SlabBlock(properties
                    .strength(3f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST))

    );
    public static final Block FLUORITE_BUTTON = registerBlock("fluorite_button",
            properties -> new ButtonBlock(BlockSetType.IRON, 20, properties
                    .strength(3f)
                    .noCollision()
                    .sound(SoundType.AMETHYST))
    );
    public static final Block FLUORITE_PRESSURE_PLATE = registerBlock("fluorite_pressure_plate",
            properties -> new PressurePlateBlock(BlockSetType.IRON, properties
                    .mapColor(MapColor.COLOR_BLUE)
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollision()
                    .strength(0.5F)
                    .pushReaction(PushReaction.DESTROY)

    ));
    public static final Block FLUORITE_FENCE = registerBlock("fluorite_fence",
            properties -> new FenceBlock(properties
                    .strength(3f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST))
    );
    public static final Block FLUORITE_FENCE_GATE = registerBlock("fluorite_fence_gate",
            properties -> new FenceGateBlock(WoodType.OAK, properties
                    .strength(3f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST))
    );
    public static final Block FLUORITE_WALL = registerBlock("fluorite_wall",
            properties -> new WallBlock(properties
                    .strength(3f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST))
    );
    public static final Block FLUORITE_DOOR = registerBlock("fluorite_door",
            properties -> new DoorBlock(BlockSetType.IRON, properties
                    .strength(3f)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()
                    .sound(SoundType.AMETHYST))
    );
    public static final Block FLUORITE_TRAPDOOR = registerBlock("fluorite_trapdoor",
            properties -> new TrapDoorBlock(BlockSetType.IRON, properties
                    .strength(3f)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()
                    .sound(SoundType.AMETHYST))
    );
    public static final Block RAW_FLUORITE_STAIRS = registerBlock("raw_fluorite_stairs",
            properties -> new StairBlock(ModBlocks.FLUORITE_BLOCK.defaultBlockState(), properties
                    .strength(3f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST))

    );
    public static final Block RAW_FLUORITE_SLAB = registerBlock("raw_fluorite_slab",
            properties -> new SlabBlock(properties
                    .strength(3f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST))

    );
    public static final Block RAW_FLUORITE_WALL = registerBlock("raw_fluorite_wall",
            properties -> new WallBlock(properties
                    .strength(3f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST))
    );

    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(FirstMod.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(FirstMod.MOD_ID, name), toRegister);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(FirstMod.MOD_ID, name),
                new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix()
                        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(FirstMod.MOD_ID, name)))));
    }

    public static void registerModBlocks() {

    }
}
