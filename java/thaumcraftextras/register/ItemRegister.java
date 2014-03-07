package thaumcraftextras.register;

import net.minecraft.block.Block;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.EnumHelper;
import thaumcraft.api.wands.WandRod;
import thaumcraft.common.config.ConfigBlocks;
import thaumcraftextras.api.functions.DestroyFunctions;
import thaumcraftextras.api.functions.ExchangeFociFunctions;
import thaumcraftextras.helpers.FuelHelper;
import thaumcraftextras.helpers.MainHelper;
import thaumcraftextras.items.ItemColorPouch;
import thaumcraftextras.items.ItemFociEmpty;
import thaumcraftextras.items.TCEItem;
import thaumcraftextras.items.XPExtractor;
import thaumcraftextras.items.foci.ArrowFoci;
import thaumcraftextras.items.foci.BeamExchangeFoci;
import thaumcraftextras.items.foci.CleanFoci;
import thaumcraftextras.items.foci.ConfusionFoci;
import thaumcraftextras.items.foci.DestroyFoci;
import thaumcraftextras.items.foci.DispelFoci;
import thaumcraftextras.items.foci.EnderFoci;
import thaumcraftextras.items.foci.ExchangeFoci;
import thaumcraftextras.items.foci.ExperienceFoci;
import thaumcraftextras.items.foci.FreezeFoci;
import thaumcraftextras.items.foci.HealFoci;
import thaumcraftextras.items.foci.ReturnFoci;
import thaumcraftextras.items.foci.SmeltingFoci;
import thaumcraftextras.items.foci.SnowballFoci;
import thaumcraftextras.items.foci.SpeedFoci;
import thaumcraftextras.items.tools.DarkThaumiumPickaxe;
import thaumcraftextras.items.tools.DarkThaumiumShovel;
import thaumcraftextras.items.tools.DarkThaumiumSword;
import thaumcraftextras.items.wand.CheatRodOnUpdate;
import thaumcraftextras.items.wand.DarkSilverwoodOnUpdate;
import thaumcraftextras.items.wand.RodItem;
import thaumcraftextras.lib.TCELocalization;
import thaumcraftextras.main.Config;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ItemRegister {

	public static void load()
	{	
		
        toolMatDarkThaumium = EnumHelper.addToolMaterial("DARKTHAUMIUM", 4, -1, 10F, 1F, 25);
		
		ignisFuel = new TCEItem(Config.ignisFuelId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.IgnisFuelTexture);
		LanguageRegistry.addName(ignisFuel, TCELocalization.IgnisFuel);
		GameRegistry.registerFuelHandler(new FuelHelper());
		
		darkThaumium = new TCEItem(Config.darkThaumiumId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.DarkThaumiumTexture);
		LanguageRegistry.addName(darkThaumium, TCELocalization.DarkThaumium);
		
		darkThaumiumNugget = new TCEItem(Config.darkThaumiumNuggetId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.DarkThaumiumNuggetTexture);
		LanguageRegistry.addName(darkThaumiumNugget, TCELocalization.DarkThaumiumNugget);
		
		magicShard = new TCEItem(Config.magicShardId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.MagicShardTexture);
		LanguageRegistry.addName(magicShard, TCELocalization.MagicShard);
		
		greedShard = new TCEItem(Config.greedShardId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.GreedShardTexture);
		LanguageRegistry.addName(greedShard, TCELocalization.GreedShard);
		
		pechTradeTier1 = new TCEItem(Config.pechTradeTier1Id).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.PechTradeTier1Texture);
		LanguageRegistry.addName(pechTradeTier1, TCELocalization.PechTradeTier1);

		pechTradeTier2 = new TCEItem(Config.pechTradeTier2Id).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.PechTradeTier2Texture);
		LanguageRegistry.addName(pechTradeTier2, TCELocalization.PechTradeTier2);
		
		pechTradeTier3 = new TCEItem(Config.pechTradeTier3Id).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.PechTradeTier3Texture);
		LanguageRegistry.addName(pechTradeTier3, TCELocalization.PechTradeTier3);
		
		pechTradeTier4 = new TCEItem(Config.pechTradeTier4Id).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.PechTradeTier4Texture);
		LanguageRegistry.addName(pechTradeTier4, TCELocalization.PechTradeTier4);
		
		pechTradeTier5 = new TCEItem(Config.pechTradeTier5Id).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.PechTradeTier5Texture);
		LanguageRegistry.addName(pechTradeTier5, TCELocalization.PechTradeTier5);
		
		magicTradeTier1 = new TCEItem(Config.magicTradeTier1Id).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.MagicTradeTier1Texture);
		LanguageRegistry.addName(magicTradeTier1, TCELocalization.MagicTradeTier1);
		
		magicTradeTier2 = new TCEItem(Config.magicTradeTier2Id).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.MagicTradeTier2Texture);
		LanguageRegistry.addName(magicTradeTier2, TCELocalization.MagicTradeTier2);
		
		magicTradeTier3 = new TCEItem(Config.magicTradeTier3Id).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.MagicTradeTier3Texture);
		LanguageRegistry.addName(magicTradeTier3, TCELocalization.MagicTradeTier3);
		
		magicTradeTier4 = new TCEItem(Config.magicTradeTier4Id).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.MagicTradeTier4Texture);
		LanguageRegistry.addName(magicTradeTier4, TCELocalization.MagicTradeTier4);
		
		magicTradeTier5 = new TCEItem(Config.magicTradeTier5Id).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.MagicTradeTier5Texture);
		LanguageRegistry.addName(magicTradeTier5, TCELocalization.MagicTradeTier5);
		
		enderFoci = new EnderFoci(Config.enderFociId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.enderFociTexture);
		LanguageRegistry.addName(enderFoci, TCELocalization.enderFoci);
		
		arrowFoci = new ArrowFoci(Config.arrowFociId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.arrowFociTexture);
		LanguageRegistry.addName(arrowFoci, TCELocalization.arrowFoci);
		
		healFoci = new HealFoci(Config.healFociId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.healFociTexture);
		LanguageRegistry.addName(healFoci, TCELocalization.healFoci);
		
		speedFoci = new SpeedFoci(Config.speedFociId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.speedFociTexture);
		LanguageRegistry.addName(speedFoci, TCELocalization.speedFoci);

		xpFoci = new ExperienceFoci(Config.xpFociId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.xpFociTexture);
		LanguageRegistry.addName(xpFoci, TCELocalization.xpFoci);
		
		xpExtractor = new XPExtractor(Config.xpExtractorId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.xpExtractorTexture);
		LanguageRegistry.addName(xpExtractor, TCELocalization.xpExtractor);
		
		returnFoci = new ReturnFoci(Config.returnFociId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.returnFociTexture);
		LanguageRegistry.addName(returnFoci,  TCELocalization.returnFoci);
		
		addToExchanger();
		exchangeFoci = new ExchangeFoci(Config.exchangeFociId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.exchangeFociTexture);
		LanguageRegistry.addName(exchangeFoci,  TCELocalization.exchangeFoci);
		
		smeltingFoci = new SmeltingFoci(Config.smeltingFociId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.smeltingFociTexture);
		LanguageRegistry.addName(smeltingFoci,  TCELocalization.smeltingFoci);
		
		dispelFoci = new DispelFoci(Config.dispelFociId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.dispelFociTexture);
		LanguageRegistry.addName(dispelFoci,  TCELocalization.dispelFoci);
        
		addToDestroy();
		destroyFoci = new DestroyFoci(Config.destroyFociId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.destroyFociTexture);
		LanguageRegistry.addName(destroyFoci,  TCELocalization.destroyFoci);
		
		darkThaumiumPickaxe = new DarkThaumiumPickaxe(Config.darkThaumiumPickaxeId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.darkThaumiumPickaxeTexture);
		LanguageRegistry.addName(darkThaumiumPickaxe, TCELocalization.darkThaumiumPickaxe);
		
		darkThaumiumShovel = new DarkThaumiumShovel(Config.darkThaumiumShovelId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.darkThaumiumShovelTexture);
		LanguageRegistry.addName(darkThaumiumShovel, TCELocalization.darkThaumiumShovel);
		
		darkThaumiumSword = new DarkThaumiumSword(Config.darkThaumiumSwordId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.darkThaumiumSwordTexture);
		LanguageRegistry.addName(darkThaumiumSword, TCELocalization.darkThaumiumSword);
		
		freezeFoci = new FreezeFoci(Config.freezeFociId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.freezeFociTexture);
		LanguageRegistry.addName(freezeFoci,  TCELocalization.freezeFoci);
		
		beamExchangeFoci = new BeamExchangeFoci(Config.beamExchangeFociId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.beamExchangeFociTexture);
		LanguageRegistry.addName(beamExchangeFoci,  TCELocalization.beamExchangeFoci);

		confusionFoci = new ConfusionFoci(Config.confusionFociId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.confusionFociTexture);
		LanguageRegistry.addName(confusionFoci,  TCELocalization.confusionFoci);
		
		snowFoci = new SnowballFoci(Config.snowballFociId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.snowFociTexture);
		LanguageRegistry.addName(snowFoci,  TCELocalization.snowFoci);
		
		cleanFoci = new CleanFoci(Config.cleanFociId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.cleanFociTexture);
		LanguageRegistry.addName(cleanFoci,  TCELocalization.cleanFoci);
		
		colorPouch = new ItemColorPouch(Config.colorPouchId);
		LanguageRegistry.addName(colorPouch, TCELocalization.colorPouch);
		
		emptyFoci = new ItemFociEmpty(Config.emptyFociId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.emptyFociTexture);
		LanguageRegistry.addName(emptyFoci, TCELocalization.emptyFoci);
		
		//book = new ItemInfo(Config.infoBookId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.infoBookTexture);
		//LanguageRegistry.addName(book, TCELocalization.infoBook);
        
		/** Special Wands */
		ultimateRodItem = new RodItem(Config.ultimateRodId).setUnlocalizedName("ultimate");
        ultimateRod = new WandRod("ULTIMATE", 9999999, new ItemStack(ultimateRodItem), 999, new CheatRodOnUpdate(),  new ResourceLocation("thaumcraftextras","textures/models/wand_rod_ultimate.png"));
        LanguageRegistry.addName(ultimateRodItem, "Ultimate Rod");
        
        /** Tier Rods */
<<<<<<< HEAD
		//ironRodItem = new RodItem(Config.ironRodId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.ironRodTexture);
		//ironRodItem = new RodItem(Config.ironRodId).setUnlocalizedName("iron");
       // ironRod = new WandRod("IRON", 65, new ItemStack(ironRodItem), 14,  new ResourceLocation("thaumcraftextras","textures/models/wand_rod_iron.png"));
		ironRodItem = new RodItem(Config.ironRodId).setUnlocalizedName("iron");
=======
		ironRodItem = new RodItem(Config.ironRodId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.ironRodTexture);
<<<<<<< HEAD
>>>>>>> dbba2faa58d25c8a09aa7e9a446d085a51bbe75f
=======
>>>>>>> dbba2faa58d25c8a09aa7e9a446d085a51bbe75f
        ironRod = new WandRod("IRON", 65, new ItemStack(ironRodItem), 14,  new ResourceLocation("thaumcraftextras","textures/models/wand_rod_iron.png"));
        LanguageRegistry.addName(ironRodItem, "Iron Rod");
        
		goldRodItem = new RodItem(Config.goldRodId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.goldRodTexture);
        goldRod = new WandRod("GOLD", 60, new ItemStack(goldRodItem), 12,  new ResourceLocation("thaumcraftextras","textures/models/wand_rod_gold.png"));
        LanguageRegistry.addName(goldRodItem, "Gold Rod");
        
		diamondRodItem = new RodItem(Config.diamondRodId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.diamondRodTexture);
        diamondRod = new WandRod("DIAMOND", 90, new ItemStack(diamondRodItem), 18,  new ResourceLocation("thaumcraftextras","textures/models/wand_rod_diamond.png"));
        LanguageRegistry.addName(diamondRodItem, "Diamond Rod");
        
		emeraldRodItem = new RodItem(Config.emeraldRodId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.emeraldRodTexture);
        emeraldRod = new WandRod("EMERALD", 95, new ItemStack(emeraldRodItem), 16,  new ResourceLocation("thaumcraftextras","textures/models/wand_rod_emerald.png"));
        LanguageRegistry.addName(emeraldRodItem, "Emerald Rod");
	
		angelRodItem = new RodItem(Config.angelRodId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.angelRodTexture);
        angelRod = new WandRod("ANGEL", 150, new ItemStack(angelRodItem), 20,  new ResourceLocation("thaumcraftextras","textures/models/wand_rod_angel.png"));
        LanguageRegistry.addName(angelRodItem, "Angel Rod");
        
        devilRodItem = new RodItem(Config.devilRodId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.devilRodTexture);
        devilRod = new WandRod("DEVIL", 250, new ItemStack(devilRodItem), 30,  new ResourceLocation("thaumcraftextras","textures/models/wand_rod_devil.png"));
        LanguageRegistry.addName(devilRodItem, "Devil Rod");
        
        godRodItem = new RodItem(Config.godRodId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.godRodTexture);
        godRod = new WandRod("GOD", 500, new ItemStack(godRodItem), 40,  new ResourceLocation("thaumcraftextras","textures/models/wand_rod_god.png"));
        LanguageRegistry.addName(godRodItem, "God Rod");
        
        darkSilverwoodRodItem = new RodItem(Config.darkSilverwoodRodId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.darkSilverwoodRodTexture);
        darkSilverwoodRod = new WandRod("DARKSILVERWOOD", 1000, new ItemStack(darkSilverwoodRodItem), 50, new DarkSilverwoodOnUpdate(),new ResourceLocation("thaumcraftextras","textures/models/wand_rod_darksilverwood.png"));
        LanguageRegistry.addName(darkSilverwoodRodItem, "Dark Silverwood Rod");
        
        //darkThaumiumCapItem = new CapItem(Config.darkThaumiumCapId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.darkThaumiumCapTexture);
        // darkThaumiumCap = new WandCaps();
        //darkThaumiumCap = new WandCap("darkThaumium", 0.7F, new ItemStack(darkThaumiumNugget), 10);
       
        //LanguageRegistry.addName(darkThaumiumCapItem, "Dark Thaumium Cap");
       
        
        /** Event Items */
		candyRodItem = new RodItem(Config.candyRodId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.candyRodTexture);
        candyRod = new WandRod("candy", 35, new ItemStack(candyRodItem), 6,  new ResourceLocation("thaumcraftextras","textures/models/wand_rod_candy.png"));
        LanguageRegistry.addName(candyRodItem, "Candy Rod");
	}
	
	public static void addToDestroy()
	{
	    DestroyFunctions.canDestroy.put(BlockRegister.wardedBlock.blockID, 0);
	    DestroyFunctions.canDestroy.put(BlockRegister.wardedCarpet.blockID, 1);
	   // DestroyFunctions.canDestroy.put(BlockRegister.wardedCover.blockID, 2);
	    DestroyFunctions.canDestroy.put(BlockRegister.wardedGlass.blockID, 3);
	    DestroyFunctions.canDestroy.put(BlockRegister.wardedPilar.blockID, 4);
	    DestroyFunctions.canDestroy.put(BlockRegister.wardedSlab.blockID, 5);
	    DestroyFunctions.canDestroy.put(BlockRegister.wardedWall.blockID, 6);
	    DestroyFunctions.canDestroy.put(BlockRegister.openWarded.blockID, 7);
	    DestroyFunctions.canDestroy.put(BlockRegister.hiddenWarded.blockID, 8);
	    DestroyFunctions.canDestroy.put(Block.bedrock.blockID, 9);
	}
	
	public static void addToExchanger()
	{
		ExchangeFociFunctions.canBeExchange.put(Block.stoneBrick.blockID, 3);
		ExchangeFociFunctions.canBeExchange.put(Block.wood.blockID, 3);
		ExchangeFociFunctions.canBeExchange.put(Block.planks.blockID, 3);
		ExchangeFociFunctions.canBeExchange.put(Block.sandStone.blockID, 3);
		ExchangeFociFunctions.canBeExchange.put(Block.sapling.blockID, 3);
		ExchangeFociFunctions.canBeExchange.put(Block.leaves.blockID, 3);
		ExchangeFociFunctions.canBeExchange.put(Block.woodSingleSlab.blockID, 3);
		ExchangeFociFunctions.canBeExchange.put(Block.woodDoubleSlab.blockID, 3);
		ExchangeFociFunctions.canBeExchange.put(Block.stoneSingleSlab.blockID, 6);
		ExchangeFociFunctions.canBeExchange.put(ConfigBlocks.blockCandle.blockID, 15);
		ExchangeFociFunctions.canBeExchange.put(Block.stainedClay.blockID, 16);
		ExchangeFociFunctions.canBeExchange.put(Block.cloth.blockID, 16);
		ExchangeFociFunctions.canBeExchange.put(Block.carpet.blockID, 16);

	}
	
	public static void recipe()
	{
	}
	
	public static Item colorPouch;
	public static Item emptyFoci;
	//public static Item book;

	public static Item pechTradeTier1;
	public static Item pechTradeTier2;
	public static Item pechTradeTier3;
	public static Item pechTradeTier4;
	public static Item pechTradeTier5;
	
	public static Item magicTradeTier1;
	public static Item magicTradeTier2;
	public static Item magicTradeTier3;
	public static Item magicTradeTier4;
	public static Item magicTradeTier5;
	
	public static Item ignisFuel;
	public static Item xpExtractor;
	public static Item darkThaumium;
	public static Item darkThaumiumNugget;
	public static Item magicShard;
	public static Item greedShard;
	
	public static Item enderFoci;
	public static Item arrowFoci;
	public static Item healFoci;
	public static Item speedFoci;
	public static Item xpFoci;
	public static Item returnFoci;
	public static Item exchangeFoci;
	public static Item smeltingFoci;
	public static Item dispelFoci;
	public static Item destroyFoci;
	public static Item freezeFoci;
	public static Item beamExchangeFoci;
	public static Item beamHealFoci;
	public static Item confusionFoci;
	public static Item fireworkFoci;
	public static Item snowFoci;
	public static Item cleanFoci;
	//public static Item customFoci;
	
	public static WandRod ultimateRod;
	public static WandRod ironRod;
	public static WandRod goldRod;
	public static WandRod diamondRod;
	public static WandRod emeraldRod;
	public static WandRod candyRod;
	public static WandRod angelRod;
	public static WandRod devilRod;
	public static WandRod godRod;
	public static WandRod darkSilverwoodRod;

	//public static WandCap darkThaumiumCap;

	public static Item ultimateRodItem;
	public static Item ironRodItem;
	public static Item goldRodItem;
	public static Item diamondRodItem;
	public static Item emeraldRodItem;
	public static Item candyRodItem;
	public static Item angelRodItem;
	public static Item devilRodItem;
	public static Item godRodItem;
	public static Item darkSilverwoodRodItem;
	
	//public static Item darkThaumiumCapItem;

	public static Item darkThaumiumPickaxe;
	public static Item darkThaumiumShovel;
	public static Item darkThaumiumSword;
	
    public static EnumToolMaterial toolMatDarkThaumium;

}
