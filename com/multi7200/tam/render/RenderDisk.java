package com.multi7200.tam.render;

import org.lwjgl.opengl.GL11;

import org.lwjgl.opengl.GL12;

import com.multi7200.tam.entity.EntityDisk;
import com.multi7200.tam.model.ModelDisk;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderDisk extends Render {

	private static final ResourceLocation diskTextures = new ResourceLocation("tam", "textures/entity/disk.png");
	private ModelDisk model;
	
	public RenderDisk(ModelDisk var1) {
		this.model = var1;
	}
	public void doRenderDisk(EntityDisk var1, double var2, double var4, double var6, float var8, float var9) {
		GL11.glPushMatrix();
        GL11.glTranslatef((float)var2, (float)var4, (float)var6);
		this.bindTexture(diskTextures);
		
		model.render(var1, (float)var2, (float)var4, (float)(var6), var8, var9, 0.0825F);
		
		GL11.glPopMatrix();
	}

	protected ResourceLocation getEntityTexture(EntityDisk var1) {
		return this.diskTextures;
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		return this.getEntityTexture((EntityDisk) var1);
	}

	@Override
	public void doRender(Entity var1, double var2, double var4, double var6, float var8, float var9) {
		this.doRenderDisk((EntityDisk) var1,var2, var4, var6, var8, var9);
	}
}
