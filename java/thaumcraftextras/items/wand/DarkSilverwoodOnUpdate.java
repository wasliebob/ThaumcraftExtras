package thaumcraftextras.items.wand;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.wands.IWandRodOnUpdate;
import thaumcraft.common.items.wands.ItemWandCasting;

public class DarkSilverwoodOnUpdate implements IWandRodOnUpdate {

	AspectList list = new AspectList().add(Aspect.FIRE, 1).add(Aspect.WATER, 1).add(Aspect.AIR, 1).add(Aspect.EARTH, 1).add(Aspect.ORDER, 1).add(Aspect.ENTROPY, 1);
	
	@Override
	public void onUpdate(ItemStack stack, EntityPlayer player) {		
		if(stack.getItem() instanceof ItemWandCasting)
		{
			Minecraft mc = Minecraft.getMinecraft();
			if(!mc.theWorld.isDaytime()){
			ItemWandCasting wand = (ItemWandCasting)stack.getItem();
			for(Aspect aspect : list.getAspects()){
				if(wand.getVis(stack, aspect) != wand.getMaxVis(stack))
					wand.addVis(stack, aspect, 1, true);
			}
			}
		}
	}

}
