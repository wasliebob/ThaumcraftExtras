package thaumcraftextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import thaumcraft.common.config.ConfigBlocks;
import thaumcraftextras.helpers.IconHelper;
import thaumcraftextras.main.Main;
import thaumcraftextras.register.BlockRegister;
import thaumcraftextras.register.CreativeTabRegister;

public class TCEBlockAir extends Block{

	public TCEBlockAir(int id) {
		super(id, Material.rock);
		setCreativeTab(CreativeTabRegister.tabMain);
		setHardness(1.0F);
	}
    
	@Override
    public void registerIcons(IconRegister par1IconRegister) 
	{
        blockIcon = IconHelper.forBlock(par1IconRegister, this);
	}	
	
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z,
                    EntityPlayer player, int par1, float par2, float par3, float par4) 
    {
    	if(world.isRemote) 
    	{
    			player.setPosition(x, y +20, z);
    	}		
    	return true;
    }
}