package com.multi7200.tam.weapons;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.multi7200.tam.entity.EntityNitron;
import com.multi7200.tam.sounds.SoundHandler;

import cpw.mods.fml.client.FMLClientHandler;

public class TAExplosiveNitron extends Item {
	private int fireRateCounter, firerate;
	
	public TAExplosiveNitron() {
		this.firerate = 22;
		
		this.setFull3D();
		
	}
	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) {
		++fireRateCounter;
	}
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
		
		if(this.fireRateCounter >= firerate) {
			if(entityplayer.capabilities.isCreativeMode) {
				if(!world.isRemote) {
					world.spawnEntityInWorld(new EntityNitron(world, entityplayer));
					
					SoundHandler.onEntityPlay("grenadethrow", world, entityplayer, 1, 1);
					
					fireRateCounter = 0;
				}
			} else if(!entityplayer.capabilities.isCreativeMode) {
				if(!world.isRemote) {
					world.spawnEntityInWorld(new EntityNitron(world, entityplayer));
					
					SoundHandler.onEntityPlay("grenadethrow", world, entityplayer, 1, 1); 
					
					itemstack.stackSize =  itemstack.stackSize - 1;
					
					fireRateCounter = 0;
				}
			}	
			
			
		}
		
		return itemstack;
	}
}
