package thaumcraftextras.items.InfoBook;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import thaumcraftextras.helpers.IconHelper;
import thaumcraftextras.main.Main;
import thaumcraftextras.register.CreativeTabRegister;

public class ItemInfo extends Item{

	public ItemInfo(int id) {
		super(id);
		setCreativeTab(CreativeTabRegister.tabMain);
	}
	
	@Override
    public void registerIcons(IconRegister par1IconRegister) 
	{
        itemIcon = IconHelper.forItem(par1IconRegister, this);
	}	
	
	/*
	  @Override
      public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10) {
                              par2EntityPlayer.openGui(Botania.instance, LibGuiIDs.LEXICON, par3World, 0, 0, 0);
                              return true;
                   }

      }
*/
	
      @Override
      public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
              player.openGui(Main.instance, 10, world, 0, 0, 0);
              return stack;
      }


}
