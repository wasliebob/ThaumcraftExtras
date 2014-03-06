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
import thaumcraftextras.api.functions.ExchangerFunctions;
import cpw.mods.fml.common.network.PacketDispatcher;

public class TileEntityExchanger extends TileEntity implements ISidedInventory
{
    
	ItemStack ItemStacks[]; 
    private static final int[] slots_top = new int[] {0};
    private static final int[] slots_bottom = new int[] {2, 1};
    private static final int[] slots_sides = new int[] {1};
    private static int chargeTime;
    
    public TileEntityExchanger()
    {
    	ItemStacks = new ItemStack[3];
    	chargeTime = 30;
    }
    
    @Override
    public void updateEntity()
    {
    	if(!this.worldObj.isRemote)
    	{
    		if(getStackInSlot(0) != null && getStackInSlot(1) != null)
    		{
    			Item inExchangeSlot = getStackInSlot(0).getItem();
    			Item inBatterySlot = getStackInSlot(1).getItem();

    			ItemStack inExchangeSlotStack = getStackInSlot(0);
    			ItemStack inBatterySlotStack = getStackInSlot(1);

				Item item;
				item = inBatterySlot;
				int getDamage = item.getDamage(inBatterySlotStack);

				if(hashmapContains(inExchangeSlot) && ChargerFunctions.isChargeAble.contains(inBatterySlot) && inBatterySlot.getDamage(inBatterySlotStack) < inBatterySlot.getMaxDamage())
				{					
    				if(chargeTime > 0)
    					chargeTime--;
    				
    				if(chargeTime <= 0)
    				{
	    				Item item2;
	    				item2 = inExchangeSlot;
	    				int getItemDamage = item2.getDamage(inExchangeSlotStack);
	        					
	    				if(getItemDamage +1 < getValue(item2) && ItemStacks[2] != null && getItemDamage != getStackInSlot(2).getItem().getDamage(getStackInSlot(2)))
	    				{
							ItemStacks[2] = new ItemStack(inExchangeSlot, ItemStacks[2].stackSize +1, getItemDamage + 1);
	    					if(ItemStacks[0].stackSize != 1){
	    						ItemStacks[0] = new ItemStack(inExchangeSlot, ItemStacks[0].stackSize - 1, getItemDamage);
	    					}else{
	    						ItemStacks[0] = null;
	    					}
	    					item.setDamage(inBatterySlotStack, getDamage + 1);
	    					chargeTime = 60;
	    				}
	    				else if(getItemDamage +1 >= getValue(item2) && ItemStacks[2] != null && getItemDamage != getStackInSlot(2).getItem().getDamage(getStackInSlot(2)))
	    				{
	    					ItemStacks[2] = new ItemStack(inExchangeSlot, ItemStacks[2].stackSize +1, 0);
	    					if(ItemStacks[0].stackSize != 1){
	    						ItemStacks[0] = new ItemStack(inExchangeSlot, ItemStacks[0].stackSize - 1, getItemDamage);
	    					}else{
	    						ItemStacks[0] = null;
	    					}		    				
	    					item.setDamage(inBatterySlotStack, getDamage + 1);
	    					chargeTime = 60;
	    				}
	    				else if(getItemDamage +1 < getValue(item2) && ItemStacks[2] == null)
	    				{
	    					ItemStacks[2] = new ItemStack(inExchangeSlot, 1, getItemDamage + 1);
	    					if(ItemStacks[0].stackSize != 1){
	    						ItemStacks[0] = new ItemStack(inExchangeSlot, ItemStacks[0].stackSize - 1, getItemDamage);
	    					}else{
	    						ItemStacks[0] = null;
	    					}		    				
	    					item.setDamage(inBatterySlotStack, getDamage + 1);
	    					chargeTime = 60;
	    				}
	    				else if(getItemDamage +1 >= getValue(item2) && ItemStacks[2] == null)
	    				{
	    					ItemStacks[2] = new ItemStack(inExchangeSlot, 1, 0);
	    					if(ItemStacks[0].stackSize != 1){
	    						ItemStacks[0] = new ItemStack(inExchangeSlot, ItemStacks[0].stackSize - 1, getItemDamage);
	    					}else{
	    						ItemStacks[0] = null;
	    					}
	    					item.setDamage(inBatterySlotStack, getDamage + 1);
	    					chargeTime = 60;
	    				}
	    				else
	    				{
	    					chargeTime = 60;
	    				}
    				}
				}
    		}
    	}
    }
    
	@Override
	public int getSizeInventory() {
		return ItemStacks.length;
	}
	
	@Override
	public ItemStack getStackInSlot(int i) 
	{
		   if(i > ItemStacks.length)
	            return ItemStacks[0];
	            else
	            	return ItemStacks[i];
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
	public String getInvName() {
		return "mcke.exchanger";
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
 	

	  
	  public boolean hashmapContains(Item item)
	  {
		  return ExchangerFunctions.canExchange.containsKey(item);
	  }
	  
	  public int getValue(Item item)
	  {
		  return ExchangerFunctions.canExchange.get(item);
	  }

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return false;
	}
	
	@Override
	public int[] getAccessibleSlotsFromSide(int var1) {
		return new int[]{0, 1, 2};
	}

	@Override
	public boolean canInsertItem(int i, ItemStack itemstack, int j) 
	{
		if(i == 0 && j == 4)
			return itemstack != null && ExchangerFunctions.canExchange.containsKey(itemstack.getItem());
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
		if(i == 1 && j ==  5 && itemstack.getItem().getDamage(getStackInSlot(1)) == getStackInSlot(1).getItem().getMaxDamage())
			return true;
		if(i == 2 && j ==  5)
			return true;
		else
			return false;
	}
}