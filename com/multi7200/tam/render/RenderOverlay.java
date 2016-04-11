package com.multi7200.tam.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

import org.lwjgl.input.Keyboard;

import com.multi7200.tam.ClientProxy;
import com.multi7200.tam.weapons.TABxt1Rifle;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderOverlay extends Gui {
	  private Minecraft mc;
	  public static boolean isDead;
	
	  // Blank : 16777215
	
	  public RenderOverlay(Minecraft mc)
	  {
	    super();
	    this.mc = mc;
	  }
	  
	  @SubscribeEvent(priority = EventPriority.NORMAL)
	  public void onRendeOverlay(RenderGameOverlayEvent event) {
			EntityPlayer player = FMLClientHandler.instance().getClient().thePlayer;
			Minecraft mc = FMLClientHandler.instance().getClient();
			
			InventoryPlayer inventory = mc.thePlayer.inventory;
			ItemStack itemstack = inventory.getCurrentItem();
			
			if(Keyboard.isKeyDown(ClientProxy.keyBindZoom.getKeyCode())) {
				if(itemstack != null) {
					if(itemstack.getItem() instanceof TABxt1Rifle && itemstack.getItem() != null) {
						if(mc.gameSettings.thirdPersonView == 0) {
							TABxt1Rifle.isZoom = true;
							
							ClientProxy.zoom(9.6F);
							
							ClientProxy.renderTextureOverlay(new ResourceLocation("tam", "textures/blur/miscScope.png"), 1.0F);
						}
					} else {ClientProxy.zoom(6.0F);}
				}
				if(itemstack == null) {ClientProxy.zoom(6.0F);} 
			} else {
				ClientProxy.zoom(1.0F);
				
				TABxt1Rifle.isZoom = false;
			}
			
	  } 
}
