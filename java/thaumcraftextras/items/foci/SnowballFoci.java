package thaumcraftextras.items.foci;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.common.items.wands.ItemWandCasting;

public class SnowballFoci extends ItemFoci {

        private static final AspectList visUsage = new AspectList().add(Aspect.AIR, 10).add(Aspect.ORDER, 10);

        public SnowballFoci(int i) {
                super(i);
        }

        @Override
        public ItemStack onFocusRightClick(ItemStack itemstack, World world, EntityPlayer player, MovingObjectPosition movingobjectposition) {
            ItemWandCasting wand = (ItemWandCasting)itemstack.getItem();
            if (wand.consumeAllVis(itemstack, player, getVisCost(), true)) {
        	if(!world.isRemote)
        	{
        		EntitySnowball projectile;
        		projectile = new EntitySnowball(world, player);
                world.spawnEntityInWorld(projectile);
        	}
            }
    		return itemstack;
        }

        @Override
        public String getSortingHelper(ItemStack itemstack) {
                return "SNOWBALL";
        }

        @Override
        public int getFocusColor() {
                return 0x66FFCC;
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