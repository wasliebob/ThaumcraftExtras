package thaumcraftextras.helpers;

public class MathHelper {

	public static int second = 20;
	public static int minute = second*60;
	
	public static int tickToSecond(int ticks)
	{
		int seconds = ticks/20;
		return seconds;
	}
	
	public static int secondToTick(int seconds)
	{
		int ticks = seconds*20;
		return ticks;
	}
	
	public static int ticksToMinutes(int ticks)
	{
		int seconds = ticks/20;
		int minutes = seconds/60;
		
		return minutes;
	}
	
	public static int minutesToTicks(int minutes)
	{
		int seconds = minutes*60;
		int ticks = seconds*20;
		
		return ticks;
	}
}