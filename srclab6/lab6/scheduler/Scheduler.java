package lab6.scheduler;

import lab6.model.Car;
import lab6.semaphore.Semaphore;

import java.io.File;
import java.io.FileReader;
import com.google.gson.Gson;

public class Scheduler {

    private final Semaphore semaphore;
    private final Gson gson = new Gson();

    public Scheduler(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public void loadCarsFromFolder(String path) {
        File folder = new File(path);

        for (File f : folder.listFiles()) {
            try (FileReader r = new FileReader(f)) {
                Car c = gson.fromJson(r, Car.class);
                semaphore.route(c);
            } catch (Exception ignored) {}
        }
    }
}
