package org.LabWorks5;

import util.LogLevel;
import util.Logger;

public class ValidateTicketConsumer extends Thread {
    /*references*/
    private EventQueue eventQueue;
    private Storage storage;

    public ValidateTicketConsumer(EventQueue eventQueue, Storage storage) {
        this.eventQueue = eventQueue;
        this.storage = storage;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("ValidateTicketConsumer");

        while (true) {
            Event eventToHandle = eventQueue.getEventIFType(EventType.ValidateTicket);

            if (eventToHandle == null) {
                continue;
            }

            if (!storage.containsTicket(eventToHandle.getTicketID())) {
                Logger.log("Ticket invalid!", LogLevel.WARN);
                continue;
            }

            Logger.log("Ticket valid!", LogLevel.SUCCESS);
        }
    }
}
