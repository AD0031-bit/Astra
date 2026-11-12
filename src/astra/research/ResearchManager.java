
package astra.research;

import java.util.ArrayList;

public class ResearchManager {

    private ArrayList<Technology> technologies;

    // Constructor
    public ResearchManager() {
        technologies = new ArrayList<>();
    }

    // Add technology
    public void addTechnology(Technology technology) {
        if (technology != null) {
            technologies.add(technology);
        }
    }

    // Display all technologies
    public void displayTechnologies() {
        for (Technology tech : technologies) {
            System.out.println(tech.getName() + " - " + tech.getDescription());
        }
    }

    // Start research
    public boolean startResearch(String name) {
        for (Technology tech : technologies) {
            if (tech.getName().equalsIgnoreCase(name)) {
                if (!tech.isResearched()) {
                    tech.setResearched(true);
                    return true;
                }
            }
        }
        return false;
    }

    // Check research status
    public boolean isResearched(String name) {
        for (Technology tech : technologies) {
            if (tech.getName().equalsIgnoreCase(name)) {
                return tech.isResearched();
            }
        }
        return false;
    }
}
