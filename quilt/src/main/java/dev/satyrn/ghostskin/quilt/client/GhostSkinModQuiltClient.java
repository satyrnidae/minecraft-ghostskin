package dev.satyrn.ghostskin.quilt.client;

import org.quiltmc.loader.api.ModContainer;

import dev.satyrn.ghostskin.fabriclike.client.GhostSkinModFabricLikeClient;
import org.quiltmc.loader.api.minecraft.ClientOnly;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;

@ClientOnly
public final class GhostSkinModQuiltClient implements ClientModInitializer {
	@Override
	public void onInitializeClient(ModContainer modContainer) {
		GhostSkinModFabricLikeClient.initClient();
	}
}
