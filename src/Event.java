import java.util.Objects;
import java.util.ArrayList;
import java.util.List;

public class Event implements Registrable {
    private String name;
    private String date;
    private int capacity;
    private List<Person> registeredPeople;

    public Event(String name, String date, int capacity) {
        this.name = name;
        this.date = date;
        this.capacity = capacity;
        this.registeredPeople = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public void register(Participant participant) {
        registeredPeople.add(participant);
        System.out.println(participant.getName() + " registered as participant");
    }

    @Override
    public void register(Organizer organizer) {
        registeredPeople.add(organizer);
        System.out.println(organizer.getName() + " registered as organizer");
    }

    @Override
    public int getRegisteredCount() {
        return registeredPeople.size();
    }

    @Override
    public String toString() {
        return "Event{name='" + name + "', date='" + date + "', capacity=" + capacity + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Event event = (Event) obj;
        return capacity == event.capacity && name.equals(event.name) && date.equals(event.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, date, capacity);
    }

    public void displayType() {
        System.out.println("Generic Event");
    }
}
