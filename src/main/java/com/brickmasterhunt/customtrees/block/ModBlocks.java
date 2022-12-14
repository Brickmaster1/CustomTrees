package com.brickmasterhunt.customtrees.block;

import com.brickmasterhunt.customtrees.customtrees;
import com.brickmasterhunt.customtrees.item.ModItems;
import com.brickmasterhunt.customtrees.world.feature.tree.OakTreeGrower;
import com.sun.jna.platform.win32.NTSecApi;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, customtrees.MOD_ID);
    public static final RegistryObject<Block> CUSTOM_OAK_SAPLING = registerBlock("oak_sapling",
            () -> new SaplingBlock(new OakTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)),
            CreativeModeTab.TAB_DECORATIONS);


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                           CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
