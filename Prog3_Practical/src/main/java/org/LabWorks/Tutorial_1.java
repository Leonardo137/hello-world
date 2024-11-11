package org.LabWorks;

import util.LogLevel;
import util.Logger;
public class Tutorial_1 {
    public static void main(String[] args) {
        /* Logger.log(" Hello", LogLevel.STATUS);
        Logger.log(" Hello", LogLevel.WARN);
        Logger.log(" Hello", LogLevel.SUCCESS);
        Logger.log(" Hello", LogLevel.ERROR); */

        Thread myThread = new HelloThread();
        /* Logger.log("Hello from user"); */
        myThread.start();

        Thread threadWithTask = new Thread(new HelloTask());
        threadWithTask.start();
    }
}
