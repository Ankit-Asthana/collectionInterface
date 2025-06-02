package com.clcnIntfc.collectionInterface.set;

import java.util.HashSet;
import java.util.Set;

public class SetLearn {
    /*
    A collection that doesn't contain duplicate elements
    Like the implementation classes that we learnt in the HashMap it also has the same classes
    It internally uses Arrays to store elements

    For not letting duplicate entry, set uses hashcode() and equals()
    Calls hashCode() to find the bucket
    If bucket has items, checks equals() to ensure uniqueness if new element is unique, then only entry is allowed

    MAP -> HashMap -> LinkedHashMap -> TreeMap -> ConcurrentHashMap -> ConcurrentSkipListMap
    SET -> HashSet -> LikedHashSet -> TreeSet -> ConcurrentHashSet -> ConcurrentSkipListSet

    The implementation and the logic are also same for the SET as the MAP, like
        LinkedHashSet - To maintain the insertion order
        TreeSet -> To maintain the sorting order based on keys
        ConcurrentHashSet -> To maintain thread safety and make it synchronized
        ConcurrentSkipListSet -> To maintain the thread safety along with sorting (Combo of TreeSet and ConcurrentHashSet)
                                 We can call it Synchronized TreeSet

        So we can use the correct implementation of SET as per our need
     */
    public static void main(String[] args) {
        Set<Integer> myset = new HashSet<>();
        myset.add(1);
        myset.add(2);
        myset.add(5);
        myset.add(56);
        myset.add(7);
        myset.add(7);  // doesn't add to the set

        System.out.println(myset.contains(56));
        System.out.println(myset.contains(15)); //returns false
        System.out.println(myset.remove(25)); //false, coz no element valued 25

        System.out.println(myset);

        for(int i : myset) {
            System.out.println(i);
        }
    }

}
