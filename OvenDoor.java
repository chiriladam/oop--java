public class OvenDoor {
    private boolean open;

    public OvenDoor() {
        open = false;
    }

    public void openDoor() {
        open = true;
        System.out.println("Door opened.");
    }

    public void closeDoor() {
        open = false;
        System.out.println("Door closed.");
    }

    public boolean isOpen() {
        return open;
    }
}
