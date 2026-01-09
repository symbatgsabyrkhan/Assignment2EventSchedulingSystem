# Event Management System

## Project Description
An event management system that allows creating different types of events (concerts, conferences), registering participants and organizers, and managing a list of events.

## Project Structure

### Classes:
- **Person** (abstract class) - base class for people
- **Participant** - event participant class
- **Organizer** - event organizer class
- **Event** - main event class
- **Conference** - conference class (inherits from Event)
- **Concert** - final concert class (inherits from Event)
- **EventManager** - class for managing event lists

### Interfaces:
- **Registrable** - interface for registering participants and organizers

## How to Run

1. Ensure you have Java installed (JDK 8 or higher)
2. Open the project in IntelliJ IDEA
3. Locate the `Main.java` file
4. Right-click on `Main.java` → Run 'Main.main()'
5. Program execution results will appear in the console

## Assignment Requirements Completed

### OOP Concepts:
- ✅ **Inheritance**: Concert and Conference inherit from Event
- ✅ **Encapsulation**: All fields are private with getter/setter methods
- ✅ **Polymorphism**: displayType() method is overridden in subclasses
- ✅ **Abstraction**: Abstract Person class with abstract getRole() method

### Additional Features:
- ✅ Registrable interface with registration methods
- ✅ equals() and hashCode() methods overridden
- ✅ toString() method overridden
- ✅ Final class usage (Concert)
- ✅ Final method usage (displayConferenceInfo)
- ✅ Event sorting by capacity
- ✅ Small events filtering (capacity <= 150)

## Usage Examples

### Creating an Event:
```java
Event event = new Event("Kairat Nurtas concert", "2025-30-12", 200);
```

### Registering a Participant:
```java
Participant participant = new Participant("Symbat", "symbat0408@icloud.com");
event.register(participant);
```

### Creating a Specialized Event:
```java
Conference conference = new Conference("AI Conference", "2025-14-12", 300);
conference.displayType(); // Output: "Conference Event"
```

## Output Example
```
All Events:
Event{name='Expo Exhibition', date='2025-25-12', capacity=100}
Event{name='Kairat Nurtas concert', date='2025-30-12', capacity=200}
Event{name='Opera Concert', date='2025-29-12', capacity=250}

Small Events:
Event{name='Expo Exhibition', date='2025-25-12', capacity=100}

Participant Information:
Participant{name='Symbat', email='symbat0408@icloud.com'}
Role: Participant

Organizer Information:
Organizer{name='Asel', location='Astana'}
Role: Organizer
```

## Author
Group: SE-2507
Date: January 2026