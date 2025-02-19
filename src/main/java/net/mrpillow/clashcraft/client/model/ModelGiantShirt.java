package net.mrpillow.clashcraft.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.12.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelGiantShirt<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("clash_craft", "model_giant_shirt"), "main");
	public final ModelPart Shirt;
	public final ModelPart HandRight;
	public final ModelPart HandLeft;

	public ModelGiantShirt(ModelPart root) {
		this.Shirt = root.getChild("Shirt");
		this.HandRight = root.getChild("HandRight");
		this.HandLeft = root.getChild("HandLeft");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Shirt = partdefinition.addOrReplaceChild("Shirt",
				CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, 0.0F, 2.05F, 8.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(0, 12).addBox(-4.0F, 0.0F, -2.05F, 8.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(16, 4)
						.addBox(4.05F, 0.0F, -2.0F, 0.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(16, 20).addBox(-4.05F, 0.0F, -2.0F, 0.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(16, 0)
						.addBox(-4.0F, -0.05F, -2.0F, 8.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition HandRight = partdefinition.addOrReplaceChild("HandRight", CubeListBuilder.create(), PartPose.offset(-5.0F, 2.0F, 0.0F));
		PartDefinition HandLeft = partdefinition.addOrReplaceChild("HandLeft", CubeListBuilder.create(), PartPose.offset(5.0F, 2.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		Shirt.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		HandRight.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		HandLeft.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}
