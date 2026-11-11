package dev.satyrn.ghostskin.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import dev.satyrn.ghostskin.GhostSkinMod;

@Mod(GhostSkinMod.MOD_ID)
public final class GhostSkinModForge {
    public GhostSkinModForge(final FMLJavaModLoadingContext modLoadingContext) {
        // Submit our event bus to let Architectury API register our content on the right time.
        EventBuses.registerModEventBus(GhostSkinMod.MOD_ID, modLoadingContext.getModEventBus());
    }
}
