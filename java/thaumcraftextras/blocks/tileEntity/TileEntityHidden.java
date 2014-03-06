package thaumcraftextras.blocks.tileEntity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;

public class TileEntityHidden extends TileEntity{
	private String username = "name";
	private static String NAME = "name";
	
	public void setName(String value)
	{
		username = value;
	}

	public String getName()
	{
		return username;
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		nbt.setString(NAME, username);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		username = nbt.getString(NAME);
	}
	
	@Override
	public Packet getDescriptionPacket() {
	    NBTTagCompound tagCompound = new NBTTagCompound();
	    writeToNBT(tagCompound);
	    return new Packet132TileEntityData(xCoord, yCoord, zCoord, -999, tagCompound);
	}
	
	@Override
	public void onDataPacket(INetworkManager networkManager, Packet132TileEntityData packet) {
		this.readFromNBT(packet.data);
	}
}