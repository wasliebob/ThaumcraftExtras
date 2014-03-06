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
import thaumcraft.common.Thaumcraft;
import thaumcraftextras.api.functions.ChargerFunctions;
import thaumcraftextras.api.functions.DarkInfuserFunctions;
import cpw.mods.fml.common.network.PacketDispatcher;

public class TileEntityDarkInfuser extends TileEntity implements ISidedInventory
{
    
	ItemStack ItemStacks[]; 
    private static final int[] slots_top = new int[] {0};
    private static final int[] slots_bottom = new int[] {2, 1};
    private static final int[] slots_sides = new int[] {1};
    private static int chargeTime;    

    public TileEntityDarkInfuser()
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
    			Item inSlot1 = getStackInSlot(0).getItem();
    			Item inBatterySlot = getStackInSlot(1).getItem();
    			ItemStack inSlot1Stack = getStackInSlot(0);
    			ItemStack inBatterySlotStack = getStackInSlot(1);
    			
				Item item;
				item = inBatterySlot;
				int getDamage = item.getDamage(inBatterySlotStack);
				if(hashmapContains(inSlot1Stack) && !this.worldObj.isDaytime() &&ChargerFunctions.isChargeAble.contains(inBatterySlot) && inBatterySlot.getDamage(inBatterySlotStack) < inBatterySlot.getMaxDamage())
				{		
					
					for (int i = 0; i<5; i++) {
		            	Thaumcraft.proxy.blockRunes(this.worldObj, this.xCoord + (2*Math.random() - 1.0F), this.yCoord + 1.5F + (2*Math.random() - 1.0F), this.zCoord + 0.5F + (2*Math.random() - 1.0F), this.xCoord + 0.5F, this.yCoord + 1.5F, this.zCoord + 0.5F, 1, 1.0F);
						}
					
    				if(chargeTime > 0)
    					chargeTime--;
    				
    				if(chargeTime <= 0)
    				{
	    				Item item2;
	    				item2 = inSlot1;
	    				int getItemDamage = item2.getDamage(inSlot1Stack);
	    				if(ItemStacks[2] == null)
	    				{
	    					ItemStacks[2] = new ItemStack(getResult(inSlot1), 1, 0);
	    					if(ItemStacks[0].stackSize != 1){
	    						ItemStacks[0] = new ItemStack(inSlot1, ItemStacks[0].stackSize - 1, getItemDamage);
	    					}else{
	    						ItemStacks[0] = null;
	    					}
	    					item.setDamage(inBatterySlotStack, getDamage + 1);
	    					chargeTime = 60;
	    				}
	    				else if(ItemStacks[2] != null && getResult(ItemStacks[0].getItem()) == ItemStacks[2].getItem().itemID)
	    				{
							ItemStacks[2] = new ItemStack(getResult(inSlot1), ItemStacks[2].stackSize +1, 0);
	    					if(ItemStacks[0].stackSize != 1){
	    						ItemStacks[0] = new ItemStack(inSlot1, ItemStacks[0].stackSize - 1, getItemDamage);
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
    
    
    public int getResult(Item item)
    {
    	//return DarkInfuserFunctions.canInfuseItem.get(item.itemID);
    	return DarkInfuserFunctions.infusion().getInfuseResult(item.itemID);
    }
    
    public boolean hasResult(Item item)
    {
    	return DarkInfuserFunctions.infusion().getInfuseList().containsKey(item.itemID);
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
		return "mcke.darkinfuser";
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
 	

	  
	  public boolean hashmapContains(ItemStack stack)
	  {
		  //if(DarkInfuserFunctions.canInfuseBlock.containsKey(stack))
			//  return true;
		  if(DarkInfuserFunctions.infusion().getInfuseList().containsKey(stack.getItem().itemID))
			  return true;
		  else
			  return false;
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
		//if(i == 0 && j == 4)
			//return itemstack != null && DarkInfuserFunctions.canInfuseBlock.containsKey(itemstack.getItem());
		if(i == 0 && j == 4)
			return itemstack != null && DarkInfuserFunctions.infusion().getInfuseList().containsKey(itemstack.getItem().itemID);
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