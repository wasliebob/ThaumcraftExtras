package thaumcraftextras.register.modSupport.forestry.bees;

import java.util.ArrayList;
import java.util.Collection;

import net.minecraft.block.Block;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.Loader;
import forestry.api.apiculture.IAlleleBeeSpecies;
import forestry.api.apiculture.IBeeGenome;
import forestry.api.apiculture.IBeeHousing;
import forestry.api.apiculture.IBeeMutation;
import forestry.api.apiculture.IBeeRoot;
import forestry.api.genetics.IAllele;
import forestry.api.genetics.IGenome;

public class BeeMutation implements IBeeMutation
{	
	public static void setupMutations()
	{
		IAlleleBeeSpecies baseA, baseB;
		BeeMutation mutation;
				
		String[] forestryMundane = new String[] { "Forest", "Meadows", "Modest", "Wintry", "Tropical", "Marshy" };
		String[] binnieMundane = new String[] { "marble", "rock", "water", "basalt" };
		
		
		new BeeMutation(Allele.getBaseSpecies("Cultivated"), Allele.getBaseSpecies("Common"), Species.silverwood, 40);
		new BeeMutation(Allele.getBaseSpecies("Cultivated"), Species.silverwood, Species.thaumium, 20);
		new BeeMutation(Species.thaumium, Species.silverwood, Species.darkSilverwood, 5);
		new BeeMutation(Species.thaumium, Species.darkSilverwood, Species.darkThaumium, 5);

		
		new BeeMutation(Allele.getBaseSpecies("Cultivated"), Allele.getBaseSpecies("Common"), Species.greatwood, 40);
		new BeeMutation(Allele.getBaseSpecies("Cultivated"), Allele.getBaseSpecies("Common"), Species.ignisFuel, 50);
		new BeeMutation(Allele.getBaseSpecies("Cultivated"), Species.greatwood, Species.tradeEssence, 20);
		new BeeMutation(Species.tradeEssence, Species.silverwood, Species.magicEssence, 5);

		new BeeMutation(Species.silverwood, Species.greatwood, Species.tradeEssence, 5);
		new BeeMutation(Species.ignisFuel, Species.darkSilverwood, Species.lightShard, 5);
		new BeeMutation(Species.ignisFuel, Species.darkThaumium, Species.salis, 5);
		new BeeMutation(Species.ignisFuel, Species.thaumium, Species.quicksilver, 5);
		new BeeMutation(Species.salis, Species.darkThaumium, Species.mana, 2);
		
    	
    	if(Loader.isModLoaded("arsmagica2") && OreDictionary.getOres("gemChimerite").size() > 0)
    	{
    		new BeeMutation(Species.thaumium, Species.silverwood, Species.chimerite, 20);
    	}
    	
    	
    	if(Loader.isModLoaded("arsmagica2") && OreDictionary.getOres("gemSunstone").size() > 0)
    	{
    		new BeeMutation(Species.thaumium, Species.chimerite, Species.sunstone, 20);
    	}
    	
    	if(Loader.isModLoaded("ArsMagica") && OreDictionary.getOres("gemMoonstoon").size() > 0)
    	{
    		new BeeMutation(Species.sunstone, Species.chimerite, Species.moonstone, 20);
    	}

    	if(Loader.isModLoaded("TConstruct") && OreDictionary.getOres("nuggetPigIron").size() > 0)
    	{
    		new BeeMutation(Species.darkSilverwood, Species.darkThaumium, Species.pig, 3);
    	}
    	
    	if(OreDictionary.getOres("fuelCoke").size() > 0)
    	{
    		new BeeMutation(Species.silverwood, Species.greatwood, Species.coke, 5);
    	}
    	
    	if(OreDictionary.getOres("dustCertusQuartz").size() > 0)
    	{
    		new BeeMutation(Species.silverwood, Species.greatwood, Species.certusQuartz, 5);
    	}
    	
    	if(OreDictionary.getOres("ingotReinforced").size() > 0)
    	{
    		new BeeMutation(Species.darkSilverwood, Species.darkThaumium, Species.reinforced, 5);
    	}
	
    	if(OreDictionary.getOres("ingotDraconic").size() > 0)
    	{
    		new BeeMutation(Species.darkSilverwood, Species.darkThaumium, Species.draconic, 1);
    	}
    	
	}
	
	private IAllele parent1;
	private IAllele parent2;
	private IAllele mutationTemplate[];
	private int baseChance;
	private boolean isSecret;
	private boolean isMoonRestricted;

	private float moonPhaseMutationBonus;
	private boolean nodeRequired;
	private double nodeRange;
	private boolean requiresBlock;
	private int requiredBlockId;
	private int requiredBlockMeta;
	private String requiredBlockOreDictEntry;
	private String requiredBlockName;
	private BiomeDictionary.Type requiredBiomeType;
	
	public BeeMutation(IAlleleBeeSpecies species0, IAlleleBeeSpecies species1, Species resultSpecies, int percentChance)
	{
		this(species0, species1, resultSpecies.getGenome(), percentChance);
	}

	public BeeMutation(IAlleleBeeSpecies species0, IAlleleBeeSpecies species1, IAllele[] resultSpeciesGenome, int percentChance)
	{
		this.parent1 = species0;
		this.parent2 = species1;
		this.mutationTemplate = resultSpeciesGenome;
		this.baseChance = percentChance;
		this.isSecret = false;
		this.isMoonRestricted = false;
		this.moonPhaseMutationBonus = -1f;
		//this.nodeType = null;
		this.requiresBlock = false;
		this.requiredBlockMeta = OreDictionary.WILDCARD_VALUE;
		this.requiredBlockOreDictEntry = null;
		this.requiredBiomeType = null;
		this.requiredBlockName = null;
		
		BeeManager.beeRoot.registerMutation(this);
	}

	@Override
	public float getChance(IBeeHousing housing, IAllele allele0, IAllele allele1, IGenome genome0, IGenome genome1)
	{
		float finalChance;
		float chance = this.baseChance * 1f;
		finalChance = Math.round(chance
				* housing.getMutationModifier((IBeeGenome) genome0,
						(IBeeGenome) genome1, chance)
				* BeeManager.beeRoot.getBeekeepingMode(housing.getWorld())
						.getMutationModifier((IBeeGenome) genome0,
								(IBeeGenome) genome1, chance));
		return finalChance;
	}

	@Override
	public IAllele getAllele0()
	{
		return parent1;
	}

	@Override
	public IAllele getAllele1()
	{
		return parent2;
	}

	@Override
	public IAllele[] getTemplate()
	{
		return mutationTemplate;
	}

	@Override
	public float getBaseChance()
	{
		return baseChance;
	}

	@Override
	public boolean isPartner(IAllele allele)
	{
		return parent1.getUID().equals(allele.getUID()) || parent2.getUID().equals(allele.getUID());
	}

	@Override
	public IAllele getPartner(IAllele allele)
	{
		IAllele val = parent1;
		if (val.getUID().equals(allele.getUID()))
			val = parent2;
		return val;
	}

	@Override
	public IBeeRoot getRoot()
	{
		return BeeManager.beeRoot;
	}
	
	public boolean arePartners(IAllele alleleA, IAllele alleleB)
	{
		return (this.parent1.getUID().equals(alleleA.getUID())) && this.parent2.getUID().equals(alleleB.getUID()) ||
				this.parent1.getUID().equals(alleleB.getUID()) && this.parent2.getUID().equals(alleleA.getUID());
	}
	
	public BeeMutation setSecret()
	{
		this.isSecret = true;
		
		return this;
	}

	public boolean isSecret()
	{
		return isSecret;
	}
	
	public BeeMutation setBlockRequired(int blockId)
	{
		this.requiresBlock = true;
		this.requiredBlockId = blockId;
		
		return this;
	}
	
	public BeeMutation setBlockRequired(Block block)
	{
		this.requiresBlock = true;
		this.requiredBlockId = block.blockID;
		
		return this;
	}
	
	public BeeMutation setBlockAndMetaRequired(int blockId, int meta)
	{
		this.requiresBlock = true;
		this.requiredBlockId = blockId;
		this.requiredBlockMeta = meta;
		
		return this;
	}
	
	public BeeMutation setBlockAndMetaRequired(Block block, int meta)
	{
		this.requiresBlock = true;
		this.requiredBlockId = block.blockID;
		this.requiredBlockMeta = meta;
		
		return this;
	}
	
	public BeeMutation setBlockRequired(String oreDictEntry)
	{
		this.requiresBlock = true;
		this.requiredBlockOreDictEntry = oreDictEntry;
		
		return this;
	}
	
	public BeeMutation setBlockRequiredNameOverride(String blockName)
	{
		this.requiredBlockName = blockName;
		
		return this;
	}
	
	public BeeMutation setBiomeRequired(BiomeDictionary.Type biomeType)
	{
		this.requiredBiomeType = biomeType;
		
		return this;
	}

	@Override
	public Collection<String> getSpecialConditions() {
		ArrayList<String> conditions = new ArrayList<String>();
		return conditions;
	}
}