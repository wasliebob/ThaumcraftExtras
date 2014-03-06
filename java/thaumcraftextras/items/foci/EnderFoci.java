package thaumcraftextras.items.foci;

import java.util.Random;

import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.common.items.wands.ItemWandCasting;
import thaumcraftextras.register.ParticleRegister;

public class EnderFoci extends ItemFoci {

        private static final AspectList visUsage = new AspectList().add(Aspect.AIR, 1000);

        public EnderFoci(int i) {
                super(i);
        }

        @Override
        public ItemStack onFocusRightClick(ItemStack itemstack, World world, EntityPlayer player, MovingObjectPosition movingobjectposition) {
            ItemWandCasting wand = (ItemWandCasting)itemstack.getItem();
            if (wand.consumeAllVis(itemstack, player, getVisCost(), true)) {
        	if(!world.isRemote)
        	{
        		if(player != null)
        		{ 
        		for (int i = 0; i < 32; ++i)
                 {
              		 Random rand2 = new Random();
                     ParticleRegister.spawnParticle("portal", world, player.posX, player.posY + rand2.nextDouble() * 0.0D, player.posZ, rand2.nextGaussian(), 0.2D, rand2.nextGaussian());
                 }
                world.spawnEntityInWorld(new EntityEnderPearl(world, player));
        	}
        	}
            }
    		return itemstack;

        }

        @Override
        public String getSortingHelper(ItemStack itemstack) {
                return "ENDER";
        }

        @Override
        public int getFocusColor() {
                return 0x006633;
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