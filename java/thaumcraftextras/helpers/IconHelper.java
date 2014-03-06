package thaumcraftextras.helpers;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;

public class IconHelper {

        private static Icon emptyTexture;

        public static Icon forName(IconRegister ir, String name) {
                return ir.registerIcon(MainHelper.modName + ":" + name);
        }

        public static Icon forNameRaw(IconRegister ir, String name) {
                return ir.registerIcon(name);
        }

        public static Icon forBlock(IconRegister ir, Block block) {
                return forNameRaw(ir, block.getUnlocalizedName().replaceAll("tile.", ""));
        }

        public static Icon forBlock(IconRegister ir, Block block, int i) {
                return forBlock(ir, block, Integer.toString(i));
        }

        public static Icon forBlock(IconRegister ir, Block block, String s) {
                return forNameRaw(ir, block.getUnlocalizedName().replaceAll("tile.", "") + s);
        }

        public static Icon forItem(IconRegister ir, Item item) {
                return forNameRaw(ir, item.getUnlocalizedName().replaceAll("item.", ""));
        }

        public static Icon forItem(IconRegister ir, Item item, int i) {
                return forItem(ir, item, Integer.toString(i));
        }

        public static Icon forItem(IconRegister ir, Item item, String s) {
                return forNameRaw(ir, item.getUnlocalizedName().replaceAll("item.", "") + s);
        }

}