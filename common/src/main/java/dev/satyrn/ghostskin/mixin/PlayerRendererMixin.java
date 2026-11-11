package dev.satyrn.ghostskin.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.blaze3d.vertex.PoseStack;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(PlayerRenderer.class)
public abstract class PlayerRendererMixin extends LivingEntityRenderer<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> {
	public PlayerRendererMixin(EntityRendererProvider.Context ctx,
							   PlayerModel<AbstractClientPlayer> model,
							   float shadowRadius) {
		super(ctx, model, shadowRadius);
	}

	@Inject(method = "renderHand(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;ILnet/minecraft/client/player/AbstractClientPlayer;Lnet/minecraft/client/model/geom/ModelPart;Lnet/minecraft/client/model/geom/ModelPart;)V",
		at = @At(value = "INVOKE", target = "net/minecraft/client/model/PlayerModel.setupAnim (Lnet/minecraft/world/entity/LivingEntity;FFFFF)V", ordinal = 0, shift = At.Shift.AFTER), cancellable = true)
	private void ghostskin$renderHand(final PoseStack matrices,
									  final MultiBufferSource vertexConsumers,
									  final int light,
									  final AbstractClientPlayer player,
									  final ModelPart arm,
									  final ModelPart sleeve,
									  final CallbackInfo ci) {
		ResourceLocation resourceLocation = player.getSkinTextureLocation();
		arm.xRot = 0.0F;
		arm.render(matrices, vertexConsumers.getBuffer(RenderType.entityTranslucent(resourceLocation)), light,
			OverlayTexture.NO_OVERLAY);
		sleeve.xRot = 0.0F;
		sleeve.render(matrices, vertexConsumers.getBuffer(RenderType.entityTranslucent(resourceLocation)), light,
			OverlayTexture.NO_OVERLAY);
		ci.cancel();
	}
}
