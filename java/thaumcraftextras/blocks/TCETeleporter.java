package thaumcraftextras.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import thaumcraftextras.blocks.tileEntity.TileEntityTeleporter;
import thaumcraftextras.helpers.IconHelper;
import thaumcraftextras.main.Main;
import thaumcraftextras.register.CreativeTabRegister;

public class TCETeleporter extends BlockContainer{
    
	public TCETeleporter(int id) {
		super(id, Material.iron);
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
            TileEntity tile = world.getBlockTileEntity(x, y, z);
            if(tile != null) 
            {
                    player.openGui(Main.instance, 0, world, x, y, z);
            }
    	}
    	return true;
    }
    

	@Override
	public TileEntity createNewTileEntity(World world) 
	{
        return new TileEntityTeleporter();
	}
    
	}