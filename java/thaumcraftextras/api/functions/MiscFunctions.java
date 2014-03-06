package thaumcraftextras.api.functions;

import java.util.ArrayList;

import net.minecraft.block.Block;

public class MiscFunctions {
    public static ArrayList<Integer> canBeCleaned = new ArrayList<Integer>();

    public static void addToCleaner(Block block)
    {
    	canBeCleaned.add(block.blockID);
    }
}
