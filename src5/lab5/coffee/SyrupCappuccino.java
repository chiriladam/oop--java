package lab5.coffee;

/**
 * SyrupCappuccino extends Cappuccino.
 * Adds ONE field: syrup type.
 */
public class SyrupCappuccino extends Cappuccino {

    protected SyrupType syrup;
    protected final String coffee = "SyrupCappuccino";

    public SyrupCappuccino(Intensity intensity, int mlOfMilk, SyrupType syrup) {
        super(intensity, mlOfMilk);
        this.syrup = syrup;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Syrup: " + syrup);
    }

    public SyrupCappuccino makeSyrupCappuccino() {
        System.out.println("Making Syrup Cappuccino:");
        System.out.println(" - Brewing espresso");
        System.out.println(" - Steaming " + mlOfMilk + " ml milk");
        System.out.println(" - Adding syrup: " + syrup);
        return this;
    }
}
