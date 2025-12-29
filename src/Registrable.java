public interface Registrable {
    void register(Participant participant);
    void register(Organizer organizer);
    int getRegisteredCount();
}