
package test;

import astra.missions.Mission;
import astra.missions.MissionManager;

public class MissionManagerTest {

    public static void main(String[] args) {

        MissionManager manager = new MissionManager();

        // Create missions
        Mission mission1 = new Mission(
            "Explore Mars",
            "Explore the Martian surface",
            500
        );

        Mission mission2 = new Mission(
            "Repair Oxygen System",
            "Repair the colony oxygen system",
            300
        );

        // Add missions
        manager.addMission(mission1);
        manager.addMission(mission2);

        // Display missions
        System.out.println("INITIAL MISSIONS:");
        manager.displayMissions();

        // Start mission
        System.out.println("\nStarting Mission:");
        System.out.println(manager.startMission("Explore Mars"));

        // Complete mission
        System.out.println("\nCompleting Mission:");
        System.out.println(manager.completeMission("Explore Mars"));

        // Start another mission
        manager.startMission("Repair Oxygen System");

        // Fail mission
        System.out.println("\nFailing Mission:");
        System.out.println(manager.failMission("Repair Oxygen System"));

        // Final mission status
        System.out.println("\nFINAL MISSIONS:");
        manager.displayMissions();

        // Find mission
        System.out.println("\nFinding Mission:");
        System.out.println(manager.findMission("Explore Mars").getName());
    }
}
