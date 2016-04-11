package com.multi7200.tam.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityDisk extends TribesProjectileEntityBase {
	private EntityPlayer thePlayer;
	
    public EntityDisk(World par1World)
    {
        super(par1World);
        
    }
    public EntityDisk(World par1World, EntityLivingBase par2EntityLiving)
    {
        super(par1World, par2EntityLiving);
        this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, 2.15F, 0F);
        
        this.thePlayer = (EntityPlayer) par2EntityLiving;
    }
    public EntityDisk(World par1World, double par2, double par4, double par6)
    {
        super(par1World, par2, par4, par6);
    }
    
	@Override
	protected void onImpact(MovingObjectPosition var1) {
		super.onImpact(var1);
	}
	
	public void onUpdate() {
		super.onUpdate();
	}
}
