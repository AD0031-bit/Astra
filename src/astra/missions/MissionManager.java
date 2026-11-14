
package astra.missions;

import java.util.ArrayList;
import astra.enums.Status;

public class MissionManager {

    private ArrayList<Mission> missions;

    // Constructor
    public MissionManager() {
        missions = new ArrayList<>();
    }

    // Add mission
    public void addMission(Mission mission) {
        if (mission != null) {
            missions.add(mission);
        }
    }

    // Display all missions
    public void displayMissions() {
        System.out.println("\nAvailable Missions:");

        for (Mission mission : missions) {
            System.out.println(
                mission.getName() + " - " +
                mission.getDescription() +
                " | Reward: " + mission.getReward() +
                " | Status: " + mission.getStatus()
            );
        }
    }

    // Start mission
    public boolean startMission(String name) {
        for (Mission mission : missions) {
            if (mission.getName().equalsIgnoreCase(name)) {
                if (mission.getStatus() == Status.NOT_STARTED) {
                    mission.setStatus(Status.IN_PROGRESS);
                    return true;
                }
            }
        }
        return false;
    }

    // Complete mission
    public boolean completeMission(String name) {
        for (Mission mission : missions) {
            if (mission.getName().equalsIgnoreCase(name)) {
                if (mission.getStatus() == Status.IN_PROGRESS) {
                    mission.setStatus(Status.COMPLETED);
                    return true;
                }
            }
        }
        return false;
    }

    // Fail mission
    public boolean failMission(String name) {
        for (Mission mission : missions) {
            if (mission.getName().equalsIgnoreCase(name)) {
                if (mission.getStatus() == Status.IN_PROGRESS) {
                    mission.setStatus(Status.FAILED);
                    return true;
                }
            }
        }
        return false;
    }

    // Find mission
    public Mission findMission(String name) {
        for (Mission mission : missions) {
            if (mission.getName().equalsIgnoreCase(name)) {
                return mission;
            }
        }
        return null;
    }
}
