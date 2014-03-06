package thaumcraftextras.blocks.tileEntity;

import java.awt.List;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;

public class TileEntityLight extends TileEntity{
	private float am = 0;
	private static String AMOUNT = "0";
	
	public void setAmount(float amount)
	{
		am = amount;
	}

	public void addAmount(float amount)
	{
		am = am + amount;
	}
	
	public float getAmount()
	{
		return am;
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		nbt.setFloat(AMOUNT, am);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		am = nbt.getFloat(AMOUNT);
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