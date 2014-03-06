package thaumcraftextras.register;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.crafting.ShapedArcaneRecipe;
import thaumcraft.api.crafting.ShapelessArcaneRecipe;
import thaumcraft.common.config.ConfigBlocks;
import thaumcraft.common.config.ConfigItems;
import thaumcraftextras.lib.CraftingAspects;
import thaumcraftextras.lib.TCELocalization;
import thaumcraftextras.main.Config;
import cpw.mods.fml.common.registry.GameRegistry;

public class ThaumcraftRecipeRegister {

	public static void load()
	{		
	if(Config.pechTrade == true)
	{
	pechTradeTier1 = ThaumcraftApi.addArcaneCraftingRecipe("Essence of Greed", new ItemStack(ItemRegister.pechTradeTier1), CraftingAspects.pechTradeTier1, new Object[]{
		"XXX",
		"XIX",
		"XXX",
		'X', Item.goldNugget,
		'I', Item.ingotGold});

	pechTradeTier2 = ThaumcraftApi.addArcaneCraftingRecipe("Essence of Greed", new ItemStack(ItemRegister.pechTradeTier2), CraftingAspects.pechTradeTier2, new Object[]{
		"YYY",
		"YXY",
		"YYY",
		'X', new ItemStack(ItemRegister.pechTradeTier1),
		'Y', new ItemStack(Item.goldNugget)});

	pechTradeTier3 = ThaumcraftApi.addArcaneCraftingRecipe("Essence of Greed", new ItemStack(ItemRegister.pechTradeTier3), CraftingAspects.pechTradeTier3, new Object[]{
		"YYY",
		"YXY",
		"YYY",
		'X', new ItemStack(ItemRegister.pechTradeTier2),
		'Y', new ItemStack(Item.goldNugget)});

	pechTradeTier4 = ThaumcraftApi.addArcaneCraftingRecipe("Essence of Greed", new ItemStack(ItemRegister.pechTradeTier4), CraftingAspects.pechTradeTier4, new Object[]{
		"YYY",
		"YXY",
		"YYY",
		'X', new ItemStack(ItemRegister.pechTradeTier3),
		'Y', new ItemStack(Item.goldNugget)});

	pechTradeTier5 = ThaumcraftApi.addArcaneCraftingRecipe("Essence of Greed", new ItemStack(ItemRegister.pechTradeTier5), CraftingAspects.pechTradeTier5, new Object[]{
		"YYY",
		"YXY",
		"YYY",
		'X', new ItemStack(ItemRegister.pechTradeTier4),
		'Y', new ItemStack(Item.goldNugget)});
	}
	
	if(Config.magicTrade == true)
	{
	magicTradeTier1 = ThaumcraftApi.addArcaneCraftingRecipe("Essence of Magic", new ItemStack(ItemRegister.magicTradeTier1), CraftingAspects.magicTradeTier1, new Object[]{
		"XXX",
		"XIX",
		"XXX",
		'X', Item.goldNugget,
		'I', Item.diamond});

	magicTradeTier2 = ThaumcraftApi.addArcaneCraftingRecipe("Essence of Magic", new ItemStack(ItemRegister.magicTradeTier2), CraftingAspects.magicTradeTier2, new Object[]{
		"YYY",
		"YXY",
		"YYY",
		'X', new ItemStack(ItemRegister.magicTradeTier1),
		'Y', new ItemStack(Item.goldNugget)});

	magicTradeTier3 = ThaumcraftApi.addArcaneCraftingRecipe("Essence of Magic", new ItemStack(ItemRegister.magicTradeTier3), CraftingAspects.magicTradeTier3, new Object[]{
		"YYY",
		"YXY",
		"YYY",
		'X', new ItemStack(ItemRegister.magicTradeTier2),
		'Y', new ItemStack(Item.goldNugget)});

	magicTradeTier4 = ThaumcraftApi.addArcaneCraftingRecipe("Essence of Magic", new ItemStack(ItemRegister.magicTradeTier4),CraftingAspects.magicTradeTier4, new Object[]{
		"YYY",
		"YXY",
		"YYY",
		'X', new ItemStack(ItemRegister.magicTradeTier3),
		'Y', new ItemStack(Item.goldNugget)});

	magicTradeTier5 = ThaumcraftApi.addArcaneCraftingRecipe("Essence of Magic", new ItemStack(ItemRegister.magicTradeTier5),	CraftingAspects.magicTradeTier5,  new Object[]{
		"YYY",
		"YXY",
		"YYY",
		'X', new ItemStack(ItemRegister.magicTradeTier4),
		'Y', new ItemStack(Item.goldNugget)});
	
	}
	if(Config.enderFoci == true)
	{
	enderFoci = ThaumcraftApi.addInfusionCraftingRecipe(TCELocalization.enderFoci, new ItemStack(ItemRegister.enderFoci),4 , 
			CraftingAspects.enderFoci, 
		new ItemStack(ItemRegister.emptyFoci), new ItemStack[]{
		new ItemStack(Item.netherQuartz), new ItemStack(Item.enderPearl), new ItemStack(Item.netherQuartz),
		new ItemStack(Item.enderPearl), new ItemStack(Item.netherQuartz), new ItemStack(Item.enderPearl), 
		new ItemStack(Item.netherQuartz), new ItemStack(Item.enderPearl)});
	}
	if(Config.arrowFoci == true)
	{
	arrowFoci = ThaumcraftApi.addInfusionCraftingRecipe(TCELocalization.arrowFoci, new ItemStack(ItemRegister.arrowFoci),4 , 
			CraftingAspects.arrowFoci, 
		new ItemStack(ItemRegister.emptyFoci), new ItemStack[]{
		new ItemStack(Item.netherQuartz), new ItemStack(Item.arrow), new ItemStack(Item.netherQuartz),
		new ItemStack(Item.arrow), new ItemStack(Item.netherQuartz), new ItemStack(Item.arrow), 
		new ItemStack(Item.netherQuartz), new ItemStack(Item.arrow)});
	}
	if(Config.healFoci == true)
	{
	healFoci = ThaumcraftApi.addInfusionCraftingRecipe(TCELocalization.healFoci, new ItemStack(ItemRegister.healFoci),10 , 
			CraftingAspects.healFoci, 
			new ItemStack(ItemRegister.emptyFoci), new ItemStack[]{
			new ItemStack(Item.netherQuartz), new ItemStack(Item.paper), new ItemStack(Item.netherQuartz),
			new ItemStack(Item.paper), new ItemStack(Item.netherQuartz), new ItemStack(Item.paper), 
			new ItemStack(Item.netherQuartz), new ItemStack(Item.paper)});
	}
	if(Config.speedFoci == true)
	{
	speedFoci = ThaumcraftApi.addInfusionCraftingRecipe(TCELocalization.speedFoci, new ItemStack(ItemRegister.speedFoci),4 , 
			CraftingAspects.speedFoci, 
			new ItemStack(ItemRegister.emptyFoci), new ItemStack[]{
			new ItemStack(Item.netherQuartz), new ItemStack(Item.feather), new ItemStack(Item.netherQuartz),
			new ItemStack(Item.feather), new ItemStack(Item.netherQuartz), new ItemStack(Item.feather), 
			new ItemStack(Item.netherQuartz), new ItemStack(Item.feather)});
	}
	
	if(Config.xpFoci == true)
	{
	xpFoci = ThaumcraftApi.addInfusionCraftingRecipe(TCELocalization.xpFoci, new ItemStack(ItemRegister.xpFoci),4 , 
			CraftingAspects.xpFoci, 
			new ItemStack(ItemRegister.emptyFoci), new ItemStack[]{
			new ItemStack(Item.netherQuartz), new ItemStack(InfusionRegister.xpShard), new ItemStack(Item.netherQuartz),
			new ItemStack(InfusionRegister.xpShard), new ItemStack(Item.netherQuartz), new ItemStack(InfusionRegister.xpShard), 
			new ItemStack(Item.netherQuartz), new ItemStack(InfusionRegister.xpShard)});
	}
	
	if(Config.xpExtractor == true)
	{
		xpExtractor = ThaumcraftApi.addArcaneCraftingRecipe(TCELocalization.xpExtractor, new ItemStack(ItemRegister.xpExtractor),	CraftingAspects.xpExtractor,  new Object[]{
			"YIY",
			"IXI",
			"YIY",
			'X', ItemRegister.magicTradeTier2,
			'Y', ItemRegister.pechTradeTier1,
			'I', ItemRegister.magicTradeTier1});
	}
	
	if(Config.returnFoci == true)
	{
		returnFoci = ThaumcraftApi.addInfusionCraftingRecipe(TCELocalization.returnFoci, new ItemStack(ItemRegister.returnFoci),4,
			CraftingAspects.returnFoci,
			new ItemStack(ItemRegister.enderFoci), new ItemStack[]{
			new ItemStack(Item.netherQuartz), new ItemStack(Item.enderPearl), new ItemStack(Item.netherQuartz),
			new ItemStack(Item.enderPearl), new ItemStack(Item.netherQuartz), new ItemStack(Item.enderPearl), 
			new ItemStack(Item.netherQuartz), new ItemStack(Item.enderPearl)});
	}
	
	if(Config.exchangeFoci == true)
	{
		exchangeFoci = ThaumcraftApi.addInfusionCraftingRecipe(TCELocalization.exchangeFoci, new ItemStack(ItemRegister.exchangeFoci),4,
			CraftingAspects.exchangeFoci,
			new ItemStack(ItemRegister.emptyFoci), new ItemStack[]{
			new ItemStack(Item.netherQuartz), new ItemStack(ItemRegister.pechTradeTier1), new ItemStack(Item.netherQuartz),
			new ItemStack(ItemRegister.pechTradeTier1), new ItemStack(Item.netherQuartz), new ItemStack(ItemRegister.pechTradeTier1), 
			new ItemStack(Item.netherQuartz), new ItemStack(ItemRegister.pechTradeTier1)});
	}
	if(Config.smeltingFoci == true)
	{
		smeltingFoci = ThaumcraftApi.addInfusionCraftingRecipe(TCELocalization.smeltingFoci, new ItemStack(ItemRegister.smeltingFoci),4,
				CraftingAspects.smeltingFoci,
				new ItemStack(ItemRegister.emptyFoci), new ItemStack[]{
				new ItemStack(Item.fireballCharge), new ItemStack(ItemRegister.magicTradeTier1), new ItemStack(Item.fireballCharge),
				new ItemStack(ItemRegister.magicTradeTier1), new ItemStack(Item.fireballCharge), new ItemStack(ItemRegister.magicTradeTier1), 
				new ItemStack(Item.fireballCharge), new ItemStack(ItemRegister.magicTradeTier1)});
	}
	if(Config.dispelFoci == true)
	{
		dispelFoci = ThaumcraftApi.addInfusionCraftingRecipe(TCELocalization.dispelFoci, new ItemStack(ItemRegister.dispelFoci),4,
				CraftingAspects.dispelFoci,
				new ItemStack(ItemRegister.emptyFoci), new ItemStack[]{
				new ItemStack(Item.netherQuartz), new ItemStack(Item.sugar), new ItemStack(Item.netherQuartz),
				new ItemStack(Item.sugar), new ItemStack(Item.netherQuartz), new ItemStack(Item.sugar), 
				new ItemStack(Item.netherQuartz), new ItemStack(Item.sugar)});
	}
	
	if(Config.destroyFoci == true)
	{
	destroyFoci = ThaumcraftApi.addInfusionCraftingRecipe(TCELocalization.destroyFoci, new ItemStack(ItemRegister.destroyFoci),4,
			CraftingAspects.destroyFoci,
			new ItemStack(ItemRegister.smeltingFoci), new ItemStack[]{
			new ItemStack(Item.netherQuartz), new ItemStack(Item.enderPearl), new ItemStack(Item.netherQuartz),
			new ItemStack(Item.enderPearl), new ItemStack(Item.netherQuartz), new ItemStack(Item.enderPearl), 
			new ItemStack(Item.netherQuartz), new ItemStack(Item.enderPearl)});
	}
	
	if(Config.cleanFoci == true)
	{
		cleanFoci = ThaumcraftApi.addInfusionCraftingRecipe(TCELocalization.cleanFoci, new ItemStack(ItemRegister.cleanFoci),4,
				CraftingAspects.cleanFoci,
				new ItemStack(ConfigItems.itemFocusExcavation), new ItemStack[]{
				new ItemStack(Item.netherQuartz), new ItemStack(Item.enderPearl), new ItemStack(Item.netherQuartz),
				new ItemStack(Item.enderPearl), new ItemStack(Item.netherQuartz), new ItemStack(Item.enderPearl), 
				new ItemStack(Item.netherQuartz), new ItemStack(Item.enderPearl)});
	}
	if(Config.freezeFoci == true)
	{
	freezeFoci = ThaumcraftApi.addInfusionCraftingRecipe(TCELocalization.freezeFoci, new ItemStack(ItemRegister.freezeFoci),4,
			CraftingAspects.freezeFoci,
			new ItemStack(ItemRegister.emptyFoci), new ItemStack[]{
			new ItemStack(Block.ice), new ItemStack(Item.snowball), new ItemStack(Block.ice),
			new ItemStack(Item.snowball), new ItemStack(Block.ice), new ItemStack(Item.snowball), 
			new ItemStack(Block.ice), new ItemStack(Item.snowball)});
	}
	
	if(Config.beamExchangeFoci == true)
	{
	beamExchangeFoci = ThaumcraftApi.addInfusionCraftingRecipe(TCELocalization.beamExchangeFoci, new ItemStack(ItemRegister.beamExchangeFoci),4,
			CraftingAspects.beamExchangeFoci,
			new ItemStack(ItemRegister.emptyFoci), new ItemStack[]{
			new ItemStack(Item.netherQuartz), new ItemStack(ItemRegister.pechTradeTier2), new ItemStack(Item.netherQuartz),
			new ItemStack(ItemRegister.pechTradeTier2), new ItemStack(Item.netherQuartz), new ItemStack(ItemRegister.pechTradeTier2), 
			new ItemStack(Item.netherQuartz), new ItemStack(ItemRegister.pechTradeTier2)});
	}
	
	if(Config.confusionFoci == true)
	{
	confusionFoci = ThaumcraftApi.addInfusionCraftingRecipe(TCELocalization.confusionFoci, new ItemStack(ItemRegister.confusionFoci),4,
			CraftingAspects.confusionFoci,
			new ItemStack(ItemRegister.emptyFoci), new ItemStack[]{
			new ItemStack(Item.netherQuartz), new ItemStack(Item.spiderEye), new ItemStack(Item.netherQuartz),
			new ItemStack(Item.spiderEye), new ItemStack(Item.netherQuartz), new ItemStack(Item.spiderEye), 
			new ItemStack(Item.netherQuartz), new ItemStack(Item.spiderEye)});
	}

	snowFoci = ThaumcraftApi.addInfusionCraftingRecipe("Event Foci", new ItemStack(ItemRegister.snowFoci),4,
			CraftingAspects.snowFoci,
			new ItemStack(ItemRegister.emptyFoci), new ItemStack[]{
			new ItemStack(Item.firework), new ItemStack(Item.snowball), new ItemStack(Item.firework),
			new ItemStack(Item.snowball), new ItemStack(Item.firework), new ItemStack(Item.snowball), 
			new ItemStack(Item.firework), new ItemStack(Item.snowball)});
/*
	darkThaumiumCap = ThaumcraftApi.addArcaneCraftingRecipe("Wand Rods", new ItemStack(ItemRegister.darkThaumiumCapItem), CraftingAspects.darkThaumiumCap, new Object[]{
		"XXX",
		"X X",
		"   ",
		'X', ItemRegister.darkThaumiumNugget});
	*/
	
	ironRod = ThaumcraftApi.addArcaneCraftingRecipe("ROD_IRON", new ItemStack(ItemRegister.ironRodItem), CraftingAspects.ironRod, new Object[]{
		"  X",
		" I ",
		"X  ",
		'X', Item.ingotIron,
		'I', new ItemStack(Item.stick)});
	
	goldRod = ThaumcraftApi.addArcaneCraftingRecipe("Wand Rods", new ItemStack(ItemRegister.goldRodItem), CraftingAspects.goldRod, new Object[]{
		"  X",
		" I ",
		"X  ",
		'X', Item.ingotGold,
		'I', new ItemStack(ItemRegister.ironRodItem, 1, 0)});
	
	diamondRod = ThaumcraftApi.addArcaneCraftingRecipe("Wand Rods", new ItemStack(ItemRegister.diamondRodItem), CraftingAspects.diamondRod, new Object[]{
		"  X",
		" I ",
		"X  ",
		'X', Item.diamond,
		'I', new ItemStack(ItemRegister.goldRodItem, 1, 0)});
	
	emeraldRod = ThaumcraftApi.addArcaneCraftingRecipe("Wand Rods", new ItemStack(ItemRegister.emeraldRodItem), CraftingAspects.emeraldRod, new Object[]{
		"  X",
		" I ",
		"X  ",
		'X', Item.emerald,
		'I', new ItemStack(ItemRegister.diamondRodItem, 1, 0)});
	
	angelRod = ThaumcraftApi.addArcaneCraftingRecipe("Advanced Rods", new ItemStack(ItemRegister.angelRodItem), CraftingAspects.angelRod, new Object[]{
		"  X",
		" I ",
		"X  ",
		'X', ItemRegister.ignisFuel,
		'I', new ItemStack(ConfigItems.itemWandRod, 1, 2)});
	
	devilRod = ThaumcraftApi.addArcaneCraftingRecipe("Wand Rods", new ItemStack(ItemRegister.devilRodItem), CraftingAspects.devilRod, new Object[]{
		"  X",
		" I ",
		"X  ",
		'X', BlockRegister.enderBlock,
		'I', new ItemStack(ItemRegister.angelRodItem, 1, 0)});
	
	godRod = ThaumcraftApi.addArcaneCraftingRecipe("Wand Rods", new ItemStack(ItemRegister.godRodItem), CraftingAspects.godRod, new Object[]{
		"  X",
		" I ",
		"X  ",
		'X', ItemRegister.darkThaumium,
		'I', new ItemStack(ItemRegister.devilRodItem, 1, 0)});
	
	darkSilverwoodRod = ThaumcraftApi.addArcaneCraftingRecipe("Wand Rods", new ItemStack(ItemRegister.darkSilverwoodRodItem), CraftingAspects.godRod, new Object[]{
		" DX",
		"DID",
		"XD ",
		'X', Item.netherStar,
		'I', new ItemStack(ItemRegister.godRodItem, 1, 0),
		'D', new ItemStack(BlockRegister.darkSilverwoodLog)});
	
	candyRod = ThaumcraftApi.addArcaneCraftingRecipe("Wand Rods", new ItemStack(ItemRegister.candyRodItem), CraftingAspects.candyRod, new Object[]{
		"  X",
		" I ",
		"X  ",
		'X', Item.sugar,
		'I', Item.bucketMilk});
	
	
	darkThaumiumPickaxe = ThaumcraftApi.addArcaneCraftingRecipe("Dark Thaumium Tools", new ItemStack(ItemRegister.darkThaumiumPickaxe), CraftingAspects.darkThaumiumTools, new Object[]{
	"XYX",
	"YIY",
	"XYX",
	'X', ItemRegister.darkThaumium,
	'I', new ItemStack(ConfigItems.itemPickThaumium, 1, 0),
	'Y', Block.blockIron});
	
	darkThaumiumShovel = ThaumcraftApi.addArcaneCraftingRecipe("Dark Thaumium Tools", new ItemStack(ItemRegister.darkThaumiumShovel), CraftingAspects.darkThaumiumTools, new Object[]{
	"XYX",
	"YIY",
	"XYX",
	'X', ItemRegister.darkThaumium,
	'I', new ItemStack(ConfigItems.itemShovelThaumium, 1, 0),
	'Y', Block.blockIron});
	
	darkThaumiumSword = ThaumcraftApi.addArcaneCraftingRecipe("Dark Thaumium Tools", new ItemStack(ItemRegister.darkThaumiumSword), CraftingAspects.darkThaumiumTools, new Object[]{
	"XYX",
	"YIY",
	"XYX",
	'X', ItemRegister.darkThaumium,
	'I', new ItemStack(ConfigItems.itemSwordThaumium, 1, 0),
	'Y', Block.blockIron});
	
	ignisFuel = ThaumcraftApi.addShapelessArcaneCraftingRecipe(TCELocalization.IgnisFuel, 
			new ItemStack(ItemRegister.ignisFuel), new AspectList().add(Aspect.FIRE, 3), 
			Item.coal,
			Block.netherrack);
	
	thaumiumGlass = ThaumcraftApi.addArcaneCraftingRecipe("Warded Block", new ItemStack(BlockRegister.wardedGlass, 8, 15), CraftingAspects.wardedBlock,  new Object[]{
		"XYX",
		"YYY",
		"XYX",
		'X', new ItemStack(ConfigItems.itemResource, 1, 2),
		'Y', Block.glass});
		
	
	wardedBlock = ThaumcraftApi.addArcaneCraftingRecipe("Warded Block", new ItemStack(BlockRegister.wardedBlock, 8, 15), CraftingAspects.wardedBlock,  new Object[]{
		"XYX",
		"YYY",
		"XYX",
		'X', new ItemStack(ConfigItems.itemResource, 1, 2),
		'Y', Block.stone});
			
	wardedSlab = ThaumcraftApi.addArcaneCraftingRecipe("Warded Block", new ItemStack(BlockRegister.wardedSlab, 6, 15), CraftingAspects.wardedBlock,  new Object[]{
		"   ",
		"   ",
		"XX ",
		'X', BlockRegister.wardedBlock});
	
	wardedCarpet = ThaumcraftApi.addArcaneCraftingRecipe("Warded Block", new ItemStack(BlockRegister.wardedCarpet, 12, 15), CraftingAspects.wardedBlock,  new Object[]{
		"   ",
		"   ",
		"XXX",
		'X', BlockRegister.wardedBlock});
	
	/*
	wardedCover = ThaumcraftApi.addArcaneCraftingRecipe("Warded Block", new ItemStack(BlockRegister.wardedCover, 16, 15), CraftingAspects.wardedBlock,  new Object[]{
		"   ",
		"X  ",
		"X  ",
		'X', BlockRegister.wardedBlock});
	*/
	
	wardedPilar = ThaumcraftApi.addArcaneCraftingRecipe("Warded Block", new ItemStack(BlockRegister.wardedPilar, 32, 15), CraftingAspects.wardedBlock,  new Object[]{
		"   ",
		"X  ",
		"X  ",
		'X', BlockRegister.wardedBlock});
	
	wardedWall = ThaumcraftApi.addArcaneCraftingRecipe("Warded Block", new ItemStack(BlockRegister.wardedWall, 12, 15), CraftingAspects.wardedBlock,  new Object[]{
		"   ",
		"XXX",
		"XXX",
		'X', BlockRegister.wardedBlock});
	
	hiddenWarded = ThaumcraftApi.addArcaneCraftingRecipe("Warded Block", new ItemStack(BlockRegister.hiddenWarded, 12, 15), CraftingAspects.wardedBlock,  new Object[]{
		"YIY",
		"IXI",
		"YIY",
		'X', BlockRegister.wardedBlock,
		'Y', Block.trapdoor,
		'I', ItemRegister.pechTradeTier1});
	
	openWarded = ThaumcraftApi.addArcaneCraftingRecipe("Warded Block", new ItemStack(BlockRegister.openWarded, 12, 15), CraftingAspects.wardedBlock,  new Object[]{
		"YIY",
		"IXI",
		"YIY",
		'X', BlockRegister.wardedBlock,
		'Y', Block.dirt,
		'I', ItemRegister.pechTradeTier1});
	
	charger = ThaumcraftApi.addArcaneCraftingRecipe("Magic Energy", new ItemStack(MCKERegister.MCKCharger, 1, 0), CraftingAspects.chargerBlock,  new Object[]{
		"XIX",
		"IYI",
		"XIX",
		'X', ItemRegister.magicTradeTier1,
		'I', Item.ingotGold,
		'Y', Block.blockIron});
	
	darkInfuser = ThaumcraftApi.addArcaneCraftingRecipe("Magic Energy", new ItemStack(MCKERegister.infuser, 1, 0), CraftingAspects.chargerBlock,  new Object[]{
		"XIX",
		"IYI",
		"XIX",
		'X', ItemRegister.magicTradeTier1,
		'I', Item.diamond,
		'Y', Block.blockIron});
	
	exchanger = ThaumcraftApi.addArcaneCraftingRecipe("Magic Energy", new ItemStack(MCKERegister.exchanger, 1, 0), CraftingAspects.exchangerBlock,  new Object[]{
		"XIX",
		"IYI",
		"XIX",
		'X', ItemRegister.magicTradeTier1,
		'I', Item.diamond,
		'Y', MCKERegister.MCKCharger});
	
	wandCharger = ThaumcraftApi.addArcaneCraftingRecipe("Magic Energy", new ItemStack(MCKERegister.charger, 1, 0), CraftingAspects.exchangerBlock,  new Object[]{
		"XIX",
		"IYI",
		"XIX",
		'X', ItemRegister.darkThaumium,
		'I', ItemRegister.magicTradeTier1,
		'Y', new ItemStack(ItemRegister.devilRodItem, 1, 0)});
	
	battery = ThaumcraftApi.addArcaneCraftingRecipe("Magic Energy", new ItemStack(MCKERegister.magicCrystal, 1, 50), CraftingAspects.exchangerBlock,  new Object[]{
		"XIX",
		"IYI",
		"XIX",
		'X', ItemRegister.pechTradeTier1,
		'I', ItemRegister.magicTradeTier1,
		'Y', Block.blockRedstone});
	
	battery2 = ThaumcraftApi.addArcaneCraftingRecipe("Magic Energy", new ItemStack(MCKERegister.magicCrystalT2, 1, 100), CraftingAspects.exchangerBlock,  new Object[]{
		"XIX",
		"IYI",
		"XIX",
		'X', ItemRegister.pechTradeTier1,
		'I', ItemRegister.magicTradeTier1,
		'Y', MCKERegister.magicCrystal});
	
	battery3 = ThaumcraftApi.addArcaneCraftingRecipe("Magic Energy", new ItemStack(MCKERegister.magicCrystalT3, 1, 250), CraftingAspects.exchangerBlock,  new Object[]{
		"XIX",
		"IYI",
		"XIX",
		'X', ItemRegister.pechTradeTier1,
		'I', ItemRegister.magicTradeTier1,
		'Y', MCKERegister.magicCrystalT2});
	
	battery4 = ThaumcraftApi.addArcaneCraftingRecipe("Magic Energy", new ItemStack(MCKERegister.magicCrystalT4, 1, 500), CraftingAspects.exchangerBlock,  new Object[]{
		"XIX",
		"IYI",
		"XIX",
		'X', ItemRegister.pechTradeTier2,
		'I', ItemRegister.magicTradeTier2,
		'Y', MCKERegister.magicCrystalT3});
	
	magicWrench = ThaumcraftApi.addArcaneCraftingRecipe("Magic Energy", new ItemStack(MCKERegister.magicWrench, 1, 100), CraftingAspects.magicWrench,  new Object[]{
		"X X",
		"XXX",
		" I ",
		'X', new ItemStack(ConfigItems.itemResource, 1, 2),
		'I', Item.stick});
	
	darkThaumium = ThaumcraftApi.addArcaneCraftingRecipe("Magic Energy", new ItemStack(ItemRegister.darkThaumium, 1, 0), CraftingAspects.pechTradeTier3,  new Object[]{
		"YIY",
		"IXI",
		"YIY",
		'X', Item.diamond,
		'I', ItemRegister.magicTradeTier1,
		'Y', new ItemStack(ConfigItems.itemResource, 1, 2)});
	
	emptyFoci = ThaumcraftApi.addArcaneCraftingRecipe("Empty Focus", new ItemStack(ItemRegister.emptyFoci, 1, 0), CraftingAspects.emptyFoci,  new Object[]{
		"YIY",
		"IXI",
		"YIY",
		'X', Item.enderPearl,
		'I', ItemRegister.magicTradeTier1,
		'Y', new ItemStack(ConfigItems.itemResource, 1, 2)});
	
		darkSilverwoodLog = ThaumcraftApi.addShapelessArcaneCraftingRecipe("Thaumcraft Extras", 
			new ItemStack(BlockRegister.darkSilverwoodLog, 2, 0), new AspectList().add(Aspect.ENTROPY, 1), 
			new ItemStack(ConfigBlocks.blockMagicalLog, 1, 1), 
			new ItemStack(ConfigItems.itemShard, 1, 5));
	
		darkSilverwoodPlank = ThaumcraftApi.addShapelessArcaneCraftingRecipe("Thaumcraft Extras", 
				new ItemStack(BlockRegister.darkSilverwood , 4, 0), new AspectList().add(Aspect.ENTROPY, 0), 
				new ItemStack(BlockRegister.darkSilverwoodLog, 1, 0));
		
		GameRegistry.addShapedRecipe(new ItemStack(BlockRegister.ignisFuelBlock), new Object[] {
		"XXX",
		"XXX",
		"XXX",
		'X', ItemRegister.ignisFuel});

		int end;
		int meta;
		
		/** Warded Block */
		meta = 0;
		end = 15;
		while(meta >= 0 && meta <= end)
		{
		GameRegistry.addShapedRecipe(new ItemStack(BlockRegister.wardedBlock, 8, meta), new Object[] {
		"XXX",
		"XYX",
		"XXX",
		'Y', new ItemStack(Item.dyePowder, 1, meta),
		'X', BlockRegister.wardedBlock});
		meta++;
		}
		
		/** Warded Carpet */
		meta = 0;
		end = 15;
		
		while(meta >= 0 && meta <= end)
		{
		GameRegistry.addShapedRecipe(new ItemStack(BlockRegister.wardedCarpet, 8, meta), new Object[] {
		"XXX",
		"XYX",
		"XXX",
		'Y', new ItemStack(Item.dyePowder, 1, meta),
		'X', BlockRegister.wardedCarpet});
		meta++;
		}
		
		/** Warded Slab */
		meta = 0;
		end = 15;
		
		while(meta >= 0 && meta <= end)
		{
		GameRegistry.addShapedRecipe(new ItemStack(BlockRegister.wardedSlab, 8, meta), new Object[] {
		"XXX",
		"XYX",
		"XXX",
		'Y', new ItemStack(Item.dyePowder, 1, meta),
		'X', BlockRegister.wardedSlab});
		meta++;
		}
		
		/** Warded Wall */
		meta = 0;
		end = 15;
		
		while(meta >= 0 && meta <= end)
		{
		GameRegistry.addShapedRecipe(new ItemStack(BlockRegister.wardedWall, 8, meta), new Object[] {
		"XXX",
		"XYX",
		"XXX",
		'Y', new ItemStack(Item.dyePowder, 1, meta),
		'X', BlockRegister.wardedWall});
		meta++;
		}
		
		/** Warded Glass */
		meta = 0;
		end = 15;
		
		while(meta >= 0 && meta <= end)
		{
		GameRegistry.addShapedRecipe(new ItemStack(BlockRegister.wardedGlass, 8, meta), new Object[] {
		"XXX",
		"XYX",
		"XXX",
		'Y', new ItemStack(Item.dyePowder, 1, meta),
		'X', BlockRegister.wardedGlass});
		meta++;
		}
		
		/*
		meta = 0;
		end = 15;
		while(meta >= 0 && meta <= end)
		{
		GameRegistry.addShapedRecipe(new ItemStack(BlockRegister.wardedCover, 8, meta), new Object[] {
		"XXX",
		"XYX",
		"XXX",
		'Y', new ItemStack(Item.dyePowder, 1, meta),
		'X', BlockRegister.wardedCover});
		meta++;
		}
		*/
		
		meta = 0;
		end = 15;
		while(meta >= 0 && meta <= end)
		{
		GameRegistry.addShapedRecipe(new ItemStack(BlockRegister.wardedPilar, 8, meta), new Object[] {
		"XXX",
		"XYX",
		"XXX",
		'Y', new ItemStack(Item.dyePowder, 1, meta),
		'X', BlockRegister.wardedPilar});
		meta++;
		}
		
		meta = 0;
		end = 15;
		while(meta >= 0 && meta <= end)
		{
		GameRegistry.addShapedRecipe(new ItemStack(BlockRegister.lightBlock, 8, meta), new Object[] {
		"XXX",
		"XYX",
		"XXX",
		'Y', new ItemStack(Item.dyePowder, 1, meta),
		'X', BlockRegister.lightBlock});
		meta++;
		}
		
		meta = 0;
		end = 15;
		while(meta >= 0 && meta <= end)
		{
		GameRegistry.addShapedRecipe(new ItemStack(ItemRegister.colorPouch, 1, meta), new Object[] {
		"XXX",
		"XYX",
		"XXX",
		'Y', ConfigItems.itemFocusPouch,
		'X', new ItemStack(Item.dyePowder, 1, meta)});
		meta++;
		}
		
		GameRegistry.addShapedRecipe(new ItemStack(ItemRegister.darkThaumium, 1, 0), new Object[] {
		"XXX",
		"XXX",
		"XXX",
		'X', new ItemStack(ItemRegister.darkThaumiumNugget, 1, 0)});
		
		GameRegistry.addShapedRecipe(new ItemStack(ItemRegister.pechTradeTier1, 1, 0), new Object[] {
		"XXX",
		"XXX",
		"XXX",
		'X', new ItemStack(ItemRegister.greedShard, 1, 0)});
		
		GameRegistry.addShapedRecipe(new ItemStack(ItemRegister.magicTradeTier1, 1, 0), new Object[] {
		"XXX",
		"XXX",
		"XXX",
		'X', new ItemStack(ItemRegister.magicShard, 1, 0)});
		
		GameRegistry.addShapelessRecipe(new ItemStack(Item.paper, 1, 0), new ItemStack(ConfigItems.itemResearchNotes));
	}
    
	public static ShapedArcaneRecipe pechTradeTier1;
	public static ShapedArcaneRecipe pechTradeTier2;
	public static ShapedArcaneRecipe pechTradeTier3;
	public static ShapedArcaneRecipe pechTradeTier4;
	public static ShapedArcaneRecipe pechTradeTier5;
	public static ShapedArcaneRecipe magicTradeTier1;
	public static ShapedArcaneRecipe magicTradeTier2;
	public static ShapedArcaneRecipe magicTradeTier3;
	public static ShapedArcaneRecipe magicTradeTier4;
	public static ShapedArcaneRecipe magicTradeTier5;
	public static ShapedArcaneRecipe xpExtractor;
	public static ShapedArcaneRecipe ironRod;
	public static ShapedArcaneRecipe goldRod;
	public static ShapedArcaneRecipe diamondRod;
	public static ShapedArcaneRecipe emeraldRod;
	public static ShapedArcaneRecipe angelRod;
	public static ShapedArcaneRecipe devilRod;
	public static ShapedArcaneRecipe godRod;
	public static ShapedArcaneRecipe darkSilverwoodRod;
	public static ShapedArcaneRecipe magicWrench;
	
	public static ShapedArcaneRecipe darkThaumiumPickaxe;
	public static ShapedArcaneRecipe darkThaumiumShovel;
	public static ShapedArcaneRecipe darkThaumiumSword;
	public static ShapedArcaneRecipe darkThaumiumCap;

	public static ShapelessArcaneRecipe ignisFuel;

	public static ShapedArcaneRecipe candyRod;
	public static ShapedArcaneRecipe wardedBlock;
	public static ShapedArcaneRecipe thaumiumGlass;
	public static ShapedArcaneRecipe wardedStairs;
	public static ShapedArcaneRecipe wardedCarpet;
	public static ShapedArcaneRecipe wardedSlab;
	public static ShapedArcaneRecipe wardedWall;
	public static ShapedArcaneRecipe wardedPilar;
	public static ShapedArcaneRecipe wardedCover;
	public static ShapedArcaneRecipe hiddenWarded;
	public static ShapedArcaneRecipe openWarded;
	public static ShapelessArcaneRecipe darkSilverwoodLog;
	public static ShapelessArcaneRecipe darkSilverwoodPlank;

	public static ShapedArcaneRecipe exchanger;
	public static ShapedArcaneRecipe charger;
	public static ShapedArcaneRecipe wandCharger;
	public static ShapedArcaneRecipe darkThaumium;
	public static ShapedArcaneRecipe darkInfuser;
	public static ShapedArcaneRecipe emptyFoci;

	public static ShapedArcaneRecipe battery;
	public static ShapedArcaneRecipe battery2;
	public static ShapedArcaneRecipe battery3;
	public static ShapedArcaneRecipe battery4;

	public static ShapedArcaneRecipe copperRod;
	public static ShapedArcaneRecipe tinRod;
	
	public static InfusionRecipe enderFoci;
	public static InfusionRecipe arrowFoci;
	public static InfusionRecipe healFoci;
	public static InfusionRecipe speedFoci;
	public static InfusionRecipe pechFoci;
	public static InfusionRecipe xpFoci;
	public static InfusionRecipe returnFoci;
	public static InfusionRecipe exchangeFoci;
	public static InfusionRecipe smeltingFoci;
	public static InfusionRecipe dispelFoci;
	public static InfusionRecipe destroyFoci;
	public static InfusionRecipe freezeFoci;
	public static InfusionRecipe beamExchangeFoci;
	public static InfusionRecipe confusionFoci;
	public static InfusionRecipe snowFoci;
	public static InfusionRecipe cleanFoci;
}
