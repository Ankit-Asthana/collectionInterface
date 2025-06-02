package com.clcnIntfc.collectionInterface.map;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMapLearn {
    public static void main(String[] args) {

        /*

        MAP ==> Insertion order maintained == LinkedHashMap

        The very first difference between the HashMap and LinkedHashMap is that, in LHM, the insertion order is maintained making it bit slow coz it takes more memory to store
        And in the HashMap, the insertion order is not maintained.

        It is maintained coz. the LinkedHashMap uses doubly linked list to store the elements in the insertion order

        To be used when you need to maintain the insertion order

        Complexity will be same as HashMap, only the memory it takes more than HashMap

        🔁 Duplicate Key Handling in LinkedHashMap
        ✅ Same as HashMap:
            LinkedHashMap does not allow duplicate keys, and uses:
                hashCode()
                equals()
         */

        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("Ankit", 1);
        linkedHashMap.put("Aryan", 2);
        linkedHashMap.put("Omkar", 3);

        Set<Map.Entry<String, Integer>> lhmEntries = linkedHashMap.entrySet();   //Stores Map.Entry<String, Integer>
        for(Map.Entry<String, Integer> entries : lhmEntries)
        {
            System.out.println(entries.getKey() +" : "+ entries.getValue());  //get the elements entries in insertion order
        }

        /*
        Use of the constructor values in LinkedHashMap
        By default the accessOrder is true, which is used to maintain the Insertion order
        We are making it false, to detect the least recently used Entry of the LinkedHashMap, it will show on TOP.
        It will help to remove the least used Entries in real time project, which is not being used
        Uses in cache clearing
         */
        System.out.println();
        System.out.println("linkedHashMapCons");
        LinkedHashMap<String, Integer> linkedHashMapCons = new LinkedHashMap<>(11, .3f, true);
        linkedHashMapCons.put("Cricket", 1);
        linkedHashMapCons.put("Football", 2);
        linkedHashMapCons.put("Hockey", 3);

        linkedHashMapCons.get("Hockey");  //it will come to the bottom of the doubly linked list
        linkedHashMapCons.get("Cricket"); //now it will come to the bottom of the doubly linked list
                                            //so these two key used, and Football key is not used, so that will come to Top

        Set<Map.Entry<String, Integer>> gamesEntries = linkedHashMapCons.entrySet();
        for(Map.Entry<String, Integer> entries: gamesEntries) {
            System.out.println(entries.getKey() +" : "+ entries.getValue());
        }
    }
}
