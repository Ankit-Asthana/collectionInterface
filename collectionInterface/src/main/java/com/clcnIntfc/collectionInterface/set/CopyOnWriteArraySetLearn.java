package com.clcnIntfc.collectionInterface.set;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArraySetLearn {
    public static void main(String[] args) {
        /*
        Used to make the set synchronized. (Thread safe)
        Maintains Insertion order
        For every insertion it:
        Creates a new copy of the underlying array.
        Adds the new element to that copy.
        Replaces the reference to the old array with the new one.

        Use when Read more, write Less
         */

        CopyOnWriteArraySet<Integer> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        copyOnWriteArraySet.add(1);
        copyOnWriteArraySet.add(4);

        for(int i : copyOnWriteArraySet)
        {
            copyOnWriteArraySet.add(3);  // Attempting to add inside iteration,  but won't be added (Consistency)
            System.out.println(i);
        }

        System.out.println(copyOnWriteArraySet);  // 3 was added
        System.out.println();

        /*
        Explanation, why 3 didn't get added in the set while iteration:

        Why does this happen?
            CopyOnWriteArraySet is backed by a CopyOnWriteArrayList internally.
            When you modify the set (add or remove), it copies the entire underlying array and applies the change.
            Iterators hold a reference to the old immutable snapshot, so they never see concurrent modifications.
            This makes iteration thread-safe without locking, but at the cost of higher memory and copy overhead during writes.
         */




        ConcurrentSkipListSet<Integer> concurrentSkipListSet = new ConcurrentSkipListSet<>();
        concurrentSkipListSet.add(1);
        concurrentSkipListSet.add(9);

        for(int i : concurrentSkipListSet) {
            concurrentSkipListSet.add(12);        // Attempting to add inside iteration, inserted and cause Inconsistency, sometimes it will not add, sometimes it will add
            System.out.println(i);
        }

    }
}
