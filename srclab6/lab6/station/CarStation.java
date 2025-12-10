package lab6.station;

import lab6.model.Car;
import lab6.queue.Queue;
import lab6.dining.Dineable;
import lab6.refuel.Refuelable;

public class CarStation {

    private final Dineable diningService;
    private final Refuelable refuelingService;
    private final Queue<Car> queue;

    public CarStation(Dineable diningService, Refuelable refuelingService, Queue<Car> queue) {
        this.diningService = diningService;
        this.refuelingService = refuelingService;
        this.queue = queue;
    }

    public void addCar(Car car) {
        queue.enqueue(car);
    }

    public void serveCars() {
        while (!queue.isEmpty()) {
            Car c = queue.dequeue();

            if (c.isDining) {
                diningService.serveDinner(c.id);
            }

            refuelingService.refuel(c.id);
        }
    }
}
