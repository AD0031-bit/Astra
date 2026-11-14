package astra.persistence;

import java.io.*;

public class SaveLoadManager {

    // Save game data
    public void saveGame(Object data, String fileName) {

        if (data == null) {
            System.out.println("Cannot save empty game data!");
            return;
        }

        try (ObjectOutputStream output =
                new ObjectOutputStream(new FileOutputStream(fileName))) {

            output.writeObject(data);
            System.out.println("Game saved successfully!");

        } catch (IOException e) {
            System.out.println("Error saving game: " + e.getMessage());
        }
    }

    // Load game data
    public Object loadGame(String fileName) {

        File file = new File(fileName);

        // Check if file exists
        if (!file.exists()) {
            System.out.println("Save file not found!");
            return null;
        }

        try (ObjectInputStream input =
                new ObjectInputStream(new FileInputStream(file))) {

            Object data = input.readObject();

            System.out.println("Game loaded successfully!");
            return data;

        } catch (EOFException e) {
            System.out.println("Save file is empty!");
            return null;

        } catch (InvalidClassException e) {
            System.out.println("Save file version is incompatible!");
            return null;

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading game: " + e.getMessage());
            return null;
        }
    }
}