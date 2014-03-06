package thaumcraftextras.blocks.tileEntity;

import java.util.HashMap;
import java.util.Map;

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
import net.minecraftforge.common.ForgeDirection;
import thaumcraft.api.ThaumcraftApiHelper;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.aspects.IAspectContainer;
import thaumcraft.api.aspects.IEssentiaTransport;
import thaumcraftextras.api.functions.ChargerFunctions;
import cpw.mods.fml.common.network.PacketDispatcher;

public class TileEntityCharger extends TileEntity implements ISidedInventory, IAspectContainer, IEssentiaTransport
{
    
	ItemStack ItemStacks[]; 
    private static final int[] slots_top = new int[] {0};
    private static final int[] slots_bottom = new int[] {2, 1};
    private static final int[] slots_sides = new int[] {1};
    private static int chargeTime;
    
    public static Map<Aspect, Integer> map = new HashMap();
    public static Aspect asp = Aspect.MAGIC;
    int x, y, z;
    
    public TileEntityCharger()
    {
    	ItemStacks = new ItemStack[2];
    	chargeTime = 60;
        //map.put(Aspect.FIRE, 1);
        map.put(Aspect.MAGIC, 1);
        //map.put(Aspect.ENERGY, 1);
        //map.put(Aspect.TREE, 1);
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
    			Item inChargeSlot = getStackInSlot(0).getItem();
    			Item inFuelSlot = getStackInSlot(1).getItem();
    			
    			ItemStack inChargeSlotStack = getStackInSlot(0);
    			
    			if(ChargerFunctions.isFuel.containsKey(inFuelSlot) && ChargerFunctions.isChargeAble.contains(inChargeSlot) && inChargeSlot.getDamage(inChargeSlotStack) <= inChargeSlot.getMaxDamage())
    			{
    				if(inChargeSlot.getDamage(inChargeSlotStack) - getValueToAdd(inFuelSlot) >= 0)
    				{
    				if(chargeTime > 0)
    					chargeTime--;
    				
    				if(chargeTime <= 0)
    				{
    				Item item;
    				item = inChargeSlot;
    				int getDamage = item.getDamage(inChargeSlotStack);
    			
    				item.setDamage(inChargeSlotStack, getDamage - getValueToAdd(inFuelSlot));
    				
    				if(ItemStacks[1].stackSize > 1)
    				{
    				ItemStacks[1] = new ItemStack(inFuelSlot, ItemStacks[1].stackSize - 1);
        			chargeTime = 60;
    				}
    				else if(ItemStacks[1].stackSize <= 1)
    				{
    				ItemStacks[1] = null;
    				}
    				
    				worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
    				}
    			}
    		}
    	}
    		/*
    		else if(getStackInSlot(0) != null && getStackInSlot(1) == null)
    		{
    			if(getStackInSlot(0).getItem().getDamage(getStackInSlot(0)) > 0 && getStackInSlot(0).getItem().getDamage(getStackInSlot(0)) <= getStackInSlot(0).getItem().getMaxDamage())
    			{
    			findAspect();
    			TileEntity essentia = super.worldObj.getBlockTileEntity(x, y, z);
    			if(essentia != null && (essentia instanceof TileJarFillable))
    			{
    				if(checkEssentia((TileJarFillable)essentia))
    				{
    					Item inSlot = getStackInSlot(0).getItem();
    					ItemStack inStack = getStackInSlot(0);
    					int getDamage = inSlot.getDamage(inStack);
    					int amount = 1;
        				inSlot.setDamage(inStack, getDamage - amount);
    				}
    			}
    			}
    		}
    		*/
    		else if(getStackInSlot(0) != null && getStackInSlot(1) == null)
    		{
    			if(getStackInSlot(0).getItem().getDamage(getStackInSlot(0)) > 0 && getStackInSlot(0).getItem().getDamage(getStackInSlot(0)) <= getStackInSlot(0).getItem().getMaxDamage())
    			{
				Item inSlot = getStackInSlot(0).getItem();
				ItemStack inStack = getStackInSlot(0);
				int getDamage = inSlot.getDamage(inStack);

				inSlot.setDamage(inStack, getDamage - drawFromTube());
    			}
    		}
    	}
    }
    
    
    public int drawFromTube()
    {
    	 ForgeDirection orientation = getOrientation();
         TileEntity tile = ThaumcraftApiHelper.getConnectableTile(worldObj, xCoord, yCoord, zCoord, orientation);

         if (tile != null) {
                 IEssentiaTransport ic = (IEssentiaTransport) tile;

                 if (!ic.canOutputTo(orientation.getOpposite()))
                         return 0;

                 for(Aspect aspect : map.keySet())
                		if(ic.getSuctionType(orientation.getOpposite()) == aspect && ic.getSuctionAmount(orientation.getOpposite()) < getSuctionAmount(orientation) && ic.takeVis(aspect, 1) == 1)
                			return map.get(aspect);
                 return 0;
         }
         return 0;
    }
    
    ForgeDirection getOrientation() 
    {
        return ForgeDirection.UP;
    }
    
    
    /*
    private boolean checkEssentia(TileJarFillable jar) {
          if(jar.doesContainerContainAmount(Aspect.FIRE, 1))
          {
 				x = ((TileEntity) (jar)).xCoord;
                 y = ((TileEntity) (jar)).yCoord;
                 z = ((TileEntity) (jar)).zCoord;
                 if (!super.worldObj.isRemote) {
                         jar.takeFromContainer(Aspect.FIRE, 1);
                         super.worldObj
                                         .addBlockEvent(super.xCoord, super.yCoord,
                                                         super.zCoord,
                                                         Config.mckChargerId, 3, 0);
                 }
                 return true;
         
          }
          else if(jar.doesContainerContainAmount(Aspect.ENERGY, 1))
          {
         	 x = ((TileEntity) (jar)).xCoord;
              y = ((TileEntity) (jar)).yCoord;
              z = ((TileEntity) (jar)).zCoord;
              if (!super.worldObj.isRemote) {
                      jar.takeFromContainer(Aspect.ENERGY, 1);
                      super.worldObj
                                      .addBlockEvent(super.xCoord, super.yCoord,
                                                      super.zCoord,
                                                      Config.mckChargerId, 3, 0);
              }
              return true;
      
       }
          else if(jar.doesContainerContainAmount(Aspect.MAGIC, 1))
          {
         	 x = ((TileEntity) (jar)).xCoord;
              y = ((TileEntity) (jar)).yCoord;
              z = ((TileEntity) (jar)).zCoord;
              if (!super.worldObj.isRemote) {
                      jar.takeFromContainer(Aspect.MAGIC, 1);
                      super.worldObj
                                      .addBlockEvent(super.xCoord, super.yCoord,
                                                      super.zCoord,
                                                      Config.mckChargerId, 3, 0);
              }
              return true;
      
         }
         else 
         {
                 return false;
         }
 }

 public void findAspect() {
         if (x != 0x7fffffff) {
                 TileEntity ja = super.worldObj.getBlockTileEntity(x, y, z);
                 if (ja != null && (ja instanceof TileJarFillable)) {
                         if (checkEssentia((TileJarFillable) ja)) {
                                 return;
                         }
                         x = 0x7fffffff;
                 }
         }
         int xx = 0;
         int yy = 0;
         int zz = 0;
         for (int y = -5; y <= 5; y++) {
                 for (int bb = -5; bb <= 5; bb++) {
                         for (int cc = 1; cc < 6; cc++) {
                                 xx = super.xCoord;
                                 yy = super.yCoord + y;
                                 zz = super.zCoord;
                                 if (orientation.getOpposite().offsetX == 0) {
                                         xx += bb;
                                         zz += cc * orientation.getOpposite().offsetZ;
                                 } else {
                                         zz += bb;
                                         xx += cc * orientation.getOpposite().offsetX;
                                 }
                                 TileEntity te = super.worldObj.getBlockTileEntity(xx, yy,
                                                 zz);
                                 if (te != null && (te instanceof TileJarFillable)
                                                 && checkEssentia((TileJarFillable) te)) {
                                         return;
                                 }
                         }
                 }
         }
 }
	*/
	public int getValueToAdd(Item item)
	{
		  return ChargerFunctions.isFuel.get(item);
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
		if(ChargerFunctions.isChargeAble.contains(itemstack.getItem()) && i == 0)
			return true;
		else if(ChargerFunctions.isFuel.containsKey(itemstack.getItem()) && i == 1)
			return true;
		else
			return false;
	}

	@Override
    public AspectList getAspects() {
            ItemStack stack = ItemStacks[0];
            if(stack == null)
                    return null;
            else return new AspectList().add(Aspect.MAGIC, stack.getItemDamage());
    }

    @Override
    public void setAspects(AspectList paramAspectList) { }

    @Override
    public boolean doesContainerAccept(Aspect paramAspect) 
    {
            return false;
    }

    @Override
    public int addToContainer(Aspect paramAspect, int paramInt) {
            return 0;
    }

    @Override
    public boolean takeFromContainer(Aspect paramAspect, int paramInt) {
            return false;
    }

    @Override
    public boolean takeFromContainer(AspectList paramAspectList) {
            return false;
    }

    @Override
    public boolean doesContainerContainAmount(Aspect paramAspect, int paramInt) {
            return false;
    }

    @Override
    public boolean doesContainerContain(AspectList paramAspectList) {
            return false;
    }

    @Override
    public int containerContains(Aspect paramAspect) {
            return 0;
    }

    @Override
    public boolean isConnectable(ForgeDirection paramForgeDirection) {
            return paramForgeDirection == getOrientation();
    }

    @Override
    public boolean canInputFrom(ForgeDirection paramForgeDirection) {
            return false;
    }

    @Override
    public boolean canOutputTo(ForgeDirection paramForgeDirection) {
            return isConnectable(paramForgeDirection);
    }
    
    /*
    @Override
    public AspectList getSuction(ForgeDirection paramForgeDirection) {
            AspectList list = new AspectList();
            for(Aspect aspect : map.keySet())
                    list.add(aspect, 256 + map.get(aspect));

            return list;
    }
*/
    
    @Override
    public int takeVis(Aspect paramAspect, int paramInt) {
            return 0;
    }

    
    @Override
    public int getMinimumSuction() {
            return 0;
    }

    @Override
    public boolean renderExtendedTube() {
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
			return itemstack != null && ChargerFunctions.isChargeAble.contains(itemstack.getItem());
		else if(i == 1 && j == 4)
			return itemstack != null && ChargerFunctions.isFuel.containsKey(itemstack.getItem());
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
		if(i == 0 && j == 5 && itemstack.getItem().getDamage(itemstack) == 0)
			return true;
		if(i == 1 && j == 5)
			return true;
		else
			return false;
	}

	@Override
	public int addVis(Aspect arg0, int arg1) {
		return 0;
	}

	@Override
	public int getEssentiaAmount(ForgeDirection arg0) {
		return 0;
	}

	@Override
	public Aspect getEssentiaType(ForgeDirection dir) {
		return null;
	}

	@Override
	public int getSuctionAmount(ForgeDirection arg0) {
		return arg0 == getOrientation() ? 128 : 0;
	}

	@Override
	public Aspect getSuctionType(ForgeDirection arg0) {
		return arg0 == getOrientation() ? asp : null;
	}

	@Override
	public void setSuction(Aspect arg0, int arg1) {		
	}

}