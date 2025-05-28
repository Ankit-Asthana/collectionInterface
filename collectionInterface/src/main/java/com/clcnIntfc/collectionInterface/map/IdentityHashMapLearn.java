package com.clcnIntfc.collectionInterface.map;

import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHashMapLearn {

    /*
    Same Key multiple entries
     */

    public static void main(String[] args) {
        IdentityHashMap<String, Integer> idHsmp = new IdentityHashMap<>();
        idHsmp.put(new String("Abc"), 1);
        idHsmp.put(new String("Abc"), 2);
        idHsmp.put(new String("Abc"), 3);

        //here 3 entries will be put coz. of the memory reference of the key, not the values of keys.
        //coz the memory address of every new String("Abc") will be different. so it will get stored.
        for(Map.Entry<String, Integer> entry : idHsmp.entrySet())
        {
            System.out.println(entry.getKey() +" : "+ entry.getValue());
        }
    }
}
