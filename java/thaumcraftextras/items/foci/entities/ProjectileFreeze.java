package thaumcraftextras.items.foci.entities;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ProjectileFreeze extends EntityThrowable
{
    public ProjectileFreeze(World par1World)
    {
        super(par1World);
    }

    public ProjectileFreeze(World par1World, EntityLivingBase par2EntityLivingBase)
    {
        super(par1World, par2EntityLivingBase);
    }

    public ProjectileFreeze(World par1World, double par2, double par4, double par6)
    {
        super(par1World, par2, par4, par6);
    }

    
    protected void onImpact(MovingObjectPosition mop)
    {
        if (mop.entityHit != null && mop.entityHit instanceof EntityLiving)
        {
            	EntityLivingBase hit = (EntityLivingBase)mop.entityHit;
            	hit.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 20*10, 100));
        }
               

   	 
        if (!this.worldObj.isRemote)
        {
            this.setDead();
        }
    }
}
