package dev.satyrn.ghostskin.mixin;

import com.mojang.blaze3d.platform.NativeImage;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.texture.HttpTexture;
import net.minecraft.client.renderer.texture.SimpleTexture;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(HttpTexture.class)
public abstract class HttpTextureMixin extends SimpleTexture {


	public HttpTextureMixin(ResourceLocation location) { super(location); }

	@Inject(method = "setNoAlpha(Lcom/mojang/blaze3d/platform/NativeImage;IIII)V", at = @At("HEAD"), cancellable = true)
	private static void ghostskin$cancelSetNoAlpha(NativeImage image, int x1, int y1, int x2, int y2, CallbackInfo ci) {
		ci.cancel();
	}

	@Inject(method = "doNotchTransparencyHack(Lcom/mojang/blaze3d/platform/NativeImage;IIII)V", at = @At("HEAD"), cancellable = true)
	private static void ghostskin$cancelDoNotchTransparencyHack(NativeImage image, int x1, int y1, int x2, int y2, CallbackInfo ci) {
		ci.cancel();
	}
}
