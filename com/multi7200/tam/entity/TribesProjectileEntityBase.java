package com.multi7200.tam.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import com.multi7200.tam.sounds.SoundHandler;

import cpw.mods.fml.client.FMLClientHandler;

public class TribesProjectileEntityBase extends EntityThrowable {
	public float gravityvelocity = 0;
	private boolean isDisk = true;
	private EntityPlayer thePlayer;
	
    public TribesProjectileEntityBase(World par1World)
    {
        super(par1World);
    }
    public TribesProjectileEntityBase(World par1World, EntityLivingBase par2EntityLiving)
    {
        super(par1World, par2EntityLiving);
        
        this.thePlayer = (EntityPlayer) par2EntityLiving;
    }
    public TribesProjectileEntityBase(World par1World, double par2, double par4, double par6)
    {
        super(par1World, par2, par4, par6);
    }
    
	@Override
	protected void onImpact(MovingObjectPosition var1) {
		if(var1.entityHit != null && !var1.entityHit.onGround) {
			// It's a midair !
			if(!this.worldObj.isRemote) {
				this.worldObj.createExplosion(var1.entityHit, this.posX, this.posY, this.posZ, 2, false);
				
				var1.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, var1.entityHit), 13F);
				
				if(var1.entityHit.isEntityAlive() == false) {
					SoundHandler.onEntityPlay("midair", worldObj, thePlayer, 2, 1);
				} 
			}
		} else if(var1.entityHit != null && var1.entityHit.onGround) {
			// Groundpound --'
			if(!this.worldObj.isRemote) {
				this.worldObj.createExplosion(var1.entityHit, this.posX, this.posY, this.posZ, 1, false);
				
				var1.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, var1.entityHit), 8F);
			}
		} else if(var1.entityHit == null) {
			
		}
		
		if(!this.worldObj.isRemote) {
			this.worldObj.createExplosion(var1.entityHit, this.posX, this.posY, this.posZ, 1, false);
		}
		
		this.setDead();
	}
	
	@Override
	protected float getGravityVelocity() 
	{
		return gravityvelocity;
	}
	
	public void onUpdate() {
		super.onUpdate();
		
		for (int i = 0; i < 8; i++) {
		    this.worldObj.spawnParticle("smoke", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D); 
		}
		
		if (this.ticksExisted == 200) {
			System.out.println("Disk removed");
			this.setDead();
		}
	}
}
