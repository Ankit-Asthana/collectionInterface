package com.clcnIntfc.collectionInterface.itrerable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorLearn {

    public static void main(String[] args) {
        /*
        Used to iterate ove any Collection interface in Java
         */

        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);

        for(int i : intList) {
            System.out.println(i);
        }

        Iterator<Integer> iter = intList.iterator();
        while(iter.hasNext()) {
            System.out.println("Element is iterator is "+iter.next());
        }
    }
}
