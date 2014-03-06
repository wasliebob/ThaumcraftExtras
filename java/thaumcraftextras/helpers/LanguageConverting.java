package thaumcraftextras.helpers;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class LanguageConverting {

	public static void load()
	{
		  String[] lang = {
              "en_US", "de_DE"};
		  
		for(String locale : lang)
            LanguageRegistry.instance().loadLocalization("/assets/thaumcraftextras/lang/" + locale + ".lang", locale, false);
	}
}
