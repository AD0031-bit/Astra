
package astra.missions;

import astra.enums.Status;

public class Mission {

    private String name;
    private String description;
    private int reward;
    private Status status;

    // Constructor
    public Mission(String name, String description, int reward) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Mission name cannot be empty");
        }

        if (reward < 0) {
            throw new IllegalArgumentException("Reward cannot be negative");
        }

        this.name = name;
        this.description = description;
        this.reward = reward;
        this.status = Status.NOT_STARTED;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getReward() {
        return reward;
    }

    public Status getStatus() {
        return status;
    }

    // Update mission status
    public void setStatus(Status status) {
        if (status != null) {
            this.status = status;
        }
    }
}
