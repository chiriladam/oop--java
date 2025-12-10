package lab6.dining;

public class RobotDinner implements Dineable {

    @Override
    public void serveDinner(String carId) {
        System.out.println("Serving dinner to ROBOTS in car " + carId);
    }
}
