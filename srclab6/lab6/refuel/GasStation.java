package lab6.refuel;

public class GasStation implements Refuelable {

    @Override
    public void refuel(String carId) {
        System.out.println("Refueling GAS car " + carId);
    }
}
