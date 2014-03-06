package thaumcraftextras.items.InfoBook;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;

public class ButtonIcon extends GuiButton {

        public ButtonIcon(int par1, int par2, int par3, int par4, int par5, String par6Str) {
                super(par1, par2, par3, par4, par5, par6Str);
        }

        @Override
        public void drawButton(Minecraft mc, int par2, int par3) {
                field_82253_i = par2 >= xPosition && par3 >= yPosition && par2 < xPosition + width && par3 < yPosition + height;
                int k = getHoverState(field_82253_i);

                boolean unicode = mc.fontRenderer.getUnicodeFlag();
                mc.fontRenderer.setUnicodeFlag(true);
                mc.fontRenderer.drawString(displayString, xPosition + (k == 2 ? 5 : 0), yPosition + (height - 8) / 2, 0);
                mc.fontRenderer.setUnicodeFlag(unicode);
        }

}