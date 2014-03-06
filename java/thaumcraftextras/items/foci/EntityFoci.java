package thaumcraftextras.items.foci;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.common.entities.monster.EntityPech;
import thaumcraft.common.items.wands.ItemWandCasting;
import thaumcraftextras.api.functions.MiscFunctions;

public class EntityFoci extends ItemFoci {

        private static final AspectList visUsage = new AspectList().add(Aspect.AIR, 625);
        private static Map<String, String> storeEntity = new HashMap();
        
        public EntityFoci(int i) {
                super(i);
        }

        @Override
        public ItemStack onFocusRightClick(ItemStack itemstack, World world, EntityPlayer player, MovingObjectPosition mop) 
        {
            ItemWandCasting wand = (ItemWandCasting)itemstack.getItem();
            
            if (wand.consumeAllVis(itemstack, player, getVisCost(), true)) 
            {
                if (mop != null && mop.entityHit != null && mop.entityHit instanceof EntityLiving)
                {
                	double x = player.posX;
                	double y = player.posY;
                	double z = player.posZ;
                	
                	EntityLivingBase hit = (EntityLivingBase)mop.entityHit;
                   
                	if(storeEntity.containsKey(player.username))
                	{
                		player.addChatMessage(storeEntity + " ");
                		storeEntity.remove(player.username);
                	}
                   	else
                	{
                    	addToTransport(player, hit);
                	}
                }
            }
            return itemstack;
        }

        @Override
        public String getSortingHelper(ItemStack itemstack) {
                return "ENTITY";
        }

        @Override
        public int getFocusColor() {
                return 0x33FFCC;
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
		
		public void addToTransport(EntityPlayer player, Entity entity)
		{
			storeEntity.put(player.username, entity.getEntityName());
			player.addChatMessage("Added " + entity + " to the hashmap");
		}
		
		/*
		public void spawnEntityInWorld(Entity entity, EntityPlayer player, World world,  double x, double y, double z)
		{
			Entity e;
			e = new 
        	e.setPosition(player.posX, player.posY, player.posZ);
            world.spawnEntityInWorld(entity);
		}
		*/
}