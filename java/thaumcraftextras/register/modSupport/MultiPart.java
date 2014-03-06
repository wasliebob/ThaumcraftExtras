package thaumcraftextras.register.modSupport;

import net.minecraft.block.Block;
import thaumcraft.common.config.ConfigBlocks;
import thaumcraftextras.main.Config;
import thaumcraftextras.register.BlockRegister;
import thaumcraftextras.register.modSupport.ChickenBonesMods.MultiPartBlock;
import thaumcraftextras.register.modSupport.ChickenBonesMods.MultipartTube;
import codechicken.microblock.BlockMicroMaterial;
import codechicken.microblock.MicroMaterialRegistry;
import cpw.mods.fml.common.Loader;

public class MultiPart {
	
	public static void init()
	{
		if(Loader.isModLoaded("ForgeMultipart"))
		{
			load();
		}
	}
	
	public static void load()
	{
		registerMultipart(BlockRegister.darkSilverwood, 0);
		registerMultipart(BlockRegister.darkSilverwoodLog, 0);
		registerMultipart(BlockRegister.ignisFuelBlock, 0);
		
		for(int i = 0; i <= 15; i++)
		registerMultipart(BlockRegister.lightBlock, i);
		
		if(Config.multipartTC4 == true){

		}

		new MultiPartBlock(ConfigBlocks.blockTube, MultipartTube.class, ConfigBlocks.blockTube.getUnlocalizedName()).init();
	}

	private static void registerMultipart(Block block, int meta) 
	{
		MicroMaterialRegistry.registerMaterial(new BlockMicroMaterial(block, meta), block.getUnlocalizedName() + (meta == 0 ? "" : "_" + meta));
	}
}