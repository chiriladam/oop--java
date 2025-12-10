package lab6.refuel;

public class ElectricStation implements Refuelable {

    @Override
    public void refuel(String carId) {
        System.out.println("Refueling ELECTRIC car " + carId);
    }
}
