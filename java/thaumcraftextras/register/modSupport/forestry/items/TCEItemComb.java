package thaumcraftextras.register.modSupport.forestry.items;

import java.util.HashMap;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import thaumcraftextras.register.CreativeTabRegister;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import forestry.api.recipes.RecipeManagers;

public class TCEItemComb extends Item{

	public TCEItemComb(int id, String itemName, int colorRGB, ItemStack result1, ItemStack result2, float chance) {
		super(id);
		setCreativeTab(CreativeTabRegister.tabMain);
		setMaxStackSize(64);
		setUnlocalizedName("tce.comb." + itemName);

		name = itemName;
		color = colorRGB;
		resultOne = result1;
		resultTwo = result2;
		percent = chance;
		init();
	}
	String name;
	int color;
	ItemStack resultOne;
	ItemStack resultTwo;
	float percent;
	
	public static HashMap<ItemStack, Integer> map = new HashMap();
	
	public void init()
	{
		registerCentrifugeResult(resultOne, resultTwo, percent);
		addName();
	}
	
	public void addStuffToMap(ItemStack result1, ItemStack result2)
	{
		
	}
	
	public void registerCentrifugeResult(ItemStack result1, ItemStack result2, float chance)
	{
		RecipeManagers.centrifugeManager.addRecipe(1, new ItemStack(this), map);
	}
	
	public void addName()
	{
		LanguageRegistry.addName(this, name + " Comb");
	}
	
	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack stack, int id)
	{
    	return color;
	}
    
	@Override
    public void registerIcons(IconRegister iconRegister) 
	{
        itemIcon = iconRegister.registerIcon("thaumcraftextras:comb");
	}
}
