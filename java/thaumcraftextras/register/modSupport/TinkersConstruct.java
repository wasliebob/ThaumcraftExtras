package thaumcraftextras.register.modSupport;

import cpw.mods.fml.common.Loader;

public class TinkersConstruct {
	public static void isInstalled()
	{
		if(Loader.isModLoaded("TinkersConstruct"))
		load();
	}
	
	public static void load()
	{
	items();
	blocks();
	recipes();
	}
	
	public static void items()
	{
	}
	
	public static void blocks()
	{
	
	}
	
	public static void recipes()
	{
		
	}
}
