package thaumcraftextras.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import thaumcraftextras.blocks.tileEntity.TileEntityHidden;
import thaumcraftextras.helpers.IconHelper;
import thaumcraftextras.helpers.MainHelper;
import thaumcraftextras.lib.TCELocalization;
import thaumcraftextras.register.BlockRegister;
import thaumcraftextras.register.CreativeTabRegister;

public class BlockHidden extends BlockContainer {

	public BlockHidden(int id) {
		super(id, Material.iron);
		setCreativeTab(CreativeTabRegister.tabMain);
		setBlockUnbreakable();
		setResistance(6000000.0F);
	}
	int metaId;
	
    @Override
    public int damageDropped(int meta)
    {
    	metaId = meta;
    	return meta;
    }

	@Override
    public void registerIcons(IconRegister par1IconRegister) 
	{
        blockIcon = IconHelper.forBlock(par1IconRegister, this);
	}
	
	@Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemstack)
	{
		if(!world.isRemote)
		{
			TileEntityHidden tile = (TileEntityHidden)world.getBlockTileEntity(x, y, z);
			EntityPlayer player = ((EntityPlayer)entity);

			if (tile != null)
			{
				tile.setName(player.username);
			}
		}
	}
	
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par1, float par2, float par3, float par4) 
    {
    	if(!player.isSneaking())
    		return false;
    	
    	if(!world.isRemote && player.isSneaking()) 
    	{
    		TileEntityHidden tile = (TileEntityHidden)world.getBlockTileEntity(x, y, z);
    		int blockId = world.getBlockId(x, y, z);
    		
    		if(tile != null && tile.getName().equals(player.username))
    		{
    			dropBlockAsItem(world, x, y, z, new ItemStack(blockId, 1, world.getBlockMetadata(x, y, z)));
    			world.setBlock(x, y, z, 0);
    			world.removeBlockTileEntity(x, y, z);
    		}
    	}
    	return true;
    }
	

    public static void dropBlockAsItem(World world, int x, int y, int z, ItemStack itemstack)
    {
        float f = 0.7F;
        double d0 = (double)(world.rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
        double d1 = (double)(world.rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
        double d2 = (double)(world.rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
        EntityItem entityitem = new EntityItem(world, (double)x + d0, (double)y + d1, (double)z + d2, itemstack);
        world.spawnEntityInWorld(entityitem);
    }

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityHidden();
	}
	
    @Override
    public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB axis, List list, Entity entity)
    {
            TileEntityHidden tile = (TileEntityHidden) world.getBlockTileEntity(x, y, z);
        	if(!(entity instanceof EntityPlayer && ((EntityPlayer) entity).username.equals(tile.getName())))
                super.addCollisionBoxesToList(world, x, y, z, axis, list, entity);
    }
}