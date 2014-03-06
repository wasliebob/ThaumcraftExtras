package thaumcraftextras.blocks.container;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import thaumcraftextras.blocks.gui.GuiInfuseInfo;
import thaumcraftextras.blocks.tileEntity.TileEntityInfusion;
import thaumcraftextras.register.BlockRegister;
import thaumcraftextras.register.InfusionRegister;
import thaumcraftextras.register.ItemRegister;

public class ContainerInfusion extends Container {
                int x, y;
        public static TileEntityInfusion tile;
        public static boolean bool = false;
        public ContainerInfusion(TileEntityInfusion tileI, InventoryPlayer inventory) {
                super();
                this.tile = tileI;
                this.addSlotToContainer(new Slot(tile, 1, 30, 10));
                this.addSlotToContainer(new Slot(tile, 2, 50, 10));
                this.addSlotToContainer(new Slot(tile, 3, 70, 10));
                this.addSlotToContainer(new Slot(tile, 4, 90, 10));
                this.addSlotToContainer(new Slot(tile, 5, 110, 10));

        }

        @Override
        public boolean canInteractWith(EntityPlayer entityplayer) {
                return tile.isUseableByPlayer(entityplayer);
        }

        @Override
        public ItemStack slotClick(int id, int x, int y, EntityPlayer player)
        {
                Item item;
                Block block = null;
                if(id == 0)
                {
                        block = BlockRegister.lightBlock;
                        GuiInfuseInfo.text = "Block Infusion";
                        GuiInfuseInfo.text2 = "With block infusion you can";
                    GuiInfuseInfo.text3 = "infuse blocks with an aspect,";
                    GuiInfuseInfo.text4 = "This will give them special effects.";
                    GuiInfuseInfo.text5 = "";
                    
                    return new ItemStack(block);
                }
                if(id == 1)
                {
                        item = InfusionRegister.lightShard;
                        GuiInfuseInfo.text = "Shard Infusion";
                        GuiInfuseInfo.text2 = "With shard infusion you can";
                    GuiInfuseInfo.text3 = "infuse items with an aspect,";
                    GuiInfuseInfo.text4 = "This can be used in a later stage.";
                    GuiInfuseInfo.text5 = "";
                    return new ItemStack(item);
                }
                
                if(id == 2)
                {
                        item = ItemRegister.exchangeFoci;
                        GuiInfuseInfo.text = "Wand Foci";
                        GuiInfuseInfo.text2 = "In Thaumcraft Extras there are";
                        GuiInfuseInfo.text3 = "A lot of different kind of foci.";
                        GuiInfuseInfo.text4 = "There all do something different.";
                        GuiInfuseInfo.text5 = "";
                    return new ItemStack(item);
                }
                
                if(id == 3)
                {
                        block = BlockRegister.researchBlock;
                        GuiInfuseInfo.text = "Blocks";
                        GuiInfuseInfo.text2 = "Thaumcraft Extras blocks";
                    GuiInfuseInfo.text3 = "are special blocks that have";
                    GuiInfuseInfo.text4 = "multiple purposes.";
                    GuiInfuseInfo.text5 = "";
                    return new ItemStack(block);
                }
                
                if(id == 4)
                {
                        item = ItemRegister.xpExtractor;
                        GuiInfuseInfo.text = "Items";
                        GuiInfuseInfo.text2 = "Thaumcraft Extras items";
                       GuiInfuseInfo.text3 = "are special items that have";
                       GuiInfuseInfo.text4 = "multiple purposes.";
                       GuiInfuseInfo.text5 = "";
                    return new ItemStack(item);
                }
                else
                {
                        block = Block.dirt;
                    return new ItemStack(block);
                }
                
        }

        @Override
        public ItemStack transferStackInSlot(EntityPlayer player, int par2) {
        ItemStack var3 = null;
        this.slotClick(1, 70, 60, player);
        return var3;
        }
}