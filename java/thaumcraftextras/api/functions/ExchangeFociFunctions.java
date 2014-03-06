package thaumcraftextras.api.functions;

import java.util.HashMap;
import java.util.Map;

public class ExchangeFociFunctions {
    public static Map<Integer, Integer> canBeExchange = new HashMap();


    /**
     * 
     * @param blockId
     * Id of the block that you want to be able to get exchanged
     * 
     * @param maxExchange
     * The max metadata the block can be exchanged to before setting the meta back to 0
     */
	public static void add(int blockId, int maxExchange)
	{
		canBeExchange.put(blockId, maxExchange);
	}
	
	public static void remove(int blockId)
	{
		canBeExchange.remove(blockId);
	}
}
