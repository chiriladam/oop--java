package lab5.coffee;

/**
 * Base Coffee class (parent in inheritance).
 * Only ONE field must be added here: intensity.
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

    /**
     * Task 2: printDetails() that subclasses extend using super.
     */
    public void printDetails() {
        System.out.println("Coffee type: " + name);
        System.out.println("Intensity: " + coffeeIntensity);
    }

    /**
     * Task 3: generic fallback method
     */
    public Coffee makeCoffee() {
        System.out.println("Brewing generic coffee...");
        return this;
    }
}
