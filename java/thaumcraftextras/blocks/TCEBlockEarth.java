package thaumcraftextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import thaumcraftextras.helpers.IconHelper;
import thaumcraftextras.register.BlockRegister;
import thaumcraftextras.register.CreativeTabRegister;

public class TCEBlockEarth extends Block{

	public TCEBlockEarth(int id) {
		super(id, Material.grass);
		setCreativeTab(CreativeTabRegister.tabMain);
		setHardness(1.0F);
	}
	
	@Override
    public void registerIcons(IconRegister par1IconRegister) 
	{
        blockIcon = IconHelper.forBlock(par1IconRegister, this);
	}
	
	@Override
	  public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
	    {
	        if (!world.isRemote &&
	    		world.getBlockId(x -1, y +1, z) == 0  &&
	    		    	world.getBlockId(x +1, y +1, z) == 0 &&
	    		    	world.getBlockId(x, y +1, z -1) == 0 &&
	    		    	world.getBlockId(x, y +1, z +1) == 0 &&

	    		    	world.getBlockId(x -1, y, z) == 0 &&
	    		    	world.getBlockId(x +1, y , z) == 0 &&
	    		    	world.getBlockId(x, y , z -1) == 0 &&
	    		    	world.getBlockId(x, y, z +1) == 0 &&
	    		    	
	    		    	world.getBlockId(x -1, y +2, z) == 0 &&
	    		    	world.getBlockId(x +1, y +2, z) == 0 &&
	    		    	world.getBlockId(x, y +2, z -1) == 0 &&
	    		    	world.getBlockId(x, y +2, z +1) == 0)
	    		{
	    			
	        	world.setBlock(x -1, y +1, z, BlockRegister.cactusBlock.blockID);
	        	world.setBlock(x +1, y +1, z, BlockRegister.cactusBlock.blockID);
	        	world.setBlock(x, y +1, z -1, BlockRegister.cactusBlock.blockID);
	        	world.setBlock(x, y +1, z +1, BlockRegister.cactusBlock.blockID);

	        	world.setBlock(x -1, y, z, BlockRegister.cactusBlock.blockID);
	        	world.setBlock(x +1, y , z, BlockRegister.cactusBlock.blockID);
	        	world.setBlock(x, y , z -1, BlockRegister.cactusBlock.blockID);
	        	world.setBlock(x, y, z +1, BlockRegister.cactusBlock.blockID);
	        	
	        	world.setBlock(x -1, y +2, z, BlockRegister.cactusBlock.blockID);
	        	world.setBlock(x +1, y +2, z, BlockRegister.cactusBlock.blockID);
	        	world.setBlock(x, y +2, z -1, BlockRegister.cactusBlock.blockID);
	        	world.setBlock(x, y +2, z +1, BlockRegister.cactusBlock.blockID);
	        }
	    }
	
	@Override
    public void onEntityWalking(World world, int x, int y, int z, Entity entity) 
	{
        if (!world.isRemote &&
    		world.getBlockId(x -1, y +1, z) == 0  &&
    		    	world.getBlockId(x +1, y +1, z) == 0 &&
    		    	world.getBlockId(x, y +1, z -1) == 0 &&
    		    	world.getBlockId(x, y +1, z +1) == 0 &&

    		    	world.getBlockId(x -1, y, z) == 0 &&
    		    	world.getBlockId(x +1, y , z) == 0 &&
    		    	world.getBlockId(x, y , z -1) == 0 &&
    		    	world.getBlockId(x, y, z +1) == 0 &&
    		    	
    		    	world.getBlockId(x -1, y +2, z) == 0 &&
    		    	world.getBlockId(x +1, y +2, z) == 0 &&
    		    	world.getBlockId(x, y +2, z -1) == 0 &&
    		    	world.getBlockId(x, y +2, z +1) == 0)
    		{
	        	world.setBlock(x -1, y +1, z, BlockRegister.cactusBlock.blockID);
	        	world.setBlock(x +1, y +1, z, BlockRegister.cactusBlock.blockID);
	        	world.setBlock(x, y +1, z -1, BlockRegister.cactusBlock.blockID);
	        	world.setBlock(x, y +1, z +1, BlockRegister.cactusBlock.blockID);

	        	world.setBlock(x -1, y, z, BlockRegister.cactusBlock.blockID);
	        	world.setBlock(x +1, y , z, BlockRegister.cactusBlock.blockID);
	        	world.setBlock(x, y , z -1, BlockRegister.cactusBlock.blockID);
	        	world.setBlock(x, y, z +1, BlockRegister.cactusBlock.blockID);
	        	
	        	world.setBlock(x -1, y +2, z, BlockRegister.cactusBlock.blockID);
	        	world.setBlock(x +1, y +2, z, BlockRegister.cactusBlock.blockID);
	        	world.setBlock(x, y +2, z -1, BlockRegister.cactusBlock.blockID);
	        	world.setBlock(x, y +2, z +1, BlockRegister.cactusBlock.blockID);
	        }
	}
}