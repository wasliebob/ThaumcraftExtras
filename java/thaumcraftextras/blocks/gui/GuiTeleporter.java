package thaumcraftextras.blocks.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import thaumcraftextras.blocks.container.ContainerTeleporter;
import thaumcraftextras.blocks.tileEntity.TileEntityTeleporter;
import cpw.mods.fml.common.network.PacketDispatcher;


public class GuiTeleporter extends GuiContainer {

        private static final ResourceLocation gui = new ResourceLocation("thaumcraftextras:textures/gui/gui.png");

        int x, y;

        TileEntityTeleporter tp;

        public GuiTeleporter(TileEntityTeleporter teleporter, InventoryPlayer inventory) {
                super(new ContainerTeleporter(teleporter, inventory));
                this.tp = teleporter;
        }

        @Override
        public void initGui() {
                super.initGui();
                x = (width - xSize) / 2;
                y = (height - ySize) / 2;
                this.buttonList.clear();
        }


        @Override
        protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture(gui);
        drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
        GL11.glColor3f(1F, 1F, 1F);
        }
}