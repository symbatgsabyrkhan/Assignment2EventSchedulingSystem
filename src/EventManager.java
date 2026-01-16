package objects;

import java.util.ArrayList;
import java.util.List;

public class EventManager {
    private List<Event> events = new ArrayList<>();

    public void addEvent(Event event) {
        events.add(event);
    }

    public void displayAllEvents() {
        for (Event event : events) {
            System.out.println(event);
        }
    }
}