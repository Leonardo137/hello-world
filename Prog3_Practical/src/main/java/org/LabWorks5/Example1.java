package org.LabWorks5;

import util.LogLevel;
import util.Logger;

public class Example1 {
    public static void main(String[] args) throws InterruptedException {
        Logger.log("Producer-Consumer system");
        long startTime = System.currentTimeMillis();

        EventQueue queue = new EventQueue();
        Storage storage = new Storage();

        EventProducer producer = new EventProducer(queue);

        CreateTicketConsumer createConsumer = new CreateTicketConsumer(queue, storage);
        UseTicketConsumer useConsumer = new UseTicketConsumer(queue, storage);
        ValidateTicketConsumer validateConsumer = new ValidateTicketConsumer(queue, storage);

        createConsumer.start();
        useConsumer.start();
        validateConsumer.start();

        producer.start();
        producer.join();

        while(queue.getSize()>1) {
            Thread.sleep(50);
        }
        long endTime = System.currentTimeMillis();
        Logger.log("Time to complete: "+(endTime - startTime) + "ms", LogLevel.SUCCESS);

        Logger.log("Queue at the end: "+queue.getSize());
    }
    /*To improve the overall time, we can use a list where we store the element after it has been used, in case of
    it being used again. Cache Invalidation, ...
    We can keep some element in the cache in case of it being used again, however have something in database so upon
    turning off the computer, the data isn't deleted.
    By having more workers, we can speed up the work.
    One case to improve as well is by opening up multiple gates i.e. having more queues
    The in-real life problem is that we may receive a Create and then Validate which will be put in different queues.
    However, since validate is faster, it will be executed before create is even performed.
    With locking, even if a thread is reading, we only let one execute. The problem with crashes is that if we have*/
}
