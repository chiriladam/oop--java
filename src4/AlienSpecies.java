/**
 * Represents an alien species.
 * This class simply stores the data loaded from the input.json file.
 * Classification will later fill the "universe" field.
 */
public class AlienSpecies {

    public int id;
    public String name;
    public String universe;     // Filled after classification
    public String dangerLevel;
    public String[] features;
    public int power;

    public AlienSpecies(int id, String name, String dangerLevel, String[] features, int power) {
        this.id = id;
        this.name = name;
        this.dangerLevel = dangerLevel;
        this.features = features;
        this.power = power;
        this.universe = "Unassigned"; // default until classification
    }

    @Override
    public String toString() {
        return id + ": " + name + " (" + dangerLevel + "), power=" + power;
    }
}
