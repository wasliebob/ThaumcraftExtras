package thaumcraftextras.items.foci;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.common.entities.projectile.EntityFrostShard;
import thaumcraft.common.items.wands.ItemWandCasting;
import thaumcraftextras.items.foci.entities.ProjectileFreeze;

public class FreezeFoci extends ItemFoci {

        private static final AspectList visUsage = new AspectList().add(Aspect.AIR, 10).add(Aspect.ORDER, 5).add(Aspect.ENTROPY, 5);

        public FreezeFoci(int i) {
                super(i);
        }
        
        
        @Override
        public ItemStack onFocusRightClick(ItemStack itemstack, World world, EntityPlayer player, MovingObjectPosition movingobjectposition) {
            ItemWandCasting wand = (ItemWandCasting)itemstack.getItem();
            if (wand.consumeAllVis(itemstack, player, getVisCost(), true)) {
        	if(!world.isRemote)
        	{
        		ProjectileFreeze freeze;
        		freeze = new ProjectileFreeze(world, player);
                world.spawnEntityInWorld(freeze);
        	}
            }
    		return itemstack;
        }

        @Override
        public String getSortingHelper(ItemStack itemstack) {
                return "FREEZE";
        }

        @Override
        public int getFocusColor() {
                return 0x00FFFF;
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