/**
 * Represents a simple alien species as described in the lab.
 * For now, it's only a data model
 */
public class AlienSpecies {
    public int id;
    public String name;
    public String universe;      // will be classified later
    public String dangerLevel;
    public String[] features;
    public int power;

    public AlienSpecies(int id, String name, String dangerLevel, String[] features, int power) {
        this.id = id;
        this.name = name;
        this.dangerLevel = dangerLevel;
        this.features = features;
        this.power = power;
        this.universe = "Unassigned";  // default until we classify
    }

    @Override
    public String toString() {
        return id + ": " + name + " (" + dangerLevel + "), power=" + power;
    }
}
