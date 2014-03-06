package thaumcraftextras.api.blocks;

import java.awt.Color;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import thaumcraftextras.api.functions.DarkInfuserFunctions;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DarkBlock extends Block{

	public DarkBlock(int id, String blockName, Block texture) {
		super(id, Material.iron);
		setHardness(1.0F);
		ntexture = texture;
		idt = id;
		name = blockName;
		setUnlocalizedName("tce.dark." + name);
		init();
	}
	Block ntexture;
	int idt;
	String name;
	
    int dark = new Color(10, 10, 10).getRGB();

    public void init()
    {
		LanguageRegistry.addName(this, "Dark " + name);

		addBlockRecipe();
    }
    
    public void addBlockRecipe()
    {
    	DarkInfuserFunctions.infusion().addInfusion(ntexture.blockID, this.blockID, 0.7F);

    }
    
    
    @SideOnly(Side.CLIENT)
	public int colorMultiplier(IBlockAccess acces, int x, int y, int z)
	{
		return dark;
	}
	
	@Override
    public void registerIcons(IconRegister par1IconRegister) 
	{
        blockIcon = par1IconRegister.registerIcon("thaumcraftextras:darkblock");
	}
	
	public Icon getBlockTexture(IBlockAccess world, int x, int y, int z, int side) 
	{
		return ntexture.getIcon(side, 0);
	}

}