package lab6.semaphore;

import lab6.model.Car;
import lab6.station.CarStation;

/**
 * Decides which CarStation should serve a given car.
 */
public class Semaphore {

    private final CarStation electricPeopleStation;
    private final CarStation electricRobotStation;
    private final CarStation gasPeopleStation;
    private final CarStation gasRobotStation;

    public Semaphore(CarStation eP, CarStation eR, CarStation gP, CarStation gR) {
        this.electricPeopleStation = eP;
        this.electricRobotStation = eR;
        this.gasPeopleStation = gP;
        this.gasRobotStation = gR;
    }

    public void route(Car c) {
        if (c.type.equals("ELECTRIC")) {
            if (c.passengers.equals("PEOPLE"))
                electricPeopleStation.addCar(c);
            else
                electricRobotStation.addCar(c);
        }
        else {
            if (c.passengers.equals("PEOPLE"))
                gasPeopleStation.addCar(c);
            else
                gasRobotStation.addCar(c);
        }
    }
}
