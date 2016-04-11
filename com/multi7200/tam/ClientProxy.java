package com.multi7200.tam;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.multi7200.tam.entity.EntityBullet;
import com.multi7200.tam.entity.EntityDisk;
import com.multi7200.tam.entity.EntityNitron;
import com.multi7200.tam.gui.TribesAscendGameOverlay;
import com.multi7200.tam.model.ModelDisk;
import com.multi7200.tam.render.RenderBullet;
import com.multi7200.tam.render.RenderDisk;
import com.multi7200.tam.render.RenderNitron;
import com.multi7200.tam.render.RenderOverlay;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;

public class ClientProxy extends CommonProxy
{
	public static KeyBinding keyBindZoom, keyJetPack;
	
	@Override
	public void registerRender()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityDisk.class, new RenderDisk(new ModelDisk()));
		RenderingRegistry.registerEntityRenderingHandler(EntityNitron.class, new RenderNitron());
		RenderingRegistry.registerEntityRenderingHandler(EntityBullet.class, new RenderBullet());
		
		MinecraftForge.EVENT_BUS.register(new RenderOverlay(FMLClientHandler.instance().getClient()));
		MinecraftForge.EVENT_BUS.register(new TribesAscendGameOverlay(FMLClientHandler.instance().getClient()));
		
		FMLCommonHandler.instance().bus().register(this);
		
		keyBindZoom = new KeyBinding("tamod.keyzoom", Keyboard.KEY_A, "key.categories.gameplay");
		keyJetPack = new KeyBinding("tamod.jetpack", Keyboard.KEY_F, "key.categories.gameplay");
		
		ClientRegistry.registerKeyBinding(keyBindZoom);
		ClientRegistry.registerKeyBinding(keyJetPack);
	}
	
	@SubscribeEvent
	public void onTickClient(TickEvent.ClientTickEvent event) {
		EntityPlayer player = FMLClientHandler.instance().getClient().thePlayer;
		Minecraft mc = FMLClientHandler.instance().getClient();
				
		if(mc.currentScreen == null) {
			if(Keyboard.isKeyDown(this.keyJetPack.getKeyCode())) {
				player.motionY = Math.min(player.motionY + 0.559999999999999998D + 0.559999999999999998D, 0.49999999999999999D);
			}
	}
}	

	
	 public static void renderTextureOverlay(ResourceLocation s, float f) {
	    	Minecraft minecraft = FMLClientHandler.instance().getClient();
	        ScaledResolution scaledresolution = new ScaledResolution(minecraft.gameSettings, minecraft.displayWidth, minecraft.displayHeight);
	        int i = scaledresolution.getScaledWidth();
	        int j = scaledresolution.getScaledHeight();
	        GL11.glEnable(GL11.GL_BLEND);
	        GL11.glDisable(GL11.GL_DEPTH_TEST);
	        GL11.glDepthMask(false);
	        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
	        GL11.glColor4f(1.0F, 1.0F, 1.0F, f);
	        GL11.glDisable(GL11.GL_ALPHA_TEST);
	        minecraft.getTextureManager().bindTexture(s);
	        Tessellator tessellator = Tessellator.instance;
	        tessellator.startDrawingQuads();
	        tessellator.addVertexWithUV(0.0D, j, -90D, 0.0D, 1.0D);
	        tessellator.addVertexWithUV(i, j, -90D, 1.0D, 1.0D);
	        tessellator.addVertexWithUV(i, 0.0D, -90D, 1.0D, 0.0D);
	        tessellator.addVertexWithUV(0.0D, 0.0D, -90D, 0.0D, 0.0D);
	        tessellator.draw();
	        GL11.glDepthMask(true);
	        GL11.glEnable(GL11.GL_DEPTH_TEST);
	        GL11.glEnable(GL11.GL_ALPHA_TEST);
	        GL11.glColor4f(1.0F, 1.0F, 1.0F, f);
	 }
	 
	 public static void zoom(float value){
	    	ObfuscationReflectionHelper.setPrivateValue(EntityRenderer.class, FMLClientHandler.instance().getClient().entityRenderer, value, "cameraZoom", "field_78503_V");
	 }
}

