package thaumcraftextras.items.foci;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.common.items.wands.ItemWandCasting;
import thaumcraftextras.api.functions.MiscFunctions;

public class CleanFoci extends ItemFoci {

        private static final AspectList visUsage = new AspectList().add(Aspect.AIR, 625);
        
        public CleanFoci(int i) {
                super(i);
        }

        @Override
        public ItemStack onFocusRightClick(ItemStack itemstack, World world, EntityPlayer player, MovingObjectPosition mop) {
            ItemWandCasting wand = (ItemWandCasting)itemstack.getItem();
            
            if(!world.isRemote)
            {
            if(mop != null)
            {
            if (wand.consumeAllVis(itemstack, player, getVisCost(), true)) 
            {
            	int x,y,z;
            	x = mop.blockX;
            	y = mop.blockY;
            	z = mop.blockZ;
            	
            	int cur = world.getBlockId(x, y, z);


            	if(MiscFunctions.canBeCleaned.contains(world.getBlockId(x, y, z)))
            		world.setBlock(x, y, z, 0);
            	else
            		return itemstack;
            }
            }
            }
            return itemstack;
        }

        @Override
        public String getSortingHelper(ItemStack itemstack) {
                return "CLEAN";
        }

        @Override
        public int getFocusColor() {
                return 0x33FFCC;
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