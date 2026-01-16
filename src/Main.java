package main;

import database.EventDAO;
import database.LocationDAO;
import database.PersonDAO;
import objects.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EventDAO eventDao = new EventDAO();
        LocationDAO locDao = new LocationDAO();
        PersonDAO personDao = new PersonDAO();

        eventDao.save(new Event("Kairat Nurtas concert", "2025-30-12", 200));
        eventDao.save(new Event("Opera Concert", "2025-29-12", 250));
        eventDao.save(new Event("Expo Exhibition", "2025-25-12", 100));
        eventDao.save(new Conference("AI Conference", "2025-14-12", 300));

        personDao.savePerson(new Participant("Symbat", "symbat0408@icloud.com"), "symbat0408@icloud.com");
        personDao.savePerson(new Organizer("Asel", "Astana"), "Astana");
        locDao.insert("Astana", "Mangilik El 55");

        List<Event> events = eventDao.getAll();
        Participant kairatParticipant = personDao.getParticipantByName("Symbat");
        Organizer aselOrganizer = personDao.getOrganizerByName("Asel");
        Conference aiConference = eventDao.getEventByName("AI Conference");

        for (int i = 0; i < events.size() - 1; i++) {
            for (int j = i + 1; j < events.size(); j++) {
                if (events.get(i).getCapacity() > events.get(j).getCapacity()) {
                    Event temp = events.get(i);
                    events.set(i, events.get(j));
                    events.set(j, temp);
                }
            }
        }

        System.out.println("--- All Events from DB ---");
        events.forEach(System.out::println);

        System.out.println("\n--- Participant Info from DB ---");
        if (kairatParticipant != null) {
            System.out.println(kairatParticipant);
            System.out.println("Role: " + kairatParticipant.getRole());
        }

        System.out.println("\n--- Organizer Info from DB ---");
        if (aselOrganizer != null) {
            System.out.println(aselOrganizer);
            System.out.println("Role: " + aselOrganizer.getRole());
        }

        System.out.println("\n--- Conference Info from DB ---");
        if (aiConference != null) {
            aiConference.displayType();
            aiConference.displayConferenceInfo();
        }

        eventDao.update("Kairat Nurtas concert", 600);

        System.out.println("\n--- Deleting Opera Concert ---");
        eventDao.deleteEvent("Opera Concert");

        System.out.println("\n--- Final DB State after Update and Delete ---");
        eventDao.getAll().forEach(System.out::println);
    }
}