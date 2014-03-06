package thaumcraftextras.register;

import thaumcraftextras.items.foci.entities.ProjectileConfusion;
import thaumcraftextras.items.foci.entities.ProjectileFreeze;
import thaumcraftextras.main.Main;
import cpw.mods.fml.common.registry.EntityRegistry;

public class EntityRegister {

	public static void load()
	{
        EntityRegistry.registerModEntity(ProjectileFreeze.class, "projectileFreeze", 2, Main.instance, 160, 1, false);	
        EntityRegistry.registerModEntity(ProjectileConfusion.class, "projectileConfusion", 3, Main.instance, 160, 1, false);

	}
}
