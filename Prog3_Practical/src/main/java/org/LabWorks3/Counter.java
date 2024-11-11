package org.LabWorks3;

public class Counter {
    private int hits = 0;
    private int total = 0;

    public synchronized void addToHits(int hits) {
        this.hits += hits;
    }

    public synchronized void addToTotal(int total) {
        this.total += total;
    }

    public int getHits() {
        return hits;
    }

    public int getTotal() {
        return total;
    }
}
