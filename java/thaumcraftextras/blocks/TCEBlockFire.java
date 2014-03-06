package thaumcraftextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import thaumcraftextras.helpers.IconHelper;
import thaumcraftextras.lib.TCELocalization;
import thaumcraftextras.register.CreativeTabRegister;

public class TCEBlockFire extends Block{

    private Icon topIcon;
    private Icon bottomIcon;
    
	public TCEBlockFire(int id) {
		super(id, Material.grass);
		setCreativeTab(CreativeTabRegister.tabMain);
		setHardness(1.0F);
	}
	
	
	@Override
	  public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
	    {
	        if (!world.isRemote)
	        {
	           entity.setFire(2);
	        }
	    }
	
	@Override
    public void onEntityWalking(World world, int x, int y, int z, Entity entity) 
	{
		  if (!world.isRemote)
	        {
	           entity.setFire(2);
	        }
	}
	
	@Override
    public boolean isBlockBurning(World world, int x, int y, int z)
    {
        return true;
    }
	
	@Override
    public void registerIcons(IconRegister par1IconRegister)
	{
        blockIcon = IconHelper.forBlock(par1IconRegister, this);
	}
}