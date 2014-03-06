package thaumcraftextras.blocks;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.ThaumcraftApiHelper;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.common.Thaumcraft;
import thaumcraft.common.config.ConfigItems;
import thaumcraft.common.items.wands.ItemWandCasting;
import thaumcraftextras.helpers.IconHelper;
import thaumcraftextras.main.Config;
import thaumcraftextras.register.CreativeTabRegister;
import thaumcraftextras.register.ItemRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TCEBlockResearch extends Block{

    
	public TCEBlockResearch(int id) {
		super(id, Material.iron);
		setCreativeTab(CreativeTabRegister.tabMain);
		setHardness(1.0F);
	}
	int amount;

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
            super.getSubBlocks(par1, par2CreativeTabs, par3List);
            amount = 99999*100;
            ItemStack wand;
            wand = new ItemStack(ConfigItems.itemWandCasting);
            ((ItemWandCasting) wand.getItem()).setRod(wand, ItemRegister.ultimateRod);
            ((ItemWandCasting) wand.getItem()).setCap(wand, ConfigItems.WAND_CAP_THAUMIUM);
            ((ItemWandCasting) wand.getItem()).storeAllVis(wand, new AspectList().add(Aspect.AIR, amount).add(Aspect.EARTH, amount).add(Aspect.FIRE, amount).add(Aspect.WATER, amount).add(Aspect.ORDER, amount).add(Aspect.ENTROPY, amount));
            par3List.add(wand);
            
            amount = 65*100;
            wand = new ItemStack(ConfigItems.itemWandCasting);
            ((ItemWandCasting) wand.getItem()).setRod(wand, ItemRegister.ironRod);
            ((ItemWandCasting) wand.getItem()).setCap(wand, ConfigItems.WAND_CAP_THAUMIUM);
            ((ItemWandCasting) wand.getItem()).storeAllVis(wand, new AspectList().add(Aspect.AIR, amount).add(Aspect.EARTH, amount).add(Aspect.FIRE, amount).add(Aspect.WATER, amount).add(Aspect.ORDER, amount).add(Aspect.ENTROPY, amount));
            par3List.add(wand);
            
            amount = 60*100;
            wand = new ItemStack(ConfigItems.itemWandCasting);
            ((ItemWandCasting) wand.getItem()).setRod(wand, ItemRegister.goldRod);
            ((ItemWandCasting) wand.getItem()).setCap(wand, ConfigItems.WAND_CAP_THAUMIUM);
            ((ItemWandCasting) wand.getItem()).storeAllVis(wand, new AspectList().add(Aspect.AIR, amount).add(Aspect.EARTH, amount).add(Aspect.FIRE, amount).add(Aspect.WATER, amount).add(Aspect.ORDER, amount).add(Aspect.ENTROPY, amount));
            par3List.add(wand);
            
            amount = 90*100;
            wand = new ItemStack(ConfigItems.itemWandCasting);
            ((ItemWandCasting) wand.getItem()).setRod(wand, ItemRegister.diamondRod);
            ((ItemWandCasting) wand.getItem()).setCap(wand, ConfigItems.WAND_CAP_THAUMIUM);
            ((ItemWandCasting) wand.getItem()).storeAllVis(wand, new AspectList().add(Aspect.AIR, amount).add(Aspect.EARTH, amount).add(Aspect.FIRE, amount).add(Aspect.WATER, amount).add(Aspect.ORDER, amount).add(Aspect.ENTROPY, amount));
            par3List.add(wand);
            
            amount = 95*100;
            wand = new ItemStack(ConfigItems.itemWandCasting);
            ((ItemWandCasting) wand.getItem()).setRod(wand, ItemRegister.emeraldRod);
            ((ItemWandCasting) wand.getItem()).setCap(wand, ConfigItems.WAND_CAP_THAUMIUM);
            ((ItemWandCasting) wand.getItem()).storeAllVis(wand, new AspectList().add(Aspect.AIR, amount).add(Aspect.EARTH, amount).add(Aspect.FIRE, amount).add(Aspect.WATER, amount).add(Aspect.ORDER, amount).add(Aspect.ENTROPY, amount));
            par3List.add(wand);
            
            amount = 100*100;
            wand = new ItemStack(ConfigItems.itemWandCasting);
            ((ItemWandCasting) wand.getItem()).setRod(wand, ItemRegister.angelRod);
            ((ItemWandCasting) wand.getItem()).setCap(wand, ConfigItems.WAND_CAP_THAUMIUM);
            ((ItemWandCasting) wand.getItem()).storeAllVis(wand, new AspectList().add(Aspect.AIR, amount).add(Aspect.EARTH, amount).add(Aspect.FIRE, amount).add(Aspect.WATER, amount).add(Aspect.ORDER, amount).add(Aspect.ENTROPY, amount));
            par3List.add(wand);
            
            amount = 250*100;
            wand = new ItemStack(ConfigItems.itemWandCasting);
            ((ItemWandCasting) wand.getItem()).setRod(wand, ItemRegister.devilRod);
            ((ItemWandCasting) wand.getItem()).setCap(wand, ConfigItems.WAND_CAP_THAUMIUM);
            ((ItemWandCasting) wand.getItem()).storeAllVis(wand, new AspectList().add(Aspect.AIR, amount).add(Aspect.EARTH, amount).add(Aspect.FIRE, amount).add(Aspect.WATER, amount).add(Aspect.ORDER, amount).add(Aspect.ENTROPY, amount));
            par3List.add(wand); 
            
            amount = 500*100;
            wand = new ItemStack(ConfigItems.itemWandCasting);
            ((ItemWandCasting) wand.getItem()).setRod(wand, ItemRegister.godRod);
            ((ItemWandCasting) wand.getItem()).setCap(wand, ConfigItems.WAND_CAP_THAUMIUM);
            ((ItemWandCasting) wand.getItem()).storeAllVis(wand, new AspectList().add(Aspect.AIR, amount).add(Aspect.EARTH, amount).add(Aspect.FIRE, amount).add(Aspect.WATER, amount).add(Aspect.ORDER, amount).add(Aspect.ENTROPY, amount));
            par3List.add(wand);
            
            amount = 1000*100;
            wand = new ItemStack(ConfigItems.itemWandCasting);
            ((ItemWandCasting) wand.getItem()).setRod(wand, ItemRegister.darkSilverwoodRod);
            ((ItemWandCasting) wand.getItem()).setCap(wand, ConfigItems.WAND_CAP_THAUMIUM);
            ((ItemWandCasting) wand.getItem()).storeAllVis(wand, new AspectList().add(Aspect.AIR, amount).add(Aspect.EARTH, amount).add(Aspect.FIRE, amount).add(Aspect.WATER, amount).add(Aspect.ORDER, amount).add(Aspect.ENTROPY, amount));
            par3List.add(wand);
    }
	
	@Override
    public void registerIcons(IconRegister par1IconRegister)
	{
        blockIcon = IconHelper.forBlock(par1IconRegister, this);
	}
	}