public class SmartOven {
    private String brand;
    private String model;
    private double temperature;
    private String mode;
    private boolean doorOpen;

    public SmartOven(String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.temperature = 25.0;
        this.mode = "off";
        this.doorOpen = false;
    }

    public void preheat(double temp) {
        if (doorOpen) {
            System.out.println("Close the door first!");
            return;
        }
        temperature = temp;
        System.out.println("Oven preheating to " + temp + "°C...");
    }

    public void setMode(String newMode) {
        mode = newMode;
        System.out.println("Mode set to " + mode);
    }

    public void start() {
        if (mode.equals("off")) {
            System.out.println("Select mode first!");
            return;
        }
        System.out.println("Oven running at " + temperature + "°C (" + mode + " mode)");
    }

    public void stop() {
        mode = "off";
        System.out.println("Oven stopped.");
    }

    public void setDoorOpen(boolean open) {
        doorOpen = open;
    }

    public void checkStatus() {
        System.out.println("--- Oven Status ---");
        System.out.println("Brand: " + brand + " | Model: " + model);
        System.out.println("Temperature: " + temperature + "°C");
        System.out.println("Mode: " + mode);
        System.out.println("Door open: " + (doorOpen ? "Yes" : "No"));
        System.out.println("-------------------");
    }
}
