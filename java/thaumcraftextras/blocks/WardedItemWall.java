package thaumcraftextras.blocks;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class WardedItemWall extends ItemBlock
{
       public WardedItemWall(int par1)
       {
             super(par1);
             setHasSubtypes(true);
       }
      
       /**
        * 0 = Black
        * 1 = Red
        * 2 = Green
        * 3 = Brown
        * 4 = Blue
        * 5 = Purple
        * 6 = Cyan
        * 7 = Light Gray
        * 8 = Gray
        * 9 = Pink
        * 10 = Lime
        * 11 = Yellow
        * 12 = Light Blue
        * 13 = Magenta
        * 14 = Orange
        * 15 = White
        */     
       
       public String getUnlocalizedName(ItemStack itemstack)
       {
             String name = "";
             switch(itemstack.getItemDamage())
             {
             case 0: name = "black"; 
             break;
             case 1: name = "red";
             break;
             case 2: name = "green";
             break;
             case 3: name = "brown";
             break;
             case 4: name = "blue";
             break;
             case 5: name = "purple";
             break;
             case 6: name = "cyan";
             break;
             case 7: name = "light gray";
             break;
             case 8: name = "gray";
             break;
             case 9: name = "pink";
             break;
             case 10: name = "lime";
             break;
             case 11: name = "yellow";
             break;
             case 12: name = "light blue";
             break;
             case 13: name = "magenta";
             break;
             case 14: name = "orange";
             break;
             case 15: name = "white";
             break;
             default: name = "white";
             }
             return "tce.warded.wall." + name;
       }
      
       public int getMetadata(int par1)
       {
             return par1;
       }
}