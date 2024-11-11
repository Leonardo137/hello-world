package org.LabWorks5;

import util.LogLevel;
import util.Logger;

import java.util.LinkedList;

public class EventQueue {
    private LinkedList<Event> queue = new LinkedList<>();
    /*It is easy to input things at end and take out at front*/

    public synchronized int getSize() {
        return queue.size();
    }

    public synchronized void addEvent(Event event) {
        queue.add(event);
        Logger.log("Event "+ event.getType() + " added. Size: "+queue.size());
    }

    /*Each thread will be executing their own task, and we should make it where no other thread will execute before the
    * required thread*/
    /*We also need to account for if the list is empty*/
    /*The problem is also synchronized, since two events may try accessing the elements*/

    public synchronized Event getEventIFType(EventType type) {
        if(queue.isEmpty()) {
            return null;
        }

        if(queue.getFirst().getType() != type) {
            return null;
        }
        Event event = queue.pop();
        Logger.log("Event "+event.getType() + " removed. Size: "+queue.size(), LogLevel.STATUS);
        return event;
    }
}
