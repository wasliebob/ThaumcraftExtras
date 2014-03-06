package thaumcraftextras.api.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import thaumcraftextras.api.functions.ChargerFunctions;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Crystal extends Item{

	public Crystal(int id, int maxEnergy, String itemName, int crystalColor) {
		super(id);
		setMaxStackSize(1);
		
		maxMCKE = maxEnergy;
		name = itemName;
		color = crystalColor;
		setMaxDamage(maxEnergy);
		setUnlocalizedName("tce.crystal." + itemName);
		initCrystal();
	}
	int maxMCKE;
	String name;
	int color;
	
	public void initCrystal()
	{
		addName();
		addToMap();
	}
	
	public void addName()
	{
		LanguageRegistry.addName(this, name + " Crystal");
	}
	
	public void addToMap()
	{
		ChargerFunctions.addChargeAble(this);
	}
	
	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack stack, int id)
	{
    	return color;
	}
    
	@Override
    public void registerIcons(IconRegister iconRegister) 
	{
        itemIcon = iconRegister.registerIcon("thaumcraftextras:magiccrystal");
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean id)
	{		
		list.add("Chargeable Crystal");
	}
	
	@Override
	public void getSubItems(int id, CreativeTabs tabs, List list)
	{
		list.add(new ItemStack(id, 1, maxMCKE));      
		list.add(new ItemStack(id, 1, 0));      
	}
	
}