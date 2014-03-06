package thaumcraftextras.blocks.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import thaumcraftextras.blocks.container.ContainerDarkInfuser;
import thaumcraftextras.blocks.tileEntity.TileEntityDarkInfuser;


public class GuiDarkInfuser extends GuiContainer {

        private static final ResourceLocation gui = new ResourceLocation("thaumcraftextras:textures/gui/exchanger.png");
        int x, y;
        
        TileEntityDarkInfuser tile;

        public GuiDarkInfuser(TileEntityDarkInfuser tileI, InventoryPlayer inventory) {
                super(new ContainerDarkInfuser(tileI, inventory));
                this.tile = tileI;
        }
        
        @Override
        protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            mc.renderEngine.bindTexture(gui);
            drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
            GL11.glColor3f(1F, 1F, 1F);
        }
        
        @Override
        public void initGui() {
                super.initGui();
                x = (width - xSize) / 2;
                y = (height - ySize) / 2;
        }    
}