package thaumcraftextras.blocks.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import thaumcraftextras.blocks.tileEntity.TileEntityTeleporter;

public class ContainerTeleporter extends Container {

        public TileEntityTeleporter tp;

        public ContainerTeleporter(TileEntityTeleporter teleporter, InventoryPlayer inventory) {
                super();
                this.tp = teleporter;
                addSlotToContainer(new Slot(teleporter, 0, 80, 15));

        }

        @Override
        public boolean canInteractWith(EntityPlayer entityplayer) {
                return tp.isUseableByPlayer(entityplayer);
        }

        @Override
        public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {
        ItemStack var3 = null;
        Slot var4 = (Slot)inventorySlots.get(par2);

        if (var4 != null && var4.getHasStack()) {
                ItemStack var5 = var4.getStack();

            var3 = var5.copy();

            if (par2 < 1) {
                    if(!mergeItemStack(var5, 1, 37, false))
                            return null;
            } else if(!mergeItemStack(var5, 0, 1, false))
                    return null;

            if (var5.stackSize == 0)
                var4.putStack((ItemStack)null);
            else
                var4.onSlotChanged();

            if (var5.stackSize == var3.stackSize)
                return null;

            var4.onPickupFromSlot(par1EntityPlayer, var5);
        }

        return var3;
        }
}