package thaumcraftextras.items.wand;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.wands.WandCap;
import thaumcraftextras.lib.TCELocalization;
import thaumcraftextras.register.ItemRegister;


public class WandCaps extends WandCap {

ResourceLocation texture = new ResourceLocation("thaumcraftextras","textures/models/wand_caps_darkthaumium.png");

public WandCaps() {
super("darkThaumium", 0.7F, new ItemStack(ItemRegister.darkThaumiumNugget), 10);
}

@Override
public ResourceLocation getTexture() {
return texture;
}
}