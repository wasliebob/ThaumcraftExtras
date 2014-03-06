package thaumcraftextras.api.energy;

import net.minecraft.item.ItemStack;

public interface IToolMCKE {

	void setAmountOfEnergy(ItemStack stack, int amount);
	
	int getAmountOfEnergy(ItemStack stack);
	
	void setCostForMode(ItemStack stack, int modeId, int cost);
	
	void getCostForMode(ItemStack stack, int modeId);
	
	
}
