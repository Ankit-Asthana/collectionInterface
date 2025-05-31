package com.clcnIntfc.collectionInterface.map;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapLearn {

    public static void main(String[] args) {

        /*
        Used to achive concurrency
        It is thread safe, means all the functions are asynchronous. So one thread can access that at a time

        In Java 7, the ConcurrentHashMap works as the Segment based locking
        By default the ConcurrentHashMap breaks down into 16 segments of HashMap
        Only the segment being written or readed from is locked

        Java 8 and above, the ConcurrentHashMap, the segmentation process is discarded coz. of maintaining of large segment
        Uses Compare and Swap method, no lock until resizing or collision

        The resizing will not be done like double when the size increases the default size, it will increase as much we put.
         */
        ConcurrentHashMap<Integer, String> cnHsmp = new ConcurrentHashMap<>();
        Thread t1 = new Thread(
                () ->  {
                    for(int i = 0; i < 1000; i++) {
                    cnHsmp.put(i, "Thread1");
                }
        });

        Thread t2 = new Thread(
                () -> {
                    for (int i = 1000; i < 2000; i++) {
                        cnHsmp.put(i, "Thread2");
                    }
                });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
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
        Thread t3 = new Thread(
                () -> {
                    for (int i = 0; i < 1000; i++) {
                        hsmp.put(i, "Thread2");
                    }
                }
        );

        Thread t4 = new Thread(
                () -> {
                    for (int i = 1000; i < 2000; i++) {
                        hsmp.put(i, "Thread2");
                    }
                }
        );

        t3.start();
        t4.start();

        try {
            t3.join();
            t4.join();
        }
        catch (Exception e) {
            System.out.println(e.getCause());
        }

        System.out.println("Hashmap size after concurrent thread operation is " +hsmp.size());
    }
}
