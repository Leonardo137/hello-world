package org.LabWorks5;

public class Producer_Consumer {
    /*Producer-Consumer Architecture*/
    /*
    * PRODUCER will produce a bunch of tickets (events) that will be put in queue (first-come, first-served).
    * The first thing that enters the queue will be the first to come out.
    *
    * - CREATE TICKET
    * - VALIDATE TICKET
    * - USE TICKET
    *
    * Producer is a thread in our case, otherwise it would be a web browser.
    * QUEUE: ...[C],[U],[V],[V],[C];
    *
    * The functions will be run by worker-threads (create, validate, use);
    *
    * Create Consumer , Validate Cons. , Use Cons. <- Worker Threads
    *
    * We will store a bunch of numbers in ArrayList;
    *
    * Queue - Class/LinkedList that stores a bunch of things
    *
    *
    * */
}
