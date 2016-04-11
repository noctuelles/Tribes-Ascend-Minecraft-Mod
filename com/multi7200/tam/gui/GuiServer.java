package com.multi7200.tam.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class GuiServer extends GuiScreen {
	private Minecraft mc;
	private GuiScreen previous_screen;
	
	private int serverPing;
	private int serverPopulation;
	private String serverMODT;
	
	public GuiServer(Minecraft minecraft, GuiScreen previous_screen) {
		this.mc = minecraft;
		this.previous_screen = previous_screen;
	}
	
    public boolean doesGuiPauseGame()
    {
        return false;
    }
    
    public void initGui() {
    	
    }
    
    protected void actionPerformed(GuiButton button) {
    	
    }
    
    public void drawScreen(int par1, int par2, float par3) {
    	this.drawDefaultBackground();
    	super.drawScreen(par1, par2, par3);
    }
    
    public void updateScreen()
    {
        super.updateScreen();
    }

}
