package thaumcraftextras.register;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;
import thaumcraftextras.helpers.MainHelper;
import thaumcraftextras.helpers.ResearchHelper;
import thaumcraftextras.lib.ResearchAspect;
import thaumcraftextras.lib.TCELocalization;
import thaumcraftextras.main.Config;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ThaumonomiconRegister {

	public static void addEntryToThaumonomicon()
	{
		ResearchItem research;

		String text;
		String text2;
		
		text = "1";
		research = new ResearchHelper("Thaumcraft Extras", "TCE", new AspectList(), 0, 0, 30, new ItemStack(BlockRegister.researchBlock)).setRound().setAutoUnlock().registerResearchItem();
		research.setPages(new ResearchPage(text),new ResearchPage(ThaumcraftRecipeRegister.darkSilverwoodLog), new ResearchPage(ThaumcraftRecipeRegister.darkSilverwoodPlank));
		
		if(Config.pechTrade == true)
		{
		text = "1";
		research = new ResearchHelper("Essence of Greed", "TCE", ResearchAspect.pechTradeResearch, 2, -2, 3, new ItemStack(ItemRegister.pechTradeTier1)).setParents("Thaumcraft Extras").setSecondary().registerResearchItem();
		research.setPages(new ResearchPage(text), new ResearchPage(ThaumcraftRecipeRegister.pechTradeTier1), new ResearchPage(ThaumcraftRecipeRegister.pechTradeTier2));
		}
		
		if(Config.magicTrade == true)
		{
		text = "1";
		research = new ResearchHelper("Essence of Magic", "TCE", ResearchAspect.magicTradeResearch, 2, -4, 3, new ItemStack(ItemRegister.magicTradeTier1)).setParents("Essence of Greed").setSecondary().registerResearchItem();
		research.setPages(new ResearchPage(text), new ResearchPage(ThaumcraftRecipeRegister.magicTradeTier1), new ResearchPage(ThaumcraftRecipeRegister.magicTradeTier2));
		}
		
		if(Config.tools == true)
		{
		text = "1";
		research = new ResearchHelper("Dark Thaumium Tools", "TCE", ResearchAspect.darkThaumiumResearch, 2, -6, 3, new ItemStack(ItemRegister.darkThaumiumSword)).setParents("Essence of Greed").setConcealed().registerResearchItem();
		research.setPages(new ResearchPage(text), new ResearchPage(ThaumcraftRecipeRegister.darkThaumiumSword), new ResearchPage(ThaumcraftRecipeRegister.darkThaumiumPickaxe), new ResearchPage(ThaumcraftRecipeRegister.darkThaumiumShovel));
		}
		
		text = "1";
		research = new ResearchHelper(TCELocalization.emptyFoci, "TCE", ResearchAspect.emptyFociResearch, -3, 0, 3, new ItemStack(ItemRegister.emptyFoci)).setParents("Thaumcraft Extras").setSecondary().registerResearchItem();
		research.setPages(new ResearchPage(text), new ResearchPage(ThaumcraftRecipeRegister.emptyFoci));
		
		if(Config.arrowFoci == true)
		{
		text = "1";
		research = new ResearchHelper(TCELocalization.arrowFoci, "TCE", ResearchAspect.arrowFociResearch, -1, 1, 3, new ItemStack(ItemRegister.arrowFoci)).setParents("Empty Focus").registerResearchItem();
		research.setPages(new ResearchPage(text), new ResearchPage(ThaumcraftRecipeRegister.arrowFoci));
		}
		
		if(Config.enderFoci == true)
		{
		text = "1";
		research = new ResearchHelper(TCELocalization.enderFoci, "TCE", ResearchAspect.enderFociResearch, -2, -2, 3, new ItemStack(ItemRegister.enderFoci)).setParents("Empty Focus").registerResearchItem();
		research.setPages(new ResearchPage(text), new ResearchPage(ThaumcraftRecipeRegister.enderFoci));
		}
		
		if(Config.healFoci == true)
		{
		text = "1";
		research = new ResearchHelper(TCELocalization.healFoci, "TCE", ResearchAspect.healFociResearch, -3, -2, 3, new ItemStack(ItemRegister.healFoci)).setParents("Empty Focus").registerResearchItem();
		research.setPages(new ResearchPage(text), new ResearchPage(ThaumcraftRecipeRegister.healFoci));
		}
		
		if(Config.speedFoci == true)
		{
		text = "1";	
		research = new ResearchHelper(TCELocalization.speedFoci, "TCE", ResearchAspect.speedFociResearch, -4, -2, 3, new ItemStack(ItemRegister.speedFoci)).setParents("Empty Focus").registerResearchItem();
		research.setPages(new ResearchPage(text), new ResearchPage(ThaumcraftRecipeRegister.speedFoci));
		}
		if(Config.xpExtractor == true)
		{
		text = "1";
		research = new ResearchHelper(TCELocalization.xpExtractor, "TCE", ResearchAspect.xpExtractorResearch, -5, 1, 3, new ItemStack(ItemRegister.xpExtractor)).setParents("Empty Focus").registerResearchItem();
		research.setPages(new ResearchPage(text), new ResearchPage(ThaumcraftRecipeRegister.xpExtractor));
		}
		
		if(Config.xpFoci == true)
		{
		text = "1";
		research = new ResearchHelper(TCELocalization.xpFoci, "TCE", ResearchAspect.xpFociResearch, -6, 1, 3, new ItemStack(ItemRegister.xpFoci)).setParents("Experience Extractor").registerResearchItem();
		research.setPages(new ResearchPage(text), new ResearchPage(ThaumcraftRecipeRegister.xpFoci));
		}
		
		text = "1";
		research = new ResearchHelper("Shard Infusion", "TCE", new AspectList(), 2, 0, 3, new ItemStack(InfusionRegister.lightShard)).setParents("Empty Focus").setRound().setAutoUnlock().registerResearchItem();
		research.setPages(new ResearchPage(text), new ResearchPage(InfusionRegister.emptyShardRecipe), new ResearchPage(InfusionRegister.lightShardRecipe), new ResearchPage(InfusionRegister.enderShardRecipe));
		
		text = "1";
		text2 = "2";
		research = new ResearchHelper("Block Infusion", "TCE", new AspectList(), 2, 3, 3, new ItemStack(BlockRegister.airBlock)).setParents("Shard Infusion").setRound().setAutoUnlock().registerResearchItem();
		research.setPages(new ResearchPage(text), new ResearchPage(text2), new ResearchPage(InfusionRegister.airBlock));
		
		
		if(Config.fireBlock == true)
		{
		text = "1";
		research = new ResearchHelper("Fire Block", "TCE", ResearchAspect.fireBlockResearch, 0, 3, 3, new ItemStack(BlockRegister.fireBlock)).setParents("Block Infusion").setSecondary().registerResearchItem();
		research.setPages(new ResearchPage(text), new ResearchPage(InfusionRegister.fireBlock));
		}
		
		if(Config.waterBlock == true)
		{
		text = "1";
		research = new ResearchHelper("Water Block", "TCE",  ResearchAspect.waterBlockResearch, 0, 2, 3, new ItemStack(BlockRegister.waterBlock)).setParents("Block Infusion").setSecondary().registerResearchItem();
		research.setPages(new ResearchPage(text), new ResearchPage(InfusionRegister.waterBlock));
		}
		
		if(Config.earthBlock == true)
		{
		text = "1";
		research = new ResearchHelper("Earth Block", "TCE",  ResearchAspect.earthBlockResearch, 0, 4, 3, new ItemStack(BlockRegister.earthBlock)).setParents("Block Infusion").setSecondary().registerResearchItem();
		research.setPages(new ResearchPage(text), new ResearchPage(InfusionRegister.earthBlock));
		}
		
		if(Config.lightBlock == true)
		{
		text = "1";
		research = new ResearchHelper("Light Block", "TCE",  ResearchAspect.lightBlockResearch, 0, 5, 3, new ItemStack(BlockRegister.lightBlock)).setParents("Block Infusion").setSecondary().registerResearchItem();
		research.setPages(new ResearchPage(text), new ResearchPage(InfusionRegister.lightBlock));
		}
		
		if(Config.enderBlock == true)
		{
		text = "1";
		research = new ResearchHelper("Ender Block", "TCE",  ResearchAspect.enderBlockResearch, 0, 6, 3, new ItemStack(BlockRegister.enderBlock)).setParents("Block Infusion").setSecondary().registerResearchItem();
		research.setPages(new ResearchPage(text), new ResearchPage(InfusionRegister.enderBlock));
		}
		
		if(Config.ignisFuel == true)
		{
		text = "1";
		research = new ResearchHelper("Ignis Fuel", "TCE",  ResearchAspect.ignisFuelResearch, 2, 5, 3, new ItemStack(ItemRegister.ignisFuel)).setParents("Shard Infusion").setSecondary().registerResearchItem();
		research.setPages(new ResearchPage(text), new ResearchPage(ThaumcraftRecipeRegister.ignisFuel));
		}
		
		if(Config.exchangeFoci == true)
		{
		text = "1";
		research = new ResearchHelper(TCELocalization.exchangeFoci, "TCE",  ResearchAspect.exchangeFociResearch, -3, 2, 3, new ItemStack(ItemRegister.exchangeFoci)).setParents("Empty Focus").registerResearchItem();
		research.setPages(new ResearchPage(text), new ResearchPage(ThaumcraftRecipeRegister.exchangeFoci), new ResearchPage(ThaumcraftRecipeRegister.beamExchangeFoci));
		}
		
		if(Config.returnFoci == true)
		{
		text = "1";
		research = new ResearchHelper(TCELocalization.returnFoci, "TCE", ResearchAspect.returnFociResearch, -4, 2, 3, new ItemStack(ItemRegister.returnFoci)).setParents("Empty Focus").registerResearchItem();
		research.setPages(new ResearchPage(text), new ResearchPage(ThaumcraftRecipeRegister.returnFoci));
		}	
		
		if(Config.smeltingFoci == true)
		{
		text = "1";
		research = new ResearchHelper(TCELocalization.smeltingFoci, "TCE", ResearchAspect.smeltingFociResearch, -2, 2, 3, new ItemStack(ItemRegister.smeltingFoci)).setParents("Empty Focus").registerResearchItem();
		research.setPages(new ResearchPage(text), new ResearchPage(ThaumcraftRecipeRegister.smeltingFoci));
		}
		
		if(Config.dispelFoci == true)
		{
		text = "1";
		research = new ResearchHelper(TCELocalization.dispelFoci, "TCE", ResearchAspect.dispelFociResearch, -5, -1, 3, new ItemStack(ItemRegister.dispelFoci)).setParents("Empty Focus").registerResearchItem();
		research.setPages(new ResearchPage(text), new ResearchPage(ThaumcraftRecipeRegister.dispelFoci));
		}
		
		if(Config.destroyFoci == true)
		{
		text = "1";
		research = new ResearchHelper(TCELocalization.destroyFoci, "TCE", ResearchAspect.destroyFociResearch, -5, 2, 3, new ItemStack(ItemRegister.destroyFoci)).setParents("Empty Focus").registerResearchItem();
		research.setPages(new ResearchPage(text), new ResearchPage(ThaumcraftRecipeRegister.destroyFoci));
		}
		
		if(Config.cleanFoci == true)
		{
			text = "1";
			research = new ResearchHelper(TCELocalization.cleanFoci, "TCE", ResearchAspect.cleanFociResearch, -7, 1, 3, new ItemStack(ItemRegister.cleanFoci)).setParents("Wand Focus: Destroy").registerResearchItem();
			research.setPages(new ResearchPage(text), new ResearchPage(ThaumcraftRecipeRegister.cleanFoci));
		}
		
		if(Config.freezeFoci == true)
		{
		text = "1";
		research = new ResearchHelper(TCELocalization.freezeFoci, "TCE", ResearchAspect.freezeFociResearch, -6, 0, 3, new ItemStack(ItemRegister.freezeFoci)).setParents("Empty Focus").registerResearchItem();
		research.setPages(new ResearchPage(text), new ResearchPage(ThaumcraftRecipeRegister.freezeFoci));
		}
		
		if(Config.confusionFoci == true)
		{
		text = "1";
		research = new ResearchHelper(TCELocalization.confusionFoci, "TCE", ResearchAspect.confusionFociResearch, -5, 0, 3, new ItemStack(ItemRegister.confusionFoci)).setParents("Empty Focus").registerResearchItem();
		research.setPages(new ResearchPage(text), new ResearchPage(ThaumcraftRecipeRegister.confusionFoci));
		}
		
		if(Config.eventFoci == true)
		{
		text = "1";
		research = new ResearchHelper("Event Foci", "TCE", ResearchAspect.eventFociResearch, -6, -3, 3, new ItemStack(ItemRegister.snowFoci)).setParents("Empty Focus").registerResearchItem();
		research.setPages(new ResearchPage(text), new ResearchPage(ThaumcraftRecipeRegister.snowFoci));
		}
		
		if(Config.wandRods == true)
		{
		//text = "1";
		//research = new ResearchHelper("Wand Rods", "TCE", ResearchAspect.wandRodResearch, 3, -4, 3, new ItemStack(ItemRegister.goldRodItem)).setParents("Essence of Greed").setSecondary().registerResearchItem();
		//research.setPages(new ResearchPage(text), new ResearchPage(ThaumcraftRecipeRegister.ironRod), new ResearchPage(ThaumcraftRecipeRegister.goldRod), new ResearchPage(ThaumcraftRecipeRegister.diamondRod), new ResearchPage(ThaumcraftRecipeRegister.emeraldRod), new ResearchPage(ThaumcraftRecipeRegister.candyRod));
		
		text = "1";
		research = new ResearchHelper("ROD_IRON", "TCE", ResearchAspect.wandRodResearch, 5, -5, 3, new ItemStack(ItemRegister.ironRodItem)).setParents("Essence of Greed").registerResearchItem();
		research.setPages(new ResearchPage(text), new ResearchPage(ThaumcraftRecipeRegister.ironRod));

		//text = "1";
		//research = new ResearchHelper("Advanced Rods", "TCE", ResearchAspect.advancedRodsResearch, 3, -6, 3, new ItemStack(ItemRegister.devilRodItem)).setParents("Wand Rods").registerResearchItem();
		//research.setPages(new ResearchPage(text), new ResearchPage(ThaumcraftRecipeRegister.angelRod), new ResearchPage(ThaumcraftRecipeRegister.devilRod), new ResearchPage(ThaumcraftRecipeRegister.godRod), new ResearchPage(ThaumcraftRecipeRegister.darkSilverwoodRod));
		}
		
		/*
		text = "1";
		research = new ResearchHelper("Wand Caps", "THAUMATURGY", ResearchAspect.wandCapsResearch, -10, -1, 3, new ItemStack(ItemRegister.darkThaumiumCapItem)).setParents("Wand Rods").registerResearchItem();
		research.setPages(new ResearchPage(text), new ResearchPage(ThaumcraftRecipeRegister.darkThaumiumCap));
	*/
		
		if(Config.wardedBlocks == true)
		{
		text = "1";
		research = new ResearchHelper("Warded Block", "ARTIFICE", ResearchAspect.wardedBlockResearch, 5, -4, 3, new ItemStack(BlockRegister.wardedBlock, 0, 1)).setParents("ARCANESTONE").setSecondary().registerResearchItem();
		research.setPages(new ResearchPage(text), new ResearchPage(ThaumcraftRecipeRegister.wardedBlock), new ResearchPage(ThaumcraftRecipeRegister.thaumiumGlass), new ResearchPage(ThaumcraftRecipeRegister.wardedCarpet), new ResearchPage(ThaumcraftRecipeRegister.wardedSlab), new ResearchPage(ThaumcraftRecipeRegister.wardedWall), new ResearchPage(ThaumcraftRecipeRegister.wardedPilar), new ResearchPage(ThaumcraftRecipeRegister.hiddenWarded), new ResearchPage(ThaumcraftRecipeRegister.openWarded));
		}
		
		if(Config.magicEnergy == true)
		{
		text = "1";
		research = new ResearchHelper("Magic Energy", "ARTIFICE", ResearchAspect.energyResearch, 6, -6, 3, new ItemStack(MCKERegister.MCKCharger, 0, 1)).setParents("Warded Block").registerResearchItem();
		research.setPages(new ResearchPage(text), new ResearchPage(ThaumcraftRecipeRegister.charger), new ResearchPage(ThaumcraftRecipeRegister.exchanger), new ResearchPage(ThaumcraftRecipeRegister.wandCharger), new ResearchPage(ThaumcraftRecipeRegister.darkThaumium), new ResearchPage(ThaumcraftRecipeRegister.battery), new ResearchPage(ThaumcraftRecipeRegister.battery2), new ResearchPage(ThaumcraftRecipeRegister.battery3), new ResearchPage(ThaumcraftRecipeRegister.battery4), new ResearchPage(ThaumcraftRecipeRegister.magicWrench), new ResearchPage(ThaumcraftRecipeRegister.darkInfuser));
		}
	}
	
	public static void addPage()
	{
		 ResourceLocation background = new ResourceLocation("thaumcraft", "textures/gui/gui_researchback.png");
         ResearchCategories.registerCategory("TCE", new ResourceLocation(MainHelper.modName + ":" + TCELocalization.TCETabIcon), background);
         LanguageRegistry.instance().addStringLocalization("tc.research_category.TCE", "Thaumcraft Extras");
	}
	
}
