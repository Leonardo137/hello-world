package org.LabWorks;

import util.Logger;

public class IncorrectCountTask implements Runnable{
    private int count;
    public IncorrectCountTask(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        Logger.log("Counting...");
        for(int i=0; i<100_000; i++) {
            count++;
        }
        Logger.log("Count done");
    }
}
