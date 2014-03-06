package thaumcraftextras.items.foci;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.common.items.wands.ItemWandCasting;
import thaumcraftextras.items.foci.entities.ProjectileConfusion;

public class ConfusionFoci extends ItemFoci {

        private static final AspectList visUsage = new AspectList().add(Aspect.AIR, 10).add(Aspect.ORDER, 15).add(Aspect.ENTROPY, 15);

        public ConfusionFoci(int i) {
                super(i);
        }
        
        
        @Override
        public ItemStack onFocusRightClick(ItemStack itemstack, World world, EntityPlayer player, MovingObjectPosition movingobjectposition) {
            ItemWandCasting wand = (ItemWandCasting)itemstack.getItem();
            if (wand.consumeAllVis(itemstack, player, getVisCost(), true)) {
        	if(!world.isRemote)
        	{
        		ProjectileConfusion proj;
        		proj = new ProjectileConfusion(world, player);
                world.spawnEntityInWorld(proj);
        	}
            }
    		return itemstack;
        }

        @Override
        public String getSortingHelper(ItemStack itemstack) {
                return "CONFUSION";
        }

        @Override
        public int getFocusColor() {
                return 0xCCFF66;
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