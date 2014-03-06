package thaumcraftextras.register.modSupport.ChickenBonesMods;

import thaumcraft.common.config.ConfigBlocks;
import net.minecraft.block.Block;
import codechicken.lib.vec.Cuboid6;
import codechicken.multipart.minecraft.McMetaPart;

public class MultipartTube extends McMetaPart {
	
	public MultipartTube(int meta)
	{
	super(0);	
	}
	
	@Override
	public Cuboid6 getBounds() {
		Block tube = ConfigBlocks.blockTube;
		//return new Cuboid6(tube.getBlockBoundsMinX(), tube.getBlockBoundsMinY(), tube.getBlockBoundsMinZ(), tube.getBlockBoundsMaxX(), tube.getBlockBoundsMaxY(), tube.getBlockBoundsMaxZ());

		return new Cuboid6(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
	}

	@Override
	public Block getBlock() {
		return ConfigBlocks.blockTube;
	}

	@Override
	public String getType() {
		return getBlock().getUnlocalizedName();
	}

}
