package thaumcraftextras.api.functions;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.item.Item;

public class ExchangerFunctions {

	//public static ArrayList<Item> canExchange = new ArrayList<Item>();
	public static Map<Item, Integer> canExchange = new HashMap();
	

	/**
	 * @param item
	 * new item to be added to work with the exchanger.
	 * 
	 * @param meta
	 * the max metadata/damage value the item that is going to be added to the exchanger has.
	 */
	
	public static void addItem(Item item, int meta)
	{
		canExchange.put(item, meta);
	}
	
	
	/**
	 * @param item
	 * the item to be removed from the exchanger.
	 */
	
	public static void removeItem(Item item)
	{
		canExchange.remove(item);
	}
}
