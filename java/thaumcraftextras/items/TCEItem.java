package thaumcraftextras.items;

import thaumcraftextras.helpers.IconHelper;
import thaumcraftextras.register.CreativeTabRegister;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class TCEItem extends Item{

	public TCEItem(int id) {
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
