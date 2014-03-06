package thaumcraftextras.items.tools;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import thaumcraft.common.lib.Utils;
import thaumcraftextras.api.energy.IMagicWrenchable;
import thaumcraftextras.api.energy.IToolMCKE;
import thaumcraftextras.api.functions.ChargerFunctions;
import thaumcraftextras.api.functions.MagicWrenchFunctions;
import thaumcraftextras.helpers.IconHelper;
import thaumcraftextras.register.CreativeTabRegister;

public class MagicWrench extends Item implements IMagicWrenchable, IToolMCKE{

	public MagicWrench(int id, boolean isElectric, int damageValue) {
		super(id);
		setCreativeTab(CreativeTabRegister.tabMain);
		setMaxDamage(damageValue);
		setMaxStackSize(1);
		addToMap();
		
		needsEnergy = isElectric;
		energySize = damageValue;
	}
	boolean needsEnergy;
	int energySize;
	
	@Override
    public void registerIcons(IconRegister par1IconRegister) 
	{
        itemIcon = IconHelper.forItem(par1IconRegister, this);
	}
	
	public void addToMap()
	{
		ChargerFunctions.addChargeAble(this);
	}

	  @Override
      public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) 
      {
          MovingObjectPosition pos = Utils.getTargetBlock(world, player, false);

          if(pos != null)
          {
      	int x, y, z;
      	x = pos.blockX;
      	y = pos.blockY;
      	z = pos.blockZ;
      	
          int blockId = world.getBlockId(x, y, z);
          
      	if(!world.isRemote)
      	{
              if(player.isSneaking())
              {
            	  if(stack.getItemDamage() < energySize -1 && MagicWrenchFunctions.canUseWrench.containsKey(blockId))
            	  {
            		  dropBlock(world, stack, player);
                	  decreaseEnergy(stack, 1);
            	  }
              }
      		}
          }
        	return stack;

      }

      public static void dropBlock(World world, ItemStack itemstack, EntityPlayer player)
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
      public static void dropBlockAsItem(World world, int x, int y, int z, ItemStack itemstack)
      {
          float f = 0.7F;
          double d0 = (double)(world.rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
          double d1 = (double)(world.rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
          double d2 = (double)(world.rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
          EntityItem entityitem = new EntityItem(world, (double)x + d0, (double)y + d1, (double)z + d2, itemstack);
          world.spawnEntityInWorld(entityitem);
      }
      
	@Override
	public boolean hasDamageValue(ItemStack stack) {
		return true;
	}

	@Override
	public void decreaseEnergy(ItemStack stack, int amount)
	{
		stack.getItem().setDamage(stack, stack.getItemDamage() + 1);
	}
	
	@Override
    public void getSubItems(int id, CreativeTabs tab, List list) {
            super.getSubItems(id, tab, list);
            
            //if(needsEnergy)
            list.add(new ItemStack(this, 1, energySize));
    }

	@Override
	public void setAmountOfEnergy(ItemStack stack, int amount) {
		
	}

	@Override
	public int getAmountOfEnergy(ItemStack stack) {
		return stack.getMaxDamage();
	}

	@Override
	public void setCostForMode(ItemStack stack, int modeId, int cost) {
	}

	@Override
	public void getCostForMode(ItemStack stack, int modeId) {		
	}
	
	
}
