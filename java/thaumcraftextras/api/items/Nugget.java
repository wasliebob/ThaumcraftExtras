package thaumcraftextras.api.items;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class Nugget extends Item{

	public Nugget(int id, String name, String itemMaterial, int nuggetColor, boolean usesDictionary, int metadataItemUse, Item itemNoDictionary)
	{
		super(id);
		metaItemUse = metadataItemUse;
		itemMat = itemMaterial;
		color = nuggetColor;
		usesOreDict = usesDictionary;
		itemNoDict = itemNoDictionary;
		itemName = name;
		setUnlocalizedName("tce.nuggets." + itemName);
		initItem();
	}
	int metaItemUse;
	String itemMat;
	int color;
	boolean usesOreDict;
	Item itemNoDict;
	String itemName;
	
	public void initItem()
	{
		OreDictionary.registerOre("nugget" + itemName, this);
		addRecipe();
		//addName();
	}
	
	public void addName()
	{
		LanguageRegistry.addName(this, itemName + " Nugget");
	}
	
	public void addRecipe()
	{        
        if(usesOreDict)
        {
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(this, 9, 0), new ItemStack(OreDictionary.getOreID(itemMat), 1, metaItemUse)));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(OreDictionary.getOreID(itemMat), 1, metaItemUse), true, new Object[]{
        "XXX",
        "XXX",
        "XXX",
        'X', new ItemStack(this, 1, 0)}));
        }
        else
        {
            GameRegistry.addShapelessRecipe(new ItemStack(this, 9, 0), new ItemStack(itemNoDict, 1, metaItemUse));

            GameRegistry.addRecipe(new ItemStack(itemNoDict, 1, metaItemUse), new Object[]{
                "XXX",
                "XXX",
                "XXX",
                'X', new ItemStack(this, 1, 0)});
        }
	}
	
    @SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack stack, int id)
	{
    	return color;
	}
    
	@Override
    public void registerIcons(IconRegister iconRegister) 
	{
        itemIcon = iconRegister.registerIcon("thaumcraftextras:nugget");
	}
	
	
}
