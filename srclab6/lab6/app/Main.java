package lab6.app;

import lab6.queue.*;
import lab6.dining.*;
import lab6.refuel.*;
import lab6.station.*;
import lab6.semaphore.Semaphore;
import lab6.scheduler.Scheduler;

public class Main {
    public static void main(String[] args) {

        // Build all 4 stations
        CarStation electricPeople = new CarStation(new PeopleDinner(), new ElectricStation(), new SimpleArrayQueue<>());
        CarStation electricRobots = new CarStation(new RobotDinner(), new ElectricStation(), new LinkedQueue<>());
        CarStation gasPeople = new CarStation(new PeopleDinner(), new GasStation(), new FixedSizeQueue<>(50));
        CarStation gasRobots = new CarStation(new RobotDinner(), new GasStation(), new SimpleArrayQueue<>());

        Semaphore semaphore = new Semaphore(electricPeople, electricRobots, gasPeople, gasRobots);

        Scheduler scheduler = new Scheduler(semaphore);

        scheduler.loadCarsFromFolder("queue");

        electricPeople.serveCars();
        electricRobots.serveCars();
        gasPeople.serveCars();
        gasRobots.serveCars();
    }
}
