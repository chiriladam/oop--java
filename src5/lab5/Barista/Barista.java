package lab5.barista;

import lab5.coffee.*;

import java.util.List;

/**
 * Barista interacts with ALL Coffee types.
 * Main is NOT allowed to instantiate coffee classes directly.
 */
public class Barista {

    /**
     * Processes a list of coffee orders.
     */
    public void makeOrders(List<Coffee> orders) {

        for (Coffee c : orders) {
            System.out.println("\n=== New Order ===");
            c.printDetails();
            brew(c);
        }
    }

    /**
     * Calls the correct brewing method based on actual class type.
     * Uses pattern matching instanceof.
     */
    private void brew(Coffee c) {

        if (c instanceof Cappuccino cap) {
            cap.makeCappuccino();
        } 
        else if (c instanceof PumpkinSpiceLatte psl) {
            psl.makePumpkinSpiceLatte();
        } 
        else if (c instanceof Americano am) {
            am.makeAmericano();
        } 
        else if (c instanceof SyrupCappuccino sc) {
            sc.makeSyrupCappuccino();
        } 
        else {
            c.makeCoffee();
        }
    }

    // FACTORY METHODS — Main must ONLY use these

    public Cappuccino orderCappuccino(Intensity i, int milk) {
        return new Cappuccino(i, milk);
    }

    public PumpkinSpiceLatte orderPSL(Intensity i, int spice) {
        return new PumpkinSpiceLatte(i, spice);
    }

    public Americano orderAmericano(Intensity i, int water) {
        return new Americano(i, water);
    }

    public SyrupCappuccino orderSyrupCappuccino(Intensity i, int milk, SyrupType type) {
        return new SyrupCappuccino(i, milk, type);
    }
}
