package com.clcnIntfc.collectionInterface.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class SyncronousBlockingQueueLearn {
    public static void main(String[] args) {
        /*
        At most, one element can be in the queue
        Once inserted, then you can't insert until the previous one is consumed
         */

        BlockingQueue<String> syncBlockQueue = new SynchronousQueue<>();

        Thread producer = new Thread(() -> {
            try {
                System.out.println("Producer is waiting to transfer");
                syncBlockQueue.put("Hello from Producer");
                System.out.println("Producer transferred message");
            }
            catch (Exception e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                System.out.println("Consumer is waiting to receive");
                syncBlockQueue.take();
                System.out.println("Consumer receives Hello from Producer");
            }
            catch (Exception e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();
    }
}
