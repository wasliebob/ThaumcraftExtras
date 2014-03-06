package thaumcraftextras.blocks.tileEntity;

import thaumcraftextras.blocks.gui.GuiInfuseInfo;
import thaumcraftextras.register.BlockRegister;
import thaumcraftextras.register.InfusionRegister;
import thaumcraftextras.register.ItemRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityInfusion extends TileEntity implements IInventory
{
        private ItemStack ItemStacks[];


        private boolean isActive;


        public int front;

        public TileEntityInfusion()
        {        
      ItemStacks = new ItemStack[3];
        }

        @Override
        public int getSizeInventory() {
                return 5;
        }
        
        @Override
        public ItemStack getStackInSlot(int i) {
                if(i == 1)
                        return new ItemStack(BlockRegister.lightBlock);
                if(i == 2)
                        return new ItemStack(InfusionRegister.lightShard);
                if(i == 3)
                        return new ItemStack(ItemRegister.exchangeFoci);
                if(i == 4)
                        return new ItemStack(BlockRegister.researchBlock);
                if(i == 5)
                        return new ItemStack(ItemRegister.xpExtractor);
                else
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
}