package com.clcnIntfc.collectionInterface.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueLearn {
    public static void main(String[] args) throws InterruptedException {

        /*
        Used when a lot of Threads are being used for producer consumer like problems
        It used two separate locks for enqueue and deque
        Higher concurrency between producer and consumer
         */
        BlockingQueue<Integer> linkedBlockingQueue = new LinkedBlockingQueue<>();
        linkedBlockingQueue.put(1);
    }
}
