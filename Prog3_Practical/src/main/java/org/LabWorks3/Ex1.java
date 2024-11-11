package org.LabWorks3;

/* P = A(circle)/A(square) = Пr^2/a^2 = П*1^2/2^2 = П/4 */
/*What is the formula of the tickets that are winning?
 * P = Hits(correct tickets)/TOTAL
 * Monte-Carlo Algorithms <- We don't really care for the perfect result, we just want a close-enough result
 * P = NP
 *
 * Hits/TOTAL = П/4
 * Hits * 4 = П * TOTAL
 * П = 4*HITS/TOTAL
 * */

import util.LogLevel;
import util.Logger;

import java.awt.*;
import java.util.Random;

public class Ex1 {

    public static final int NUM_OF_THREADS = 30;
    /*Even if we increase the number of threads, there is only so much we can accomplish.
    * Aside from that, the thread-creation process takes time as well.*/

    public static void main(String[] args) throws InterruptedException {
        /*Gui is very slow hence we have a huge total*/
        GUI gui = new GUI();

        /*Every thread works on a copy with primitive types*/
        /*int hits = 0;
        int total = 0;*/

        Counter counter = new Counter();

        long start = System.currentTimeMillis();
        long endTime = start + 1000;

        Thread[] threads = new Thread[NUM_OF_THREADS];

        for(int i=0; i< threads.length; i++) {
            threads[i] = new Thread(new ThrowingTask(gui, counter, endTime));
        }

        for(Thread t : threads) {
            t.start();
        }

        for(Thread t : threads) {
            t.join();
        }
        //Thread t1 = new Thread(new ThrowingTask(gui, /*hits, total,*/ counter, endTime));
        //Thread t2 = new Thread(new ThrowingTask(gui, /*hits, total,*/ counter, endTime));
        /*t1.start();
        t2.start();

        t1.join();
        t2.join();*/

        gui.close();

        int hits = counter.getHits();
        int total = counter.getTotal();
        double calculatedPI = 4. * hits / total;
        Logger.log("Calculated Pi: "+calculatedPI);
        Logger.log("Error: "+(calculatedPI-Math.PI), LogLevel.ERROR);
        Logger.log("Total: "+String.format("%,d", total));

        /*System.out.println(rnd.nextInt());*/
        /*
        Random rnd = new Random();
        while(System.currentTimeMillis() < endTime)
        while (hits < 100){
            float x = rnd.nextFloat() * 2 - 1; Instead of (0,1) we get a range of (0,2) and then (-1,1)
            float y = rnd.nextFloat() * 2 - 1;

            How do we know if a point is in a circle? Pythagorean Theorem
            In a circle, if the point is greater than 1, then it is not in the circle, otherwise it is

            double xSquared = Math.pow(x,2);
            double ySquared = Math.pow(y,2);

            double distFromCenter = Math.sqrt(xSquared + ySquared);

            Color pointColor = Color.BLACK;
            if(distFromCenter <= 1) {
                pointColor = Color.CYAN;
                hits++;
            }
            total++;

            gui.drawPoint(x, y, pointColor);
        }

        double calculatedPI = 4. * hits / total; the dot is important for double
        Logger.log("Calculated Pi: "+calculatedPI);
        Logger.log("Error: "+(calculatedPI-Math.PI), LogLevel.ERROR);
        Logger.log("Total: "+total);
        gui.close(); */

        /*To get the same random points as with someoone else we can use something called a seed*/

        /*The problem is the CPU time, i.e. how much a CPU spends time on a certain tasks*/

        /*the dot is important for double*/
    }
}
