package org.LabWorks5;

import util.LogLevel;
import util.Logger;

public class CreateTicketConsumer extends Thread{
    /*references*/
    private EventQueue eventQueue;
    private Storage storage;

    public CreateTicketConsumer(EventQueue eventQueue, Storage storage) {
        this.eventQueue = eventQueue;
        this.storage = storage;
    }
    @Override
    public void run() {
        Thread.currentThread().setName("CreateTicketConsumer");

        while(true) {
            Event eventToHandle = eventQueue.getEventIFType(EventType.CreateTicket);

            if(eventToHandle == null) {
                continue;
            }

            if(!storage.containsTicket(eventToHandle.getTicketID())) {
                Logger.log("Ticket already exists!", LogLevel.WARN);
                continue;
            }

            storage.addTicket(eventToHandle.getTicketID());
        }
    }
}
