package thaumcraftextras.register.modSupport.ChickenBonesMods;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import codechicken.lib.vec.BlockCoord;
import codechicken.multipart.MultiPartRegistry;
import codechicken.multipart.MultiPartRegistry.IPartConverter;
import codechicken.multipart.MultiPartRegistry.IPartFactory;
import codechicken.multipart.TMultiPart;

public class MultiPartBlock implements IPartFactory, IPartConverter {
Block block = null;
Class<? extends TMultiPart> part = null;
String name = "";

public MultiPartBlock(Block block, Class<? extends TMultiPart> part) {
try {
name = part.getConstructor().newInstance(new Object[] {}).getType();
} catch (Exception e) {
e.printStackTrace();
}
}

public MultiPartBlock(Block block, Class<? extends TMultiPart> part, String name) {
this.block = block;
this.part = part;
this.name = name;
}

@Override
public TMultiPart createPart(String name, boolean client) {
if (name.equals(name))
try {
return part.getConstructor().newInstance();
} catch (Exception e) {
e.printStackTrace();
return null;
}
return null;
}

public void init() {
if (name.isEmpty() || block == null || part == null)
return;

MultiPartRegistry.registerConverter(this);
MultiPartRegistry.registerParts(this, new String[] { name });
}

@Override
public boolean canConvert(int blockID) {
return blockID == block.blockID;
}

@Override
public TMultiPart convert(World world, BlockCoord pos) {
int id = world.getBlockId(pos.x, pos.y, pos.z);
int meta = world.getBlockMetadata(pos.x, pos.y, pos.z);
if (id == block.blockID) {
try {
//if(part.getName().equals("thaumcraftextras.register.modSupport.ChickenBonesMods.MultipartTube") && meta != 0)
//return null;

if(part.getDeclaredConstructor(int.class) != null)
return part.getDeclaredConstructor(int.class).newInstance(meta);

return part.getConstructor().newInstance();
} catch (Exception e) {
e.printStackTrace();
return null;
}
}

return null;
}
}