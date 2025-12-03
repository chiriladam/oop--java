package task3;

import java.util.ArrayList;
import java.util.List;

/*
 * Assistant holds multiple Display objects and compares them
 * to help the user choose a display.
 */
public class Assistant {

    String assistantName;
    List<Display> assignedDisplays = new ArrayList<>();

    public Assistant(String name) {
        this.assistantName = name;
    }

    // Adds a display to the list
    public void assignDisplay(Display d) {
        assignedDisplays.add(d);
        System.out.println("Assigned: " + d.model);
    }

    /*
     * Compares displays one-by-one in the list.
     * Example: d1 vs d2, then d2 vs d3, etc.
     */
    public void assist() {
        if (assignedDisplays.size() < 2) {
            System.out.println("Need at least 2 displays to compare!");
            return;
        }

        for (int i = 0; i < assignedDisplays.size() - 1; i++) {
            assignedDisplays.get(i).compareWithMonitor(assignedDisplays.get(i + 1));
        }
    }

    // Removes a display from the list and returns it
    public Display buyDisplay(Display d) {
        assignedDisplays.remove(d);
        System.out.println("Bought: " + d.model);
        return d;
    }
}
