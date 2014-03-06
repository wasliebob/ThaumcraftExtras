package thaumcraftextras.blocks.gui;

import java.awt.Color;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.ResourceManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import thaumcraftextras.blocks.container.ContainerInfusion;
import thaumcraftextras.blocks.tileEntity.TileEntityInfusion;


public class GuiInfuseInfo extends GuiContainer {

        private static final ResourceLocation gui = new ResourceLocation("thaumcraftextras:textures/gui/infusion.png");
        int x, y;
        public static String text = "Page 1: Block Infusion";
        public static String text2 = "Page 2: Shard Infusion";
        public static String text3 = "Page 3: Foci";
        public static String text4 = "Page 4: Blocks";
        public static String text5 = "Page 5: Items";
        
        TileEntityInfusion tile;

        public GuiInfuseInfo(TileEntityInfusion tileI, InventoryPlayer inventory) {
                super(new ContainerInfusion(tileI, inventory));
                this.tile = tileI;
        }
        
        @Override
        protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            mc.renderEngine.bindTexture(gui);

            drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
            GL11.glColor3f(1F, 1F, 1F);
            int mainColor;
            int secColor;
            
            if(text != "Page 1: Block Infusion")
            {
                    mainColor = 0x990000;
            }
            else
            {
                    mainColor = 0x3366FF;
            }
            
            secColor = 0x3366FF;
                drawString(fontRenderer, text, x + 0, y + 60 , mainColor);
                drawString(fontRenderer, text2, x + 0, y + 70 , secColor);
                drawString(fontRenderer, text3, x + 0, y + 80 , secColor);
                drawString(fontRenderer, text4, x + 0, y + 90 , secColor);
        }
        
        @Override
        public void initGui() {
                super.initGui();
                x = (width - xSize) / 2;
                y = (height - ySize) / 2;
                
                this.buttonList.clear();
                /*
this.buttonList.add(new GuiButton(0, x + 2 , y + 2, 50, 20, "Page 1"));
this.buttonList.add(new GuiButton(1, x + 50, y + 2, 50, 20, "Page 2"));
this.buttonList.add(new GuiButton(2, x + 99, y + 2, 50, 20, "Page 3"));
this.buttonList.add(new GuiButton(3, x + 2 , y + 21, 50, 20, "Page 4"));
this.buttonList.add(new GuiButton(4, x + 50 , y + 21, 50, 20, "Page 5"));
this.buttonList.add(new GuiButton(5, x + 99, y + 21, 50, 20, "Main"));
                */
        }
        
        @Override
        public void actionPerformed(GuiButton button)
        {        
                switch(button.id)
                {
                case 0:
                {
                text = "Block Infusion";
                text2 = "With block infusion you can";
                text3 = "infuse blocks with an aspect,";
                text4 = "This will give them special effects";
                text5 = "";
                }
                break;
                case 1:
                {
                text = "Shard Infusion";
                text2 = "With shard infusion you can";
                text3 = "infuse items with an aspect,";
                text4 = "This can be used in a later stage.";
                text5 = "";
                }
                break;
                case 2:
                {
                text = "Wand Foci";
                text2 = "In Thaumcraft Extras there are";
                text3 = "A lot of different kind of foci.";
                text4 = "There all do something different";
                text5 = "";
                }
                break;
                case 3:
                {
                text = "Blocks";
                text2 = "Thaumcraft Extras blocks";
                text3 = "are special blocks that have";
                text4 = "multiple purposes.";
                text5 = "";
                }
                break;
                case 4:
                {
            text = "Items";
                   text2 = "Thaumcraft Extras items";
                   text3 = "are special items that have";
                   text4 = "multiple purposes.";
                   text5 = "";
                }
                break;
                }
        }
}