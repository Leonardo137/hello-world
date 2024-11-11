package org.LabWorks;

import util.Logger;

public class CountTask implements Runnable{
    private volatile Counter counter;
    public CountTask(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        Logger.log("Counting...");
        for(int i=0; i<100_000; i++) {
            counter.count++;
        }
        Logger.log("Count done");
    }
}