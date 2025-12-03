package task2;

import java.nio.file.Files;
import java.nio.file.Paths;

/*
 * Utility class to read entire text files into a String.
 */
public class FileReaderUtil {

    // Reads file content as a complete string
    public static String readFileIntoString(String path) {
        try {
            return Files.readString(Paths.get(path));
        } catch (Exception e) {
            System.out.println("Error reading file: " + path);
            return "";
        }
    }
}
