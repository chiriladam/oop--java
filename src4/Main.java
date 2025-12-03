import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {

    /**
     * Reads a file and returns its content as a single string.
     */
    public static String readFile(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            return sb.toString();

        } catch (Exception e) {
            System.out.println("Could not read file: " + path);
            return "[]";
        }
    }

    /**
     * A VERY simple JSON parser made specifically for this lab.
     * It expects the structure from input.json and converts it into objects.
     */
    public static ArrayList<AlienSpecies> parseSpecies(String json) {
        ArrayList<AlienSpecies> speciesList = new ArrayList<>();

        // Remove the [   ] at start and end
        json = json.trim();
        if (json.startsWith("[")) json = json.substring(1);
        if (json.endsWith("]")) json = json.substring(0, json.length() - 1);

        if (json.isBlank()) return speciesList;

        // Split objects by "},{"
        String[] objects = json.split("\\},\\{");

        for (String obj : objects) {

            obj = obj.replace("{", "").replace("}", "").trim();
            if (obj.isEmpty()) continue;

            try {
                // id
                int id = Integer.parseInt(obj.split("\"id\":")[1].split(",")[0].trim());

                // name
                String name = obj.split("\"name\":")[1]
                                 .split(",")[0]
                                 .replace("\"", "")
                                 .trim();

                // dangerLevel
                String danger = obj.split("\"dangerLevel\":")[1]
                                   .split(",")[0]
                                   .replace("\"", "")
                                   .trim();

                // features
                String featureBlock = obj.split("\"features\":")[1]
                                         .split("]")[0]
                                         .replace("[", "")
                                         .replace("\"", "")
                                         .trim();

                String[] features = featureBlock.isEmpty()
                        ? new String[0]
                        : featureBlock.split(",");

                // power
                int power = Integer.parseInt(obj.split("\"power\":")[1].trim());

                speciesList.add(new AlienSpecies(id, name, danger, features, power));

            } catch (Exception e) {
                System.out.println("Error parsing object: " + obj);
            }
        }

        return speciesList;
    }

    /**
     * SIMPLE classification rules (as requested):
     *
     * - If features contain "telepathy" → Psi Universe
     * - Else if power > 70 → Omega Universe
     * - Else if dangerLevel = "high" → Delta Universe
     * - Else → Neutral Universe
     */
    public static void classify(AlienSpecies a) {

        // telepathy -> psi universe
        for (String f : a.features) {
            if (f.trim().equalsIgnoreCase("telepathy")) {
                a.universe = "Psi";
                return;
            }
        }

        // strong species
        if (a.power > 70) {
            a.universe = "Omega";
            return;
        }

        // dangerous species
        if (a.dangerLevel.equalsIgnoreCase("high")) {
            a.universe = "Delta";
            return;
        }

        // default
        a.universe = "Neutral";
    }

    /**
     * Writes a simple JSON output file containing only:
     * - id
     * - name
     * - universe (after classification)
     */
    public static void writeOutput(ArrayList<AlienSpecies> list) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("[\n");

            for (int i = 0; i < list.size(); i++) {
                AlienSpecies a = list.get(i);

                sb.append("  {\n");
                sb.append("    \"id\": ").append(a.id).append(",\n");
                sb.append("    \"name\": \"").append(a.name).append("\",\n");
                sb.append("    \"universe\": \"").append(a.universe).append("\"\n");
                sb.append("  }");

                if (i < list.size() - 1) sb.append(",");
                sb.append("\n");
            }

            sb.append("]");

            java.nio.file.Files.writeString(
                    java.nio.file.Path.of("output.json"),
                    sb.toString()
            );

            System.out.println("\noutput.json generated successfully!");

        } catch (Exception e) {
            System.out.println("Failed to write output.json");
        }
    }

    /**
     * Main pipeline of the entire lab:
     * 1. Load input.json
     * 2. Parse JSON into AlienSpecies objects
     * 3. Classify each species
     * 4. Write output.json
     */
    public static void main(String[] args) {

        // 1. Read file content
        String rawJson = readFile("input.json");

        // 2. Convert JSON -> objects
        ArrayList<AlienSpecies> list = parseSpecies(rawJson);

        // 3. Classify each alien
        for (AlienSpecies a : list) {
            classify(a);
        }

        // 4. Save results
        writeOutput(list);

        System.out.println("\nProcess completed.");
    }
}
