package thaumcraftextras.register.modSupport.forestry.bees;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import forestry.api.apiculture.EnumBeeChromosome;
import forestry.api.apiculture.EnumBeeType;
import forestry.api.core.ItemInterface;
import forestry.api.genetics.IAllele;

public class GenomeManager {

	private static IAllele[] getTemplateModBase()
	{
		IAllele[] genome = new IAllele[EnumBeeChromosome.values().length];

		genome[EnumBeeChromosome.SPECIES.ordinal()] = Species.thaumium;
		genome[EnumBeeChromosome.SPEED.ordinal()] =  Allele.getBaseAllele("speedSlowest");
		genome[EnumBeeChromosome.LIFESPAN.ordinal()] = Allele.getBaseAllele("lifespanShorter");
		genome[EnumBeeChromosome.FERTILITY.ordinal()] = Allele.getBaseAllele("fertilityNormal");
		genome[EnumBeeChromosome.TEMPERATURE_TOLERANCE.ordinal()] = Allele.getBaseAllele("toleranceNone");
		genome[EnumBeeChromosome.NOCTURNAL.ordinal()] = Allele.getBaseAllele("boolFalse");
		genome[EnumBeeChromosome.HUMIDITY_TOLERANCE.ordinal()] = Allele.getBaseAllele("toleranceNone");
		genome[EnumBeeChromosome.TOLERANT_FLYER.ordinal()] = Allele.getBaseAllele("boolFalse");
		genome[EnumBeeChromosome.CAVE_DWELLING.ordinal()] = Allele.getBaseAllele("boolFalse");
		genome[EnumBeeChromosome.FLOWER_PROVIDER.ordinal()] = Allele.getBaseAllele("flowersVanilla");
		genome[EnumBeeChromosome.FLOWERING.ordinal()] = Allele.getBaseAllele("floweringSlowest");
		genome[EnumBeeChromosome.TERRITORY.ordinal()] = Allele.getBaseAllele("territoryDefault");
		genome[EnumBeeChromosome.EFFECT.ordinal()] = Allele.getBaseAllele("effectNone");

		return genome;
	}
		
		public static IAllele[] getTemplateThaumium()
		{
			IAllele[] genome = getTemplateModBase();
			
			genome[EnumBeeChromosome.SPECIES.ordinal()] = Species.thaumium;
			genome[EnumBeeChromosome.CAVE_DWELLING.ordinal()] = Allele.getBaseAllele("boolTrue");
			genome[EnumBeeChromosome.NOCTURNAL.ordinal()] = Allele.getBaseAllele("boolTrue");

			return genome;
		}
		
		public static IAllele[] getTemplateDarkThaumium()
		{
			IAllele[] genome = getTemplateModBase();
			
			genome[EnumBeeChromosome.SPECIES.ordinal()] = Species.darkThaumium;
			genome[EnumBeeChromosome.CAVE_DWELLING.ordinal()] = Allele.getBaseAllele("boolTrue");
			genome[EnumBeeChromosome.NOCTURNAL.ordinal()] = Allele.getBaseAllele("boolTrue");

			return genome;
		}
		
		public static IAllele[] getTemplateDarkSilverwood()
		{
			IAllele[] genome = getTemplateModBase();
			
			genome[EnumBeeChromosome.SPECIES.ordinal()] = Species.darkSilverwood;
			genome[EnumBeeChromosome.CAVE_DWELLING.ordinal()] = Allele.getBaseAllele("boolTrue");
			genome[EnumBeeChromosome.NOCTURNAL.ordinal()] = Allele.getBaseAllele("boolTrue");

			return genome;
		}
		
		public static IAllele[] getTemplateLightShard()
		{
			IAllele[] genome = getTemplateModBase();
			
			genome[EnumBeeChromosome.SPECIES.ordinal()] = Species.lightShard;
			genome[EnumBeeChromosome.CAVE_DWELLING.ordinal()] = Allele.getBaseAllele("boolTrue");
			genome[EnumBeeChromosome.NOCTURNAL.ordinal()] = Allele.getBaseAllele("boolTrue");

			return genome;
		}
		
		public static IAllele[] getTemplateTradeEssence()
		{
			IAllele[] genome = getTemplateModBase();
			
			genome[EnumBeeChromosome.SPECIES.ordinal()] = Species.tradeEssence;
			genome[EnumBeeChromosome.CAVE_DWELLING.ordinal()] = Allele.getBaseAllele("boolTrue");
			genome[EnumBeeChromosome.NOCTURNAL.ordinal()] = Allele.getBaseAllele("boolTrue");

			return genome;
		}
		
		public static IAllele[] getTemplateMagicEssence()
		{
			IAllele[] genome = getTemplateModBase();
			
			genome[EnumBeeChromosome.SPECIES.ordinal()] = Species.magicEssence;
			genome[EnumBeeChromosome.CAVE_DWELLING.ordinal()] = Allele.getBaseAllele("boolTrue");
			genome[EnumBeeChromosome.NOCTURNAL.ordinal()] = Allele.getBaseAllele("boolTrue");

			return genome;
		}
		
		public static IAllele[] getTemplateSilverwood()
		{
			IAllele[] genome = getTemplateModBase();
			
			genome[EnumBeeChromosome.SPECIES.ordinal()] = Species.silverwood;
			genome[EnumBeeChromosome.CAVE_DWELLING.ordinal()] = Allele.getBaseAllele("boolTrue");
			genome[EnumBeeChromosome.NOCTURNAL.ordinal()] = Allele.getBaseAllele("boolTrue");

			return genome;
		}
		
		public static IAllele[] getTemplateGreatwood()
		{
			IAllele[] genome = getTemplateModBase();
			
			genome[EnumBeeChromosome.SPECIES.ordinal()] = Species.greatwood;
			genome[EnumBeeChromosome.CAVE_DWELLING.ordinal()] = Allele.getBaseAllele("boolTrue");
			genome[EnumBeeChromosome.NOCTURNAL.ordinal()] = Allele.getBaseAllele("boolTrue");

			return genome;
		}
		
		public static IAllele[] getTemplateIgnisFuel()
		{
			IAllele[] genome = getTemplateModBase();
			
			genome[EnumBeeChromosome.SPECIES.ordinal()] = Species.ignisFuel;
			genome[EnumBeeChromosome.CAVE_DWELLING.ordinal()] = Allele.getBaseAllele("boolTrue");
			genome[EnumBeeChromosome.NOCTURNAL.ordinal()] = Allele.getBaseAllele("boolTrue");

			return genome;
		}
		
		public static IAllele[] getTemplateSalis()
		{
			IAllele[] genome = getTemplateModBase();
			
			genome[EnumBeeChromosome.SPECIES.ordinal()] = Species.salis;
			genome[EnumBeeChromosome.CAVE_DWELLING.ordinal()] = Allele.getBaseAllele("boolTrue");
			genome[EnumBeeChromosome.NOCTURNAL.ordinal()] = Allele.getBaseAllele("boolTrue");

			return genome;
		}
		
		public static IAllele[] getTemplateQuickSilver()
		{
			IAllele[] genome = getTemplateModBase();
			
			genome[EnumBeeChromosome.SPECIES.ordinal()] = Species.quicksilver;
			genome[EnumBeeChromosome.CAVE_DWELLING.ordinal()] = Allele.getBaseAllele("boolTrue");
			genome[EnumBeeChromosome.NOCTURNAL.ordinal()] = Allele.getBaseAllele("boolTrue");

			return genome;
		}
		
		public static IAllele[] getTemplateMana()
		{
			IAllele[] genome = getTemplateModBase();
			
			genome[EnumBeeChromosome.SPECIES.ordinal()] = Species.mana;
			genome[EnumBeeChromosome.CAVE_DWELLING.ordinal()] = Allele.getBaseAllele("boolTrue");
			genome[EnumBeeChromosome.NOCTURNAL.ordinal()] = Allele.getBaseAllele("boolTrue");

			return genome;
		}
		
		public static IAllele[] getTemplateReinforced()
		{
			IAllele[] genome = getTemplateModBase();
			
			genome[EnumBeeChromosome.SPECIES.ordinal()] = Species.reinforced;
			genome[EnumBeeChromosome.CAVE_DWELLING.ordinal()] = Allele.getBaseAllele("boolTrue");
			genome[EnumBeeChromosome.NOCTURNAL.ordinal()] = Allele.getBaseAllele("boolTrue");

			return genome;
		}
		
		public static IAllele[] getTemplateSunstone()
		{
			IAllele[] genome = getTemplateModBase();
			
			genome[EnumBeeChromosome.SPECIES.ordinal()] = Species.sunstone;

			return genome;
		}
		
		public static IAllele[] getTemplateMoonstoon()
		{
			IAllele[] genome = getTemplateModBase();
			
			genome[EnumBeeChromosome.SPECIES.ordinal()] = Species.moonstone;
			genome[EnumBeeChromosome.CAVE_DWELLING.ordinal()] = Allele.getBaseAllele("boolTrue");
			genome[EnumBeeChromosome.NOCTURNAL.ordinal()] = Allele.getBaseAllele("boolTrue");

			return genome;
		}
		
		public static IAllele[] getTemplateChimerite()
		{
			IAllele[] genome = getTemplateModBase();
			
			genome[EnumBeeChromosome.SPECIES.ordinal()] = Species.chimerite;
			genome[EnumBeeChromosome.CAVE_DWELLING.ordinal()] = Allele.getBaseAllele("boolTrue");
			genome[EnumBeeChromosome.NOCTURNAL.ordinal()] = Allele.getBaseAllele("boolTrue");

			return genome;
		}
		
		public static IAllele[] getTemplateCertusQuartz()
		{
			IAllele[] genome = getTemplateModBase();
			
			genome[EnumBeeChromosome.SPECIES.ordinal()] = Species.certusQuartz;
			genome[EnumBeeChromosome.CAVE_DWELLING.ordinal()] = Allele.getBaseAllele("boolTrue");
			genome[EnumBeeChromosome.NOCTURNAL.ordinal()] = Allele.getBaseAllele("boolTrue");

			return genome;
		}
		
		public static IAllele[] getTemplateCoke()
		{
			IAllele[] genome = getTemplateModBase();
			
			genome[EnumBeeChromosome.SPECIES.ordinal()] = Species.coke;
			genome[EnumBeeChromosome.CAVE_DWELLING.ordinal()] = Allele.getBaseAllele("boolTrue");
			genome[EnumBeeChromosome.NOCTURNAL.ordinal()] = Allele.getBaseAllele("boolTrue");

			return genome;
		}
		
		public static IAllele[] getTemplateDraconic()
		{
			IAllele[] genome = getTemplateModBase();
			
			genome[EnumBeeChromosome.SPECIES.ordinal()] = Species.draconic;
			genome[EnumBeeChromosome.CAVE_DWELLING.ordinal()] = Allele.getBaseAllele("boolTrue");
			genome[EnumBeeChromosome.NOCTURNAL.ordinal()] = Allele.getBaseAllele("boolTrue");

			return genome;
		}
		
		public static IAllele[] getTemplatePig()
		{
			IAllele[] genome = getTemplateModBase();
			
			genome[EnumBeeChromosome.SPECIES.ordinal()] = Species.pig;

			return genome;
		}
		
		public static ItemStack getBeeNBTForSpecies(Species species, EnumBeeType beeType)
		{
			ItemStack taggedBee;
			switch (beeType)
			{
				case PRINCESS:
					taggedBee = ItemInterface.getItem("beePrincessGE");
					break;
				case QUEEN:
					taggedBee = ItemInterface.getItem("beeQueenGE");
					break;
				case DRONE:
				default:
					taggedBee = ItemInterface.getItem("beeDroneGE");
					break;
			}
			
			NBTTagCompound tags = new NBTTagCompound();
			
			addGeneToCompound(EnumBeeChromosome.SPECIES, species, tags);
			
			taggedBee.setTagCompound(tags);
			
			return taggedBee;
		}
		
		private static void addGeneToCompound(EnumBeeChromosome gene, IAllele allele, NBTTagCompound compound)
		{
			NBTTagCompound geneRoot = new NBTTagCompound();
			compound.setTag("Genome", geneRoot);
			NBTTagList chromosomes = new NBTTagList();
			geneRoot.setTag("Chromosomes", chromosomes);
			
			NBTTagCompound selectedGene = new NBTTagCompound();
			chromosomes.appendTag(selectedGene);
			
			selectedGene.setByte("Slot", (byte)gene.ordinal());
			selectedGene.setString("UID0", allele.getUID());
			selectedGene.setString("UID1", allele.getUID());		
		}
}