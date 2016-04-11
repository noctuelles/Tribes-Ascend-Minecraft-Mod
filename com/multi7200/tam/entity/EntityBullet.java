package com.multi7200.tam.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import com.multi7200.tam.Const;
import com.multi7200.tam.sounds.SoundHandler;

import cpw.mods.fml.client.FMLClientHandler;

public class EntityBullet extends EntityThrowable{

	private EntityPlayer thePlayer;
	
    public EntityBullet(World par1World)
    {
        super(par1World);
    }
    public EntityBullet(World par1World, EntityLivingBase par2EntityLiving)
    {
        super(par1World, par2EntityLiving);
        
        this.thePlayer = (EntityPlayer) par2EntityLiving;
        
        this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, Const.SUPER_SPEED, - 0.9F);
    }
    public EntityBullet(World par1World, double par2, double par4, double par6)
    {
        super(par1World, par2, par4, par6);
    }
	@Override
	protected void onImpact(MovingObjectPosition var1) {
		if(var1.entityHit != null) {
			if(!thePlayer.worldObj.isRemote) {
				com.multi7200.tam.sounds.SoundHandler.onEntityPlay("impactplayer" , thePlayer.worldObj, thePlayer, 0.5F, 1.0F);
				
				var1.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, var1.entityHit), 13F);
			}
		}
		
		this.setDead();
	}
	
	@Override
	protected float getGravityVelocity() 
	{
		return Const.NO_GRAVITY;
	}
	
	public void onUpdate() {
		super.onUpdate();
	}
}
