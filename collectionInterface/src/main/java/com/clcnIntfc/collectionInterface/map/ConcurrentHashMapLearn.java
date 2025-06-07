package com.clcnIntfc.collectionInterface.map;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapLearn {

    public static void main(String[] args) throws InterruptedException {

        /*

        MAP ==> Synchronize == ConcurrentHashMap

        Used to achive concurrency
        It is thread safe, means all the functions are asynchronous. So one thread can access that at a time
        Internally uses Array for storing elements like HashMap

        For Concurrency(updating HashMap from n no. of threads simultaneously), it uses CompareAndSwap method
        CompareAndSwap()
              What happens internally
                    1️⃣ Both threads T1 & T2 hash key 1 → go to bucket i

                    2️⃣ The bucket i is currently empty → table[i] == null

                    3️⃣ Both threads prepare a Node to insert

                    4️⃣ Both try:
                    CAS table[i] from null → Node

                    5️⃣ Only one CAS succeeds → the other thread retries → sees table[i] already filled → updates existing node (with synchronized block for that bucket).
        */
            ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();

            Thread t1 = new Thread(() -> {
                map.put(1, "One");
            });

            Thread t2 = new Thread(() -> {
                map.put(1, "Uno");
            });

            t1.start();
            t2.start();

            t1.join();
            t2.join();

            System.out.println(map);
            System.out.println();

        /*
        ✅ For duplicate key handling it uses:
            hashCode() to find a bucket
            equals() to check for key equality

        In Java 7, the ConcurrentHashMap works as the Segment based locking
        By default the ConcurrentHashMap breaks down into 16 segments of HashMap
        Only the segment being written or readed from is locked

        Java 8 and above, the ConcurrentHashMap, the segmentation process is discarded coz. of maintaining of large segment
        Uses Compare and Swap method, no lock until resizing or collision

        The resizing will not be done like double when the size increases the default size, it will increase as much we put.
         */
        ConcurrentHashMap<Integer, String> cnHsmp = new ConcurrentHashMap<>();
        Thread t3 = new Thread(
                () ->  {
                    for(int i = 0; i < 1000; i++) {
                    cnHsmp.put(i, "Thread1");
                }
        });

        Thread t4 = new Thread(
                () -> {
                    for (int i = 1000; i < 2000; i++) {
                        cnHsmp.put(i, "Thread2");
                    }
                });

        t3.start();
        t4.start();

        try {
            t3.join();
            t4.join();
        }
        catch (Exception e) {
            System.out.println(e.getCause());
        }

        System.out.println("Concurrent HashMap size after concurrent thread operation is " +cnHsmp.size()); //always gives 2000 coz of thread saftey

        /*
        Similarly if we check the HashMap for concurrent update using 2 threads.
        It will not give 2000 size, coz it is not thread safe, all the functions are not synchronized.
        So it may happen that thread t1 is updating and thread t2 runs at that same time but t2 update didn't happen coz t1 was updating
         */

        HashMap<Integer, String> hsmp = new HashMap<>();
        Thread t5 = new Thread(
                () -> {
                    for (int i = 0; i < 1000; i++) {
                        hsmp.put(i, "Thread2");
                    }
                }
        );

        Thread t6 = new Thread(
                () -> {
                    for (int i = 1000; i < 2000; i++) {
                        hsmp.put(i, "Thread2");
                    }
                }
        );

        t5.start();
        t6.start();

        try {
            t5.join();
            t6.join();
        }
        catch (Exception e) {
            System.out.println(e.getCause());
        }

        System.out.println("Hashmap size after concurrent thread operation is " +hsmp.size());
    }
}
