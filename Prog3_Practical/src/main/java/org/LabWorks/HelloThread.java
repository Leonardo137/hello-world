package org.LabWorks;

import util.Logger;

public class HelloThread extends Thread{
    public void run(){
        Logger.log(" Hello from thread");
    }
}
