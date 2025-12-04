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
}
