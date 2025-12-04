package lab5.coffee;

/**
 * PumpkinSpiceLatte extends Coffee.
 * Adds ONE field: mgOfPumpkinSpice.
 */
public class PumpkinSpiceLatte extends Coffee {

    protected int mgOfPumpkinSpice;
    protected final String name = "PumpkinSpiceLatte";

    public PumpkinSpiceLatte(Intensity intensity, int mgOfPumpkinSpice) {
        super(intensity);
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;
    }
}
