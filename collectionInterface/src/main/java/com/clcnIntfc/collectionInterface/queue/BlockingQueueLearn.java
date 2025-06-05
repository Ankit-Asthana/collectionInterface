package com.clcnIntfc.collectionInterface.queue;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueLearn {
    public static void main(String[] args) {
        /*
        In standard queue that we learnt earlier, the operations takes place immediately. It doesn't wait

        Thread safe Queue, waits for queue to become empty/non-empty when insertion/removal done for Exception case like:
            When queue is empty, and you try to remove element, then it waits until an element gets inserted to remove it
            When queue is full, and you insert element, then it waits until an element gets removed to insert your element

        Simplify concurrency producer-consumer problem.
            Producer don't produce until there is space in Queue to hold the produced element in queue
            Consumer don't remove/consume the element until there is an element in the queue

        Blocking Queue methods:
            put -> Blocks if the queue is full until space become available, when you try to add element
            take -> Blocks if the queue is empty until an element become available, when you try to remove element from empty queue
            offer -> Waits for space to become available, up to specified timeout
         */

//        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(5);
//        blockingQueue.put(1);
//        blockingQueue.put(2);
//        blockingQueue.put(3);
//        blockingQueue.put(4);
//        blockingQueue.put(5);
//        blockingQueue.put(6);

//        System.out.println(blockingQueue);


        /*
        Producer consumer
        ArrayBlockingQueue:
            single lock for both enqueue and deque operation
            more threads -> more wait per Producer <-> Consumer == Problem
         */
        BlockingQueue<Integer> prodCons = new ArrayBlockingQueue<>(5);
        Thread producer = new Thread(new Producer(prodCons));
        producer.start();

        Thread consumer = new Thread(new Consumer(prodCons));
        consumer.start();


    }
}

class Producer implements Runnable {

    private BlockingQueue<Integer> blockingQueue;
    private int value = 0;
    public Producer(BlockingQueue<Integer> queue) {
        this.blockingQueue = queue;
    }

    @Override
    public void run() {
        while(true) {
            try {
                blockingQueue.put(value);
                value++;
                System.out.println("Producer produced "+value+ " in the Producer queue");
                Thread.sleep(2000);
            }
            catch (Exception e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {

    private BlockingQueue<Integer> blockingQueue;
    public Consumer(BlockingQueue<Integer> queue) {
        this.blockingQueue = queue;
    }

    @Override
    public void run() {
        while(true) {
            try {
                Integer val = blockingQueue.take();    //it will wait for 2 sec. until producer add some values to the queue
                System.out.println("Consumer consumed value "+val+" from Producer queue");
                Thread.sleep(1000);
            }
            catch (Exception e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}