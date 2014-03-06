package thaumcraftextras.items.tools;

import java.awt.Color;
import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import thaumcraftextras.client.HudHandler;
import thaumcraftextras.helpers.IconHelper;
import thaumcraftextras.helpers.MathHelper;
import thaumcraftextras.register.CreativeTabRegister;
import thaumcraftextras.register.ItemRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DarkThaumiumSword extends ItemSword {

        public DarkThaumiumSword(int id) {
                super(id, ItemRegister.toolMatDarkThaumium);
                setCreativeTab(CreativeTabRegister.tabMain);
        }
        public int amountModes = 3;
        
        @Override
        @SideOnly(Side.CLIENT)
        public void registerIcons(IconRegister par1IconRegister) {
                itemIcon = IconHelper.forItem(par1IconRegister, this);
        }

        @Override
        public boolean isItemTool(ItemStack stack) {
                return true;
        }
        
        @Override
        public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) 
        {
        	if(!world.isRemote)
        	{
                if(player.isSneaking())
                {
                	int stack0 = player.inventory.getCurrentItem().getItemDamage();
                	if(stack0 +1 > amountModes)
                	{
                    	player.inventory.getCurrentItem().setItemDamage(0);
                    	HudHandler.setTooltip(getModeName(0));
                	}
                	else
                	{
                    	player.inventory.getCurrentItem().setItemDamage(getNextMode(stack));
                    	HudHandler.setTooltip(getModeName(stack0 +1));
                	}
                }
                else
                {
                	int stack1 = player.inventory.getCurrentItem().getItemDamage();

                	if(getModeName(stack1) == "Heal")
                	{
                		player.heal(5.0F);
                	}
                	if(getModeName(stack1) == "Strength")
                	{
                		player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, MathHelper.minutesToTicks(1)));
                	}
                	if(getModeName(stack1) == "Resistance")
                	{
                		player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, MathHelper.minutesToTicks(1)));
                	}
                	if(getModeName(stack1) == "Speed")
                	{
                		player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, MathHelper.minutesToTicks(1)));
                	}
                	else
                	{
                	}
                }
        	}
			return stack;
        }

        public int getNextMode(ItemStack stack)
        {
        	int damage = stack.getItem().getDamage(stack);
        	if(damage + 1 > amountModes)
        		return 0;
        	else;
        		return damage +1;

        }
        
        public int getMode(ItemStack stack)
        {
        	int damage = stack.getItem().getDamage(stack);
        		return damage;
        }
        
        public String getModeName(int value)
        {
        	switch(value)
        	{
        	case 0: return "Heal";
        	case 1: return "Strength";
        	case 2: return "Resistance";
        	case 3: return "Speed";
        	default: return "Normal";
        	}
        }
        
        @Override
        public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean id) 
        {
            int color = Color.cyan.getRGB();
        	list.add(EnumChatFormatting.AQUA + "Mode: " + EnumChatFormatting.RED + getModeName(getMode(stack)));
        }
}