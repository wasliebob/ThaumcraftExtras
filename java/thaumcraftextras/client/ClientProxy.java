package thaumcraftextras.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityEnchantmentTableParticleFX;
import net.minecraft.client.particle.EntityFlameFX;
import net.minecraft.client.particle.EntityHeartFX;
import net.minecraft.client.particle.EntityPortalFX;
import net.minecraft.client.particle.EntitySmokeFX;
import net.minecraft.client.particle.EntitySnowShovelFX;
import net.minecraft.world.World;
import thaumcraft.client.fx.FXEssentiaTrail;
import thaumcraftextras.blocks.tileEntity.TileEntityDarkInfuser;
import thaumcraftextras.client.renderer.TileEntityDarkInfuserRenderer;
import thaumcraftextras.items.foci.entities.ProjectileConfusion;
import thaumcraftextras.items.foci.entities.ProjectileFreeze;
import thaumcraftextras.items.foci.entities.renders.RenderProjectileConfusion;
import thaumcraftextras.items.foci.entities.renders.RenderProjectileFreeze;
import thaumcraftextras.main.CommonProxy;
import thaumcraftextras.register.ParticleRegister;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

	@Override
	public void load()
	{
		render();
		registerParticles();
		}
	
	public void render()
    {
		 //EntityRegistry.registerGlobalEntityID(ProjectileFreeze.class, "projectileFreeze", EntityRegistry.findGlobalUniqueEntityId());
		 //EntityRegistry.registerGlobalEntityID(ProjectileConfusion.class, "projectileConfusion", EntityRegistry.findGlobalUniqueEntityId());
	     ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDarkInfuser.class, new TileEntityDarkInfuserRenderer());		
	     RenderingRegistry.registerEntityRenderingHandler(ProjectileFreeze.class, new RenderProjectileFreeze());
		 RenderingRegistry.registerEntityRenderingHandler(ProjectileConfusion.class, new RenderProjectileConfusion());
    }
	
	@Override
    public World getClientWorld()
    {
        return FMLClientHandler.instance().getClient().theWorld;
    }
	
	@Override
    public void registerParticles()
    {
            ParticleRegister.registerParticle("portal", EntityPortalFX.class);
            ParticleRegister.registerParticle("snowballpoof", EntitySnowShovelFX.class);
            ParticleRegister.registerParticle("flame", EntityFlameFX.class);
            ParticleRegister.registerParticle("largesmoke", EntitySmokeFX.class);
            ParticleRegister.registerParticle("heart", EntityHeartFX.class);
            ParticleRegister.registerParticle("enchantmenttable", EntityEnchantmentTableParticleFX.class);

    }
	}