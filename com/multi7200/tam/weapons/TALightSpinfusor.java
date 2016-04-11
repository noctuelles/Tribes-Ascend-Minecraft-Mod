package com.multi7200.tam.weapons;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.multi7200.tam.entity.EntityDisk;

public class TALightSpinfusor extends TABasicWeapon {
	
	private int fireRateCounter;
	private int firerate;
	
	public TALightSpinfusor(String weaponname, int firerate, String finalname) {
		super(weaponname, finalname);
		
		this.firerate = firerate;
	}
	
	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) {
		++fireRateCounter;
	}
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
		if(fireRateCounter >= firerate) {  // Can continue
				if(!world.isRemote) {
					world.spawnEntityInWorld(new EntityDisk(world, entityplayer));
					
					fireRateCounter = 0;
				}		
		}
		return itemstack;
	}
}
