package thaumcraftextras.items.foci;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.common.config.ConfigBlocks;
import thaumcraft.common.items.wands.ItemWandCasting;
import thaumcraftextras.api.functions.ExchangeFociFunctions;
import thaumcraftextras.register.ParticleRegister;

public class ExchangeFoci extends ItemFoci {

        private static final AspectList visUsage = new AspectList().add(Aspect.ORDER, 20);

        public ExchangeFoci(int i) {
                super(i);
        }
        
        @Override
        public ItemStack onFocusRightClick(ItemStack itemstack, World world, EntityPlayer player, MovingObjectPosition mop) {
    		if(mop == null)
				return itemstack;
        	ItemWandCasting wand = (ItemWandCasting)itemstack.getItem();
            int blockId = world.getBlockId(mop.blockX, mop.blockY, mop.blockZ);
    		
            	if(player.canPlayerEdit(mop.blockX, mop.blockY, mop.blockZ, mop.sideHit, itemstack)){
                	if (wand.consumeAllVis(itemstack, player, getVisCost(), true)) {
            		if(!world.isRemote)
            		{
                	/*
            		if(blockId == Block.stoneBrick.blockID)
            		{
            		cap = 3;
            		setBlock(mop, world, player, itemstack);
            		}
            		else if(blockId == Block.wood.blockID)
            		{
            			cap = 3;
                		setBlock(mop, world, player, itemstack);
            		}
            		else if(blockId == Block.planks.blockID)
            		{
            			cap = 3;
            			setBlock(mop, world, player, itemstack);
            		}
            		else if(blockId == Block.sandStone.blockID)
            		{
            			cap = 3;
                		setBlock(mop, world, player, itemstack);
            		}
            		else if(blockId == Block.stainedClay.blockID)
            		{
            			cap = 16;
                		setBlock(mop, world, player, itemstack);
            		}
            		else if(blockId == Block.cloth.blockID)
            		{
            			cap = 16;
                		setBlock(mop, world, player, itemstack);
            		}
            		else if(blockId == Block.carpet.blockID)
            		{
            			cap = 16;
            			setBlock(mop, world, player, itemstack);
            		}
            		else if(blockId == Block.sapling.blockID)
            		{
            			cap = 3;
            			setBlock(mop, world, player, itemstack);
            		}
            		else if(blockId == Block.leaves.blockID)
            		{
            			cap = 3;
            			setBlock(mop, world, player, itemstack);
            		}
            		else if(blockId == Block.blockNetherQuartz.blockID)
            		{
            			cap = 3;
            			setBlock(mop, world, player, itemstack);
            		}
            		else if(blockId == Block.woodSingleSlab.blockID)
            		{
            			cap = 3;
            			setBlock(mop, world, player, itemstack);	
            		}
            		else if(blockId == Block.woodDoubleSlab.blockID)
            		{
            			cap = 3;
            			setBlock(mop, world, player, itemstack);
            		}
            		else if(blockId == Block.stoneSingleSlab.blockID)
            		{
            			cap = 6;
            			setBlock(mop, world, player, itemstack);
            		}
            		else if(blockId == ConfigBlocks.blockCandle.blockID)
            		{
            			cap = 15;
            			setBlock(mop, world, player, itemstack);
            		}
            		else if(blockId == Block.plantRed.blockID)
            		{
            			type = 0;
            			ChangeBlockType(mop, world, player, itemstack);
            		}
            		else if(blockId == Block.plantYellow.blockID)
            		{
            			type = 1;
            			ChangeBlockType(mop, world, player, itemstack);
            		}
            		else if(blockId == Block.cobblestone.blockID)
            		{
            			type = 2;
            			ChangeBlockType(mop, world, player, itemstack);
            		}
            		else if(blockId == Block.cobblestoneMossy.blockID)
            		{
            			type = 3;
                		ChangeBlockType(mop, world, player, itemstack);
            		}
            		}
            		*/
            			
            			if(ExchangeFociFunctions.canBeExchange.containsKey(blockId))
            			{
            				cap = ExchangeFociFunctions.canBeExchange.get(blockId);
                			setBlock(mop, world, player, itemstack);
            			}
            		}
                	}
            	}
            	
      		return itemstack;
        }
        private static int cap;
        
        
        public static void setBlock(MovingObjectPosition mop, World world, EntityPlayer player, ItemStack itemstack)
        {
    		int nextMeta = world.getBlockMetadata(mop.blockX, mop.blockY, mop.blockZ) + 1;
            int blockId = world.getBlockId(mop.blockX, mop.blockY, mop.blockZ);

    		world.setBlockMetadataWithNotify(mop.blockX, mop.blockY, mop.blockZ, nextMeta, 2);
			if(nextMeta -1 >= cap)
				world.setBlockMetadataWithNotify(mop.blockX, mop.blockY, mop.blockZ, 0, 2);
			
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
                return "EXCHANGE";
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