package thaumcraftextras.api.energy;

import net.minecraft.item.ItemStack;

public interface IMagicWrenchable {

	public boolean hasDamageValue(ItemStack stack);
	
	public void decreaseEnergy(ItemStack stack, int amount);
	
}
