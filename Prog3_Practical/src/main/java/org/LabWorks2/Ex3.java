package org.LabWorks2;

import util.LogLevel;
import util.Logger;

public class Ex3 {
    public enum CounterSelector {
        FIRST,
        SECOND
    }

    public static void main(String[] args) throws InterruptedException {
        Logger.log("Example 3");

        mtIncrement();

        mtIncrementBoth();

        incrementSingle();

        Logger.log("Done", LogLevel.SUCCESS);
    }

    public static void incrementSingle() {
        Logger.log("Incrementing single thread...");
        long start = System.nanoTime();
        int count = 0;

        for(int i=0; i<300_000; i++){
            count++;
        }

        long end = System.nanoTime();
        Logger.log("Single Thread Time: "+(end-start)+"ns");
        Logger.log("Done", LogLevel.SUCCESS);
    }

    public static void mtIncrement() throws InterruptedException {
        Logger.log("Incrementing C1");

        long start = System.currentTimeMillis();

        DoubleCounter counter = new DoubleCounter();

        Thread t1 = new Thread(new DoubleCountingTask(counter, CounterSelector.FIRST));
        Thread t2 = new Thread(new DoubleCountingTask(counter, CounterSelector.FIRST));
        Thread t3 = new Thread(new DoubleCountingTask(counter, CounterSelector.FIRST));

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        long end = System.currentTimeMillis();

        Logger.log("Time: "+(end-start) + "ms", LogLevel.STATUS);

        Logger.log("Count1: "+counter.getCountC1(), LogLevel.SUCCESS);
    }

    public static void mtIncrementBoth() throws InterruptedException {
        //The reason why we get 69ms instead of at most 30ms,
        Logger.log("Incrementing Both: ");

        long start = System.currentTimeMillis();

        DoubleCounter counter = new DoubleCounter();

        Thread t1 = new Thread(new DoubleCountingTask(counter, CounterSelector.FIRST));
        Thread t2 = new Thread(new DoubleCountingTask(counter, CounterSelector.FIRST));
        Thread t3 = new Thread(new DoubleCountingTask(counter, CounterSelector.FIRST));

        Thread t4 = new Thread(new DoubleCountingTask(counter, CounterSelector.SECOND));
        Thread t5 = new Thread(new DoubleCountingTask(counter, CounterSelector.SECOND));
        Thread t6 = new Thread(new DoubleCountingTask(counter, CounterSelector.SECOND));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();
        t6.join();

        long end = System.currentTimeMillis();

        Logger.log("Time: "+(end-start) + "ms", LogLevel.STATUS);

        Logger.log("Count1: "+counter.getCountC1(), LogLevel.SUCCESS);
        Logger.log("Count1: "+counter.getCountC2(), LogLevel.SUCCESS);
    }
}
