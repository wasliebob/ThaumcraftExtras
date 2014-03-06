package thaumcraftextras.helpers;

import cpw.mods.fml.common.Loader;

public class ModSupportHelper {

	public static boolean isICEnabled()
	{
		if(Loader.isModLoaded("IC2"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
