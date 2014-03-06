package thaumcraftextras.blocks.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import thaumcraftextras.api.functions.ChargerFunctions;
import thaumcraftextras.blocks.tileEntity.TileEntityCharger;

public class ContainerCharger extends Container {
		int x, y;
        
		public static TileEntityCharger tile;
        Slot slot;
        public ContainerCharger(TileEntityCharger tileI, InventoryPlayer inventory) {
                super();
                this.tile = tileI;
                
                this.addSlotToContainer(new Slot(tile, 0, 79, 17));
                this.addSlotToContainer(new Slot(tile, 1, 79, 53));
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
                
                if (slotObject != null && slotObject.getHasStack()) 
                {
                        ItemStack stackInSlot = slotObject.getStack();
                        stack = stackInSlot.copy();

                        if (slot < 2)
                        {
                                if (!this.mergeItemStack(stackInSlot, 2, 37, true)) 
                                {
                                        return null;
                                }
                        }
                        else if(doesItemFitInSlot(stackInSlot.getItem()) && !this.mergeItemStack(stackInSlot, getStartSlot(stackInSlot.getItem()), getEndSlot(stackInSlot.getItem()), false))
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

        public int getStartSlot(Item item)
        {
        	if(ChargerFunctions.isChargeAble.contains(item))
        		return 0;
        	else if(ChargerFunctions.isFuel.containsKey(item))
        		return 1;
        	else
        		return 0;
        }
        
        public int getEndSlot(Item item)
        {
        	if(ChargerFunctions.isChargeAble.contains(item))
        		return 1;
        	else if(ChargerFunctions.isFuel.containsKey(item))
        		return 2;
        	else
        		return 2;
        }
        
        public boolean doesItemFitInSlot(Item item)
        {
        	if(ChargerFunctions.isChargeAble.contains(item))
        		return true;
        	else if(ChargerFunctions.isFuel.containsKey(item))
        		return true;
        	else
        		return false;
        }
}