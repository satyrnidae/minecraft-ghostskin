package dev.satyrn.ghostskin;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class GhostSkinMod implements ModInitializer {
	public static final String MOD_ID = "ghostskin";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// Nothing to set up common side, all the work is client mixins
	}
}
