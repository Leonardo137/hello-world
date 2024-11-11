package org.LabWorks3;

import org.LabWorks2.CountingTask;
import util.LogLevel;
import util.Logger;

import java.awt.*;
import java.util.Random;

public class ThrowingTask implements Runnable{
    private GUI gui;
    /*private int hits;
    private int total;*/
    private long endTime;
    private Counter counter;

    public ThrowingTask(GUI gui, /*int hits, int total,*/Counter counter , long endTime) {
        this.gui = gui;
        /*this.hits = hits;
        this.total = total;*/
        this.endTime = endTime;
        this.counter = counter;
    }

    @Override
    public void run() {
        int hits = 0;
        int total = 0;
        Random rnd = new Random(42);
        while(System.currentTimeMillis() < endTime)
        /*while (hits < 100)*/{
            float x = rnd.nextFloat() * 2 - 1; /*Instead of (0,1) we get a range of (0,2) and then (-1,1)*/
            float y = rnd.nextFloat() * 2 - 1;

            /*How do we know if a point is in a circle? Pythagorean Theorem
             * In a circle, if the point is greater than 1, then it is not in the circle, otherwise it is*/

            double xSquared = Math.pow(x,2);
            double ySquared = Math.pow(y,2);

            /*if the sum is bigger, the distance will be bigger and vice versa*/
            /*double distFromCenter = Math.sqrt(xSquared + ySquared);*/
            double distFromCenter = xSquared + ySquared;

            Color pointColor = Color.BLACK;
            if(distFromCenter <= 1) {
                pointColor = Color.CYAN;
                hits++;
            }
            total++;

            gui.drawPoint(x, y, pointColor);
        }

        counter.addToHits(hits);
        counter.addToTotal(total);
    }
}
