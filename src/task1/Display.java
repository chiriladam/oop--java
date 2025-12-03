package task1;

/*
 * The Display class represents a monitor with width, height, ppi, and model name.
 * It includes comparison methods to compare two Display objects.
 */

public class Display {
    int width;
    int height;
    float ppi;
    String model;

    // Constructor to set basic attributes
    public Display(int width, int height, float ppi, String model) {
        this.width = width;
        this.height = height;
        this.ppi = ppi;
        this.model = model;
    }

    // Compare the screen area (width * height) between two displays
    public void compareSize(Display m) {
        int thisSize = width * height;
        int otherSize = m.width * m.height;

        if (thisSize > otherSize)
            System.out.println(model + " is bigger than " + m.model);
        else if (thisSize < otherSize)
            System.out.println(model + " is smaller than " + m.model);
        else
            System.out.println(model + " and " + m.model + " are the same size.");
    }

    // Compare the sharpness (ppi) between two displays
    public void compareSharpness(Display m) {
        if (ppi > m.ppi)
            System.out.println(model + " is sharper than " + m.model);
        else if (ppi < m.ppi)
            System.out.println(model + " is less sharp than " + m.model);
        else
            System.out.println(model + " and " + m.model + " have equal sharpness.");
    }

    // Compare both size and sharpness at once
    public void compareWithMonitor(Display m) {
        System.out.println("=== Comparing " + model + " vs " + m.model + " ===");
        compareSize(m);
        compareSharpness(m);
        System.out.println();
    }
}
