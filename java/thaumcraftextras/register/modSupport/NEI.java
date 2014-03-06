package thaumcraftextras.register.modSupport;

import thaumcraftextras.blocks.gui.GuiCharger;
import thaumcraftextras.blocks.gui.GuiDarkInfuser;
import thaumcraftextras.register.modSupport.ChickenBonesMods.recipes.ChargerRecipeHandler;
import thaumcraftextras.register.modSupport.ChickenBonesMods.recipes.InfuserRecipeHandler;
import codechicken.nei.api.API;
import cpw.mods.fml.common.Loader;

public class NEI {

	public static void init()
	{
		if(Loader.isModLoaded("NotEnoughItems"))
		{
			load();
		}
	}
	
	public static void load()
	{
		//API.registerGuiOverlay(InfuserRecipeHandler.guiclass, "infuser.gui");
		API.registerGuiOverlay(GuiDarkInfuser.class, "infuser.gui");
		API.registerRecipeHandler(new InfuserRecipeHandler());
		API.registerUsageHandler(new InfuserRecipeHandler());
		
		API.registerGuiOverlay(GuiCharger.class, "charger.gui");
		API.registerRecipeHandler(new ChargerRecipeHandler());
		API.registerUsageHandler(new ChargerRecipeHandler());
	}
}
