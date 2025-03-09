package net.mrpillow.clashcraft.client.renderer;

import net.mrpillow.clashcraft.entity.SpearProjectileEntity;
import net.mrpillow.clashcraft.client.model.ModelSpear_Converted;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.mojang.math.Axis;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class SpearProjectileRenderer extends EntityRenderer<SpearProjectileEntity> {
	private static final ResourceLocation texture = ResourceLocation.parse("clash_craft:textures/entities/speartexture.png");
	private final ModelSpear_Converted model;

	public SpearProjectileRenderer(EntityRendererProvider.Context context) {
		super(context);
		model = new ModelSpear_Converted(context.bakeLayer(ModelSpear_Converted.LAYER_LOCATION));
	}

	@Override
	public void render(SpearProjectileEntity entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
		VertexConsumer vb = bufferIn.getBuffer(RenderType.entityCutout(this.getTextureLocation(entityIn)));
		poseStack.pushPose();
		poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90));
		poseStack.mulPose(Axis.ZP.rotationDegrees(90 + Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));
		model.renderToBuffer(poseStack, vb, packedLightIn, OverlayTexture.NO_OVERLAY);
		poseStack.popPose();
		super.render(entityIn, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getTextureLocation(SpearProjectileEntity entity) {
		return texture;
	}
}
