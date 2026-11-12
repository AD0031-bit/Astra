
package test;

import astra.research.Technology;
import astra.research.ResearchManager;

public class ResearchManagerTest {

    public static void main(String[] args) {

        ResearchManager manager = new ResearchManager();

        Technology tech1 = new Technology(
            "Advanced Oxygen Generator",
            "Improves oxygen production"
        );

        Technology tech2 = new Technology(
            "Solar Energy",
            "Improves energy production"
        );

        manager.addTechnology(tech1);
        manager.addTechnology(tech2);

        System.out.println("Available Technologies:");
        manager.displayTechnologies();

        System.out.println("\nStarting Research:");
        System.out.println(manager.startResearch("Advanced Oxygen Generator"));

        System.out.println("\nResearch Status:");
        System.out.println(manager.isResearched("Advanced Oxygen Generator"));
        System.out.println(manager.isResearched("Solar Energy"));
    }
}
