package thaumcraftextras.register;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class CreativeTabRegister {

	public static void load()
	{
        LanguageRegistry.instance().addStringLocalization("itemGroup.tabMain", "en_US", "Thaumcraft Extras");
        LanguageRegistry.instance().addStringLocalization("itemGroup.tabMain", "nl_NL", "Thaumcraft Extras");
	}
	
	
    public static CreativeTabs tabMain = new CreativeTabs("tabMain") {
        public ItemStack getIconItemStack() {
               return new ItemStack(BlockRegister.researchBlock, 1, 0);}};  
}
