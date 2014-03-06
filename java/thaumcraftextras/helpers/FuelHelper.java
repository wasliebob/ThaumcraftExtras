package thaumcraftextras.helpers;
import thaumcraft.common.config.ConfigItems;
import thaumcraftextras.register.BlockRegister;
import thaumcraftextras.register.ItemRegister;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class FuelHelper implements IFuelHandler {
	public int getBurnTime(ItemStack fuel){
		if(fuel.itemID == ItemRegister.ignisFuel.itemID)
			return 3200;
		else if(fuel.itemID == ConfigItems.itemShard.itemID)
			return 1700;
		else if(fuel.itemID == BlockRegister.ignisFuelBlock.blockID)
			return 28800;
		else
			return 0;
}
}