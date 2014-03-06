package thaumcraftextras.items.foci;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.common.items.wands.ItemWandCasting;

public class ReturnFoci extends ItemFoci {

        private static final AspectList visUsage = new AspectList().add(Aspect.ORDER, 2400);
        public static Map<String, Double> xPos = new HashMap<String, Double>();
        public static Map<String, Double> yPos = new HashMap<String, Double>();
        public static Map<String, Double> zPos = new HashMap<String, Double>();

        public ReturnFoci(int i) {
                super(i);
        }

        @Override
        public ItemStack onFocusRightClick(ItemStack itemstack, World world, EntityPlayer player, MovingObjectPosition movingobjectposition) {
            ItemWandCasting wand = (ItemWandCasting)itemstack.getItem();
           if(player.isSneaking()){
        	   xPos.put(player.username, player.posX);
        	   yPos.put(player.username, player.posY);
        	   zPos.put(player.username, player.posZ);
           }else{
            	
            if (wand.consumeAllVis(itemstack, player, getVisCost(), true)) {
            	String name = player.username;
            	if(xPos.containsKey(name) && yPos.containsKey(name) && zPos.containsKey(name)){
            	player.setPosition(xPos.get(name), yPos.get(name), zPos.get(name));
            }
            }
           }
           return itemstack;
        }

        @Override
        public String getSortingHelper(ItemStack itemstack) {
                return "RETURN";
        }

        @Override
        public int getFocusColor() {
                return 0xCC0066;
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