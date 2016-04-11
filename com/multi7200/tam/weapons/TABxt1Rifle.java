package com.multi7200.tam.weapons;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.multi7200.tam.entity.EntityBullet;
import com.multi7200.tam.sounds.SoundHandler;

public class TABxt1Rifle extends TABasicWeapon {
	
	private int fireRateCounter;
	private int firerate;
	
	public static boolean isZoom;
	public static int timeZoom;
	
	public TABxt1Rifle(String weaponname, int firerate, String finalname) {
		super(weaponname, finalname);
		
		this.firerate = firerate;
	}
	
	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) {
		++fireRateCounter;
	}
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
		if(fireRateCounter >= firerate) {  // Can continue
				if(!world.isRemote) {
					world.spawnEntityInWorld(new EntityBullet(world, entityplayer));
					
					com.multi7200.tam.sounds.SoundHandler.onEntityPlay("bxtfire", world, entityplayer, 0.5F, 1.0F);
					
					fireRateCounter = 0;
				}		
		}
		return itemstack;
	}
}
