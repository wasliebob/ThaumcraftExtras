package thaumcraftextras.register.modSupport;

import net.minecraftforge.oredict.OreDictionary;
import thaumcraftextras.api.items.Nugget;
import thaumcraftextras.main.Config;
import thaumcraftextras.register.modSupport.forestry.bees.BeeManager;
import cpw.mods.fml.common.Loader;

public class Forestry {
	public static void isInstalled()
	{
		if(Loader.isModLoaded("Forestry"))
		load();
	}
	
	public static void load()
	{
	items();
	bees();
	blocks();
	}
	
	public static void items()
	{
		if(OreDictionary.getOres("ingotDraconic").size() > 0)
			draconicNugget = new Nugget(Config.draconicNuggetId, "Draconic", "ingotDraconic", 0x990000, true, 0, null);
		
		if(OreDictionary.getOres("ingotReinforced").size() > 0)
			reinforcedNugget = new Nugget(Config.reinforcedNuggetId, "Reinforced", "ingotReinforced", 0xCCCC99, true, 0, null);
		
		//comb1 = new TCEItemComb(1122, "Dark Thaumium", 0xCC00CC, new ItemStack(ItemRegister.darkThaumiumNugget), OreDictionary.getOres("dropHoney").get(0), 1.0F);
		/*
		if(OreDictionary.getOres("gemSunstone").size() > 0)
			sunstoneNugget = new Nugget(Config.sunstoneNuggetId, "Sunstone", "gemSunstone", 0xFF6600, true, 0, null);
	*/
	}
	
	public static void bees()
	{
		BeeManager.setupController();
	}
	
	public static void blocks()
	{
	
	}
	
	public static void recipes()
	{
		
	}
	public static Nugget draconicNugget;
	public static Nugget reinforcedNugget;	
	public static Nugget sunstoneNugget;	
	//public static TCEItemComb comb1;
	
}
