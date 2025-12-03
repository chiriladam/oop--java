package task3;

/*
 * Task 3 runner.
 * Demonstrates Assistant class behavior with a list of Displays.
 */
public class Main {
    public static void main(String[] args) {
        Assistant a = new Assistant("John");

        // Create some displays
        Display d1 = new Display(1920, 1080, 90, "Monitor A");
        Display d2 = new Display(2560, 1440, 110, "Monitor B");
        Display d3 = new Display(3840, 2160, 140, "Monitor C");

        // Assign displays
        a.assignDisplay(d1);
        a.assignDisplay(d2);
        a.assignDisplay(d3);

        // Automatic comparisons
        a.assist();

        // Buy one
        a.buyDisplay(d2);
    }
}
