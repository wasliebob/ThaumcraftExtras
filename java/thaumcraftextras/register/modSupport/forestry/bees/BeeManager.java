package thaumcraftextras.register.modSupport.forestry.bees;

import forestry.api.apiculture.IBeeRoot;
import forestry.api.genetics.AlleleManager;

public class BeeManager {

    public static IBeeRoot beeRoot;

    public static void setupController() {
        beeRoot = (IBeeRoot) AlleleManager.alleleRegistry.getSpeciesRoot("rootBees");
        Species.loadSpecies();
        BeeMutation.setupMutations();
    }
}
