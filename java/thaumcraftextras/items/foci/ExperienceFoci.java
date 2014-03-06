package thaumcraftextras.items.foci;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.common.items.wands.ItemWandCasting;
import thaumcraftextras.items.XPShard;
import thaumcraftextras.register.InfusionRegister;

public class ExperienceFoci extends ItemFoci {

        private static final AspectList visUsage = new AspectList().add(Aspect.AIR, 10).add(Aspect.ORDER, 5).add(Aspect.ENTROPY, 5);

        public ExperienceFoci(int i) {
                super(i);
        }
        
        @Override
        public ItemStack onFocusRightClick(ItemStack itemstack, World world, EntityPlayer player, MovingObjectPosition movingobjectposition) {
            ItemWandCasting wand = (ItemWandCasting)itemstack.getItem();
			if(player.experienceLevel >= 5)
			{
				if (wand.consumeAllVis(itemstack, player, getVisCost(), true)) 
					{
						if(!world.isRemote)
						{
							Experience(player);
							return itemstack;
						}
						return itemstack;
					}
				return itemstack;
			}
			return itemstack;
        }

        public static void Experience(EntityPlayer player)
        {
        	player.addExperienceLevel(-5);
			player.inventory.addItemStackToInventory(new ItemStack(InfusionRegister.xpShard));
        }
        
        @Override
        public String getSortingHelper(ItemStack itemstack) {
                return "XP";
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