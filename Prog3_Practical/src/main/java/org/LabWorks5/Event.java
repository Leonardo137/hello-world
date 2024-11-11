package org.LabWorks5;

public class Event {
    /*Each event is going to have two things: type and id*/

    private EventType type;
    private int ticketID;

    public Event(EventType type, int ticketID) {
        this.type = type;
        this.ticketID = ticketID;
    }

    public EventType getType() {
        return type;
    }

    public int getTicketID() {
        return ticketID;
    }

    /*By the above point we have created the events*/


}
