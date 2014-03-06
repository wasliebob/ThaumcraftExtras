package thaumcraftextras.register;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import thaumcraftextras.blocks.container.ContainerCharger;
import thaumcraftextras.blocks.container.ContainerDarkInfuser;
import thaumcraftextras.blocks.container.ContainerExchanger;
import thaumcraftextras.blocks.container.ContainerInfusion;
import thaumcraftextras.blocks.container.ContainerWandCharger;
import thaumcraftextras.blocks.gui.GuiCharger;
import thaumcraftextras.blocks.gui.GuiDarkInfuser;
import thaumcraftextras.blocks.gui.GuiExchanger;
import thaumcraftextras.blocks.gui.GuiInfuseInfo;
import thaumcraftextras.blocks.gui.GuiWandCharger;
import thaumcraftextras.blocks.tileEntity.TileEntityCharger;
import thaumcraftextras.blocks.tileEntity.TileEntityDarkInfuser;
import thaumcraftextras.blocks.tileEntity.TileEntityExchanger;
import thaumcraftextras.blocks.tileEntity.TileEntityInfusion;
import thaumcraftextras.blocks.tileEntity.TileEntityWandCharger;
import thaumcraftextras.items.InfoBook.GUIInfo;
import cpw.mods.fml.common.network.IGuiHandler;


public class GuiHandler implements IGuiHandler {
        @Override
        public Object getServerGuiElement(int id, EntityPlayer player, World world,
                        int x, int y, int z) 
        {
                TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
                if(id == 0)
                	return new ContainerInfusion((TileEntityInfusion) tileEntity, player.inventory);
                if(id == 4)
                	return new ContainerCharger((TileEntityCharger) tileEntity, player.inventory);
                if(id == 5)
                	return new ContainerExchanger((TileEntityExchanger) tileEntity, player.inventory);
                if(id == 7)
                	return new ContainerWandCharger((TileEntityWandCharger) tileEntity, player.inventory);
                if(id == 10)
                	return null;
                if(id == 11)
                	return new ContainerDarkInfuser((TileEntityDarkInfuser) tileEntity, player.inventory);
                else
                	return false;
        }


        @Override
        public Object getClientGuiElement(int id, EntityPlayer player, World world,
                        int x, int y, int z) 
        {
                TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
                if(id == 0)
                	return new GuiInfuseInfo((TileEntityInfusion) tileEntity, player.inventory);
                if(id == 4)
                	return new GuiCharger((TileEntityCharger) tileEntity, player.inventory);
                if(id == 5)
                	return new GuiExchanger((TileEntityExchanger) tileEntity, player.inventory);
                if(id == 7)
                	return new GuiWandCharger((TileEntityWandCharger)tileEntity, player.inventory);
                if(id == 10)
                	return new GUIInfo();
                if(id == 11)
                	return new GuiDarkInfuser((TileEntityDarkInfuser)tileEntity, player.inventory);
                else 
                	return false;
        }
}