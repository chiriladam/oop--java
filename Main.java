public class Main {
    public static void main(String[] args) {
        OvenDoor door = new OvenDoor();
        SmartOven oven = new SmartOven("Bosch", "X200");
        UserAccount user = new UserAccount("Alice");

        door.closeDoor();
        oven.setDoorOpen(door.isOpen());

        user.useOven(oven);
        oven.checkStatus();
        oven.stop();
    }
}
