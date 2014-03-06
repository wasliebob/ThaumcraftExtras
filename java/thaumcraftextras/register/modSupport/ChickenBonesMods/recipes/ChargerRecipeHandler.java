package thaumcraftextras.register.modSupport.ChickenBonesMods.recipes;

import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map.Entry;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import thaumcraftextras.api.functions.ChargerFunctions;
import thaumcraftextras.blocks.gui.GuiCharger;
import thaumcraftextras.register.MCKERegister;
import codechicken.nei.NEIClientUtils;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;

public class ChargerRecipeHandler extends TemplateRecipeHandler{

    public class SmeltingPair extends CachedRecipe
    {
    	public SmeltingPair(ItemStack ingredients, ItemStack item)
        {
            ingredients.stackSize = 1;
            this.ingred = new PositionedStack(ingredients, 51, 42);
            this.result = new PositionedStack(item, 111, 24);
        }
		PositionedStack result; 
		PositionedStack ingred;
		
		 public PositionedStack getIngredient()
	        {
	            int cycle = cycleticks / 48;
	            if(ingred.item.getItemDamage() == -1)
	            {
	                PositionedStack stack = ingred.copy();
	                int maxDamage = 0;
	                do
	                {
	                    maxDamage++;
	                    stack.item.setItemDamage(maxDamage);
	                }
	                while(NEIClientUtils.isValidItem(stack.item));
	                
	                stack.item.setItemDamage(cycle % maxDamage);
	                return stack;
	            }
	            return ingred;
	        }
		 
		@Override
		public PositionedStack getResult()
		{
			ItemStack charged;
			charged = new ItemStack(MCKERegister.magicCrystal, 1, 50);
			charged.setItemName("Chargeable Item");
			return new PositionedStack(charged, 111, 24);
		}
		
		@Override
		public PositionedStack getOtherStack()
		{
			if(afuels.length > 0)
				return new PositionedStack(afuels[cycleticks/48 % afuels.length], 51, 6);
			else
				return null;
		}
    }
    static final ItemStack[] afuels = ChargerFunctions.isChargeAbleStack.toArray(new ItemStack[0]);

    @Override
	public String getRecipeName() 
	{
		return "Magic Charger";
	}

	@Override
	public String getGuiTexture() 
	{
		return "thaumcraftextras:textures/gui/exchanger.png";
	}
    
	@Override
	public void loadTransferRects()
	{
		transferRects.add(new RecipeTransferRect(new Rectangle(74, 23, 24, 6), "charger"));
	}


	//public static Class<? extends GuiContainer> guiclass;

	@Override
	public Class<? extends GuiContainer> getGuiClass()
	{
		return GuiCharger.class;
	}

	  @Override
	    public void loadCraftingRecipes(String outputId, Object... results)
	    {
	        if(outputId.equals("charger") && getClass() == ChargerRecipeHandler.class)
	        {
	            HashMap<Item, Integer> recipes = (HashMap<Item, Integer>) ChargerFunctions.getFuelList();
	            
	            for(Entry<Item, Integer> recipe : recipes.entrySet())
	            {
	            	Integer item = recipe.getValue();
	                arecipes.add(new SmeltingPair(new ItemStack(recipe.getKey(), 1, -1), new ItemStack(item, 1, 0)));
	            }
	        }
	        else
	        {
	            super.loadCraftingRecipes(outputId, results);
	        }
	    }
	    
	    @Override
	    public void loadCraftingRecipes(ItemStack result)
	    {
	        HashMap<Item, Integer> recipes = (HashMap<Item, Integer>) ChargerFunctions.getFuelList();
	        
	        for(Entry<Item, Integer> recipe : recipes.entrySet())
	        {
	        	Integer item = recipe.getValue();
	            if(NEIServerUtils.areStacksSameType(new ItemStack(item, 1, 0), result))
	            {
	                arecipes.add(new SmeltingPair(new ItemStack(recipe.getKey(), 1, -1), new ItemStack(item, 1, 0)));
	            }
	        }

	    }
	    
	    @Override
	    public void loadUsageRecipes(String inputId, Object... ingredients)
	    {
	        if(inputId.equals("fuel") && getClass() == ChargerRecipeHandler.class)
	        {
	            loadCraftingRecipes("charger");
	        }
	        else
	        {
	            super.loadUsageRecipes(inputId, ingredients);
	        }
	    }
	    
	    @Override
	    public void loadUsageRecipes(ItemStack stacks)
	    {
	        HashMap<Item, Integer> recipes = (HashMap<Item, Integer>)  ChargerFunctions.getFuelList();
	        Item ingredients = stacks.getItem();
	        
	        for(Entry<Item, Integer> recipe : recipes.entrySet())
	        {
	        	Integer item = recipe.getValue();
	            if(ingredients == recipe.getKey())
	            {
	                arecipes.add(new SmeltingPair(new ItemStack(ingredients), new ItemStack(item, 1, 0)));
	            }
	        }
	    }
}
