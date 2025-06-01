package com.clcnIntfc.collectionInterface.map;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentSkipListMapLearn {

    public static void main(String[] args) {
        /*

        MAP ==> Synchronized ==> Sorted  == ConcurrentSkipListMap (ThreadSafe TreeMap)

        Uses SkipList for storing the Entries basis of keys

        Used when you want synchronized Map with sorted order

    SkipList working:
        Data should be Sorted
        Works as a multiple layer LinkedList, for fast access
        Suppose we have an Array of items like, arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}
        So it converts them in multiple layer of LinkedList and skip some elements in each layer
            Layer 2 -> { 1 ........ 5 ......... 9 }       -> Skipped 3 elements
            Layer 1 -> { 1 .. 3 .. 5 .. 7 .. 9 }          -> Skipped 1 element
            Layer 0 -> { 1, 2, 3, 4, 5, 6, 7, 8, 9 }      -> All elements

        It is faster coz.there is no or minimal need of adding newly inserted elements to each layer, will add to the lower level first
        Probability of adding newly inserted element to upper layer is 50%
         */

        ConcurrentSkipListMap<Integer, String> cnSkpLstMap = new ConcurrentSkipListMap<>((a, b) -> b - a);  //descending order sorting on Keys
        cnSkpLstMap.put(1, "One");
        cnSkpLstMap.put(5, "Five");
        cnSkpLstMap.put(2, "Two");

        Set<Map.Entry<Integer, String>> entries = cnSkpLstMap.entrySet();
        for(Map.Entry<Integer, String> entry : entries) {
            System.out.println(entry.getKey() +" -=> "+ entry.getValue());
        }

        Thread cnTh1 = new Thread(
                () -> {
                    for (int i =0; i < 1000; i++) {
                        cnSkpLstMap.put(i, "CncSkpLst1");
                    }
                }
        );

        Thread cnTh2 = new Thread(
                () -> {
                    for (int i =1000; i < 2000; i++) {
                        cnSkpLstMap.put(i, "CncSkpLst2");
                    }
                }
        );

        cnTh1.start();
        cnTh2.start();

        try {
            cnTh1.join();
            cnTh2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Set<Map.Entry<Integer, String>> entriess = cnSkpLstMap.entrySet();
        for(Map.Entry<Integer, String> entry : entriess) {
            System.out.println(entry.getKey() +" -=> "+ entry.getValue());
        }

        System.out.println("Size of ConcurrentSkipListMap after sync is "+cnSkpLstMap.size());

    }
}
