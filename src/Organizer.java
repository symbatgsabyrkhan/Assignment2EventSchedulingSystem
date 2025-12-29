import java.util.Objects;

public class Organizer extends Person {
    private String location;

    public Organizer(String name, String location) {
        super(name);
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    String getRole() {
        return "Organizer";
    }

    @Override
    public String toString() {
        return "Organizer{name='" + getName() + "', location='" + location + "'}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Organizer organizer = (Organizer) obj;
        return getName().equals(organizer.getName()) && location.equals(organizer.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), location);
    }
}