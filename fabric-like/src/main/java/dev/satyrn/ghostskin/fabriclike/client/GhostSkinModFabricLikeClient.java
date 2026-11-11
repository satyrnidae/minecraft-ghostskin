package dev.satyrn.ghostskin.fabriclike.client;

import dev.satyrn.ghostskin.client.GhostSkinModClient;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public final class GhostSkinModFabricLikeClient {
    public static void initClient() {
		GhostSkinModClient.initClient();
    }
}
