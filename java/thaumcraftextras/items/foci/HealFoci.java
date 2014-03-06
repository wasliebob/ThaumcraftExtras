package thaumcraftextras.items.foci;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.common.items.wands.ItemWandCasting;
import thaumcraftextras.register.ParticleRegister;

public class HealFoci extends ItemFoci {

        private static final AspectList visUsage = new AspectList().add(Aspect.ORDER, 625);

        public HealFoci(int i) {
                super(i);
        }

        @Override
        public ItemStack onFocusRightClick(ItemStack itemstack, World world, EntityPlayer player, MovingObjectPosition movingobjectposition) {
            ItemWandCasting wand = (ItemWandCasting)itemstack.getItem();
            if (wand.consumeAllVis(itemstack, player, getVisCost(), true)) {
        	player.heal(4);
        	
        	if(player != null)
			{
			for (int i = 0; i < 4; ++i)
            {
				{
         		 Random rand2 = new Random();
         		 ParticleRegister.spawnParticle("heart", world, player.posX, player.posY +2 + rand2.nextDouble() * 0.5D, player.posZ, rand2.nextGaussian(), 0.5D, rand2.nextGaussian());
				}
			}
			}
            }
      		return itemstack;
          }

        @Override
        public String getSortingHelper(ItemStack itemstack) {
                return "HEAL";
        }

        @Override
        public int getFocusColor() {
                return 0xFF00CC;
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