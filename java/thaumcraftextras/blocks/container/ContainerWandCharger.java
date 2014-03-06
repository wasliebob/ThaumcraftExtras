package thaumcraftextras.blocks.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import thaumcraft.common.items.wands.ItemWandCasting;
import thaumcraftextras.api.functions.ChargerFunctions;
import thaumcraftextras.blocks.tileEntity.TileEntityWandCharger;

public class ContainerWandCharger extends Container {
		int x, y;
        
		public static TileEntityWandCharger tile;
        
        public ContainerWandCharger(TileEntityWandCharger tileI, InventoryPlayer inventory) {
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
                Slot slot0 = (Slot) inventorySlots.get(0);
                Slot slot1 = (Slot) inventorySlots.get(1);

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
        	if(item instanceof ItemWandCasting)
        		return 0;
        	else if(ChargerFunctions.isChargeAble.contains(item))
        		return 1;
        	else
        		return 0;
        }
        
        public int getEndSlot(Item item)
        {
        	if(item instanceof ItemWandCasting)
        		return 1;
        	else if(ChargerFunctions.isChargeAble.contains(item))
        		return 2;
        	else
        		return 2;
        }
        
        public boolean doesItemFitInSlot(Item item)
        {
        	if(item instanceof ItemWandCasting)
        		return true;
        	else if(ChargerFunctions.isChargeAble.contains(item))
        		return true;
        	else
        		return false;
        }
}