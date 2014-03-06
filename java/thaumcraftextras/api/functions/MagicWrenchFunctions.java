package thaumcraftextras.api.functions;

import java.util.HashMap;
import java.util.Map;

public class MagicWrenchFunctions {

	public static Map<Integer, Boolean> canUseWrench = new HashMap();

	public static void addItem(int id, boolean value)
	{
		canUseWrench.put(id, value);
	}
	
	
	public static void removeItem(int id)
	{
		canUseWrench.remove(id);
	}
}
