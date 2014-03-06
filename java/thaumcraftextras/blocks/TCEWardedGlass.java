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
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import thaumcraftextras.blocks.tileEntity.TileWarded;
import thaumcraftextras.helpers.ColorHelper;
import thaumcraftextras.register.CreativeTabRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TCEWardedGlass extends Block implements ITileEntityProvider{

	public TCEWardedGlass(int id) {
		super(id, Material.rock);
		setCreativeTab(CreativeTabRegister.tabMain);
		setBlockUnbreakable();
		setResistance(6000000.0F);
	}
	 private Icon[] icons = new Icon[16];
     private boolean shouldRenderSelectionBox = true;
     protected String folder;
     private int renderPass;
     int metaId;
     
     @Override
     public int damageDropped(int meta)
     {
     	metaId = meta;
     	return meta;
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
    
    
    @Override
    public Icon getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
            return this.getConnectedBlockTexture(par1IBlockAccess, par2, par3, par4, par5, this.icons);
    }
    
    public boolean shouldConnectToBlock(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5, int par6)
    {
            return par5 == this.blockID;
    }
    
    public Icon getConnectedBlockTexture(IBlockAccess blockAccess, int x, int y, int z, int side, Icon[] icons)
    {
            boolean isOpenUp = false, isOpenDown = false, isOpenLeft = false, isOpenRight = false;
            
            switch (side)
            {
                    case 0:
                            if (this.shouldConnectToBlock(blockAccess, x, y, z, blockAccess.getBlockId(x - 1, y, z), blockAccess.getBlockMetadata(x - 1, y, z)))
                            {
                                    isOpenDown = true;
                            }
                            
                            if (this.shouldConnectToBlock(blockAccess, x, y, z, blockAccess.getBlockId(x + 1, y, z), blockAccess.getBlockMetadata(x + 1, y, z)))
                            {
                                    isOpenUp = true;
                            }
                            
                            if (this.shouldConnectToBlock(blockAccess, x, y, z, blockAccess.getBlockId(x, y, z - 1), blockAccess.getBlockMetadata(x, y, z - 1)))
                            {
                                    isOpenLeft = true;
                            }
                            
                            if (this.shouldConnectToBlock(blockAccess, x, y, z, blockAccess.getBlockId(x, y, z + 1), blockAccess.getBlockMetadata(x, y, z + 1)))
                            {
                                    isOpenRight = true;
                            }
                            
                            if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight)
                            {
                                    return icons[15];
                            } else if (isOpenUp && isOpenDown && isOpenLeft)
                            {
                                    return icons[11];
                            } else if (isOpenUp && isOpenDown && isOpenRight)
                            {
                                    return icons[12];
                            } else if (isOpenUp && isOpenLeft && isOpenRight)
                            {
                                    return icons[13];
                            } else if (isOpenDown && isOpenLeft && isOpenRight)
                            {
                                    return icons[14];
                            } else if (isOpenDown && isOpenUp)
                            {
                                    return icons[5];
                            } else if (isOpenLeft && isOpenRight)
                            {
                                    return icons[6];
                            } else if (isOpenDown && isOpenLeft)
                            {
                                    return icons[8];
                            } else if (isOpenDown && isOpenRight)
                            {
                                    return icons[10];
                            } else if (isOpenUp && isOpenLeft)
                            {
                                    return icons[7];
                            } else if (isOpenUp && isOpenRight)
                            {
                                    return icons[9];
                            } else if (isOpenDown)
                            {
                                    return icons[3];
                            } else if (isOpenUp)
                            {
                                    return icons[4];
                            } else if (isOpenLeft)
                            {
                                    return icons[2];
                            } else if (isOpenRight)
                            {
                                    return icons[1];
                            }
                            break;
                    case 1:
                            if (this.shouldConnectToBlock(blockAccess, x, y, z, blockAccess.getBlockId(x - 1, y, z), blockAccess.getBlockMetadata(x - 1, y, z)))
                            {
                                    isOpenDown = true;
                            }
                            
                            if (this.shouldConnectToBlock(blockAccess, x, y, z, blockAccess.getBlockId(x + 1, y, z), blockAccess.getBlockMetadata(x + 1, y, z)))
                            {
                                    isOpenUp = true;
                            }
                            
                            if (this.shouldConnectToBlock(blockAccess, x, y, z, blockAccess.getBlockId(x, y, z - 1), blockAccess.getBlockMetadata(x, y, z - 1)))
                            {
                                    isOpenLeft = true;
                            }
                            
                            if (this.shouldConnectToBlock(blockAccess, x, y, z, blockAccess.getBlockId(x, y, z + 1), blockAccess.getBlockMetadata(x, y, z + 1)))
                            {
                                    isOpenRight = true;
                            }
                            
                            if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight)
                            {
                                    return icons[15];
                            } else if (isOpenUp && isOpenDown && isOpenLeft)
                            {
                                    return icons[11];
                            } else if (isOpenUp && isOpenDown && isOpenRight)
                            {
                                    return icons[12];
                            } else if (isOpenUp && isOpenLeft && isOpenRight)
                            {
                                    return icons[13];
                            } else if (isOpenDown && isOpenLeft && isOpenRight)
                            {
                                    return icons[14];
                            } else if (isOpenDown && isOpenUp)
                            {
                                    return icons[5];
                            } else if (isOpenLeft && isOpenRight)
                            {
                                    return icons[6];
                            } else if (isOpenDown && isOpenLeft)
                            {
                                    return icons[8];
                            } else if (isOpenDown && isOpenRight)
                            {
                                    return icons[10];
                            } else if (isOpenUp && isOpenLeft)
                            {
                                    return icons[7];
                            } else if (isOpenUp && isOpenRight)
                            {
                                    return icons[9];
                            } else if (isOpenDown)
                            {
                                    return icons[3];
                            } else if (isOpenUp)
                            {
                                    return icons[4];
                            } else if (isOpenLeft)
                            {
                                    return icons[2];
                            } else if (isOpenRight)
                            {
                                    return icons[1];
                            }
                            break;
                    case 2:
                            if (this.shouldConnectToBlock(blockAccess, x, y, z, blockAccess.getBlockId(x, y - 1, z), blockAccess.getBlockMetadata(x, y - 1, z)))
                            {
                                    isOpenDown = true;
                            }
                            
                            if (this.shouldConnectToBlock(blockAccess, x, y, z, blockAccess.getBlockId(x, y + 1, z), blockAccess.getBlockMetadata(x, y + 1, z)))
                            {
                                    isOpenUp = true;
                            }
                            
                            if (this.shouldConnectToBlock(blockAccess, x, y, z, blockAccess.getBlockId(x - 1, y, z), blockAccess.getBlockMetadata(x - 1, y, z)))
                            {
                                    isOpenLeft = true;
                            }
                            
                            if (this.shouldConnectToBlock(blockAccess, x, y, z, blockAccess.getBlockId(x + 1, y, z), blockAccess.getBlockMetadata(x + 1, y, z)))
                            {
                                    isOpenRight = true;
                            }
                            
                            if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight)
                            {
                                    return icons[15];
                            } else if (isOpenUp && isOpenDown && isOpenLeft)
                            {
                                    return icons[13];
                            } else if (isOpenUp && isOpenDown && isOpenRight)
                            {
                                    return icons[14];
                            } else if (isOpenUp && isOpenLeft && isOpenRight)
                            {
                                    return icons[11];
                            } else if (isOpenDown && isOpenLeft && isOpenRight)
                            {
                                    return icons[12];
                            } else if (isOpenDown && isOpenUp)
                            {
                                    return icons[6];
                            } else if (isOpenLeft && isOpenRight)
                            {
                                    return icons[5];
                            } else if (isOpenDown && isOpenLeft)
                            {
                                    return icons[9];
                            } else if (isOpenDown && isOpenRight)
                            {
                                    return icons[10];
                            } else if (isOpenUp && isOpenLeft)
                            {
                                    return icons[7];
                            } else if (isOpenUp && isOpenRight)
                            {
                                    return icons[8];
                            } else if (isOpenDown)
                            {
                                    return icons[1];
                            } else if (isOpenUp)
                            {
                                    return icons[2];
                            } else if (isOpenLeft)
                            {
                                    return icons[4];
                            } else if (isOpenRight)
                            {
                                    return icons[3];
                            }
                            break;
                    case 3:
                            if (this.shouldConnectToBlock(blockAccess, x, y, z, blockAccess.getBlockId(x, y - 1, z), blockAccess.getBlockMetadata(x, y - 1, z)))
                            {
                                    isOpenDown = true;
                            }
                            
                            if (this.shouldConnectToBlock(blockAccess, x, y, z, blockAccess.getBlockId(x, y + 1, z), blockAccess.getBlockMetadata(x, y + 1, z)))
                            {
                                    isOpenUp = true;
                            }
                            
                            if (this.shouldConnectToBlock(blockAccess, x, y, z, blockAccess.getBlockId(x - 1, y, z), blockAccess.getBlockMetadata(x - 1, y, z)))
                            {
                                    isOpenLeft = true;
                            }
                            
                            if (this.shouldConnectToBlock(blockAccess, x, y, z, blockAccess.getBlockId(x + 1, y, z), blockAccess.getBlockMetadata(x + 1, y, z)))
                            {
                                    isOpenRight = true;
                            }
                            
                            if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight)
                            {
                                    return icons[15];
                            } else if (isOpenUp && isOpenDown && isOpenLeft)
                            {
                                    return icons[14];
                            } else if (isOpenUp && isOpenDown && isOpenRight)
                            {
                                    return icons[13];
                            } else if (isOpenUp && isOpenLeft && isOpenRight)
                            {
                                    return icons[11];
                            } else if (isOpenDown && isOpenLeft && isOpenRight)
                            {
                                    return icons[12];
                            } else if (isOpenDown && isOpenUp)
                            {
                                    return icons[6];
                            } else if (isOpenLeft && isOpenRight)
                            {
                                    return icons[5];
                            } else if (isOpenDown && isOpenLeft)
                            {
                                    return icons[10];
                            } else if (isOpenDown && isOpenRight)
                            {
                                    return icons[9];
                            } else if (isOpenUp && isOpenLeft)
                            {
                                    return icons[8];
                            } else if (isOpenUp && isOpenRight)
                            {
                                    return icons[7];
                            } else if (isOpenDown)
                            {
                                    return icons[1];
                            } else if (isOpenUp)
                            {
                                    return icons[2];
                            } else if (isOpenLeft)
                            {
                                    return icons[3];
                            } else if (isOpenRight)
                            {
                                    return icons[4];
                            }
                            break;
                    case 4:
                            if (this.shouldConnectToBlock(blockAccess, x, y, z, blockAccess.getBlockId(x, y - 1, z), blockAccess.getBlockMetadata(x, y - 1, z)))
                            {
                                    isOpenDown = true;
                            }
                            
                            if (this.shouldConnectToBlock(blockAccess, x, y, z, blockAccess.getBlockId(x, y + 1, z), blockAccess.getBlockMetadata(x, y + 1, z)))
                            {
                                    isOpenUp = true;
                            }
                            
                            if (this.shouldConnectToBlock(blockAccess, x, y, z, blockAccess.getBlockId(x, y, z - 1), blockAccess.getBlockMetadata(x, y, z - 1)))
                            {
                                    isOpenLeft = true;
                            }
                            
                            if (this.shouldConnectToBlock(blockAccess, x, y, z, blockAccess.getBlockId(x, y, z + 1), blockAccess.getBlockMetadata(x, y, z + 1)))
                            {
                                    isOpenRight = true;
                            }
                            
                            if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight)
                            {
                                    return icons[15];
                            } else if (isOpenUp && isOpenDown && isOpenLeft)
                            {
                                    return icons[14];
                            } else if (isOpenUp && isOpenDown && isOpenRight)
                            {
                                    return icons[13];
                            } else if (isOpenUp && isOpenLeft && isOpenRight)
                            {
                                    return icons[11];
                            } else if (isOpenDown && isOpenLeft && isOpenRight)
                            {
                                    return icons[12];
                            } else if (isOpenDown && isOpenUp)
                            {
                                    return icons[6];
                            } else if (isOpenLeft && isOpenRight)
                            {
                                    return icons[5];
                            } else if (isOpenDown && isOpenLeft)
                            {
                                    return icons[10];
                            } else if (isOpenDown && isOpenRight)
                            {
                                    return icons[9];
                            } else if (isOpenUp && isOpenLeft)
                            {
                                    return icons[8];
                            } else if (isOpenUp && isOpenRight)
                            {
                                    return icons[7];
                            } else if (isOpenDown)
                            {
                                    return icons[1];
                            } else if (isOpenUp)
                            {
                                    return icons[2];
                            } else if (isOpenLeft)
                            {
                                    return icons[3];
                            } else if (isOpenRight)
                            {
                                    return icons[4];
                            }
                            break;
                    case 5:
                            if (this.shouldConnectToBlock(blockAccess, x, y, z, blockAccess.getBlockId(x, y - 1, z), blockAccess.getBlockMetadata(x, y - 1, z)))
                            {
                                    isOpenDown = true;
                            }
                            
                            if (this.shouldConnectToBlock(blockAccess, x, y, z, blockAccess.getBlockId(x, y + 1, z), blockAccess.getBlockMetadata(x, y + 1, z)))
                            {
                                    isOpenUp = true;
                            }
                            
                            if (this.shouldConnectToBlock(blockAccess, x, y, z, blockAccess.getBlockId(x, y, z - 1), blockAccess.getBlockMetadata(x, y, z - 1)))
                            {
                                    isOpenLeft = true;
                            }
                            
                            if (this.shouldConnectToBlock(blockAccess, x, y, z, blockAccess.getBlockId(x, y, z + 1), blockAccess.getBlockMetadata(x, y, z + 1)))
                            {
                                    isOpenRight = true;
                            }
                            
                            if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight)
                            {
                                    return icons[15];
                            } else if (isOpenUp && isOpenDown && isOpenLeft)
                            {
                                    return icons[13];
                            } else if (isOpenUp && isOpenDown && isOpenRight)
                            {
                                    return icons[14];
                            } else if (isOpenUp && isOpenLeft && isOpenRight)
                            {
                                    return icons[11];
                            } else if (isOpenDown && isOpenLeft && isOpenRight)
                            {
                                    return icons[12];
                            } else if (isOpenDown && isOpenUp)
                            {
                                    return icons[6];
                            } else if (isOpenLeft && isOpenRight)
                            {
                                    return icons[5];
                            } else if (isOpenDown && isOpenLeft)
                            {
                                    return icons[9];
                            } else if (isOpenDown && isOpenRight)
                            {
                                    return icons[10];
                            } else if (isOpenUp && isOpenLeft)
                            {
                                    return icons[7];
                            } else if (isOpenUp && isOpenRight)
                            {
                                    return icons[8];
                            } else if (isOpenDown)
                            {
                                    return icons[1];
                            } else if (isOpenUp)
                            {
                                    return icons[2];
                            } else if (isOpenLeft)
                            {
                                    return icons[4];
                            } else if (isOpenRight)
                            {
                                    return icons[3];
                            }
                            break;
            }
            
            return icons[0];
    }

    
    @Override
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
            int i1 = par1IBlockAccess.getBlockId(par2, par3, par4);
            return i1 == this.blockID ? false : super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, par5);
    }
    
    @Override
    public Icon getIcon(int par1, int par2)
    {
            return this.icons[0];
    }
    
    @Override
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
            if (this.shouldRenderSelectionBox)
            {
                    return super.getSelectedBoundingBoxFromPool(par1World, par2, par3, par4);
            } else
            {
                    return AxisAlignedBB.getAABBPool().getAABB(0D, 0D, 0D, 0D, 0D, 0D);
            }
    }
    

    @Override
    public void registerIcons(IconRegister par1IconRegister)
    {
            String path = "thaumcraftextras:glass";
            icons[0] = par1IconRegister.registerIcon(path);
            icons[1] = par1IconRegister.registerIcon(path + "_1_d");
            icons[2] = par1IconRegister.registerIcon(path + "_1_u");
            icons[3] = par1IconRegister.registerIcon(path + "_1_l");
            icons[4] = par1IconRegister.registerIcon(path + "_1_r");
            icons[5] = par1IconRegister.registerIcon(path + "_2_h");
            icons[6] = par1IconRegister.registerIcon(path + "_2_v");
            icons[7] = par1IconRegister.registerIcon(path + "_2_dl");
            icons[8] = par1IconRegister.registerIcon(path + "_2_dr");
            icons[9] = par1IconRegister.registerIcon(path + "_2_ul");
            icons[10] = par1IconRegister.registerIcon(path + "_2_ur");
            icons[11] = par1IconRegister.registerIcon(path + "_3_d");
            icons[12] = par1IconRegister.registerIcon(path + "_3_u");
            icons[13] = par1IconRegister.registerIcon(path + "_3_l");
            icons[14] = par1IconRegister.registerIcon(path + "_3_r");
            icons[15] = par1IconRegister.registerIcon(path + "_4");
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
	public TileEntity createNewTileEntity(World world) {
		return new TileWarded();
	}
}