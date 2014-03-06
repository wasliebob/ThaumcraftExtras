package thaumcraftextras.blocks;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import thaumcraftextras.blocks.tileEntity.TileEntityDarkInfuser;
import thaumcraftextras.helpers.IconHelper;
import thaumcraftextras.main.Main;
import thaumcraftextras.register.CreativeTabRegister;

public class Infuser extends BlockContainer{
    
	public Infuser(int id) {
		super(id, Material.iron);
		setCreativeTab(CreativeTabRegister.tabMain);
		setHardness(1.0F);
		setBlockUnbreakable();
		//setBlockBounds(minX, maxY, maxZ, maxX, maxY, maxZ)
		setBlockBounds(0.0F, 0.0F, 0.0F,
					   1.0F, 0.5F, 1.0F);
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
    
    /*
    @Override
    public int  getRenderType()
    {
    	return -1;
    }
    */
    
	@Override
    public void registerIcons(IconRegister par1IconRegister) 
	{
        blockIcon = IconHelper.forBlock(par1IconRegister, this);
	}	
	
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z,
                    EntityPlayer player, int par1, float par2, float par3, float par4) 
    {

            TileEntity tile = world.getBlockTileEntity(x, y, z);
            
            if(tile != null || player.isSneaking()) 
            {
                    player.openGui(Main.instance, 11, world, x, y, z);
            }
    	return true;
    }
    
    
    @Override
    public void breakBlock(World world, int x, int y, int z, int par5, int par6) {
            dropItems(world, x, y, z);
            world.removeBlockTileEntity(x, y, z);
            super.breakBlock(world, x, y, z, par5, par6);
    }

    private void dropItems(World world, int x, int y, int z){
            Random rand = new Random();

            TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
            if (!(tileEntity instanceof IInventory)) {
                    return;
            }
            IInventory inventory = (IInventory) tileEntity;

            for (int i = 0; i < inventory.getSizeInventory(); i++) {
                    ItemStack item = inventory.getStackInSlot(i);

                    if (item != null && item.stackSize > 0) {
                            float rx = rand.nextFloat() * 0.8F + 0.1F;
                            float ry = rand.nextFloat() * 0.8F + 0.1F;
                            float rz = rand.nextFloat() * 0.8F + 0.1F;

                            EntityItem entityItem = new EntityItem(world,
                                            x + rx, y + ry, z + rz,
                                            new ItemStack(item.itemID, item.stackSize, item.getItemDamage()));

                            if (item.hasTagCompound()) {
                                    entityItem.getEntityItem().setTagCompound((NBTTagCompound) item.getTagCompound().copy());
                            }

                            float factor = 0.05F;
                            entityItem.motionX = rand.nextGaussian() * factor;
                            entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
                            entityItem.motionZ = rand.nextGaussian() * factor;
                            world.spawnEntityInWorld(entityItem);
                            item.stackSize = 0;
                    }
            }
    }

	@Override
	public TileEntity createNewTileEntity(World world) 
	{
        return new TileEntityDarkInfuser();
	}
	}