import java.util.Objects;

public class Organizer {
    private String name;
    private String location;

    public Organizer(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Organizer{name='" + name + "', location='" + location + "'}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Organizer organizer = (Organizer) obj;
        return name.equals(organizer.name) && location.equals(organizer.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }
}