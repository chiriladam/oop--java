package task2;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReaderUtil {
    public static String readFileIntoString(String path) {
        try {
            return Files.readString(Paths.get(path));
        } catch (Exception e) {
            return "";
        }
    }
}
