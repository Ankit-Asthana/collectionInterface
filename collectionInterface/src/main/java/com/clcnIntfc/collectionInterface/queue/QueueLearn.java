package com.clcnIntfc.collectionInterface.queue;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueLearn {
    /*
    Queue is an interface in Java so we can't implement it. We should implement its implementation class.
    Implementation classes
        1. LinkedList
        2. PriorityQueue
        3. BlockingQueue
        4. ArrayBlockingQueue

     offer(E e), poll(E e) and peek() will not give Exception, they will return null if not worked

    A data structure that runs on First in First out principle
    Basic Functionality
        Enqueue - Add element at end                  fn ->  (add(), offer())
        Dequeue - Remove element from head            fn ->  (remove(), poll())
        Peek - To see the element at head             fn ->  (peek(), element())
     */

    public static void main(String[] args) {
        Queue<Integer> integerQueue = new LinkedList<>();

        //For adding element in Queue
//        System.out.println(integerQueue.remove());         //throw the exception, if queue is Empty
        System.out.println(integerQueue.poll());           //returns null if Queue is empty

        //For removing finding the element at head of queue
//        System.out.println(integerQueue.element());      //throw exception, if Queue is empty
        System.out.println(integerQueue.peek());         // returns null if Queue is empty


        Queue<Integer> blockingQueue = new ArrayBlockingQueue<>(2);  //fixed the capacity 2
        blockingQueue.add(1);
        blockingQueue.offer(2);

//        blockingQueue.add(3);               //throws exception if queue is full
        blockingQueue.offer(3);

    }

}
