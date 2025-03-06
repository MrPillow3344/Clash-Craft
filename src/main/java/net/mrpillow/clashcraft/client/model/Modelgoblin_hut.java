package net.mrpillow.clashcraft.client.model;

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

// Made with Blockbench 4.12.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelgoblin_hut<T extends GoblinHutEntity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("clash_craft", "modelgoblin_hut"), "main");
	public final ModelPart Roof;
	public final ModelPart Corners;
	public final ModelPart RightHorn;
	public final ModelPart LeftHorn;
	public final ModelPart Shingles;
	public final ModelPart Walls;
	public final ModelPart Floor;
	public final ModelPart RightFloorSpikes;
	public final ModelPart Spike1;
	public final ModelPart Spike2;
	public final ModelPart LeftFloorSpikes;
	public final ModelPart Spike3;
	public final ModelPart Spike4;

	public Modelgoblin_hut(ModelPart root) {
		this.Roof = root.getChild("Roof");
		this.Corners = this.Roof.getChild("Corners");
		this.RightHorn = this.Roof.getChild("RightHorn");
		this.LeftHorn = this.Roof.getChild("LeftHorn");
		this.Shingles = this.Roof.getChild("Shingles");
		this.Walls = root.getChild("Walls");
		this.Floor = root.getChild("Floor");
		this.RightFloorSpikes = root.getChild("RightFloorSpikes");
		this.Spike1 = this.RightFloorSpikes.getChild("Spike1");
		this.Spike2 = this.RightFloorSpikes.getChild("Spike2");
		this.LeftFloorSpikes = root.getChild("LeftFloorSpikes");
		this.Spike3 = this.LeftFloorSpikes.getChild("Spike3");
		this.Spike4 = this.LeftFloorSpikes.getChild("Spike4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Roof = partdefinition.addOrReplaceChild("Roof", CubeListBuilder.create(), PartPose.offset(7.0F, 24.0F, 9.0F));
		PartDefinition Corners = Roof.addOrReplaceChild("Corners", CubeListBuilder.create(), PartPose.offset(24.0F, -60.0F, -40.0F));
		PartDefinition cube_r1 = Corners.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(256, 172).addBox(-6.0F, 2.5F, -36.0F, 8.0F, 7.0F, 45.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-56.0F, 15.0F, 59.0F, -0.6109F, -0.7854F, 0.0F));
		PartDefinition cube_r2 = Corners.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 260).addBox(-6.0F, -1.5F, 9.0F, 8.0F, 7.0F, 43.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-64.0F, 28.0F, -5.0F, 0.6109F, 0.7854F, 0.0F));
		PartDefinition cube_r3 = Corners.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(256, 224).addBox(-46.5F, 1.5F, 5.0F, 8.0F, 7.0F, 45.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, -8.0F, 3.0F, -0.6109F, 0.7854F, 0.0F));
		PartDefinition cube_r4 = Corners.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(256, 0).addBox(-7.0F, -3.5F, 2.0F, 8.0F, 7.0F, 45.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, 26.0F, 3.0F, 0.6109F, -0.7854F, 0.0F));
		PartDefinition RightHorn = Roof.addOrReplaceChild("RightHorn",
				CubeListBuilder.create().texOffs(298, 104).addBox(-24.0F, 3.0F, -1.0F, 15.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(0, 310).addBox(-10.0F, -4.0F, -1.0F, 10.0F, 9.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(256, 52)
						.addBox(-9.0F, -5.0F, 0.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(192, 172).addBox(-8.0F, -6.0F, 1.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(292, 62)
						.addBox(-7.0F, -7.0F, 2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(170, 295).addBox(-6.0F, -8.0F, 3.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(24.0F, -60.0F, -13.0F));
		PartDefinition cube_r5 = RightHorn.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(102, 307).addBox(-1.0F, -21.0F, -1.0F, 10.0F, 12.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-21.0F, 13.0F, 0.0F, 0.0F, 0.0F, 0.7854F));
		PartDefinition LeftHorn = Roof.addOrReplaceChild("LeftHorn",
				CubeListBuilder.create().texOffs(262, 302).addBox(-24.0F, 3.0F, -1.0F, 15.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(40, 310).addBox(-10.0F, -4.0F, -1.0F, 10.0F, 9.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(198, 260)
						.addBox(-9.0F, -5.0F, 0.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(216, 172).addBox(-8.0F, -6.0F, 1.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(304, 52)
						.addBox(-7.0F, -7.0F, 2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(298, 124).addBox(-6.0F, -8.0F, 3.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-37.0F, -60.0F, -5.0F, 0.0F, 3.1416F, 0.0F));
		PartDefinition cube_r6 = LeftHorn.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(142, 307).addBox(-1.0F, -21.0F, -1.0F, 10.0F, 12.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-21.0F, 13.0F, 0.0F, 0.0F, 0.0F, 0.7854F));
		PartDefinition Shingles = Roof.addOrReplaceChild("Shingles",
				CubeListBuilder.create().texOffs(0, 0).addBox(-39.0F, -36.0F, -41.0F, 64.0F, 4.0F, 64.0F, new CubeDeformation(0.0F)).texOffs(0, 68).addBox(-35.0F, -40.0F, -37.0F, 56.0F, 4.0F, 56.0F, new CubeDeformation(0.0F)).texOffs(0, 128)
						.addBox(-31.0F, -44.0F, -33.0F, 48.0F, 4.0F, 48.0F, new CubeDeformation(0.0F)).texOffs(192, 128).addBox(-27.0F, -48.0F, -29.0F, 40.0F, 4.0F, 40.0F, new CubeDeformation(0.0F)).texOffs(224, 68)
						.addBox(-23.0F, -52.0F, -25.0F, 32.0F, 4.0F, 32.0F, new CubeDeformation(0.0F)).texOffs(102, 260).addBox(-19.0F, -56.0F, -21.0F, 24.0F, 4.0F, 24.0F, new CubeDeformation(0.0F)).texOffs(262, 276)
						.addBox(-15.0F, -66.0F, -17.0F, 16.0F, 10.0F, 16.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition Walls = partdefinition.addOrReplaceChild("Walls", CubeListBuilder.create().texOffs(0, 180).addBox(8.0F, -32.0F, -24.0F, 16.0F, 32.0F, 48.0F, new CubeDeformation(0.0F)).texOffs(128, 180)
				.addBox(-24.0F, -32.0F, -24.0F, 16.0F, 32.0F, 48.0F, new CubeDeformation(0.0F)).texOffs(198, 276).addBox(-8.0F, -32.0F, 8.0F, 16.0F, 32.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition Floor = partdefinition.addOrReplaceChild("Floor", CubeListBuilder.create().texOffs(224, 104).addBox(-8.0F, -2.0F, -13.0F, 16.0F, 1.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition cube_r7 = Floor.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(102, 288).addBox(-8.0F, -1.0F, -17.0F, 16.0F, 1.0F, 18.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -1.0F, -14.0F, 0.1309F, 0.0F, 0.0F));
		PartDefinition RightFloorSpikes = partdefinition.addOrReplaceChild("RightFloorSpikes", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition Spike1 = RightFloorSpikes.addOrReplaceChild("Spike1",
				CubeListBuilder.create().texOffs(182, 288).addBox(-1.0F, -32.0F, -46.0F, 3.0F, 20.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(218, 269).addBox(-1.0F, -35.0F, -46.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(224, 126)
						.addBox(0.0F, -37.0F, -45.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(256, 61).addBox(-2.0F, -33.0F, -47.0F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(240, 172)
						.addBox(-1.5F, -34.0F, -46.5F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(240, 177).addBox(-0.5F, -36.0F, -45.5F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(17.0F, -6.0F, 9.0F, 0.3135F, 0.6855F, -0.1171F));
		PartDefinition Spike2 = RightFloorSpikes.addOrReplaceChild("Spike2",
				CubeListBuilder.create().texOffs(80, 310).addBox(-1.0F, -32.0F, -46.0F, 3.0F, 20.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(230, 272).addBox(-1.0F, -35.0F, -46.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(228, 126)
						.addBox(0.0F, -37.0F, -45.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(230, 260).addBox(-2.0F, -33.0F, -47.0F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(276, 61)
						.addBox(-1.5F, -34.0F, -46.5F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(248, 177).addBox(-0.5F, -36.0F, -45.5F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(5.0F, -10.0F, 11.0F, 0.4707F, 0.3838F, -0.0526F));
		PartDefinition LeftFloorSpikes = partdefinition.addOrReplaceChild("LeftFloorSpikes", CubeListBuilder.create(), PartPose.offset(22.0F, 24.0F, 0.0F));
		PartDefinition Spike3 = LeftFloorSpikes.addOrReplaceChild("Spike3",
				CubeListBuilder.create().texOffs(182, 311).addBox(-1.0F, -32.0F, -46.0F, 3.0F, 20.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(242, 272).addBox(-1.0F, -35.0F, -46.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(232, 126)
						.addBox(0.0F, -37.0F, -45.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(230, 266).addBox(-2.0F, -33.0F, -47.0F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(288, 52)
						.addBox(-1.5F, -34.0F, -46.5F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(218, 273).addBox(-0.5F, -36.0F, -45.5F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-41.0F, -6.0F, 9.0F, 0.2967F, -0.6855F, 0.1222F));
		PartDefinition Spike4 = LeftFloorSpikes.addOrReplaceChild("Spike4",
				CubeListBuilder.create().texOffs(312, 302).addBox(-1.0F, -32.0F, -46.0F, 3.0F, 20.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(170, 288).addBox(-1.0F, -35.0F, -46.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(236, 126)
						.addBox(0.0F, -37.0F, -45.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(198, 269).addBox(-2.0F, -33.0F, -47.0F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(292, 57)
						.addBox(-1.5F, -34.0F, -46.5F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(170, 292).addBox(-0.5F, -36.0F, -45.5F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-28.0F, -10.0F, 12.0F, 0.4707F, -0.384F, 0.0524F));
		return LayerDefinition.create(meshdefinition, 512, 512);
	}

	@Override
	public void setupAnim(GoblinHutEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		Roof.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		Walls.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		Floor.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		RightFloorSpikes.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		LeftFloorSpikes.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}
}
