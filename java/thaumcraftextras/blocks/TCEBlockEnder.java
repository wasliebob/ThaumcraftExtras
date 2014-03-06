package thaumcraftextras.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import thaumcraftextras.helpers.IconHelper;
import thaumcraftextras.main.Config;
import thaumcraftextras.register.CreativeTabRegister;

public class TCEBlockEnder extends Block{

    
	public TCEBlockEnder(int id) {
		super(id, Material.grass);
		setCreativeTab(CreativeTabRegister.tabMain);
		setHardness(1.0F);
	}
	
	@Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
	{
		Random rand = new Random();		
		int pos;
			if(world.getBlockId(x, y + 1, z) == Config.enderBlockId)
			  {
				pos = rand.nextInt(10) * 100;	
				  player.setPosition(x + pos , y + 1, z + pos);
				  return true;
			  }
			else if(world.getBlockId(x, y - 1, z) == Config.enderBlockId)
			  {
				pos = rand.nextInt(10) * 100;	
				  player.setPosition(x + pos , y + 1, z + pos);
				  return true;
			  }
			else
			{
				pos = rand.nextInt(10) * 10;
				  player.setPosition(x + pos , y + 1, z + pos);
			}

		return true;
	}
	
	
	@Override
    public void registerIcons(IconRegister par1IconRegister)
	{
        blockIcon = IconHelper.forBlock(par1IconRegister, this);
	}
	}