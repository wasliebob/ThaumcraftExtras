package thaumcraftextras.items.foci;

import java.awt.Color;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.common.Thaumcraft;
import thaumcraft.common.items.wands.ItemWandCasting;

public class DispelFoci extends ItemFoci {

        private static final AspectList visUsage = new AspectList().add(Aspect.ORDER, 500);

        public DispelFoci(int i) {
                super(i);
        }

        @Override
        public ItemStack onFocusRightClick(ItemStack itemstack, World world, EntityPlayer player, MovingObjectPosition movingobjectposition) {
            ItemWandCasting wand = (ItemWandCasting)itemstack.getItem();
            if (wand.consumeAllVis(itemstack, player, getVisCost(), true)) {
        	if(!world.isRemote)
        	{
        		player.clearActivePotions();
        		Thaumcraft.proxy.sparkle((float)player.posX, (float)player.posY, (float)player.posZ, Color.red.getRGB());
        	}
            }
    		return itemstack;

        }

        @Override
        public String getSortingHelper(ItemStack itemstack) {
                return "DISPEL";
        }

        @Override
        public int getFocusColor() {
                return 0x663333;
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