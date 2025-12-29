import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Event event1 = new Event("Kairat Nurtas concert", "2025-30-12", 200);
        Event event2 = new Event("Opera Concert", "2025-29-12", 250);
        Event event3 = new Event("Expo Exhibition", "2025-25-12", 100);

        List<Event> events = new ArrayList<>();
        events.add(event1);
        events.add(event2);
        events.add(event3);

        for (int i = 0; i < events.size() - 1; i++) {
            for (int j = i + 1; j < events.size(); j++) {
                if (events.get(i).getCapacity() > events.get(j).getCapacity()) {
                    Event temp = events.get(i);
                    events.set(i, events.get(j));
                    events.set(j, temp);
                }
            }
        }

        List<Event> smallEvents = new ArrayList<>();
        for (Event event : events) {
            if (event.getCapacity() <= 150) {
                smallEvents.add(event);
            }
        }

        System.out.println("All Events:");
        for (Event event : events) {
            System.out.println(event);
        }

        System.out.println("\nSmall Events:");
        for (Event event : smallEvents) {
            System.out.println(event);
        }

        Participant participant1 = new Participant("Symbat", "symbat0408@icloud.com");
        Organizer organizer1 = new Organizer("Asel", "Astana");

        System.out.println("\nParticipant Information:");
        System.out.println(participant1);
        System.out.println("Role: " + participant1.getRole());

        System.out.println("\nOrganizer Information:");
        System.out.println(organizer1);
        System.out.println("Role: " + organizer1.getRole());

        Conference conference = new Conference("AI Conference", "2025-14-12", 300);
        Concert concert = new Concert("Jazz Concert", "2026-02-01", 500);

        System.out.println("\nEvent Types:");
        conference.displayType();
        concert.displayType();

        System.out.println("\nComparing Events:");
        System.out.println(event1.equals(event2));
        System.out.println(event1.equals(event3));

        EventManager manager = new EventManager();
        manager.addEvent(event1);
        manager.addEvent(event2);
        manager.addEvent(conference);

        System.out.println("\nEvent Manager:");
        manager.displayAllEvents();

        System.out.println("\nRegistration Demo:");
        event1.register(participant1);
        event1.register(organizer1);
        System.out.println("Total registered for " + event1.getName() + ": " + event1.getRegisteredCount());

        System.out.println("\nConference Info:");
        conference.displayConferenceInfo();
    }
}