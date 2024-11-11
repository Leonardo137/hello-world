package org.LabWorks;

import util.Logger;

public class Example4 {
    public static void main(String[] args) throws InterruptedException {
        /* The numbered-papers task from Lecture */
        Logger.log("Main starting...");
        Counter count = new Counter();

        /*The integer we pass gets saved in the thread, incremented and then it ends*/
        /*When you pass an object you pass a reference, so we don't pass an integer but an object*/

        Thread thread1 = new Thread(new CountTask(count));
        Thread thread2 = new Thread(new CountTask(count));
        Thread thread3 = new Thread(new CountTask(count));

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        Logger.log("Count at the end: "+count.count);
    }
}
