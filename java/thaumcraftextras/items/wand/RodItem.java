package thaumcraftextras.items.wand;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import thaumcraftextras.helpers.IconHelper;
import thaumcraftextras.register.CreativeTabRegister;

public class RodItem extends Item{

	public RodItem(int id) {
		super(id);
		setCreativeTab(CreativeTabRegister.tabMain);
		setMaxStackSize(64);
	}
	
	@Override
    public void registerIcons(IconRegister par1IconRegister) 
	{
        itemIcon = IconHelper.forItem(par1IconRegister, this);
	}
}
