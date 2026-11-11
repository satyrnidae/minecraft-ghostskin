package dev.satyrn.ghostskin.client;

import dev.satyrn.ghostskin.GhostSkinMod;
import net.fabricmc.api.ClientModInitializer;

public final class GhostSkinModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		GhostSkinMod.LOGGER.info("Ghost Skin mod loaded!");
	}
}
