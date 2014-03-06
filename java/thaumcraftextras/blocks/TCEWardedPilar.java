package thaumcraftextras.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import thaumcraftextras.blocks.tileEntity.TileWarded;
import thaumcraftextras.register.CreativeTabRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TCEWardedPilar extends Block implements ITileEntityProvider{

	
	public TCEWardedPilar (int id) {
		super(id, Material.rock);
		setCreativeTab(CreativeTabRegister.tabMain);
		setBlockUnbreakable();
		setResistance(6000000.0F);
		//setBlockBounds(minX, maxY, maxZ, maxX, maxY, maxZ)
		setBlockBounds(0.3F, 0.0F, 0.3F, 0.6F, 1.0F, 0.6F);
	}
	int metaId;
	
    @SideOnly(Side.CLIENT)
    private Icon[] icons;
  
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        icons = new Icon[16];
        
        for(int i = 0; i < icons.length; i++)
        {
            icons[i] = par1IconRegister.registerIcon((this.getUnlocalizedName().substring(5)) + i);
        }
    }
    
    @Override
    public int damageDropped(int meta)
    {
    	metaId = meta;
    	return meta;
    }
    
    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }


    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }
    /**
     * 0 = Black
     * 1 = Red
     * 2 = Green
     * 3 = Brown
     * 4 = Blue
     * 5 = Purple
     * 6 = Cyan
     * 7 = Light Gray
     * 8 = Gray
     * 9 = Pink
     * 10 = Lime
     * 11 = Yellow
     * 12 = Light Blue
     * 13 = Magenta
     * 14 = Orange
     * 15 = White
     */
    
    @SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata) {
    	switch(metadata)
    	{
    	case 0: return icons[0];
    	case 1: return icons[1];
        case 2: return icons[2];
       	case 3: return icons[3];
       	case 4: return icons[4];
       	case 5: return icons[5];
       	case 6: return icons[6];
       	case 7: return icons[7];
       	case 8: return icons[8];
       	case 9: return icons[9];
       	case 10: return icons[10];
       	case 11: return icons[11];
       	case 12: return icons[12];
       	case 13: return icons[13];
       	case 14: return icons[14];
       	case 15: return icons[15];
       	default: return icons[0];
    	}
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
		}
    }
	@Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemstack)
	{
		if(!world.isRemote)
		{
			TileWarded tile = (TileWarded)world.getBlockTileEntity(x, y, z);
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
    		TileWarded tile = (TileWarded)world.getBlockTileEntity(x, y, z);
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
		return new TileWarded();
	}
}
