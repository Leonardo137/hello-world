package org.LabWorks2;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    /*We need not use the volatile keyword, since we have AtomicInteger*/
    public volatile AtomicInteger count = new AtomicInteger(0);
}
