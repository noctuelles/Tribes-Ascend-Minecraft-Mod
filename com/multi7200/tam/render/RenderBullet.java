package com.multi7200.tam.render;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.multi7200.tam.entity.EntityBullet;
import com.multi7200.tam.entity.EntityDisk;
import com.multi7200.tam.model.ModelSniperBullet;

public class RenderBullet extends Render {

	private static final ResourceLocation bulletTextures = new ResourceLocation("tam", "lolilol");
	
	public RenderBullet() {
		
	}
	public void doRenderBullet(EntityBullet var1, double var2, double var4, double var6, float var8, float var9) {
		IM_INVISIBLE_BITCH();
	}

	protected ResourceLocation getEntityTexture(EntityBullet var1) {
		return this.bulletTextures;
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		return this.getEntityTexture((EntityBullet) var1);
	}

	@Override
	public void doRender(Entity var1, double var2, double var4, double var6, float var8, float var9) {
		this.doRenderBullet((EntityBullet) var1,var2, var4, var6, var8, var9);
	}
	
	private void IM_INVISIBLE_BITCH(){}
}