package thaumcraftextras.main;

import net.minecraft.world.World;

public class CommonProxy {
	
	public void load()
	{
        registerRenderInformation();
        registerParticles();
	}
	
    public void registerRenderInformation(){}
    
    public World getClientWorld()
    {
        return null;
    }
    
    public void registerParticles(){}
    
    public void spawnEssentiaAtLocation(World worldObj, double xCoord, double yCoord, double zCoord, double dX, double dY, double dZ, int size, int color) {}
}

