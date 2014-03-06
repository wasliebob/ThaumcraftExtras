package thaumcraftextras.items.foci;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.common.entities.monster.EntityPech;
import thaumcraft.common.items.wands.ItemWandCasting;

public class PechFoci extends ItemFoci {

        private static final AspectList visUsage = new AspectList().add(Aspect.ORDER, 625).add(Aspect.AIR, 625);

        public PechFoci(int i) {
                super(i);
        }

        @Override
        public ItemStack onFocusRightClick(ItemStack itemstack, World world, EntityPlayer player, MovingObjectPosition movingobjectposition) {
            ItemWandCasting wand = (ItemWandCasting)itemstack.getItem();
        	EntityPech ep;
            if (wand.consumeAllVis(itemstack, player, getVisCost(), true)) {
            	if(!world.isRemote)
            	{
            	Random rand = new Random();
            	ep = new EntityPech(world);
            	ep.setPosition(player.posX, player.posY, player.posZ);
                world.spawnEntityInWorld(ep);
            	}
            }
      		return itemstack;
        }

        @Override
        public String getSortingHelper(ItemStack itemstack) {
                return "PECH";
        }

        @Override
        public int getFocusColor() {
                return 0xCCFF00;
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