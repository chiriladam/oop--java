public class UserAccount {
    private String name;

    public UserAccount(String name) {
        this.name = name;
    }

    public void useOven(SmartOven oven) {
        System.out.println(name + " is using the oven.");
        oven.setMode("bake");
        oven.preheat(180);
        oven.start();
    }
}
