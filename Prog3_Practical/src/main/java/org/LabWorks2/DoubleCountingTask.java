package org.LabWorks2;

import util.LogLevel;
import util.Logger;

public class DoubleCountingTask implements Runnable{
    private DoubleCounter counter;
    private Ex3.CounterSelector selector;

    public DoubleCountingTask(DoubleCounter counter, Ex3.CounterSelector selector) {
        this.counter = counter;
        this.selector = selector;
    }

    @Override
    public void run() {
        Logger.log("Incrementing...");

        for(int i=0; i<100_000; i++) {
            if(selector == Ex3.CounterSelector.FIRST) {
                counter.incrementC1();
            }
            if(selector == Ex3.CounterSelector.SECOND) {
                counter.incrementC2();
            }


        }

        Logger.log("Done", LogLevel.SUCCESS);
    }
}

//Website Scraper - takes data from other websites