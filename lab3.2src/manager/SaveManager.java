package manager;

import system.University;

import java.io.*;

/**
 * SaveManager handles saving and loading the University object to disk.
 * Uses Java serialization to write a binary file "university.dat".
 *
 * Note: using built-in serialization satisfies the "no third party" requirement.
 */
public class SaveManager {

    private static final String SAVE_FILE = "university.dat";

    // Save the university to disk; returns true on success
    public static boolean save(University u) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_FILE))) {
            oos.writeObject(u);
            return true;
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
            return false;
        }
    }

    // Load the university; if file absent or error, returns a new empty University
    public static University load() {
        File f = new File(SAVE_FILE);
        if (!f.exists()) {
            // No saved state -> return new University
            return new University();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SAVE_FILE))) {
            Object obj = ois.readObject();
            if (obj instanceof University) {
                return (University) obj;
            } else {
                System.out.println("Save file corrupted or not valid. Starting fresh.");
                return new University();
            }
        } catch (Exception e) {
            System.out.println("Error loading data: " + e.getMessage());
            return new University();
        }
    }
}
