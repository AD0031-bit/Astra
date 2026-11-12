
package test;

import astra.persistence.SaveLoadManager;
import java.io.FileOutputStream;
import java.io.IOException;

public class SaveLoadManagerTest {

    public static void main(String[] args) {

        SaveLoadManager manager = new SaveLoadManager();

        String fileName = "savegame.dat";

        // Sample game data
        String gameData = "ASTRA GAME PROGRESS";

        // Save game
        System.out.println("Saving Game:");
        manager.saveGame(gameData, fileName);

        // Load game
        System.out.println("\nLoading Game:");
        Object loadedData = manager.loadGame(fileName);

        // Display loaded data
        System.out.println("\nLoaded Data:");
        System.out.println(loadedData);

        // Test missing file
        System.out.println("\nTesting Missing File:");
        manager.loadGame("missing.dat");

        // Test empty file
        System.out.println("\nTesting Empty File:");

        try {
            new FileOutputStream("empty.dat").close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        manager.loadGame("empty.dat");
    }
}
