package thaumcraftextras.items.InfoBook;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;


public class GUIInfo extends GuiScreen {

       // public static GUIInfo currentOpenPage = new GUIInfo();
        
        private static final ResourceLocation gui = new ResourceLocation("thaumcraftextras:textures/gui/book.png");

        int guiWidth = 170;
        int guiHeight = 180;
        int left, top;

        String text, tag;

		private int guiWeight;
        
        @Override
        public void initGui() {
                super.initGui();
                //currentOpenPage = this;
                
                left = width / 2 - guiWidth / 2;
                top = height / 2 - guiHeight / 2;

                int x, y;
                x = (width - guiWeight) / 2;
                y = (height - guiHeight) / 2;
                
                this.buttonList.clear();
                                
                //id, posX, posY, SizeX, SizeY, TextOnButton
                int sizeX, sizeY;
                
                sizeX = 50;
                sizeY = 20;
                
                this.buttonList.add(new GuiButton(0, x - 115 , y + 20, sizeX, sizeY, "Lore"));
                this.buttonList.add(new GuiButton(1, x - 115 , y + 40, sizeX, sizeY, "Items"));
                this.buttonList.add(new GuiButton(2, x - 115 , y + 60, sizeX, sizeY, "Blocks"));
                this.buttonList.add(new GuiButton(3, x - 115 , y + 80, sizeX, sizeY, "Recipes"));

                this.buttonList.add(new GuiButton(10, x + 80 , y + 130, sizeX, sizeY, "Next"));

        }

        @Override
        public void drawScreen(int par1, int par2, float par3) {
                GL11.glColor4f(1F, 1F, 1F, 1F);
                mc.renderEngine.bindTexture(gui);
                drawTexturedModalRect(left, top, 0, 0, guiWidth, guiHeight);
                //drawCenteredString(fontRenderer, getTitle(), left + guiWidth / 2, top - 12, 0x00FF00);

                drawHeader();
                
                
                int x, y;
                x = (width - guiWeight) / 2;
                y = (height - guiHeight) / 2;
                int mainColor = 0x3366FF;
                
                drawString(fontRenderer, tag, x - 15, y + 8 , mainColor);
                drawString(fontRenderer, text, x - 50, y + 20 , mainColor);
                
                super.drawScreen(par1, par2, par3);
        }

        
        void drawHeader() {
                boolean unicode = fontRenderer.getUnicodeFlag();
                fontRenderer.setUnicodeFlag(true);
                //fontRenderer.drawSplitString(StatCollector.translateToLocal("Thaumcraft Extras Info"), left + 15, top + 20, 110, 0);
                fontRenderer.setUnicodeFlag(unicode);
        }

        @Override
        public void actionPerformed(GuiButton button)
        {
          text(button.id);
        }

        public void drawSelection(int id){}
        
        public void text(int id)
        {
        	switch(id)
        	{
        	case 0: {
        		tag = "Lore";
        		text = "tce.info.lore";
        	};
        	break;
        	case 1: {
        		tag =  "Items";
        		text = "tce.info.items";
        	};
        	break;
        	case 2: {
        		tag =  "Blocks";
        		text = "tce.info.blocks";
        	};
        	break;
        	case 3: {
        		tag =  "Recipes";
        		drawRecipes();
        	};
        	break;
        	case 10: nextPage(id);
        	break;
        	default: {
        		tag =  "String";
        		text = "tce.info.null";
        	};
        	break;
        	}
        }
        
        public void drawRecipes()
        {
        	clearGui();
        }
        
        public void nextPage(int id)
        {
        	clearGui();
        }
        
        public void clearGui()
        {
        	String empty = "";
        	text = empty;
        }

}