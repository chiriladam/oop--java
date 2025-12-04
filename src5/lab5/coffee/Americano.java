package lab5.coffee;

/**
 * Americano extends Coffee.
 * Adds ONE field: mlOfWater.
 */
public class Americano extends Coffee {

    protected int mlOfWater;
    protected final String coffeeName = "Americano";

    public Americano(Intensity intensity, int mlOfWater) {
        super(intensity);
        this.mlOfWater = mlOfWater;
    }
}
