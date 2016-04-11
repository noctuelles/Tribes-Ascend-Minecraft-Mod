package com.multi7200.tam.weapons;

import com.multi7200.tam.TribesAscendMod;
import com.multi7200.tam.entity.EntityDisk;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class TABasicWeapon extends Item {
	
	
	public TABasicWeapon(String weaponname, String finalname) {
		this.setUnlocalizedName(weaponname + "_tam");
		LanguageRegistry.addName(this, finalname);
		this.setFull3D();
		TribesAscendMod.print("Weapon " + finalname + " has been properly registed");
	}
	
	public void setWeaponTexture(String textureName) {
		this.setTextureName("tam:" + textureName);
	}
}
