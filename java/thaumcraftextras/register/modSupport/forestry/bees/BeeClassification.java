package thaumcraftextras.register.modSupport.forestry.bees;

import java.util.ArrayList;

import forestry.api.genetics.AlleleManager;
import forestry.api.genetics.IAlleleSpecies;
import forestry.api.genetics.IClassification;

public enum BeeClassification implements IClassification
{
	THAUMIUM("Thaumium", "Thaumium"),
	DARKTHAUMIUM("DarkThaumium", "DarkThaumium"),
	DARKSILVERWOOD("DarkSilverwood", "DarkSilverwood"),
	LIGHTSHARD("LightShard", "LightShard"),
	GREEDESSENCE("GreedEssence", "GreedEssence"),
	MAGICESSENCE("MagicEssence", "MagicEssence"),
	SILVERWOOD("Silverwood", "Silverwood"),
	GREATWOOD("Greatwood", "Greatwood"),
	IGNISFUEL("IgnisFuel", "IgnisFuel"),
	SALIS("Salis", "Salis"),
	QUICKSILVER("QuickSilver", "QuickSilver"),
	MANA("Mana", "Mana"),
	SUNSTONE("Sunstone", "Sunstone"), 
	MOONSTONE("Moonstone", "Moonstone"), 
	CHIMERITE("Chimerite", "Chimerite"), 
	COKE("Coke", "Coke"), 
	CERTUSQUARTZ("CertusQuartz", "CertusQuartz"), 
	REINFORCED("Reinforced", "Reinforced"), 
	DRACONIC("Draconic", "Draconic"),
	PIG("Pig", "Pig");

	private String uID;
	private String latin;
	private ArrayList<IAlleleSpecies> species;
	private IClassification parent;
	private EnumClassLevel level;
	
	private BeeClassification(String name, String scientific)
	{
		this.uID = "classification." + name.toLowerCase();
		this.latin = scientific;
		this.level = EnumClassLevel.GENUS;
		this.species = new ArrayList();
		this.parent = AlleleManager.alleleRegistry.getClassification("family.apidae");
		AlleleManager.alleleRegistry.registerClassification(this);
	}
	
	@Override
	public EnumClassLevel getLevel()
	{
		return this.level;
	}

	@Override
	public String getUID()
	{
		return this.uID;
	}

	@Override
	public String getName()
	{
		return "tce.species";
	}

	@Override
	public String getScientific()
	{
		return "tce.science";
	}

	@Override
	public String getDescription()
	{
		return "tce.description";
	}

	@Override
	public IClassification[] getMemberGroups()
	{
		return null;
	}

	@Override
	public void addMemberGroup(IClassification group)
	{
		
	}

	@Override
	public IAlleleSpecies[] getMemberSpecies()
	{
		return this.species.toArray(new IAlleleSpecies[this.species.size()]);
	}

	@Override
	public void addMemberSpecies(IAlleleSpecies species)
	{
		if (!this.species.contains(species))
		{
			this.species.add(species);
		}
	}

	@Override
	public IClassification getParent()
	{
		return this.parent;
	}

	@Override
	public void setParent(IClassification parent)
	{
		this.parent = parent;
	}

}

