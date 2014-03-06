package thaumcraftextras.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import thaumcraftextras.helpers.IconHelper;
import thaumcraftextras.register.CreativeTabRegister;

public class ItemFociEmpty extends Item{

	public ItemFociEmpty(int id) {
		super(id);
		setCreativeTab(CreativeTabRegister.tabMain);
		setMaxStackSize(1);
	}
	
	@Override
    public void registerIcons(IconRegister par1IconRegister) 
	{
        itemIcon = IconHelper.forItem(par1IconRegister, this);
	}
}
