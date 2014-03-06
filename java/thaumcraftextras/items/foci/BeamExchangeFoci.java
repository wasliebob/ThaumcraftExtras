package thaumcraftextras.items.foci;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.common.Thaumcraft;
import thaumcraft.common.config.ConfigBlocks;
import thaumcraft.common.items.wands.ItemWandCasting;
import thaumcraft.common.lib.Utils;
import thaumcraftextras.register.ParticleRegister;

public class BeamExchangeFoci extends ItemFoci {	 
	
    	private static final AspectList visUsage = new AspectList().add(Aspect.ORDER, 20);

        public BeamExchangeFoci(int i) {
                super(i);
        }
        
        @Override
        public boolean isUseItem() {
                return true;
        }
        
		@Override
        public void onUsingFocusTick(ItemStack itemstack, EntityPlayer player, int time) {  
        	ItemWandCasting wand = (ItemWandCasting)itemstack.getItem();
            MovingObjectPosition pos = Utils.getTargetBlock(player.worldObj, player, false);
            if(pos != null)
            {
            	if(player.canPlayerEdit(pos.blockX, pos.blockY, pos.blockZ, pos.sideHit, itemstack))
            	{
                	if (wand.consumeAllVis(itemstack, player, getVisCost(), true)) 
                	{
                		int blockId = player.worldObj.getBlockId(pos.blockX, pos.blockY, pos.blockZ);
                		if(blockId != 0 && player.worldObj.getBlockId(pos.blockX, pos.blockY, pos.blockZ) != Block.bedrock.blockID)
                		{
                			if(!player.worldObj.isRemote)
                			{
                				if(blockId == Block.stoneBrick.blockID)
                        		{
                        		cap = 3;
                        		setBlock(pos, player.worldObj, player, itemstack);
                        		}
                        		else if(blockId == Block.wood.blockID)
                        		{
                        			cap = 3;
                            		setBlock(pos, player.worldObj, player, itemstack);
                        		}
                        		else if(blockId == Block.planks.blockID)
                        		{
                        			cap = 3;
                        			setBlock(pos, player.worldObj, player, itemstack);
                        		}
                        		else if(blockId == Block.sandStone.blockID)
                        		{
                        			cap = 3;
                            		setBlock(pos, player.worldObj, player, itemstack);
                        		}
                        		else if(blockId == Block.stainedClay.blockID)
                        		{
                        			cap = 16;
                            		setBlock(pos, player.worldObj, player, itemstack);
                        		}
                        		else if(blockId == Block.cloth.blockID)
                        		{
                        			cap = 16;
                            		setBlock(pos, player.worldObj, player, itemstack);
                        		}
                        		else if(blockId == Block.carpet.blockID)
                        		{
                        			cap = 16;
                        			setBlock(pos, player.worldObj, player, itemstack);
                        		}
                        		else if(blockId == Block.sapling.blockID)
                        		{
                        			cap = 3;
                        			setBlock(pos, player.worldObj, player, itemstack);
                        		}
                        		else if(blockId == Block.leaves.blockID)
                        		{
                        			cap = 3;
                        			setBlock(pos, player.worldObj, player, itemstack);
                        		}
                        		else if(blockId == Block.blockNetherQuartz.blockID)
                        		{
                        			cap = 3;
                        			setBlock(pos, player.worldObj, player, itemstack);
                        		}
                        		else if(blockId == Block.woodSingleSlab.blockID)
                        		{
                        			cap = 3;
                        			setBlock(pos, player.worldObj, player, itemstack);	
                        		}
                        		else if(blockId == Block.woodDoubleSlab.blockID)
                        		{
                        			cap = 3;
                        			setBlock(pos, player.worldObj, player, itemstack);
                        		}
                        		else if(blockId == Block.stoneSingleSlab.blockID)
                        		{
                        			cap = 6;
                        			setBlock(pos, player.worldObj, player, itemstack);
                        		}
                        		else if(blockId == ConfigBlocks.blockCandle.blockID)
                        		{
                        			cap = 15;
                        			setBlock(pos, player.worldObj, player, itemstack);
                        		}
                        		else if(blockId == Block.plantRed.blockID)
                        		{
                        			type = 0;
                        			ChangeBlockType(pos, player.worldObj, player, itemstack);
                        		}
                        		else if(blockId == Block.plantYellow.blockID)
                        		{
                        			type = 1;
                        			ChangeBlockType(pos, player.worldObj, player, itemstack);
                        		}
                        		else if(blockId == Block.cobblestone.blockID)
                        		{
                        			type = 2;
                        			ChangeBlockType(pos, player.worldObj, player, itemstack);
                        		}
                        		else if(blockId == Block.cobblestoneMossy.blockID)
                        		{
                        			type = 3;
                            		ChangeBlockType(pos, player.worldObj, player, itemstack);
                        		}
                        		}
                			}
                			if(player.worldObj.isRemote)
                                Thaumcraft.proxy.beamCont(player.worldObj, player, pos.blockX + 0.5, pos.blockY + 0.5, pos.blockZ + 0.5, 2, 0x33CC99, true, 0F, null, 1);
                			}
                		}
            		}
            	}
        private static int cap;
        private static int type;
        
        
        public static void setBlock(MovingObjectPosition mop, World world, EntityPlayer player, ItemStack itemstack)
        {
    		int nextMeta = world.getBlockMetadata(mop.blockX, mop.blockY, mop.blockZ) + 1;
            int blockId = world.getBlockId(mop.blockX, mop.blockY, mop.blockZ);

    		world.setBlockMetadataWithNotify(mop.blockX, mop.blockY, mop.blockZ, nextMeta, 2);
			if(nextMeta -1 >= cap)
			{
				
					world.setBlockMetadataWithNotify(mop.blockX, mop.blockY, mop.blockZ, 0, 2);
			}	
			if(blockId != 0)
			{
			for (int i = 0; i < 4; ++i)
            {
				{
         		 Random rand2 = new Random();
         		 ParticleRegister.spawnParticle("enchantmenttable", world, mop.blockX, mop.blockY + rand2.nextDouble() * 0.5D, mop.blockZ, rand2.nextGaussian(), 0.5D, rand2.nextGaussian());
				}
			}
			}
        }
        
        public static void ChangeBlockType(MovingObjectPosition mop, World world, EntityPlayer player, ItemStack itemstack)
        {           
            int blockId = world.getBlockId(mop.blockX, mop.blockY, mop.blockZ);
        	if(type == 0)
        		world.setBlock(mop.blockX, mop.blockY, mop.blockZ, Block.plantYellow.blockID);
        	if(type == 1)
        		world.setBlock(mop.blockX, mop.blockY, mop.blockZ, Block.plantRed.blockID);
        	if(type == 2)
        		world.setBlock(mop.blockX, mop.blockY, mop.blockZ, Block.cobblestoneMossy.blockID);
        	if(type == 3)
        		world.setBlock(mop.blockX, mop.blockY, mop.blockZ, Block.cobblestone.blockID);
        
			
			if(blockId != 0)
			{
			for (int i = 0; i < 4; ++i)
            {
				{
         		 Random rand2 = new Random();
         		 ParticleRegister.spawnParticle("enchantmenttable", world, mop.blockX, mop.blockY + rand2.nextDouble() * 0.5D, mop.blockZ, rand2.nextGaussian(), 0.5D, rand2.nextGaussian());
				}
			}
			}
        }
        
        @Override
        public String getSortingHelper(ItemStack itemstack) {
                return "BEAMEXCHANGE";
        }

        @Override
        public int getFocusColor() {
                return 0x33CC99;
        }

        @Override
        boolean hasOrnament() {
                return false;
        }

        @Override
        public AspectList getVisCost() {
                return visUsage;
        }
        
		@Override
		public boolean acceptsEnchant(int id) {
			return false;
		}
}