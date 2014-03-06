package thaumcraftextras.items.tools;

import java.awt.Color;
import java.util.List;
import java.util.Random;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import thaumcraft.common.lib.Utils;
import thaumcraftextras.api.functions.DestroyFunctions;
import thaumcraftextras.client.HudHandler;
import thaumcraftextras.helpers.IconHelper;
import thaumcraftextras.helpers.MathHelper;
import thaumcraftextras.register.CreativeTabRegister;
import thaumcraftextras.register.ItemRegister;
import thaumcraftextras.register.ParticleRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DarkThaumiumShovel extends ItemSpade {

        public DarkThaumiumShovel(int id) {
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
                		player.heal(10.0F);
                	}
                	if(getModeName(stack1) == "Silk Touch")
                	{
                		harvestWithSilkTouch(world, stack, player);
                	}
                	if(getModeName(stack1) == "Resistance")
                	{
                		player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, MathHelper.minutesToTicks(1)));
                	}
                	if(getModeName(stack1) == "Smelt")
                	{
                		setSmeltingResult(world, stack, player);
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
        	case 0: return "Resistance";
        	case 1: return "Heal";
        	case 2: return "Silk Touch";
        	case 3: return "Smelt";
        	default: return "Normal";
        	}
        }
        
        @Override
        public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean id) 
        {
            int color = Color.cyan.getRGB();
        	list.add(EnumChatFormatting.AQUA + "Mode: " + EnumChatFormatting.RED + getModeName(getMode(stack)));
        }
        
        private static int block;
        
        public static void setSmeltingResult(World world, ItemStack itemstack, EntityPlayer player)
        {
            MovingObjectPosition pos = Utils.getTargetBlock(world, player, false);

            if(pos != null)
            {
        	int x, y, z;
        	x = pos.blockX;
        	y = pos.blockY;
        	z = pos.blockZ;
        	
            int blockId = world.getBlockId(x, y, z);
            ItemStack block = new ItemStack(blockId, 1, world.getBlockMetadata(x, y, z));
            ItemStack blockAir = new ItemStack(blockId, 1, 0);
            ItemStack sResult = FurnaceRecipes.smelting().getSmeltingResult(block);
            
            if(sResult != null)
            {
            	int meta = sResult.getItemDamage();
            	if(blockId != 0)
    			{
    			for (int i = 0; i < 4; ++i)
                {
    				{
             		 Random rand2 = new Random();
             		 ParticleRegister.spawnParticle("flame", world, x, y + rand2.nextDouble() * 0.5D, z, rand2.nextGaussian(), 0.5D, rand2.nextGaussian());
    				}
                }
    				
        			world.setBlock(x, y, z, 0);
        			dropBlockAsItem(world, x, y, z, new ItemStack(sResult.itemID, 1, meta));
    			}
    		}
        	else if (sResult != block)
        	{
        		return;
        	}
            }
        }
        
        public static void harvestWithSilkTouch(World world, ItemStack itemstack, EntityPlayer player)
        {
            MovingObjectPosition pos = Utils.getTargetBlock(world, player, false);

            if(pos != null)
            {
        	int x, y, z;
        	x = pos.blockX;
        	y = pos.blockY;
        	z = pos.blockZ;
        	
            int blockId = world.getBlockId(x, y, z);
            ItemStack block = new ItemStack(blockId, 1, world.getBlockMetadata(x, y, z));
            ItemStack blockAir = new ItemStack(blockId, 1, 0);
            
            if(block != null) 
            {
            	if(!DestroyFunctions.canDestroy.containsKey(blockId))
            	{
            	int meta2 = block.getItemDamage();
        		if(blockId != 0)
    			{
    			world.setBlock(x, y, z, 0);
    			dropBlockAsItem(world, x, y, z, new ItemStack(block.itemID, 1, meta2));
    			}
            }
        	else if (block != block)
        	{
        		return;
        	}
            }
            }
        }
        public static void dropBlockAsItem(World world, int x, int y, int z, ItemStack itemstack)
        {
            float f = 0.7F;
            double d0 = (double)(world.rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
            double d1 = (double)(world.rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
            double d2 = (double)(world.rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
            EntityItem entityitem = new EntityItem(world, (double)x + d0, (double)y + d1, (double)z + d2, itemstack);
            world.spawnEntityInWorld(entityitem);
        }
}