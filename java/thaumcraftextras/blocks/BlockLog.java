package thaumcraftextras.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;

import thaumcraftextras.helpers.MainHelper;
import thaumcraftextras.lib.TCELocalization;
import thaumcraftextras.main.Config;
import thaumcraftextras.register.BlockRegister;
import thaumcraftextras.register.CreativeTabRegister;

import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockLog extends BlockRotatedPillar
{
    /** The type of tree this log came from. */
    public static final String[] woodType = new String[] {"darksilverwood"};
    @SideOnly(Side.CLIENT)
    private Icon[] field_111052_c;
    @SideOnly(Side.CLIENT)
    private Icon[] tree_top;

    public BlockLog(int par1)
    {
        super(par1, Material.wood);
        setCreativeTab(CreativeTabRegister.tabMain);
        setHardness(1.0F);
    }

    public int quantityDropped(Random par1Random)
    {
        return 1;
    }

    public int idDropped(int par1, Random par2Random, int par3)
    {
        return BlockRegister.darkSilverwoodLog.blockID;
    }

    protected Icon getSideIcon(int par1)
    {
        return this.field_111052_c[par1];
    }

    protected Icon getEndIcon(int par1)
    {
        return this.tree_top[par1];
    }


    public void registerIcons(IconRegister par1IconRegister)
    {
        this.field_111052_c = new Icon[woodType.length];
        this.tree_top = new Icon[woodType.length];

        for (int i = 0; i < this.field_111052_c.length; ++i)
        {
            this.field_111052_c[i] = par1IconRegister.registerIcon(MainHelper.modName + ":" + "darksilverwood");
            this.tree_top[i] = par1IconRegister.registerIcon(MainHelper.modName + ":" + "darksilverwood" + "_top");
        }
    }

    @Override
    public boolean canSustainLeaves(World world, int x, int y, int z)
    {
        return true;
    }

    @Override
    public boolean isWood(World world, int x, int y, int z)
    {
        return true;
    }
}