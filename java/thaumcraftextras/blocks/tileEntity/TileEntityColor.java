package thaumcraftextras.blocks.tileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityColor extends TileEntity implements IInventory
{
	private ItemStack ItemStacks[];
	
	private boolean isActive;


	public int front;

	public TileEntityColor()
	{	
      ItemStacks = new ItemStack[3];
	}

	@Override
	public int getSizeInventory() {
		return 0;
	}
	
	@Override
	public ItemStack getStackInSlot(int i) {
			return null;
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		return null;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) 
	{		
	}

	@Override
	public String getInvName() {
		return null;
	}

	@Override
	public boolean isInvNameLocalized() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 0;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return true;
	}

	@Override
	public void openChest() {
		
	}

	@Override
	public void closeChest() {
		
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return false;
	}
	
	public static String color;
	
	
	public static void setColor(String colorN)
	{
		color = colorN;
	}
	
	public String getColor(World world, int x, int y, int z)
	{
	     TileEntityColor tile = (TileEntityColor)world.getBlockTileEntity(x, y, z);
	     if(tile.color == "red")
	     {
	    	 return tile.color;
	     }
	     return tile.color;
	}
	   @Override
	   public void writeToNBT(NBTTagCompound tag)
	   {
		   super.writeToNBT(tag);
		   tag.setString("1", color);
	   }

	   @Override
	   public void readFromNBT(NBTTagCompound tag)
	   {
		  super.readFromNBT(tag);
	      this.color = tag.getString("1");
	   }
}