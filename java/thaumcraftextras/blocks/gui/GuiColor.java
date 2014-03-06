package thaumcraftextras.blocks.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import thaumcraftextras.blocks.container.ContainerColor;
import thaumcraftextras.blocks.tileEntity.TileEntityColor;


public class GuiColor extends GuiContainer {

        private static final ResourceLocation gui = new ResourceLocation("thaumcraftextras:textures/gui/infusion.png");
        int x, y;
        
        TileEntityColor tile;

        public GuiColor(TileEntityColor tileI, InventoryPlayer inventory) {
                super(new ContainerColor(tileI, inventory));
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
                
                this.buttonList.clear();
                this.buttonList.add(new GuiButton(0, x + 2 , y + 2, 50, 20, "Red"));
                this.buttonList.add(new GuiButton(1, x + 50, y + 2, 50, 20, "Blue"));
                this.buttonList.add(new GuiButton(2, x + 99, y + 2, 50, 20, "Green"));
                this.buttonList.add(new GuiButton(3, x + 2 , y + 21, 50, 20, "Yellow"));
                this.buttonList.add(new GuiButton(4, x + 50 , y + 21, 50, 20, "Purple"));
                this.buttonList.add(new GuiButton(5, x + 99, y + 21, 50, 20, "Black"));
        }
        
        @Override
        public void actionPerformed(GuiButton button)
        {	
        	switch(button.id)
        	{
        	case 0:
        	{
        		TileEntityColor.setColor("red");
        	}
        	}
        }   
}