package thaumcraftextras.blocks.tileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.common.items.wands.ItemWandCasting;
import thaumcraftextras.api.functions.ChargerFunctions;
import cpw.mods.fml.common.network.PacketDispatcher;

public class TileEntityWandCharger extends TileEntity implements ISidedInventory
{
    
	ItemStack ItemStacks[]; 
    private static final int[] slots_top = new int[] {0};
    private static final int[] slots_bottom = new int[] {2, 1};
    private static final int[] slots_sides = new int[] {1};
    private static int chargeTime;
    
    public TileEntityWandCharger()
    {
    	ItemStacks = new ItemStack[2];
    	chargeTime = 30;
    }
    
	@Override
	public int getSizeInventory() {
		return ItemStacks.length;
	}
	
	@Override
	public ItemStack getStackInSlot(int i) 
	{
        return ItemStacks[i];
	}

	
	@Override
	public ItemStack decrStackSize(int i, int j)
	{
		if (ItemStacks[i] != null)
        {

            if (ItemStacks[i].stackSize <= j)
            {
                ItemStack itemstack = ItemStacks[i];
                ItemStacks[i] = null;
                return itemstack;
            }
            else
            {
                ItemStack itemstack1 = ItemStacks[i].splitStack(j);

                if (ItemStacks[i].stackSize == 0)
                {
                    ItemStacks[i] = null;
                }

                return itemstack1;
            }
        }
        else
        {
            return null;
        }
	}

    @Override
    public ItemStack getStackInSlotOnClosing(int i)
{
        if (ItemStacks[i] != null)
        {
            ItemStack itemstack = ItemStacks[i];
            ItemStacks[i] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
    }

    @Override
    public void updateEntity()
    {
    	if(!this.worldObj.isRemote)
    	{
    		
    		if(getStackInSlot(0) != null && getStackInSlot(1) != null)
    		{
    			Item inWandSlot = getStackInSlot(0).getItem();
    			Item inChargeSlot = getStackInSlot(1).getItem();
    			
    			ItemStack inChargeSlotStack = getStackInSlot(1);
    			ItemStack inWandSlotStack = getStackInSlot(0);

    			if(inWandSlot instanceof ItemWandCasting && ChargerFunctions.isChargeAble.contains(inChargeSlot) && inChargeSlot.getDamage(inChargeSlotStack) < inChargeSlot.getMaxDamage())
    			{
        			ItemWandCasting convWandSlot = ((ItemWandCasting)inWandSlot);
        			if(convWandSlot.getVis(inWandSlotStack, Aspect.ORDER) != convWandSlot.getMaxVis(inWandSlotStack) &&
        					convWandSlot.getVis(inWandSlotStack, Aspect.FIRE) != convWandSlot.getMaxVis(inWandSlotStack) &&
        					convWandSlot.getVis(inWandSlotStack, Aspect.ENTROPY) != convWandSlot.getMaxVis(inWandSlotStack) &&
        							convWandSlot.getVis(inWandSlotStack, Aspect.WATER) != convWandSlot.getMaxVis(inWandSlotStack) &&
        							convWandSlot.getVis(inWandSlotStack, Aspect.EARTH) != convWandSlot.getMaxVis(inWandSlotStack) &&
        									convWandSlot.getVis(inWandSlotStack, Aspect.AIR) != convWandSlot.getMaxVis(inWandSlotStack))
        			{
    				if(chargeTime > 0)
    					chargeTime--;
    				
    				if(chargeTime <= 0)
    				{
    				Item item;
    				item = inChargeSlot;
    				int getDamage = item.getDamage(inChargeSlotStack);
    			
    				item.setDamage(inChargeSlotStack, getDamage + 1);
    				
    				if(ItemStacks[0].getItem() != null)
    				{
    				//ItemStacks[0] = new ItemStack(inFuelSlot, ItemStacks[1].stackSize - 1);
    		            ItemWandCasting wand = (ItemWandCasting)inWandSlot;
    		            wand.addVis(inWandSlotStack, Aspect.ORDER, 1, true);
    		            wand.addVis(inWandSlotStack, Aspect.FIRE, 1, true);
    		            wand.addVis(inWandSlotStack, Aspect.ENTROPY, 1, true);
    		            wand.addVis(inWandSlotStack, Aspect.WATER, 1, true);
    		            wand.addVis(inWandSlotStack, Aspect.EARTH, 1, true);
    		            wand.addVis(inWandSlotStack, Aspect.AIR, 1, true);

    					chargeTime = 30;
    				}
    				
    				worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
    				}
    			}
    		}
    	}
    	}
    }
    
	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) 
	{	
        ItemStacks[i] = itemstack;

        if (itemstack != null && itemstack.stackSize > getInventoryStackLimit())
        {
            itemstack.stackSize = getInventoryStackLimit();
        }        
	}

	@Override
	public String getInvName() {
		return "mcke.charger";
	}

	@Override
	public boolean isInvNameLocalized() {
		return false;
	}

	@Override
	public int getInventoryStackLimit()
	{
		return 64;
	}
	

	@Override
	public void openChest() 
	{
		
	}

	@Override
	public void closeChest() 
	{
		
	}
	

	
	 @Override
     public void readFromNBT(NBTTagCompound tagCompound) {
             super.readFromNBT(tagCompound);
            
             NBTTagList tagList = tagCompound.getTagList("Inventory");
             for (int i = 0; i < tagList.tagCount(); i++) {
                     NBTTagCompound tag = (NBTTagCompound) tagList.tagAt(i);
                     byte slot = tag.getByte("Slot");
                     if (slot >= 0 && slot < ItemStacks.length) {
                             ItemStacks[slot] = ItemStack.loadItemStackFromNBT(tag);
                     }
             }
     }

     @Override
     public void writeToNBT(NBTTagCompound tagCompound) {
             super.writeToNBT(tagCompound);
                            
             NBTTagList itemList = new NBTTagList();
             for (int i = 0; i < ItemStacks.length; i++) {
                     ItemStack stack = ItemStacks[i];
                     if (stack != null) {
                             NBTTagCompound tag = new NBTTagCompound();
                             tag.setByte("Slot", (byte) i);
                             stack.writeToNBT(tag);
                             itemList.appendTag(tag);
                     }
             }
             tagCompound.setTag("Inventory", itemList);
     }
	
     @Override
     public Packet getDescriptionPacket() {
             NBTTagCompound nbttagcompound = new NBTTagCompound();
             writeToNBT(nbttagcompound);
             return new Packet132TileEntityData(xCoord, yCoord, zCoord, -999, nbttagcompound);
     }

     @Override
     public void onDataPacket(INetworkManager manager, Packet132TileEntityData packet) {
             super.onDataPacket(manager, packet);
             readFromNBT(packet.data);
     }


     @Override
     public void onInventoryChanged() 
     {
             super.onInventoryChanged();
             if(!worldObj.isRemote) 
             {
                     PacketDispatcher.sendPacketToAllInDimension(getDescriptionPacket(), worldObj.provider.dimensionId);
             }
     }
     
 	@Override
 	public boolean isUseableByPlayer(EntityPlayer player) 
 	{
         if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) != this)
         {
                 return false;
         }

         return player.getDistanceSq((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D) <= 64D;
 	}
 	
	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) 
	{
        return false;
	}
	
	@Override
	public int[] getAccessibleSlotsFromSide(int var1) {
		return new int[]{0, 1};
	}

	@Override
	public boolean canInsertItem(int i, ItemStack itemstack, int j) 
	{
		if(i == 0 && j == 4)
			return itemstack != null && itemstack.getItem() instanceof ItemWandCasting;
		else if(i == 1 && j == 4)
			return itemstack != null && ChargerFunctions.isChargeAble.contains(itemstack.getItem());
		else 
			return false;
	}

	/**
	 * 0 = Bottom
	 * 1 = Top
	 * 2 = Back
	 * 3 = Front
	 * 4 = Left
	 * 5 = Right
	 */
	
	@Override
	public boolean canExtractItem(int i, ItemStack itemstack, int j)
	{
		if(i == 0 && j ==  5 && itemstack.getItem() instanceof ItemWandCasting) 
		{
			ItemWandCasting wand = (ItemWandCasting)itemstack.getItem();
			int amount = wand.getMaxVis(itemstack);
			return wand.getVis(itemstack, Aspect.AIR) == amount && wand.getVis(itemstack, Aspect.FIRE) == amount && wand.getVis(itemstack, Aspect.WATER) == amount && wand.getVis(itemstack, Aspect.EARTH) == amount && wand.getVis(itemstack, Aspect.ENTROPY) == amount && wand.getVis(itemstack, Aspect.ORDER) == amount;
			
		}
		if(i == 1 && j ==  5 && itemstack.getItem().getDamage(getStackInSlot(1)) == getStackInSlot(1).getItem().getMaxDamage())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}