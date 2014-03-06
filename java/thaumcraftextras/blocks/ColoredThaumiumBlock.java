package thaumcraftextras.blocks;

import java.awt.Color;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import thaumcraftextras.blocks.tileEntity.TileEntityColor;
import thaumcraftextras.helpers.IconHelper;
import thaumcraftextras.main.Main;
import thaumcraftextras.register.CreativeTabRegister;

public class ColoredThaumiumBlock extends BlockContainer{
    
	public ColoredThaumiumBlock(int id) {
		super(id, Material.iron);
		setCreativeTab(CreativeTabRegister.tabMain);
		setHardness(1.0F);
		
	}
	public static String colorN;
	
	@Override
    public void registerIcons(IconRegister par1IconRegister) 
	{
        blockIcon = IconHelper.forBlock(par1IconRegister, this);
	}	
	
	@Override
    public int getBlockColor()
    {
		if(colorN == "red")
			return Color.red.hashCode();
		else
			return Color.white.hashCode();
    }
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z,
                    EntityPlayer player, int par1, float par2, float par3, float par4) 
    {
    	/*
    	if(world.isRemote) 
    	{
            TileEntity tileE = world.getBlockTileEntity(x, y, z);
            if(tileE != null) 
            {
                    player.openGui(Main.instance, 1, world, x, y, z);
            }
    	}
    	*/
    	TileEntityColor tile = (TileEntityColor) world.getBlockTileEntity(x, y, z);
    	if (tile != null)
    	{
    	   tile.setColor("red");
    	   player.addChatMessage(tile.color);
    	   colorN = tile.color;
    	   if(tile.getColor(world, x, y, z) == "red")
    	   {
    		   
    	   }
    	}
    	return true;
    }

	@Override
	public TileEntity createNewTileEntity(World world) 
	{
        return new TileEntityColor();
	}
    
	}