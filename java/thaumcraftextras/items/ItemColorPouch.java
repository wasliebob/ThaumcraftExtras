package thaumcraftextras.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.common.config.ConfigItems;
import thaumcraft.common.items.wands.ItemFocusPouch;
import thaumcraft.common.items.wands.ItemWandCasting;
import thaumcraftextras.helpers.ColorHelper;
import thaumcraftextras.helpers.IconHelper;
import thaumcraftextras.register.CreativeTabRegister;
import thaumcraftextras.register.ItemRegister;

public class ItemColorPouch extends ItemFocusPouch{

	public ItemColorPouch(int id) {
		super(id);
		setCreativeTab(CreativeTabRegister.tabMain);
		setUnlocalizedName("tce.item.pouch.color");
	}
	
	@Override
    public void getSubItems(int id, CreativeTabs tab, List list) {
            super.getSubItems(id, tab, list);
            int maxMeta = 16;
            for(int meta=1; meta < maxMeta; meta++)
            list.add(new ItemStack(ItemRegister.colorPouch, 1, meta));
    }
	
    @SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack stack, int id)
	{
    	return ColorHelper.getColorCode(stack.getItemDamage());
	}
    
}
