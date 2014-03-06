package thaumcraftextras.items.foci;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.common.items.wands.ItemWandCasting;

public class ArrowFoci extends ItemFoci {

        private static final AspectList visUsage = new AspectList().add(Aspect.AIR, 25).add(Aspect.ORDER, 25);

        public ArrowFoci(int i) {
                super(i);
        }

        @Override
        public ItemStack onFocusRightClick(ItemStack itemstack, World world, EntityPlayer player, MovingObjectPosition movingobjectposition) {
            ItemWandCasting wand = (ItemWandCasting)itemstack.getItem();
            if (wand.consumeAllVis(itemstack, player, getVisCost(), true)) {
        	if(!world.isRemote)
        	{
        		EntityArrow arrow;
        		arrow = new EntityArrow(world, player, 2);
        		arrow.canBePickedUp = 0;
                world.spawnEntityInWorld(arrow);
        	}
            }
    		return itemstack;
        }

        @Override
        public String getSortingHelper(ItemStack itemstack) {
                return "ARROW";
        }

        @Override
        public int getFocusColor() {
                return 0x996633;
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