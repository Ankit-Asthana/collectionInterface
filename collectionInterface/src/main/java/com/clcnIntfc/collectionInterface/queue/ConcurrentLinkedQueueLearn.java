package com.clcnIntfc.collectionInterface.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueLearn {


    public static void main(String[] args) {

        /*
        Thread safe
        No lock on put() and take() functions of queue, makes it Sync
        Multiple thread can put() and take() from the queue simultaneously

        Uses CAS method, i.e CompareAndSwap method
        What Happened in below code:
            Both producer and producer2 read current tail node → say tail is Node A

            2️⃣ producer prepares new node Node B
            producer2 prepares new node Node C

            3️⃣ Both try to CAS tail.next from null → Node B / Node C (coz we are inserting, and insertion comes from rear)
                👉 Only one thread's CAS succeeds first (say producer → tail.next → Node B)
                👉 The other thread (producer2) sees failure → retries with updated tail.

            4️⃣ Both threads CAS tail pointer itself to point to latest node.
         */
        ConcurrentLinkedQueue<String> taskQueue = new ConcurrentLinkedQueue<>();

        Thread producer = new Thread( () -> {
            try {
                taskQueue.add("Task " +System.currentTimeMillis());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread producer2 = new Thread( () -> {
            try {
//                String task = taskQueue.poll();
//                System.out.println("Processing " +task);
                taskQueue.add("Task " +System.currentTimeMillis());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        producer.start();
        producer2.start();
    }
}
