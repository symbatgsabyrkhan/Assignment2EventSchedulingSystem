public class Concert extends Event {
    public Concert(String name, String date, int capacity) {
        super(name, date, capacity);
    }

    @Override
    public void displayType() {
        System.out.println("Concert Event");
    }
}