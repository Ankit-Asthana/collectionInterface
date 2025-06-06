package com.clcnIntfc.collectionInterface.queue;

import java.util.Comparator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueLearn {
    public static void main(String[] args) throws InterruptedException {
        /*
        A blocking queue with priority defined.
        So we can consume elements according to the priority
        Binary Heap as array
        Default size is 11 and grows dynamically, so there will be no wait time for put().
        That makes it Unbounded, and put won't block
        Head element will be based on the natural ordering or the Comparator provided
         */

        BlockingQueue<Integer> priorityBlockingQueue = new PriorityBlockingQueue<>(11, Comparator.reverseOrder());
        priorityBlockingQueue.put(12);
        priorityBlockingQueue.put(10);
        priorityBlockingQueue.put(25);

        for(int i : priorityBlockingQueue){
            System.out.println("Head element = "+priorityBlockingQueue.remove());  //removing head to find the order in which elements are getting placed on head
        }
    }
}
