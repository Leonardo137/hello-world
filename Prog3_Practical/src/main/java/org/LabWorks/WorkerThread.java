package org.LabWorks;

import util.Logger;

public class WorkerThread extends Thread{

    //It will never be written to cache, but to the memory which will make it slower
    private volatile boolean running = true;

    @Override
    public void run() {
        Logger.log(" Worker running...");
        while(running) {

            System.out.println("Working...");
        }

        Logger.log(" Worker stopped!");
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
