package com.multi7200.tam.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

import com.multi7200.tam.ClientProxy;
import com.multi7200.tam.weapons.TABxt1Rifle;
import com.multi7200.tam.weapons.TALightSpinfusor;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TribesAscendGameOverlay extends Gui {
	
	  private Minecraft mc;
	  public static int spinAmmo = 28;
	  
	  // Blank : 16777215
	
	  public TribesAscendGameOverlay(Minecraft mc)
	  {
	    super();
	    this.mc = mc;
	  }
	  
	  @SubscribeEvent(priority = EventPriority.NORMAL)
	  public void onRendeOverlay(RenderGameOverlayEvent event) {
		  EntityPlayer player = mc.thePlayer;
		  
		  InventoryPlayer inventory = player.inventory;
		  ItemStack itemstack = inventory.getCurrentItem();
		  
			if(itemstack != null) {
				if(itemstack.getItem() instanceof TABxt1Rifle && itemstack.getItem() != null) {
					this.drawString(mc.fontRenderer, "LOLILOL", mc.displayHeight / 2 - 200, 24, 16777215);
				}
			}  
	  } 
}
