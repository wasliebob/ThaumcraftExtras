package thaumcraftextras.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import thaumcraftextras.helpers.IconHelper;
import thaumcraftextras.register.CreativeTabRegister;
import thaumcraftextras.register.InfusionRegister;

public class XPExtractor extends TCEItem{

	public XPExtractor(int id) {
		super(id);
		setCreativeTab(CreativeTabRegister.tabMain);
		setMaxStackSize(1);
		xpLevel = 5;
	}
	public static int xpLevel;
	
	@Override
    public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10)
    {
		if(player.isSneaking())
        return false;
		
		if(player.experienceLevel >= 5)
		{
			player.experienceLevel = player.experienceLevel - xpLevel;
			player.inventory.addItemStackToInventory(new ItemStack(InfusionRegister.xpShard));
			return false;
		}
		return false;
    }
	
	@Override
    public void registerIcons(IconRegister par1IconRegister) 
	{
        itemIcon = IconHelper.forItem(par1IconRegister, this);
	}
}
