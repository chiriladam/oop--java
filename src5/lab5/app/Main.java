package lab5.app;

import lab5.barista.Barista;
import lab5.coffee.Intensity;
import lab5.coffee.SyrupType;

import java.util.ArrayList;
import java.util.List;

/**
 * Main interacts ONLY with Barista.
 */
public class Main {
    public static void main(String[] args) {

        Barista barista = new Barista();
        List coffees = new ArrayList<>();

        // All coffee objects are created ONLY by Barista
        coffees.add(barista.orderCappuccino(Intensity.NORMAL, 150));
        coffees.add(barista.orderPSL(Intensity.STRONG, 85));
        coffees.add(barista.orderAmericano(Intensity.LIGHT, 120));
        coffees.add(barista.orderSyrupCappuccino(Intensity.NORMAL, 130, SyrupType.VANILLA));

        barista.makeOrders(coffees);
    }
}
