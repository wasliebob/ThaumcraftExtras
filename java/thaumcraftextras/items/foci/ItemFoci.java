package thaumcraftextras.items.foci;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.wands.IWandFocus;
import thaumcraftextras.helpers.IconHelper;
import thaumcraftextras.items.TCEItem;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public abstract class ItemFoci extends TCEItem implements IWandFocus {

        private Icon ornament, depth;

        public ItemFoci(int par1) {
                super(par1);
                maxStackSize = 1;
        }

        boolean hasOrnament() {
                return false;
        }
        
        boolean hasDepth() {
                return false;
        }

        @Override
        @SideOnly(Side.CLIENT)
        public void registerIcons(IconRegister par1IconRegister) {
                super.registerIcons(par1IconRegister);
                if(hasOrnament())
                        ornament = IconHelper.forItem(par1IconRegister, this, "Orn");
                if(hasDepth())
                        depth = IconHelper.forItem(par1IconRegister, this, "Depth");
        }

        @Override
        public boolean isItemTool(ItemStack par1ItemStack){
                return true;
        }

        @Override
        public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
                AspectList cost = getVisCost();
                if (cost != null && cost.size() > 0) {
                        list.add(StatCollector.translateToLocal(isVisCostPerTick() ? "item.Focus.cost2" : "item.Focus.cost1"));
                        for (Aspect aspect : cost.getAspectsSorted()) {
                                float amount = cost.getAmount(aspect) / 100.0F;
                                list.add(" " + '\u00a7' + aspect.getChatcolor() + aspect.getName() + '\u00a7' + "r x " + amount);
                        }
                }
        }

        @Override
        public int getItemEnchantability() {
                return 5;
        }

        @Override
        public EnumRarity getRarity(ItemStack itemstack) {
                return EnumRarity.rare;
        }

        @Override
        public Icon getOrnament() {
                return ornament;
        }
        
        @Override
        public Icon getFocusDepthLayerIcon() {
                return depth;
        }

        @Override
        public WandFocusAnimation getAnimation() {
                return WandFocusAnimation.WAVE;
        }

        @Override
        public boolean isVisCostPerTick() {
                return false;
        }

        public boolean isUseItem() {
                return isVisCostPerTick();
        }
        
        @Override
        public ItemStack onFocusRightClick(ItemStack paramItemStack, World paramWorld, EntityPlayer paramEntityPlayer, MovingObjectPosition paramMovingObjectPosition) {
                if(isUseItem())
                        paramEntityPlayer.setItemInUse(paramItemStack, Integer.MAX_VALUE);

                return paramItemStack;
        }

        @Override
        public void onUsingFocusTick(ItemStack paramItemStack, EntityPlayer paramEntityPlayer, int paramInt) {
        	
        }

        @Override
        public void onPlayerStoppedUsingFocus(ItemStack paramItemStack, World paramWorld, EntityPlayer paramEntityPlayer, int paramInt) {
        }

        @Override
        public String getSortingHelper(ItemStack paramItemStack) {
                return "00";
        }

        @Override
        public boolean onFocusBlockStartBreak(ItemStack paramItemStack, int paramInt1, int paramInt2, int paramInt3, EntityPlayer paramEntityPlayer) {
                return false;
        }
        
        @Override
    	public AspectList getVisCost()
        {
			return new AspectList().add(Aspect.AIR, 100);
        }
}