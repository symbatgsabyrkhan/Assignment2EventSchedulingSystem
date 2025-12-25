public class Conference extends Event {
    public Conference(String name, String date, int capacity) {
        super(name, date, capacity);
    }

    @Override
    public void displayType() {
        System.out.println("Conference Event");
    }
}