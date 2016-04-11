package com.multi7200.tam;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class GiveHelper {

	private InventoryPlayer playerInventory;
	
	public GiveHelper(InventoryPlayer inv) {
		this.playerInventory = inv;
	}
	
	public void giveItemToPlayer(Item itemToGive) {
		this.playerInventory.addItemStackToInventory(new ItemStack(itemToGive));
	}
	
	public void giveItemToPlayer(Item itemToGive, int number) {
		this.playerInventory.addItemStackToInventory(new ItemStack(itemToGive, number));
	}
}

