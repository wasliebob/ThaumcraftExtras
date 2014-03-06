package thaumcraftextras.register.modSupport.ChickenBonesMods;

import thaumcraft.common.config.ConfigBlocks;
import net.minecraft.block.Block;
import codechicken.lib.vec.Cuboid6;
import codechicken.multipart.minecraft.McMetaPart;

public class MultipartTube extends McMetaPart {
	
	@Override
	public Cuboid6 getBounds() {
		Block tube = ConfigBlocks.blockTube;
		
		return new Cuboid6(tube.getBlockBoundsMinX(), tube.getBlockBoundsMinY(), tube.getBlockBoundsMinZ(), tube.getBlockBoundsMaxX(), tube.getBlockBoundsMaxY(), tube.getBlockBoundsMaxZ());
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
