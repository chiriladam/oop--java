package lab5.coffee;

/**
 * Cappuccino extends Coffee.
 * Adds ONE field: mlOfMilk.
 */
public class Cappuccino extends Coffee {

    protected int mlOfMilk;
    protected final String coffee = "Cappuccino";

    public Cappuccino(Intensity intensity, int mlOfMilk) {
        super(intensity);
        this.mlOfMilk = mlOfMilk;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Milk: " + mlOfMilk + " ml");
    }

    public Cappuccino makeCappuccino() {
        System.out.println("Making Cappuccino:");
        System.out.println(" - Brewing espresso");
        System.out.println(" - Steaming " + mlOfMilk + " ml of milk");
        return this;
    }
}
