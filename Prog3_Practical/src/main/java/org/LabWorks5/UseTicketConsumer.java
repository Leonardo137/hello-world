package org.LabWorks5;

import util.LogLevel;
import util.Logger;

public class UseTicketConsumer extends Thread{
    /*references*/
    private EventQueue eventQueue;
    private Storage storage;

    public UseTicketConsumer(EventQueue eventQueue, Storage storage) {
        this.eventQueue = eventQueue;
        this.storage = storage;
    }
    @Override
    public void run() {
        Thread.currentThread().setName("UseTicketConsumer");

        while(true) {
            Event eventToHandle = eventQueue.getEventIFType(EventType.UseTicket);

            if(eventToHandle == null) {
                continue;
            }

            if(!storage.containsTicket(eventToHandle.getTicketID())) {
                Logger.log("Ticket invalid!", LogLevel.WARN);
                continue;
            }

            storage.removeTicket(eventToHandle.getTicketID());
        }
    }
}
