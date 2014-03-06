package thaumcraftextras.items.foci;

import java.util.Random;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.common.items.wands.ItemWandCasting;
import thaumcraftextras.register.ParticleRegister;

public class SmeltingFoci extends ItemFoci {

        private static final AspectList visUsage = new AspectList().add(Aspect.ORDER, 50).add(Aspect.FIRE, 50);

        public SmeltingFoci(int i) {
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
                    	setSmeltingResult(mop, world, player, itemstack);
            		}
                	}
            	}
      		return itemstack;
        }
        private static int block;
        
        public static void setSmeltingResult(MovingObjectPosition mop, World world, EntityPlayer player, ItemStack itemstack)
        {
            int blockId = world.getBlockId(mop.blockX, mop.blockY, mop.blockZ);
            ItemStack block = new ItemStack(blockId, 1, world.getBlockMetadata(mop.blockX, mop.blockY, mop.blockZ));
            ItemStack blockAir = new ItemStack(blockId, 1, 0);
            ItemStack sResult = FurnaceRecipes.smelting().getSmeltingResult(block);
            
            if(sResult != null  && sResult.getItem() instanceof ItemBlock)
            {
            	world.setBlock(mop.blockX, mop.blockY, mop.blockZ, sResult.itemID, sResult.getItemDamage(), 2);
            	if(blockId != 0)
    			{
    			for (int i = 0; i < 4; ++i)
                {
    				{
             		 Random rand2 = new Random();
             		 ParticleRegister.spawnParticle("flame", world, mop.blockX, mop.blockY + rand2.nextDouble() * 0.5D, mop.blockZ, rand2.nextGaussian(), 0.5D, rand2.nextGaussian());
    				}
    			}
    			}
            }
            else if(sResult != null) 
            {
            	int meta = sResult.getItemDamage();
        		if(blockId != 0)
    			{
    			for (int i = 0; i < 4; ++i)
                {
    				{
             		 Random rand2 = new Random();
             		 ParticleRegister.spawnParticle("flame", world, mop.blockX, mop.blockY + rand2.nextDouble() * 0.5D, mop.blockZ, rand2.nextGaussian(), 0.5D, rand2.nextGaussian());
    				}
    			}
    			world.setBlock(mop.blockX, mop.blockY, mop.blockZ, 0);
    			dropBlockAsItem(world, mop.blockX, mop.blockY, mop.blockZ, new ItemStack(sResult.itemID, 1, meta));
    			}
            }
        	else if (sResult != block)
        	{
        		return;
        	}
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
        public String getSortingHelper(ItemStack itemstack) {
                return "SMELTING";
        }

        @Override
        public int getFocusColor() {
                return 0x333300;
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