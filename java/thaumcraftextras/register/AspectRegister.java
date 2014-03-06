package thaumcraftextras.register;

import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraftextras.main.Config;

public class AspectRegister{

	public static void addAspects()
	{

		int amount = 9999;
		//AspectList a = new AspectList().add(Aspect.AIR, amount).add(Aspect.ARMOR, amount).add(Aspect.AURA, amount).add(Aspect.BEAST, amount).add(Aspect.CLOTH, amount).add(Aspect.CRAFT, amount).add(Aspect.CROP, amount).add(Aspect.CRYSTAL, amount).add(Aspect.DARKNESS ,amount).add(Aspect.DEATH, amount).add(Aspect.EARTH, amount).add(Aspect.ELDRITCH, amount).add(Aspect.ENERGY, amount).add(Aspect.ENTROPY, amount).add(Aspect.EXCHANGE, amount).add(Aspect.FIRE, amount).add(Aspect.FLESH, amount).add(Aspect.FLIGHT, amount).add(Aspect.GREED, amount).add(Aspect.HARVEST, amount).add(Aspect.HEAL, amount).add(Aspect.HUNGER, amount).add(Aspect.ICE, amount).add(Aspect.LIFE, amount).add(Aspect.LIGHT, amount).add(Aspect.MAGIC, amount).add(Aspect.MAN, amount).add(Aspect.MECHANISM, amount).add(Aspect.METAL, amount).add(Aspect.MIND, amount).add(Aspect.MINE, amount).add(Aspect.MOTION, 9).add(Aspect.ORDER, amount).add(Aspect.PLANT, amount).add(Aspect.POISON, amount).add(Aspect.SEED, amount).add(Aspect.SENSES, amount).add(Aspect.SLIME, amount).add(Aspect.SOUL, amount).add(Aspect.STONE, amount).add(Aspect.TAINT, amount).add(Aspect.TOOL, amount).add(Aspect.TRAP, amount).add(Aspect.TRAVEL, amount).add(Aspect.TREE, amount).add(Aspect.UNDEAD, amount).add(Aspect.VOID, amount).add(Aspect.WATER, amount).add(Aspect.WEAPON, amount).add(Aspect.WEATHER, amount);

		AspectList a = new AspectList().add(Aspect.AIR, 999).add(Aspect.ENTROPY, 999).add(Aspect.ORDER, 999).add(Aspect.EARTH, 999).add(Aspect.WATER, 999).add(Aspect.FIRE, 999);
		ThaumcraftApi.registerObjectTag(Config.researchBlockId, -1, a);
		
		ThaumcraftApi.registerObjectTag(Config.fireBlockId, -1, new AspectList().add(Aspect.FIRE, 4));
		ThaumcraftApi.registerObjectTag(Config.airBlockId, -1, new AspectList().add(Aspect.AIR, 4));
		ThaumcraftApi.registerObjectTag(Config.waterBlockId , -1, new AspectList().add(Aspect.WATER, 4));
		ThaumcraftApi.registerObjectTag(Config.earthBlockId , -1, new AspectList().add(Aspect.EARTH, 4));
		ThaumcraftApi.registerObjectTag(Config.enderBlockId , -1, new AspectList().add(Aspect.ENTROPY, 10).add(Aspect.ENTROPY, 5));
		ThaumcraftApi.registerObjectTag(Config.wardedGlassId, -1, new AspectList().add(Aspect.METAL, 5).add(Aspect.METAL, 5).add(Aspect.CRYSTAL, 5));
		//ThaumcraftApi.registerObjectTag(Config.darkBlockId , -1, new AspectList().add(Aspect.DARKNESS, 18));
		
		ThaumcraftApi.registerObjectTag(Config.pechTradeTier1Id, -1, new AspectList().add(Aspect.EXCHANGE, 2).add(Aspect.GREED, 2));
		ThaumcraftApi.registerObjectTag(Config.pechTradeTier2Id, -1, new AspectList().add(Aspect.EXCHANGE, 4).add(Aspect.GREED, 4));
		ThaumcraftApi.registerObjectTag(Config.pechTradeTier3Id, -1, new AspectList().add(Aspect.EXCHANGE, 6).add(Aspect.GREED, 6));
		ThaumcraftApi.registerObjectTag(Config.pechTradeTier4Id, -1, new AspectList().add(Aspect.EXCHANGE, 8).add(Aspect.GREED, 8));
		ThaumcraftApi.registerObjectTag(Config.pechTradeTier5Id, -1, new AspectList().add(Aspect.EXCHANGE, 10).add(Aspect.GREED, 10));
	
		ThaumcraftApi.registerObjectTag(Config.magicTradeTier1Id, -1, new AspectList().add(Aspect.MAGIC, 2));
		ThaumcraftApi.registerObjectTag(Config.magicTradeTier2Id, -1, new AspectList().add(Aspect.MAGIC, 4));
		ThaumcraftApi.registerObjectTag(Config.magicTradeTier3Id, -1, new AspectList().add(Aspect.MAGIC, 6));
		ThaumcraftApi.registerObjectTag(Config.magicTradeTier4Id, -1, new AspectList().add(Aspect.MAGIC, 8));
		ThaumcraftApi.registerObjectTag(Config.magicTradeTier5Id, -1, new AspectList().add(Aspect.MAGIC, 10));

		ThaumcraftApi.registerObjectTag(Config.enderFociId, -1, new AspectList().add(Aspect.MAGIC, 10).add(Aspect.ELDRITCH, 10));
		ThaumcraftApi.registerObjectTag(Config.arrowFociId, -1, new AspectList().add(Aspect.MAGIC, 10).add(Aspect.AIR, 10));
		ThaumcraftApi.registerObjectTag(Config.healFociId, -1, new AspectList().add(Aspect.MAGIC, 10).add(Aspect.HEAL, 5));
		ThaumcraftApi.registerObjectTag(Config.speedFociId, -1, new AspectList().add(Aspect.MAGIC, 10).add(Aspect.AIR, 5));

	}
}
