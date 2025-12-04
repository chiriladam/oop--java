package lab5.coffee;

/**
 * PSL extends Coffee.
 * Adds ONE field: mgOfPumpkinSpice.
 */
public class PumpkinSpiceLatte extends Coffee {

    protected int mgOfPumpkinSpice;
    protected final String coffee = "PumpkinSpiceLatte";

    public PumpkinSpiceLatte(Intensity intensity, int mgOfPumpkinSpice) {
        super(intensity);
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Pumpkin spice: " + mgOfPumpkinSpice + " mg");
    }

    public PumpkinSpiceLatte makePumpkinSpiceLatte() {
        System.out.println("Making Pumpkin Spice Latte:");
        System.out.println(" - Brewing espresso");
        System.out.println(" - Adding " + mgOfPumpkinSpice + " mg pumpkin spice");
        return this;
    }
}
