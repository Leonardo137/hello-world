package org.LabWorks;

import util.Logger;

import java.util.Scanner;

public class Example2 {
    public static void main(String[] args) {
        /*We will make a main thread that will initiate the worker thread and will stop from main thread*/

        Logger.log("Main running thread");

        WorkerThread worker = new WorkerThread();
        worker.start();

        new Scanner(System.in).nextLine();
        Logger.log("Attempting to stop worker!");
        worker.setRunning(false);

        /*volatile - check the memory and input the value*/


    }
}
