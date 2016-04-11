package com.multi7200.tam.render;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.multi7200.tam.TribesAscendMod;
import com.multi7200.tam.entity.EntityDisk;
import com.multi7200.tam.entity.EntityNitron;
import com.multi7200.tam.weapons.TAExplosiveNitron;

public class RenderNitron extends Render {

	private static final ResourceLocation nitronTextures = new ResourceLocation("tam", "textures/entity/nitron.png");
	public RenderNitron() {}

	@Override
	public void doRender(Entity var1, double var2, double var4, double var6,
			float var8, float var9) {
		this.doRenderNitron((EntityNitron)var1, var2, var4, var6, var8, var9);
	}

	public void doRenderNitron(EntityNitron var1, double var2, double var4, double var6, float var8, float var9) {
		GL11.glPushMatrix();
        GL11.glTranslatef((float)var2, (float)var4, (float)var6);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);

        float var10 = 0.6F;

        GL11.glScalef(var10 / 1.0F, var10 / 1.0F, var10 / 1.0F);

        byte var11 = 0;

        this.bindTexture(this.nitronTextures);

        Tessellator var12 = Tessellator.instance;

        float var13 = (float)(var11 % 16 * 16 + 0) / 16.0F;
        float var14 = (float)(var11 % 16 * 16 + 16) / 16.0F;
        float var15 = (float)(var11 / 16 * 16 + 0) / 16.0F;
        float var16 = (float)(var11 / 16 * 16 + 16) / 16.0F;
        float var17 = 1.0F;
        float var18 = 0.5F;
        float var19 = 0.25F;

        GL11.glRotatef(180.0F - this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);

        GL11.glRotatef(-this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);

        var12.startDrawingQuads();

        var12.setNormal(0.0F, 1.0F, 0.0F);

        var12.addVertexWithUV((double)(0.0F - var18), (double)(0.0F - var19), 0.0D, (double)var13, (double)var16);
        var12.addVertexWithUV((double)(var17 - var18), (double)(0.0F - var19), 0.0D, (double)var14, (double)var16);
        var12.addVertexWithUV((double)(var17 - var18), (double)(1.0F - var19), 0.0D, (double)var14, (double)var15);
        var12.addVertexWithUV((double)(0.0F - var18), (double)(1.0F - var19), 0.0D, (double)var13, (double)var15);

        var12.draw();

        GL11.glDisable(GL12.GL_RESCALE_NORMAL);

        GL11.glPopMatrix();

	}
	
	protected ResourceLocation getEntityTexture(EntityDisk var1) {
		return this.nitronTextures;
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		return this.getEntityTexture((EntityDisk) var1);
	}
}
