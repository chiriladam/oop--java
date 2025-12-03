package task1;

/*
 * Task 1 runner.
 * Creates 3 Display objects and compares them using class methods.
 */
public class Main {
    public static void main(String[] args) {

        Display d1 = new Display(1920, 1080, 90, "Monitor A");
        Display d2 = new Display(2560, 1440, 110, "Monitor B");
        Display d3 = new Display(3840, 2160, 140, "Monitor C");

        // perform comparisons
        d1.compareWithMonitor(d2);
        d2.compareWithMonitor(d3);
        d1.compareWithMonitor(d3);
    }
}
