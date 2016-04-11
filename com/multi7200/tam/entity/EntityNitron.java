package com.multi7200.tam.entity;

import com.multi7200.tam.sounds.SoundHandler;

import cpw.mods.fml.client.FMLClientHandler;

import net.minecraft.entity.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityNitron extends EntityThrowable {

	private EntityPlayer thePlayer;
	
    public EntityNitron(World par1World) {
        super(par1World);
    }
    
	public EntityNitron(World par1World, EntityLivingBase par2EntityLivingBase) {
		super(par1World, par2EntityLivingBase);
		
		this.thePlayer = (EntityPlayer) par2EntityLivingBase;
		
		this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, 1.19F, 1.0F);
	}
	
    public EntityNitron(World par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }

	@Override
	protected void onImpact(MovingObjectPosition var1) {
		if(var1.entityHit != null && !var1.entityHit.onGround) {
			// It's a midair !
			if(!this.worldObj.isRemote) {
				this.worldObj.createExplosion(var1.entityHit, this.posX, this.posY, this.posZ, 1.59F, false);
				
				var1.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, var1.entityHit), 6F);
				
				if(var1.entityHit.isEntityAlive() == false) {
					 SoundHandler.onEntityPlay("midair", worldObj, this.thePlayer, 1, 1);
				} 
			}
		} else if(var1.entityHit != null && var1.entityHit.onGround) {
			// Groundpound --'
			if(!this.worldObj.isRemote) {
				this.worldObj.createExplosion(var1.entityHit, this.posX, this.posY, this.posZ, 1F, false);
				
				var1.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, var1.entityHit), 5F);
			}
		} 
		
		if(!this.worldObj.isRemote) {
			this.worldObj.createExplosion(var1.entityHit, this.posX, this.posY, this.posZ, 1, false);
		}
		
		this.setDead();
	}
	
	public void onUpdate() {
		super.onUpdate();
		
		for (int i = 0; i < 5; i++) {
		    this.worldObj.spawnParticle("flame", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D); 
		}
		
		if (this.ticksExisted == 60) {
			this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 1, false);
			this.setDead();
		}
	}
}
