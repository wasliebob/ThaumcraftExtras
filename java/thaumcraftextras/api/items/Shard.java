package thaumcraftextras.api.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Shard extends Item{

	public Shard(int id, String itemName, int shardColor)
	{
		super(id);
		color = shardColor;
		name = itemName;
		setUnlocalizedName("tce.shards." + name);
		initItem();
	}
	int color;
	String name;
	
	public void initItem()
	{
		OreDictionary.registerOre("shard" + name, this);
		//addName();
	}
	
	public void addName()
	{
		LanguageRegistry.addName(this, name + " Shard");
	}
	
    @SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack stack, int id)
	{
    	return color;
	}
    
	@Override
    public void registerIcons(IconRegister iconRegister) 
	{
        itemIcon = iconRegister.registerIcon("thaumcraftextras:defaultShard");
	}	
}