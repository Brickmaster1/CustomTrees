package com.brickmasterhunt.customtrees.world;

import com.brickmasterhunt.customtrees.customtrees;
import com.brickmasterhunt.customtrees.world.gen.ModTreeGeneraion;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = customtrees.MOD_ID)
public class ModWorldEvents {
    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
        ModTreeGeneraion.generateTrees(event);
    }
}
