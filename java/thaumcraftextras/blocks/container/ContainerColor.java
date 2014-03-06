package thaumcraftextras.blocks.container;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import thaumcraftextras.blocks.gui.GuiColor;
import thaumcraftextras.blocks.tileEntity.TileEntityColor;
import thaumcraftextras.register.BlockRegister;
import thaumcraftextras.register.InfusionRegister;
import thaumcraftextras.register.ItemRegister;

public class ContainerColor extends Container {
		int x, y;
        public static TileEntityColor tile;
        public static boolean bool = false;
        public ContainerColor(TileEntityColor tileI, InventoryPlayer inventory) {
                super();
                this.tile = tileI;

        }

        @Override
        public boolean canInteractWith(EntityPlayer entityplayer) {
                return tile.isUseableByPlayer(entityplayer);
        }

        @Override
        public ItemStack slotClick(int id, int x, int y, EntityPlayer player)
        {
        	
            	return null;
        }
        	
        @Override
        public ItemStack transferStackInSlot(EntityPlayer player, int par2) {
        ItemStack var3 = null;
        this.slotClick(1, 70, 60, player);
        return var3;
        }
}