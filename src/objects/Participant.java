package objects;

import java.util.Objects;

public class Participant extends Person {
    private String email;

    public Participant(String name, String email) {
        super(name);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getRole() {
        return "objects.Participant";
    }

    @Override
    public String toString() {
        return "objects.Participant{name='" + getName() + "', email='" + email + "'}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Participant participant = (Participant) obj;
        return getName().equals(participant.getName()) && email.equals(participant.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), email);
    }
}