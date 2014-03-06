package thaumcraftextras.helpers;

import java.awt.Color;

public class ColorHelper {

    /**
     * A 0 = Black
     * B 1 = Red
     * C 2 = Green
     * D 3 = Brown
     * E 4 = Blue
     * F 5 = Purple
     * G 6 = Cyan
     * H 7 = Light Gray
     * I 8 = Gray
     * J 9 = Pink
     * K 10 = Lime
     * L 11 = Yellow
     * M 12 = Light Blue
     * N 13 = Magenta
     * O 14 = Orange
     * P 15 = White
     */
	
    /** new Color(red, green, blue) */
    static int a = new Color(20, 0, 0).getRGB();
    static int b = new Color(255, 0, 0).getRGB();
    static int c = new Color(0, 255, 20).getRGB();
    static int d = new Color(51, 25, 0).getRGB();
    static int e = new Color(0, 0, 255).getRGB();
    static int f = new Color(255, 0, 255).getRGB();
    static int g = new Color(0, 0, 153).getRGB();
    static int h = new Color(224, 224, 224).getRGB();
    static int i = new Color(128, 128, 128).getRGB();
    static int j = new Color(255, 0, 127).getRGB();
    static int k = new Color(153, 255, 51).getRGB();
    static int l = new Color(255, 255, 0).getRGB();
    static int m = new Color(102, 255, 255).getRGB();
    static int n = new Color(204, 0, 204).getRGB();
    static int o = new Color(204, 102, 0).getRGB();
    static int p = new Color(255, 255, 255).getRGB();
    
	public static int getColorCode(int value)
	{
		switch(value)
		{
    	case 0: return a;
    	case 1: return b;
    	case 2: return c;
    	case 3: return d;
    	case 4: return e;
    	case 5: return f;
    	case 6: return g;
    	case 7: return h;
    	case 8: return i;
    	case 9: return j;
    	case 10: return k;
    	case 11: return l;
    	case 12: return m;
    	case 13: return n;
    	case 14: return o;
    	case 15: return p;
    	default: return a;
		}
	}
}
