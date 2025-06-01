package com.clcnIntfc.collectionInterface.map;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapLearn {

    /*
    MAP ==> Entry of Keys not used for a long time gets deleted by Garbage collector == WeakHashMap

    It is used to garbage collect the Keys of hashmap which are not strong reference
    ex - if key is string literal (in String constant pool, then it is strong key and will not be garbage collected. (String abc = "Abc";)
        If they are not string literal then they can be garbage collected (String abc = new String("Abc");)
        Garbage collect means, it will be deleted from the WeakHashMap
     */
    public static void main(String[] args) {
        WeakHashMap<String, Integer> wkMap = new WeakHashMap<>();
        wkMap.put("Abc", 1);   //this will be deleted from the Hashmap after sometime
        wkMap.put(new String("Def"), 2);  //this will be there in HashMap till the program exit
        System.gc();    //called Garbage collector
        simulateThread();
        for(Map.Entry<String, Integer> entries : wkMap.entrySet())
        {
            System.out.println(entries.getKey() +" : "+ entries.getValue());
        }
    }

    private static void simulateThread() {
        try
        {
            System.out.println("Simulating Thread");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
