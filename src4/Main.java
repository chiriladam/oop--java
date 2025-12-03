import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {

    // Simple file reader: returns full JSON string
    public static String readFile(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) sb.append(line);
            return sb.toString();
        } catch (Exception e) {
            return "[]";
        }
    }

    public static void main(String[] args) {
        String rawJson = readFile("input.json");

        System.out.println("Raw JSON loaded:");
        System.out.println(rawJson);
    }
}
