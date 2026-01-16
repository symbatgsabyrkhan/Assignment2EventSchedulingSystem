package objects;

public class Conference extends Event {
    public Conference(String name, String date, int capacity) {
        super(name, date, capacity);
    }

    @Override
    public void displayType() {
        System.out.println("objects.Conference objects.Event");
    }

    public final void displayConferenceInfo() {
        System.out.println("This is a conference event with capacity: " + getCapacity());
    }
}