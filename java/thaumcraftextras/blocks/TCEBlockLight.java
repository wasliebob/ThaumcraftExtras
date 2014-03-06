package thaumcraftextras.blocks;

import java.awt.Color;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import thaumcraftextras.blocks.tileEntity.TileEntityLight;
import thaumcraftextras.blocks.tileEntity.TileWarded;
import thaumcraftextras.helpers.ColorHelper;
import thaumcraftextras.helpers.IconHelper;
import thaumcraftextras.register.CreativeTabRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TCEBlockLight extends Block{

	public TCEBlockLight(int id) {
		super(id, Material.rock);
		setCreativeTab(CreativeTabRegister.tabMain);
		setLightValue(1.0F);
		setHardness(1.0F);
	}

    public int getRenderBlockPass()
    {
        return 0;
    }


    public boolean isOpaqueCube()
    {
        return false;
    }


    public boolean renderAsNormalBlock()
    {
        return false;
    }


	@Override
    public void registerIcons(IconRegister par1IconRegister) 
	{
        blockIcon = IconHelper.forBlock(par1IconRegister, this);
	}	

    @Override
    public void getSubBlocks(int id, CreativeTabs tabs, List list)
    {
		int meta = 0;
		int end = 15;
		while(meta >= 0 && meta <= end)
		{
            list.add(new ItemStack(id, 1, meta));     
            meta++;
            //getBlockColor();
            getRenderColor(meta);
		}
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public int getRenderColor(int par1)
    {
    	return ColorHelper.getColorCode(par1);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public int colorMultiplier(IBlockAccess acces, int x, int y, int z)
    {
    	int meta = acces.getBlockMetadata(x, y, z);
    	return ColorHelper.getColorCode(meta);
    }
    
    @Override
    public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int id)
    {
    	world.removeBlockTileEntity(x, y, z);
    }
    
    @Override
    public void onBlockDestroyedByExplosion(World world, int x, int y, int z, Explosion explosion) 
    {
    	world.removeBlockTileEntity(x, y, z);
    }
}