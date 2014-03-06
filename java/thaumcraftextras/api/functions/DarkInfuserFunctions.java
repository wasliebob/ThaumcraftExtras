package thaumcraftextras.api.functions;

import java.util.HashMap;
import java.util.Map;

public class DarkInfuserFunctions
{
public static final DarkInfuserFunctions canInfuse = new DarkInfuserFunctions();

private Map infuserList = new HashMap();
private Map infuserXP = new HashMap();

public static final DarkInfuserFunctions infusion()
{
	return canInfuse;
}

private DarkInfuserFunctions()
{
}

public void addInfusion(int id, int item, float experience)
{
	infuserList.put(id, item);
	this.infuserXP.put(Integer.valueOf(item), Float.valueOf(experience));
}

public int getInfuseResult(int id)
{
return (Integer) infuserList.get(id);
}

public Map getInfuseList()
{
	return infuserList;
}

public float getExperience(int par1)
{
	return this.infuserXP.containsKey(Integer.valueOf(par1)) ? ((Float)this.infuserXP.get(Integer.valueOf(par1))).floatValue() : 0.0F;
}

}