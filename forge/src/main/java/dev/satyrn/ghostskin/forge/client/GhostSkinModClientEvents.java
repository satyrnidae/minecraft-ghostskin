package dev.satyrn.ghostskin.forge.client;

import dev.satyrn.ghostskin.GhostSkinMod;
import dev.satyrn.ghostskin.client.GhostSkinModClient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = GhostSkinMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class GhostSkinModClientEvents {

	@SubscribeEvent
	public static void onClientInit(FMLClientSetupEvent event) {
		GhostSkinModClient.initClient();
	}
}
