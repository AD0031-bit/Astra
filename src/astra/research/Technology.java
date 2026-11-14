
package astra.research;

public class Technology {

    private String name;
    private String description;
    private boolean researched;

    // Constructor
    public Technology(String name, String description) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Technology name cannot be empty");
        }

        this.name = name;
        this.description = description;
        this.researched = false;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isResearched() {
        return researched;
    }

    // Setter
    public void setResearched(boolean researched) {
        this.researched = researched;
    }
}
