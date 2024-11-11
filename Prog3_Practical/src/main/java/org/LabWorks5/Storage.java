package org.LabWorks5;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/*Whatever you are accessing for multiple threads, you need to be careful since there is a chance the program may crash*/
public class Storage {
    private ArrayList<Integer> tickets = new ArrayList<>();
    private ReadWriteLock rwLock = new ReentrantReadWriteLock();
    /*As soon as somebody starts writing, nobody can read for upper lock*/
    private Lock readLock = rwLock.readLock();
    private Lock writeLock = rwLock.writeLock();

    /*ArrayList - mix of Arrays and Lists; the problem with Arrays is when we delete an element, we need to move the
    elements to fit the array; the ArrayList has any and every function in terms of arrays
    Instead of Arr[i], we have Arr.get(i);*/

    public void addTicket(int ticketID) {
        writeLock.lock();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        tickets.add(ticketID);
        writeLock.unlock();
    }

    public void removeTicket(int ticketID) {
        /*When we delete we need to be careful of the index the element is on*/
        writeLock.lock();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int index = tickets.indexOf(ticketID);
        tickets.remove(index);
        writeLock.unlock();
    }

    public boolean containsTicket(int ticketID) {
        readLock.lock();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        boolean contains = tickets.contains(ticketID);
        readLock.unlock();
        return contains;
    }

    /*The storage unit should be a database*/
    /*The time we received when implementing ReadWriteLock is about 5.5 seconds, in comparison to 10 seconds*/

}
