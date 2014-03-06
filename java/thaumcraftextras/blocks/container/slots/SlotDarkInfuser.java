package thaumcraftextras.blocks.container.slots;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import thaumcraftextras.blocks.tileEntity.TileEntityDarkInfuser;

public class SlotDarkInfuser extends Slot {

        TileEntityDarkInfuser tile;

        public SlotDarkInfuser(TileEntityDarkInfuser tileI, int x, int y, int z) {
                super(tileI, x, y, z);
                this.tile = tileI;
        }

        @Override
        public boolean isItemValid(ItemStack par1ItemStack) {
        	return false;
        }

        @Override
        public int getSlotStackLimit() {
                return 64;
        }

        @Override
        public boolean canTakeStack(EntityPlayer par1EntityPlayer) {
        	return true;
        }
}