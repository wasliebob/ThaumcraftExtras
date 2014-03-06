package thaumcraftextras.main;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Config {


	public static void loadConfig(FMLPreInitializationEvent e){
		Configuration config = new Configuration(e.getSuggestedConfigurationFile());

	        researchBlockId = config.getBlock("researchBlock", 224).getInt();
	        fireBlockId = config.getBlock("fireBlock", 225).getInt();
	        airBlockId = config.getBlock("airBlock", 226).getInt();
	        earthBlockId = config.getBlock("earthBlock", 227).getInt();
	        waterBlockId = config.getBlock("waterBlock", 228).getInt();
	        lightBlockId = config.getBlock("lightBlock", 229).getInt();
	        ignisFuelBlockId = config.getBlock("ignisFuelBlock", 330).getInt();
	        cactusBlockId = config.getBlock("cactusBlock", 331).getInt();
	        enderBlockId = config.getBlock("enderBlock", 332).getInt();
	        wardedGlassId = config.getBlock("wardedGlass", 333).getInt();
	        wardedBlockId = config.getBlock("wardedBlock", 335).getInt();
	        wardedSlabId = config.getBlock("wardedSlab", 336).getInt();
	        wardedCarpetId = config.getBlock("wardedCarpet", 337).getInt();
	        wardedWallId = config.getBlock("wardedWall", 338).getInt();
	        wardedPillarId = config.getBlock("wardedPillar", 339).getInt();
	        wardedCoverId = config.getBlock("wardedCover", 400).getInt();
	        hiddenWardedId = config.getBlock("hiddenWarded", 410).getInt();
	        openWardedId = config.getBlock("openWarded", 411).getInt();
	        darkSilverwoodId = config.getBlock("darkSilverwood", 412).getInt();
	        darkSilverwoodLogId = config.getBlock("darkSilverwoodLog", 413).getInt();
	        darkBrickId = config.getBlock("darkBrick", 414).getInt();
	        darkAmberId = config.getBlock("darkAmber", 415).getInt();
	        
	        mckChargerId = config.getBlock("mckCharger", 420).getInt();
	        exchangerId = config.getBlock("exchanger", 421).getInt();
	       // cableId = config.getBlock("cable", 423).getInt();
	        chargerId = config.getBlock("charger", 424).getInt();
	        infuserId = config.getBlock("infuser", 425).getInt();

	        magicCrystalId = config.getItem("magicCrystal", 11200).getInt();
	        magicCrystalT2Id = config.getItem("magicCrystalT2", 11201).getInt();
	        magicCrystalT3Id = config.getItem("magicCrystalT3", 11202).getInt();
	        magicCrystalT4Id = config.getItem("magicCrystalT4", 11203).getInt();

	        magicWrenchId = config.getItem("magicWrench", 11210).getInt();

	        pechTradeTier1Id = config.getItem("pechTradeTier1", 12225).getInt();
	        pechTradeTier2Id = config.getItem("pechTradeTier2", 12226).getInt();
	        pechTradeTier3Id = config.getItem("pechTradeTier3", 12227).getInt();
	        pechTradeTier4Id = config.getItem("pechTradeTier4", 12228).getInt();
	        pechTradeTier5Id = config.getItem("pechTradeTier5", 12229).getInt();

	        magicTradeTier1Id = config.getItem("magicTradeTier1", 12230).getInt();
	        magicTradeTier2Id = config.getItem("magicTradeTier2", 12231).getInt();
	        magicTradeTier3Id = config.getItem("magicTradeTier3", 12232).getInt();
	        magicTradeTier4Id = config.getItem("magicTradeTier4", 12233).getInt();
	        magicTradeTier5Id = config.getItem("magicTradeTier5", 12234).getInt();
	        
	        ignisFuelId = config.getItem("ignisFuel", 12235).getInt();
	        ultimateRodId = config.getItem("ultimateRod", 12236).getInt();
	        ironRodId = config.getItem("ironRod", 12237).getInt();
	        goldRodId = config.getItem("goldRod", 12238).getInt();
	        diamondRodId = config.getItem("diamondRod", 12239).getInt();
	        emeraldRodId = config.getItem("emeraldRod", 12240).getInt();
	        candyRodId = config.getItem("candyRod", 12241).getInt();
	        angelRodId = config.getItem("angelRod", 12242).getInt();
	        devilRodId = config.getItem("devilRod", 12243).getInt();
	        godRodId = config.getItem("godRod", 12244).getInt();
	        darkSilverwoodRodId = config.getItem("darkSilverwoodRod", 12245).getInt();

	        //darkThaumiumCapId = config.getItem("darkSilverwoodCap", 12260).getInt();

	        enderFociId = config.getItem("enderFoci", 13230).getInt();
	        arrowFociId = config.getItem("arrowFoci", 13231).getInt();
	        healFociId = config.getItem("healFoci", 13232).getInt();
	        speedFociId = config.getItem("speedFoci", 13233).getInt();
	        xpFociId = config.getItem("xpFoci", 13235).getInt();
	        returnFociId = config.getItem("returnFoci", 13256).getInt();
	        exchangeFociId = config.getItem("exchangeFoci", 13257).getInt();
	        smeltingFociId = config.getItem("smeltingFoci", 13258).getInt();
	        dispelFociId = config.getItem("dispelFoci", 13259).getInt();
	        destroyFociId = config.getItem("destoryFoci", 13260).getInt();
	        freezeFociId = config.getItem("freezeFoci", 13263).getInt();
	        beamExchangeFociId = config.getItem("beamExchangeFoci", 13264).getInt();
	        confusionFociId = config.getItem("confusionFoci", 13265).getInt();
	        snowballFociId = config.getItem("snowballFoci", 13266).getInt();
	        cleanFociId = config.getItem("cleanFoci", 13267).getInt();
	        
	        colorPouchId = config.getItem("colorFoci", 13300).getInt();
	        //infoBookId = config.getItem("infoBook", 13301).getInt();

	        magicShardId = config.getItem("magicShard", 13401).getInt();
	        greedShardId = config.getItem("greedShard", 13402).getInt();
	        darkThaumiumNuggetId = config.getItem("darkThaumiumNugget", 13400).getInt();
	        draconicNuggetId = config.getItem("draconicNugget", 13401).getInt();
	        reinforcedNuggetId = config.getItem("reinforcedNugget", 13402).getInt();
	        sunstoneNuggetId = config.getItem("sunstoneNugget", 13403).getInt();
	        darkThaumiumPickaxeId = config.getItem("darkThaumiumPickaxe", 13404).getInt();
	        darkThaumiumShovelId = config.getItem("darkThaumiumShovel", 13405).getInt();
	        darkThaumiumSwordId = config.getItem("darkThaumiumSword", 13406).getInt();

	        lightShardId = config.getItem("lightShard", 14201).getInt();
	        emptyShardId = config.getItem("emptyShard", 14202).getInt();
	        xpShardId = config.getItem("xpShard", 14203).getInt();
	        xpExtractorId = config.getItem("xpExtractor", 14204).getInt();
	        darkThaumiumId = config.getItem("darkThaumium", 14205).getInt();
	        emptyFociId = config.getItem("emptyFoci", 14206).getInt();
	        enderShardId = config.getItem("emderShard", 14207).getInt();

	        enderFoci = config.get(Configuration.CATEGORY_GENERAL, "enderFoci", true).getBoolean(enderFoci);
	    	arrowFoci = config.get(Configuration.CATEGORY_GENERAL, "arrowFoci", true).getBoolean(arrowFoci);
	    	healFoci = config.get(Configuration.CATEGORY_GENERAL, "healFoci", true).getBoolean(healFoci);
	    	speedFoci = config.get(Configuration.CATEGORY_GENERAL, "speedFoci", true).getBoolean(speedFoci);
	    	fireBlock = config.get(Configuration.CATEGORY_GENERAL, "fireBlock", true).getBoolean(fireBlock);
	    	earthBlock = config.get(Configuration.CATEGORY_GENERAL, "earthBlock", true).getBoolean(earthBlock);
	    	waterBlock = config.get(Configuration.CATEGORY_GENERAL, "waterBlock", true).getBoolean(waterBlock);
	    	lightBlock = config.get(Configuration.CATEGORY_GENERAL, "lightBlock", true).getBoolean(lightBlock);
	    	pechTrade = config.get(Configuration.CATEGORY_GENERAL, "pechTrade", true).getBoolean(pechTrade);
	    	magicTrade = config.get(Configuration.CATEGORY_GENERAL, "magicTrade", true).getBoolean(magicTrade);
	    	xpFoci = config.get(Configuration.CATEGORY_GENERAL, "xpFoci", true).getBoolean(xpFoci);
	    	xpExtractor = config.get(Configuration.CATEGORY_GENERAL, "xpExtractor", true).getBoolean(xpExtractor);
	    	returnFoci = config.get(Configuration.CATEGORY_GENERAL, "returnFoci", true).getBoolean(returnFoci);
	    	exchangeFoci = config.get(Configuration.CATEGORY_GENERAL, "exchangeFoci", true).getBoolean(exchangeFoci);
	    	smeltingFoci = config.get(Configuration.CATEGORY_GENERAL, "smeltingFoci", true).getBoolean(smeltingFoci);
	    	dispelFoci = config.get(Configuration.CATEGORY_GENERAL, "dispelFoci", true).getBoolean(dispelFoci);
	    	destroyFoci = config.get(Configuration.CATEGORY_GENERAL, "destroyFoci", true).getBoolean(destroyFoci);
	    	freezeFoci = config.get(Configuration.CATEGORY_GENERAL, "freezeFoci", true).getBoolean(freezeFoci);
	    	enderBlock = config.get(Configuration.CATEGORY_GENERAL, "enderBlock", true).getBoolean(enderBlock);
	    	beamExchangeFoci = config.get(Configuration.CATEGORY_GENERAL, "beamExchangeFoci", true).getBoolean(beamExchangeFoci);
	    	confusionFoci = config.get(Configuration.CATEGORY_GENERAL, "confusionFoci", true).getBoolean(confusionFoci);
	    	eventFoci = config.get(Configuration.CATEGORY_GENERAL, "eventFoci", true).getBoolean(eventFoci);
	    	wardedBlocks = config.get(Configuration.CATEGORY_GENERAL, "wardedBlocks", true).getBoolean(wardedBlocks);
	    	wandRods = config.get(Configuration.CATEGORY_GENERAL, "wandRods", true).getBoolean(wandRods);
	    	ignisFuel = config.get(Configuration.CATEGORY_GENERAL, "ignisFuel", true).getBoolean(ignisFuel);
	    	cleanFoci = config.get(Configuration.CATEGORY_GENERAL, "cleanFoci", true).getBoolean(cleanFoci);
	    	magicEnergy = config.get(Configuration.CATEGORY_GENERAL, "magicEnergy", true).getBoolean(magicEnergy);
	    	tools = config.get(Configuration.CATEGORY_GENERAL, "tools", true).getBoolean(tools);

	    	multipartTC4 = config.get(Configuration.CATEGORY_GENERAL, "thaumcraft4Multipart", false).getBoolean(multipartTC4);
	    	multipart = config.get(Configuration.CATEGORY_GENERAL, "multipart", true).getBoolean(multipart);
	    	forestrySupport = config.get(Configuration.CATEGORY_GENERAL, "forestrySupport", false).getBoolean(forestrySupport);
	    	capes = config.get(Configuration.CATEGORY_GENERAL, "capes", true).getBoolean(capes);
	    	updateNotification = config.get(Configuration.CATEGORY_GENERAL, "updateNotification", true).getBoolean(updateNotification);
	    	config.save();
}
	
    public static int researchBlockId;
    public static int fireBlockId;
    public static int airBlockId;
    public static int waterBlockId;
    public static int earthBlockId;
    public static int lightBlockId;
    //public static int darkBlockId;
    public static int cactusBlockId;
    public static int enderBlockId;
	//public static int teleporterBlockId;
    public static int teslaBlockId;
	public static int colorBlockId;
	public static int infusionInfoId;
	public static int wardedBlockId;
	public static int wardedSlabId;
	public static int wardedCarpetId;
	public static int wardedWallId;
	public static int wardedGlassId;
	public static int wardedPillarId;
	public static int wardedCoverId;
	public static int hiddenWardedId;
	public static int openWardedId;
	public static int darkSilverwoodId;
	public static int darkSilverwoodLogId;

	public static int magicCrystalId;
	public static int magicCrystalT2Id;
	public static int magicCrystalT3Id;
	public static int magicCrystalT4Id;

	public static int magicWrenchId;
	public static int mckChargerId;
	public static int exchangerId;
	public static int infuserId;
	public static int chargerId;
	//public static int cableId;

    public static int pechTradeTier1Id;
    public static int pechTradeTier2Id;
    public static int pechTradeTier3Id;
    public static int pechTradeTier4Id;
    public static int pechTradeTier5Id;
    
    public static int magicTradeTier1Id;
    public static int magicTradeTier2Id;
    public static int magicTradeTier3Id;
    public static int magicTradeTier4Id;
    public static int magicTradeTier5Id;
    
    public static int ignisFuelId;
    public static int magicShardId;
    public static int greedShardId;
    public static int darkThaumiumNuggetId;
    public static int draconicNuggetId;
    public static int reinforcedNuggetId;
    public static int sunstoneNuggetId;
    public static int darkThaumiumPickaxeId;
    public static int darkThaumiumShovelId;
    public static int darkThaumiumSwordId;

    public static int ignisFuelBlockId;

    public static int ultimateRodId;
    public static int ironRodId;
	public static int goldRodId;
	public static int diamondRodId;
	public static int emeraldRodId;
	public static int candyRodId;
	public static int angelRodId;
	public static int devilRodId;
	public static int godRodId;
	public static int darkSilverwoodRodId;
	public static int darkBrickId;
	public static int darkAmberId;

	//public static int darkThaumiumCapId;

    public static int enderFociId;
    public static int arrowFociId;  
    public static int healFociId;
    public static int speedFociId;
    public static int xpFociId;
    public static int returnFociId;
    public static int exchangeFociId;
    public static int smeltingFociId;
    public static int dispelFociId;
    public static int destroyFociId;
    public static int freezeFociId;
    public static int beamExchangeFociId;
    public static int confusionFociId;
    public static int snowballFociId;
    public static int cleanFociId;
    
    public static int darkThaumiumId;
    public static int emptyFociId;

    public static int lightShardId;
    public static int enderShardId;
    public static int emptyShardId;
    
    public static int xpShardId;
    public static int xpExtractorId;
    public static int colorPouchId;
    //public static int infoBookId;

    public static boolean enderFoci;
    public static boolean arrowFoci;
    public static boolean healFoci;
    public static boolean speedFoci;
    public static boolean pechTrade;
    public static boolean magicTrade;
    public static boolean fireBlock;
    public static boolean waterBlock;
    public static boolean lightBlock;
    public static boolean earthBlock;
    public static boolean xpExtractor;
    public static boolean xpFoci;
    public static boolean returnFoci;
    public static boolean exchangeFoci;
    public static boolean dispelFoci;
    public static boolean smeltingFoci;
    public static boolean destroyFoci;
    public static boolean freezeFoci;
    public static boolean enderBlock;
	public static boolean beamExchangeFoci;
	public static boolean confusionFoci;
	public static boolean eventFoci;
	public static boolean wandRods;
	public static boolean wardedBlocks;
	public static boolean ignisFuel;
	public static boolean cleanFoci;
	public static boolean magicEnergy;
	public static boolean tools;
	
	public static boolean forestrySupport;
	public static boolean capes;
	public static boolean updateNotification;
	public static boolean multipart;
	public static boolean multipartTC4;

	}
