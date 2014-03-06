package thaumcraftextras.register;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.ShapedArcaneRecipe;
import thaumcraft.api.crafting.ShapelessArcaneRecipe;
import thaumcraft.common.config.ConfigItems;
import thaumcraftextras.api.items.Shard;
import thaumcraftextras.helpers.MainHelper;
import thaumcraftextras.items.XPShard;
import thaumcraftextras.lib.CraftingAspects;
import thaumcraftextras.lib.TCELocalization;
import thaumcraftextras.main.Config;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class InfusionRegister {

	public static void load()
	{	
		emptyShard = new Shard(Config.emptyShardId, "Empty", 0xCCCC99);
		lightShard = new Shard(Config.lightShardId, "Light", 0xFFFF33);
		enderShard = new Shard(Config.enderShardId, "Ender", 0x003333);

		xpShard = new XPShard(Config.xpShardId).setUnlocalizedName(MainHelper.modName + ":" + TCELocalization.xpShardTexture);
		LanguageRegistry.addName(xpShard, TCELocalization.xpShard);
	}
	
	public static void recipe()
	{
		airBlock = ThaumcraftApi.addShapelessArcaneCraftingRecipe("Block Infusion",
				new ItemStack(BlockRegister.airBlock),
				new AspectList().add(Aspect.AIR, 18), Block.stoneBrick, 
				new ItemStack(ConfigItems.itemShard, 1, 0));
		
		emptyShardRecipe = ThaumcraftApi.addArcaneCraftingRecipe("Shard Infusion", new ItemStack(emptyShard, 1, 0), CraftingAspects.emptyFoci,  new Object[]{
			"YIY",
			"IXI",
			"YIY",
			'X', new ItemStack(ConfigItems.itemShard, 1, 0),
			'I', Block.glass,
			'Y', Item.ingotIron});
		
		
		if(Config.lightBlock = true)
		{
			lightBlock = ThaumcraftApi.addShapelessArcaneCraftingRecipe(TCELocalization.LightBlock, 
					new ItemStack(BlockRegister.lightBlock), new AspectList().add(Aspect.FIRE, 2).add(Aspect.AIR, 2), 
					Block.stoneBrick, 
					lightShard);
		}
		
		if(Config.waterBlock = true)
		{
			waterBlock = ThaumcraftApi.addShapelessArcaneCraftingRecipe(TCELocalization.WaterBlock, 
					new ItemStack(BlockRegister.waterBlock), new AspectList().add(Aspect.WATER, 2), 
					Block.stoneBrick, 
					new ItemStack(ConfigItems.itemShard, 1, 2));
		}
		
		if(Config.earthBlock = true)
		{
			earthBlock = ThaumcraftApi.addShapelessArcaneCraftingRecipe(TCELocalization.EarthBlock, 
					new ItemStack(BlockRegister.earthBlock), new AspectList().add(Aspect.EARTH, 2), 
					Block.stoneBrick, 
					new ItemStack(ConfigItems.itemShard, 1, 3));
		}
		
		if(Config.fireBlock = true)
		{
			fireBlock = ThaumcraftApi.addShapelessArcaneCraftingRecipe(TCELocalization.FireBlock, 
					new ItemStack(BlockRegister.fireBlock), new AspectList().add(Aspect.FIRE, 2), 
					Block.stoneBrick, 
					new ItemStack(ConfigItems.itemShard, 1, 1));
		}
		
		if(Config.lightBlock = true)
		{
			lightShardRecipe = ThaumcraftApi.addShapelessArcaneCraftingRecipe("Shard Infusion", 
					new ItemStack(lightShard), new AspectList().add(Aspect.AIR, 2), 
					emptyShard, 
					Block.torchWood);
		}
		
		if(Config.enderBlock = true)
		{
			enderShardRecipe = ThaumcraftApi.addShapelessArcaneCraftingRecipe("Shard Infusion", 
					new ItemStack(enderShard), new AspectList().add(Aspect.AIR, 2), 
					emptyShard, 
					Item.enderPearl);
			
			enderBlock = ThaumcraftApi.addShapelessArcaneCraftingRecipe(TCELocalization.EnderBlock, 
					new ItemStack(BlockRegister.enderBlock), new AspectList().add(Aspect.ENTROPY, 2), 
					Block.stoneBrick, 
					enderShard);
		}
		
		}
	

	public static ShapelessArcaneRecipe airBlock;
	public static ShapelessArcaneRecipe fireBlock;
	public static ShapelessArcaneRecipe waterBlock;
	public static ShapelessArcaneRecipe earthBlock;
	public static ShapelessArcaneRecipe lightBlock;
	public static ShapelessArcaneRecipe enderBlock;
	
	public static ShapelessArcaneRecipe lightShardRecipe;
	public static ShapelessArcaneRecipe enderShardRecipe;
	public static ShapedArcaneRecipe emptyShardRecipe;

	public static Shard lightShard;
	public static Shard enderShard;
	public static Item xpShard;
	public static Shard emptyShard;	
}