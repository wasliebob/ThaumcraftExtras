package thaumcraftextras.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import thaumcraftextras.helpers.IconHelper;
import thaumcraftextras.register.BlockRegister;
import thaumcraftextras.register.CreativeTabRegister;

public class TCETesla extends Block{

	public TCETesla(int id) {
		super(id, Material.iron);
		setCreativeTab(CreativeTabRegister.tabMain);
	}
	
	@Override
    public void registerIcons(IconRegister par1IconRegister) 
	{
        blockIcon = IconHelper.forBlock(par1IconRegister, this);
	}	
	
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) 
    {
    	xP = x;
    	yP = y;
    	zP = z;
		return true;
    }
    
    public static int xP;
    public static int yP;
    public static int zP;
    
    @Override
    public void updateTick(World world, int x, int y, int z, Random random) 
    {
        	world.getBlockId(xP, yP, zP);;
        	world.setBlock(xP, yP, zP, BlockRegister.researchBlock.blockID);
    }
}