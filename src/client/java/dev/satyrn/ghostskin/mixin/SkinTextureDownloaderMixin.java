package dev.satyrn.ghostskin.mixin;

import com.mojang.blaze3d.platform.NativeImage;
import net.minecraft.client.renderer.texture.SkinTextureDownloader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Stops the skin loader from forcing parts of a player skin opaque.
 * <p>
 * {@code processLegacySkin} calls {@code setNoAlpha} on the head, body, arm and leg regions, so the base layer
 * can never be transparent. Cancelling it keeps the alpha channel of the original skin intact.
 */
@Mixin(SkinTextureDownloader.class)
public abstract class SkinTextureDownloaderMixin {
	@Inject(method = "setNoAlpha", at = @At("HEAD"), cancellable = true)
	private static void ghostskin$keepAlpha(NativeImage image, int x0, int y0, int x1, int y1, CallbackInfo ci) {
		ci.cancel();
	}

	// Legacy 64x32 skins only. Strips the hat layer alpha if it is fully opaque, which would undo the above
	@Inject(method = "doNotchTransparencyHack", at = @At("HEAD"), cancellable = true)
	private static void ghostskin$keepHatAlpha(NativeImage image, int x0, int y0, int x1, int y1, CallbackInfo ci) {
		ci.cancel();
	}
}
