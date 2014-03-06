package thaumcraftextras.items.foci;

import java.awt.Color;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.common.items.wands.ItemWandCasting;

public class CustomFoci extends ItemFoci {

        private static final AspectList visUsage = new AspectList().add(Aspect.AIR, 0);
        public static String COLOR = "COLOR";
        public static String TYPE = "TYPE";
        public static String ACTION = "ACTION";
        
        public static String SPEED = "SPEED";
        
        public static String NULL = "NULL";

        public static Map<Integer, Integer> color = new HashMap<Integer, Integer>();
        public static Map<String, Integer> type = new HashMap<String, Integer>();
        public static Map<String, Integer> actions = new HashMap<String, Integer>();

        public CustomFoci(int i) {
                super(i);
                fociAdd();
        }
        
        public static void fociAdd()
        {
        	/** Colors */
        	addToList("", 0, Color.red.getRGB());
        	
        	/** Types */
        	addToList("Touch", 1, 0);
        	addToList("Self", 1, 0);

        	/** Actions */
        	addToList("Dig", 2, 0);
        	addToList("Fire", 2, 0);
        	addToList("Heal", 2, 0);
        }

        @Override
        public ItemStack onFocusRightClick(ItemStack itemstack, World world, EntityPlayer player, MovingObjectPosition mop) {
            ItemWandCasting wand = (ItemWandCasting)itemstack.getItem();
            if (wand.consumeAllVis(itemstack, player, getVisCost(), true)) {
        	if(!world.isRemote)
        	{
        		if(player != null)
        		{
        			if(itemstack.hasTagCompound() == true)
        			{
        	            itemstack.setTagCompound(new NBTTagCompound());
        	        	NBTTagCompound tag = itemstack.getTagCompound();
        				if(tag.getString(TYPE) == "TOUCH")
        				{
                			player.addChatMessage("TYPE");
        					if(tag.getString(ACTION) == "DIG")
        					{
        						world.setBlock(mop.blockX, mop.blockY, mop.blockZ, 0);
        					}
        				}
        				else if(tag.getString(TYPE) == "SELF")
        				{
                			player.addChatMessage("SELF");
        				}
        				else
        				{
        					player.addChatMessage(ACTION);
        					player.addChatMessage(TYPE);
        				}
        			}
        			else
        			{
        				player.addChatMessage("No NBTTAG Found :(");
        			}
        		}
        	}													
        	}
    		return itemstack;
        }
        
        public static void addToList(String string, int todo, int colorCode)
        {
        	/**
        	 * 0 = Color
        	 * 1 = Type
        	 * 2 = Action
        	 */
        	
        	switch(todo)
        	{
        	case 0: color.put(colorCode, 0);
        	case 1: type.put(string, 0);
        	case 2: actions.put(string, 0);
        	}
        }
        
        @Override
        public void getSubItems(int id, CreativeTabs tabs, List list)
        {
    		int meta = 0;
    		int end = 15;
    		while(meta >= 0 && meta <= end)
    		{
                list.add(new ItemStack(id, 1, meta));     
                meta++;
    		}
        }
        
        @Override
        public void onCreated(ItemStack stack, World world, EntityPlayer player)
        {
        	if(stack.getItemDamage() > 0)
        	{
            stack.setTagCompound(new NBTTagCompound());
        	NBTTagCompound tag = stack.getTagCompound();

        	if(stack.getItemDamage() > 0 && stack.getItemDamage() <= 1000)
        	{
        		tag.setString(TYPE, "TOUCH");
        		
            	if(stack.getItemDamage() >= 2 && stack.getItemDamage() <= 100)
            	{
            		tag.setString(ACTION, "DIG");
            	}
        	}
        	else if(stack.getItemDamage() > 1000 && stack.getItemDamage() <= 2000)
        	{
            	tag.setString(TYPE, "SELF");
        	}
        	if(!world.isRemote)
        	{
        	player.addChatMessage(tag.getString(TYPE));
        	player.addChatMessage(tag.getString(ACTION));
        	player.addChatMessage(tag.getString(COLOR));
        	}
        	}
        	/*
        	if(tag.getInteger(SPEED) > 0)
        	{
            	tag.setInteger(SPEED, tag.getInteger(SPEED) + 1);
        	}
        	else
        	{
        		tag.setInteger(SPEED, 0);
        	}
    		player.addChatMessage(tag.getString(TYPE));
        	*/
        }

        
        @Override
        public String getSortingHelper(ItemStack itemstack) {
                return "CUSTOM";
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