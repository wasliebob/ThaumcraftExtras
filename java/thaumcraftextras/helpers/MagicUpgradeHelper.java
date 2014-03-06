package thaumcraftextras.helpers;

public class MagicUpgradeHelper {

	public static int max = 19;
	public static int discountEach = 1;
	
	public static boolean isLowerThen(int upgradeDiscount)
	{
		return upgradeDiscount <= max;
	}
	
	public static int getDiscountEachUpgrade()
	{
		return discountEach;
	}
}
