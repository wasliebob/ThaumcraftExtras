package thaumcraftextras.blocks.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import thaumcraftextras.api.functions.ChargerFunctions;
import thaumcraftextras.api.functions.DarkInfuserFunctions;
import thaumcraftextras.blocks.container.slots.SlotDarkInfuser;
import thaumcraftextras.blocks.tileEntity.TileEntityDarkInfuser;

public class ContainerDarkInfuser extends Container {
		int x, y;
        
		public static TileEntityDarkInfuser tile;
        
        public ContainerDarkInfuser(TileEntityDarkInfuser tileI, InventoryPlayer inventory) {
                super();
                this.tile = tileI;
                this.addSlotToContainer(new Slot(tile, 0, 56, 17));
                this.addSlotToContainer(new Slot(tile, 1, 56, 53));
                this.addSlotToContainer(new SlotDarkInfuser(tile, 2, 116, 35));

                int i;

                for (i = 0; i < 3; ++i)
                {
                    for (int j = 0; j < 9; ++j)
                    {
                        this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
                    }
                }

                for (i = 0; i < 9; ++i)
                {
                    this.addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 142));
                }
        }
        
        @Override
        public boolean canInteractWith(EntityPlayer entityplayer) {
                return tile.isUseableByPlayer(entityplayer);
        }
        
        @Override
        public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
                ItemStack stack = null;
                Slot slotObject = (Slot) inventorySlots.get(slot);
                Slot slot0 = (Slot) inventorySlots.get(0);
                Slot slot1 = (Slot) inventorySlots.get(1);

                if (slotObject != null && slotObject.getHasStack()) 
                {
                        ItemStack stackInSlot = slotObject.getStack();
                        stack = stackInSlot.copy();

                        if (slot < 3)
                        {
                                if (!this.mergeItemStack(stackInSlot, 3, 37, true)) 
                                {
                                        return null;
                                }
                        }
                        else if(doesItemFitInSlot(stackInSlot) && !this.mergeItemStack(stackInSlot, getStartSlot(stackInSlot), getEndSlot(stackInSlot), false))
                        {
                                return null;
                        }
                        
                        if (stackInSlot.stackSize == 0) 
                        {
                                slotObject.putStack(null);
                        }
                        else 
                        {
                                slotObject.onSlotChanged();
                        }

                        if (stackInSlot.stackSize == stack.stackSize) 
                        {
                                return null;
                        }
                        slotObject.onPickupFromSlot(player, stackInSlot);
                }
                return stack;
        }

        public int getStartSlot(ItemStack stack)
        {
        	//if(DarkInfuserFunctions.infusion().canInfuse.containsKey(stack.getItem().itemID))
        		if(DarkInfuserFunctions.infusion().getInfuseList().containsKey(stack.itemID))
        			return 0;
        	//else if(DarkInfuserFunctions.canInfuseBlock.containsKey(item))
        		//return 0;
        	else if(ChargerFunctions.isChargeAble.contains(stack.getItem()))
        		return 1;
        	else
        		return 0;
        }
        
        public int getEndSlot(ItemStack stack)
        {
    		if(DarkInfuserFunctions.infusion().getInfuseList().containsKey(stack.itemID))
        		return 1;
        	//else if(DarkInfuserFunctions.canInfuseBlock.containsKey(item))
        	//	return 1;
        	else if(ChargerFunctions.isChargeAble.contains(stack.getItem()))
        		return 2;
        	else
        		return 2;
        }
        
        public boolean doesItemFitInSlot(ItemStack stack)
        {
    		if(DarkInfuserFunctions.infusion().getInfuseList().containsKey(stack.itemID))
        		return true;
        	//else if(DarkInfuserFunctions.canInfuseBlock.containsKey(item))
        	//	return true;
        	else if(ChargerFunctions.isChargeAble.contains(stack.getItem()))
        		return true;
        	else
        		return false;
        }
}