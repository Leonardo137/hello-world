package org.LabWorks2;

import util.LogLevel;
import util.Logger;

public class Ex2 {
    public static void main(String[] args) throws InterruptedException {
        Logger.log("Example 2");

        SynchronizedCounter counter = new SynchronizedCounter();

        Thread t1 = new Thread(new SynchronizedCountingTask(counter));
        Thread t2 = new Thread(new SynchronizedCountingTask(counter));
        Thread t3 = new Thread(new SynchronizedCountingTask(counter));

        t1.start();
        t2.start();
        t3.start();

        //main thread will wait until t1 does execution
        t1.join();
        t2.join();
        t3.join();

        Logger.log("Final count: "+counter.getCount());
        Logger.log("Done", LogLevel.SUCCESS);
    }
}

/*
* We will be using a concept called Locks
* Take for example T1 reads, so the lock which was previously unlocked will be locked
* Hence no other thread will execute any of their three main functions (Read, Inc, Write) until T1 finishes and
* unlocks the lock.
* */
