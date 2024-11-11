package org.LabWorks5;

import util.LogLevel;
import util.Logger;

import java.util.Random;

public class EventProducer extends Thread {

    /*We need to have reference to Constructor*/

    private EventQueue eventQueue;

    public EventProducer(EventQueue eventQueue) {
        this.eventQueue = eventQueue;
    }

    /*We want to have the integer we create be random so we will bound it*/

    @Override
    public void run() {
        Thread.currentThread().setName("EventProducer");
        Logger.log("Producing work...");
        Random r = new Random();

        for(int i=0; i<1_000; i++) {
            int ticketID = r.nextInt(100);
            EventType[] possibleEvents = EventType.values(); //return EventType[]; can be used for any enum

            int randomEventIndex = r.nextInt(possibleEvents.length);
            EventType randomEventType = possibleEvents[randomEventIndex];

            Event event = new Event(randomEventType, ticketID);
            eventQueue.addEvent(event);
        }
        Logger.log("Work produced!", LogLevel.SUCCESS);
        /*We have a server that is working forever. The problem we might have is that it can stop.*/
    }
}
