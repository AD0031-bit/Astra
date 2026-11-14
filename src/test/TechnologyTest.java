
package test;

import astra.research.Technology;

public class TechnologyTest {

    public static void main(String[] args) {

        Technology tech = new Technology(
            "Advanced Oxygen Generator",
            "Improves oxygen production"
        );

        System.out.println(tech.getName());
        System.out.println(tech.getDescription());
        System.out.println(tech.isResearched());

        // Mark technology as researched
        tech.setResearched(true);

        System.out.println(tech.isResearched());
    }
}
