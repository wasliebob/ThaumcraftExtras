package thaumcraftextras.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import thaumcraftextras.api.items.Shard;
import thaumcraftextras.helpers.IconHelper;
import thaumcraftextras.register.CreativeTabRegister;

public class XPShard extends Item{

	public XPShard(int id) {
		super(id);
		setCreativeTab(CreativeTabRegister.tabMain);
		xpLevel = XPExtractor.xpLevel;
	}
	public static int xpLevel;
	
	@Override
    public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10)
    {
		if(player.isSneaking())
        return false;
		
		player.addExperienceLevel(xpLevel);
		itemstack.stackSize--;
		return false;
    }
	
	@Override
    public void registerIcons(IconRegister par1IconRegister) 
	{
        itemIcon = IconHelper.forItem(par1IconRegister, this);
	}
}
