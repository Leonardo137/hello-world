package org.LabWorks;

import util.Logger;

public class HelloTask implements Runnable {

    @Override
    public void run() {
        Logger.log(" Hello from runnable task");
    }
}
