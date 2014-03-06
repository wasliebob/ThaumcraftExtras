package thaumcraftextras.register;

import net.minecraft.block.Block;
import thaumcraft.common.config.ConfigBlocks;
import thaumcraftextras.api.blocks.DarkBlock;
import thaumcraftextras.blocks.BlockHidden;
import thaumcraftextras.blocks.BlockLog;
import thaumcraftextras.blocks.BlockOpen;
import thaumcraftextras.blocks.BlockWood;
import thaumcraftextras.blocks.LightItemBlock;
import thaumcraftextras.blocks.TCEBlock;
import thaumcraftextras.blocks.TCEBlockAir;
import thaumcraftextras.blocks.TCEBlockEarth;
import thaumcraftextras.blocks.TCEBlockEnder;
import thaumcraftextras.blocks.TCEBlockFire;
import thaumcraftextras.blocks.TCEBlockLight;
import thaumcraftextras.blocks.TCEBlockResearch;
import thaumcraftextras.blocks.TCEBlockWater;
import thaumcraftextras.blocks.TCECactus;
import thaumcraftextras.blocks.TCEWardedBlock;
import thaumcraftextras.blocks.TCEWardedCarpet;
import thaumcraftextras.blocks.TCEWardedGlass;
import thaumcraftextras.blocks.TCEWardedPilar;
import thaumcraftextras.blocks.TCEWardedSlab;
import thaumcraftextras.blocks.TCEWardedWall;
import thaumcraftextras.blocks.WardedItemBlock;
import thaumcraftextras.blocks.WardedItemCarpet;
import thaumcraftextras.blocks.WardedItemGlass;
import thaumcraftextras.blocks.WardedItemSlab;
import thaumcraftextras.blocks.WardedItemWall;
import thaumcraftextras.helpers.MainHelper;
import thaumcraftextras.lib.TCELocalization;
import thaumcraftextras.main.Config;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class BlockRegister {

	public static void load()
	{

		researchBlock = new TCEBlockResearch(Config.researchBlockId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.ResearchBlockTexture);
		GameRegistry.registerBlock(researchBlock, "ResearchBlock");
		LanguageRegistry.addName(researchBlock, TCELocalization.ResearchBlock);
		
		fireBlock = new TCEBlockFire(Config.fireBlockId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.FireBlockTexture);
		GameRegistry.registerBlock(fireBlock, "FireBlock");
		LanguageRegistry.addName(fireBlock, TCELocalization.FireBlock);
		
		airBlock = new TCEBlockAir(Config.airBlockId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.AirBlockTexture);
		GameRegistry.registerBlock(airBlock, "AirBlock");
		LanguageRegistry.addName(airBlock, TCELocalization.AirBlock);
		
		earthBlock = new TCEBlockEarth(Config.earthBlockId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.EarthBlockTexture);
		GameRegistry.registerBlock(earthBlock, "EarthBlock");
		LanguageRegistry.addName(earthBlock, TCELocalization.EarthBlock);
		
		waterBlock = new TCEBlockWater(Config.waterBlockId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.WaterBlockTexture);
		GameRegistry.registerBlock(waterBlock, "WaterBlock");
		LanguageRegistry.addName(waterBlock, TCELocalization.WaterBlock);
		
		lightBlock = new TCEBlockLight(Config.lightBlockId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.LightBlockTexture);
		GameRegistry.registerBlock(lightBlock, LightItemBlock.class, (lightBlock.getUnlocalizedName()).substring(5));
		LanguageRegistry.addName(lightBlock, TCELocalization.LightBlock);
		
		cactusBlock = new TCECactus(Config.cactusBlockId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.cactusBlockTexture);
		GameRegistry.registerBlock(cactusBlock, "CactusBlock");
		LanguageRegistry.addName(cactusBlock, TCELocalization.CactusBlock);
		
		enderBlock = new TCEBlockEnder(Config.enderBlockId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.EnderBlockTexture);
		GameRegistry.registerBlock(enderBlock, "EnderBlock");
		LanguageRegistry.addName(enderBlock, TCELocalization.EnderBlock);
		
		ignisFuelBlock = new TCEBlock(Config.ignisFuelBlockId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.IgnisFuelBlockTexture);
		GameRegistry.registerBlock(ignisFuelBlock, "IgnisFuelBlock");
		LanguageRegistry.addName(ignisFuelBlock, TCELocalization.IgnisFuelBlock);
			
		wardedGlass = new TCEWardedGlass(Config.wardedGlassId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.WardedGlassTexture);
		GameRegistry.registerBlock(wardedGlass, WardedItemGlass.class, (wardedGlass.getUnlocalizedName()).substring(5));
		LanguageRegistry.addName(wardedGlass, TCELocalization.WardedGlass);
		
		wardedBlock = new TCEWardedBlock(Config.wardedBlockId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.WardedBlockTexture);
		GameRegistry.registerBlock(wardedBlock, WardedItemBlock.class, (wardedBlock.getUnlocalizedName()).substring(5));
		LanguageRegistry.addName(wardedBlock, TCELocalization.WardedBlock);
		
		wardedCarpet = new TCEWardedCarpet(Config.wardedCarpetId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.WardedCarpetTexture);
		GameRegistry.registerBlock(wardedCarpet, WardedItemCarpet.class, (wardedCarpet.getUnlocalizedName()).substring(5));
		LanguageRegistry.addName(wardedCarpet, TCELocalization.WardedCarpet);
	
		wardedSlab = new TCEWardedSlab(Config.wardedSlabId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.WardedSlabTexture);
		GameRegistry.registerBlock(wardedSlab, WardedItemSlab.class, (wardedSlab.getUnlocalizedName()).substring(5));
		LanguageRegistry.addName(wardedSlab, TCELocalization.WardedSlab);
		
		wardedWall = new TCEWardedWall(Config.wardedWallId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.WardedWallTexture);
		GameRegistry.registerBlock(wardedWall, WardedItemWall.class, (wardedWall.getUnlocalizedName()).substring(5));
		LanguageRegistry.addName(wardedWall, TCELocalization.WardedWall);
		
		wardedPilar = new TCEWardedPilar(Config.wardedPillarId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.WardedPilarTexture);
		GameRegistry.registerBlock(wardedPilar, WardedItemWall.class, (wardedPilar.getUnlocalizedName()).substring(5));
		LanguageRegistry.addName(wardedPilar, TCELocalization.WardedPilar);
		
		//wardedCover = new TCEWardedCover(Config.wardedCoverId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.WardedCoverTexture);
		//GameRegistry.registerBlock(wardedCover, WardedItemCover.class, (wardedCover.getUnlocalizedName()).substring(5));
		//LanguageRegistry.addName(wardedCover, TCELocalization.WardedCover);
		
		hiddenWarded = new BlockHidden(Config.hiddenWardedId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.HiddenWardedTexture);
		GameRegistry.registerBlock(hiddenWarded, "hiddenWarded");
		LanguageRegistry.addName(hiddenWarded, TCELocalization.HiddenWarded);
		
		openWarded = new BlockOpen(Config.openWardedId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.OpenWardedTexture);
		GameRegistry.registerBlock(openWarded, "openWarded");
		LanguageRegistry.addName(openWarded, TCELocalization.OpenWarded);
		
		darkSilverwood = new BlockWood(Config.darkSilverwoodId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.darkSilverwoodTexture);
		GameRegistry.registerBlock(darkSilverwood, "darkSilverwood");
		LanguageRegistry.addName(darkSilverwood, TCELocalization.darkSilverwood);
		
		darkSilverwoodLog = new BlockLog(Config.darkSilverwoodLogId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.darkSilverwoodLogTexture);
		GameRegistry.registerBlock(darkSilverwoodLog, "darkSilverwoodLog");
		LanguageRegistry.addName(darkSilverwoodLog, TCELocalization.darkSilverwoodLog);
		
		
		addDarkBlocks();

	}
	
	public static void addDarkBlocks()
	{
	darkBrick = new DarkBlock(Config.darkBrickId, "Brick", Block.stoneBrick);
	GameRegistry.registerBlock(darkBrick, "darkbrick");

	darkAmber = new DarkBlock(Config.darkAmberId, "Amber", ConfigBlocks.blockCosmeticOpaque);
	GameRegistry.registerBlock(darkAmber, "darkamber");
	}
	
	public static void recipe()
	{
	}
	
	public static void oreDictionary()
	{
		
	}
	public static Block researchBlock;
	public static Block fireBlock;
	public static Block airBlock;
	public static Block waterBlock;
	public static Block earthBlock;
	public static Block lightBlock;
	public static Block cactusBlock;
	public static Block enderBlock;
	public static Block ignisFuelBlock;
	public static Block teleporterBlock;
	public static Block teslaBlock;
	public static Block wardedGlass;
	public static Block wardedBlock;
	public static Block wardedCarpet;
	public static Block wardedSlab;
	public static Block wardedWall;
	public static Block wardedPilar;
	//public static Block wardedCover;
	public static Block hiddenWarded;
	public static Block openWarded;
	public static Block darkSilverwood;
	public static Block darkSilverwoodLog;

	public static Block colorBlock;
	
	public static DarkBlock darkBrick;
	public static DarkBlock darkAmber;
}
