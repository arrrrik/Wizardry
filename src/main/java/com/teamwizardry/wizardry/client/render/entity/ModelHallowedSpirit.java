package com.teamwizardry.wizardry.client.render.entity;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

/**
 * Created by Saad on 8/21/2016.
 */
@SideOnly(Side.CLIENT)
public class ModelHallowedSpirit extends ModelBiped {

	//public ModelRenderer arm_right;
	//public ModelRenderer chest;
	//public ModelRenderer arm_left;

	public ModelHallowedSpirit() {
		this.textureWidth = 64;
		this.textureHeight = 64;
		bipedHead.showModel = false;
		bipedHeadwear.showModel = false;
		bipedLeftLeg.showModel = false;
		bipedRightLeg.showModel = false;
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		GlStateManager.disableBlend();
		GlStateManager.enableBlend();
		GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 0.3F);
		GlStateManager.rotate(entityIn.rotationYaw, 0, 1, 0);

		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);

		GlStateManager.disableBlend();
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
