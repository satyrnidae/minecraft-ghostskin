package dev.satyrn.ghostskin.fabric.client;

import dev.satyrn.ghostskin.fabriclike.client.GhostSkinModFabricLikeClient;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class GhostSkinModFabricClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		GhostSkinModFabricLikeClient.initClient();
	}
}
