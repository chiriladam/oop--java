package lab5.coffee;

/**
 * Cappuccino extends Coffee.
 * Adds ONE extra field: mlOfMilk.
 */
public class Cappuccino extends Coffee {

    protected int mlOfMilk;
    protected final String coffee = "Cappuccino";

    public Cappuccino(Intensity intensity, int mlOfMilk) {
        super(intensity);
        this.mlOfMilk = mlOfMilk;
    }
}
