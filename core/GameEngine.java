package core;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public final class GameEngine {
    public interface ModuleActions {
        default void buildStructure(Colony colony, Scanner input, PrintStream output) { }
        default void manageRobots(Colony colony, Scanner input, PrintStream output) { }
        default void manageColonists(Colony colony, Scanner input, PrintStream output) { }
        default void researchTechnology(Colony colony, Scanner input, PrintStream output) { }
        default void viewMissions(Colony colony, PrintStream output) { }
        default void applyEndOfDayEvents(Colony colony, PrintStream output) { }
        default void saveGame(Colony colony, PrintStream output) { }
    }

    private static final ModuleActions NO_ACTIONS = new ModuleActions() { };

    private final Colony colony;
    private final Scanner input;
    private final PrintStream output;
    private ModuleActions moduleActions;
    private boolean running;

    public GameEngine() {
        this(new Colony(), System.in, System.out);
    }

    public GameEngine(Colony colony, InputStream input, PrintStream output) {
        if (colony == null || input == null || output == null) {
            throw new IllegalArgumentException("Colony, input, and output are required.");
        }
        this.colony = colony;
        this.input = new Scanner(input);
        this.output = output;
        this.moduleActions = NO_ACTIONS;
    }

    public Colony getColony() {
        return colony;
    }

    public void setModuleActions(ModuleActions moduleActions) {
        this.moduleActions = moduleActions == null ? NO_ACTIONS : moduleActions;
    }

    public void run() {
        running = true;
        output.println("Welcome, Commander. Keep ASTRA alive.");
        while (running && !colony.isCollapsed()) {
            printMenu();
            handleChoice(readChoice());
        }
        if (colony.isCollapsed()) {
            output.println("Colony collapse: a life-support requirement was exhausted.");
        }
        output.println("ASTRA session ended.");
    }

    private void handleChoice(int choice) {
        switch (choice) {
            case 1:
                printDashboard();
                break;
            case 2:
                moduleActions.buildStructure(colony, input, output);
                break;
            case 3:
                moduleActions.manageRobots(colony, input, output);
                break;
            case 4:
                moduleActions.manageColonists(colony, input, output);
                break;
            case 5:
                moduleActions.researchTechnology(colony, input, output);
                break;
            case 6:
                moduleActions.viewMissions(colony, output);
                break;
            case 7:
                endDay();
                break;
            case 8:
                moduleActions.saveGame(colony, output);
                break;
            case 9:
                running = false;
                break;
            default:
                output.println("Invalid choice. Please enter a number from 1 to 9.");
        }
    }

    private int readChoice() {
        output.print("Choose: ");
        if (!input.hasNextLine()) {
            return 9;
        }
        String line = input.nextLine().trim();
        try {
            return Integer.parseInt(line);
        } catch (NumberFormatException exception) {
            return -1;
        }
    }

    private void endDay() {
        colony.advanceDay();
        moduleActions.applyEndOfDayEvents(colony, output);
        output.println("Day " + colony.getDay() + " has begun.");
        printDashboard();
    }

    private void printMenu() {
        output.println();
        output.println("+====================================+");
        output.println("|       ASTRA COLONY COMMAND         |");
        output.println("+====================================+");
        output.println("Day: " + colony.getDay());
        output.println("1. View Colony");
        output.println("2. Build Structure");
        output.println("3. Manage Robots");
        output.println("4. Manage Colonists");
        output.println("5. Research Technology");
        output.println("6. View Missions");
        output.println("7. End Day");
        output.println("8. Save Game");
        output.println("9. Exit");
    }

    private void printDashboard() {
        output.println("Oxygen : " + progressBar(colony.getResource(Colony.OXYGEN)));
        output.println("Food   : " + progressBar(colony.getResource(Colony.FOOD)));
        output.println("Water  : " + progressBar(colony.getResource(Colony.WATER)));
        output.println("Energy : " + progressBar(colony.getResource(Colony.ENERGY)));
        output.println("Metal  : " + progressBar(colony.getResource(Colony.METAL)));
        output.println("Population: " + colony.getPopulation());
        output.println("Morale: " + colony.getMorale() + "%");
    }

    private String progressBar(int value) {
        int filled = value / 10;
        StringBuilder bar = new StringBuilder("[");
        for (int index = 0; index < 10; index++) {
            bar.append(index < filled ? '#' : '-');
        }
        return bar.append("] ").append(value).append('%').toString();
    }
}
