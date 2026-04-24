package model;

public class Participant {

    private int id;
    private String name;
    private int eventId;

    public Participant() {}

    public Participant(String name, int eventId) {
        this.name = name;
        this.eventId = eventId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getEventId() {
        return eventId;
    }
}