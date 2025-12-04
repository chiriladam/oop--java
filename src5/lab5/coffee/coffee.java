package lab5.coffee;

/**
 * Base Coffee class. All drinks inherit from this class.
 * Adds only ONE field: intensity + constant name.
 */
public class Coffee {
    protected Intensity coffeeIntensity;
    protected final String name = "Coffee";

    public Coffee(Intensity intensity) {
        this.coffeeIntensity = intensity;
    }

    public String getName() {
        return name;
    }

    public Intensity getIntensity() {
        return coffeeIntensity;
    }
}
