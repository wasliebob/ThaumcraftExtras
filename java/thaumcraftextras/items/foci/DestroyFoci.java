package thaumcraftextras.items.foci;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.common.Thaumcraft;
import thaumcraft.common.items.wands.ItemWandCasting;
import thaumcraft.common.lib.Utils;
import thaumcraftextras.api.functions.DestroyFunctions;

public class DestroyFoci extends ItemFoci {	 
	
        private static final AspectList visUsage = new AspectList().add(Aspect.ORDER, 35).add(Aspect.ENTROPY, 35);
        
        public DestroyFoci(int i) {
                super(i);
        }
        
        @Override
        public boolean isUseItem() {
                return true;
        }
        
		@Override
        public void onUsingFocusTick(ItemStack itemstack, EntityPlayer player, int time) {  
        	ItemWandCasting wand = (ItemWandCasting)itemstack.getItem();
            MovingObjectPosition pos = Utils.getTargetBlock(player.worldObj, player, false);
            if(pos != null)
            {
                	if (wand.consumeAllVis(itemstack, player, getVisCost(), true)) 
                	{
                		int blockId = player.worldObj.getBlockId(pos.blockX, pos.blockY, pos.blockZ);
                		//if(blockId != 0 && blockId != Block.bedrock.blockID && blockId != BlockRegister.wardedBlock.blockID && blockId != BlockRegister.hiddenWarded.blockID)
                		if(blockId != 0 && !DestroyFunctions.canDestroy.containsKey(blockId))
                		{
                			if(!player.worldObj.isRemote)
                			{
                        				player.worldObj.setBlock(pos.blockX, pos.blockY, pos.blockZ, 0);      			
                			}
                			if(player.worldObj.isRemote)
                                Thaumcraft.proxy.beamCont(player.worldObj, player, pos.blockX + 0.5, pos.blockY + 0.5, pos.blockZ + 0.5, 2, 0x000033, true, 0F, null, 1);
                		}
                	}
            }
		}

        @Override
        public String getSortingHelper(ItemStack itemstack) {
                return "DESTROY";
        }

        @Override
        public int getFocusColor() {
                return 0x000000;
        }

        @Override
        boolean hasOrnament() {
                return false;
        }

        @Override
        public AspectList getVisCost() {
                return visUsage;
        }
        
		@Override
		public boolean acceptsEnchant(int id) {
			return false;
		}
}