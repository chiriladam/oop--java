package lab5.coffee;

/**
 * Americano extends Coffee.
 * Adds ONE field: mlOfWater.
 */
public class Americano extends Coffee {

    protected int mlOfWater;
    protected final String coffee = "Americano";

    public Americano(Intensity intensity, int mlOfWater) {
        super(intensity);
        this.mlOfWater = mlOfWater;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Water: " + mlOfWater + " ml");
    }

    public Americano makeAmericano() {
        System.out.println("Making Americano:");
        System.out.println(" - Brewing espresso");
        System.out.println(" - Adding " + mlOfWater + " ml hot water");
        return this;
    }
}
