package org.LabWorks2;

public class DoubleCounter {
    /*We can make the counters into an object and have the synchronized be implemented in said object*/
    private int count1 = 0;
    private int count2 = 0;

    private Object lock1 = new Object();
    private Object lock2 = new Object();


    //Make a private variable and make functions that modify said variable
    /*public synchronized void incrementC1() {
        count1++;
    }*/

    public void incrementC1() {
        synchronized (lock1) {
            count1++;
        }
    }

    /*public void incrementC1() {
        synchronized (this) {
            count1++;
        }
        //count1++;
    }*/

    public void incrementC2() {
        synchronized (lock2) {
            count2++;
        }
    }

    /*public synchronized void incrementC2() {
        synchronized (this) {
            //this is the instance of the DoubleCounter
            count2++;
        }
    }*/

    public int getCountC1() {
        /*
        * synchronized(lock1) {
        *   
        * }
        * */
        return count1;
    }
    public int getCountC2() {
        return count2;
    }
}
