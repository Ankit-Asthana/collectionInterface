package com.clcnIntfc.collectionInterface.map;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class HashmapLearn {
    public static void main(String[] args) {

        /*
        If the collison happens at an index then a "linked list" will get created at that index in bucket.
        But if the collision happens more than 8 times at one index, then LinkedList will get converted in the
        "Red black tree" which have the self-balancing technique after every addition and deletion

        The time complexity of HashMap functions {put(K,V), get(K), remove(K)} are 0(log n) coz. we can "get" and "put" the element at 0(1),
        but in due to the insertion and deletion in the red black tree, it will become 0(log n)
         */

        HashMap<Person, String> personMap = new HashMap<>();

        Person p1 = new Person("Ankit", 1);
        Person p2 = new Person("Aryan", 2);
        Person p3 = new Person("Ankit", 1);  //same pname and pid as p1, so it will return true if compared with p1

        personMap.put(p1, "SW Engineer"); // Hashcode1 of p1 key -> Index1
        personMap.put(p2, "Collector"); // Hashcode2 of p2 key -> Index2
        personMap.put(p3, "SW/HW Engineer"); // Hashcode1 of p3 key -> Index1 --> here the hashcode will be same as p1, coz same key "p1"
                                            // we had used the equal method to check the id and name, and here it is same as "p1"
                                            // so it replaces p1
        System.out.println(personMap.size());
        System.out.println(personMap.get(p3));
        System.out.println();


        /*
         how to iterate over map
            map.keySet() -> It will return Set<K> containing all the keys.
            map.entrySet() -> It will return Set<Map.Entry<K, V>> of the map containing the key value pair of map
         */

        System.out.println("Keys");
        Set<Person> personKeys = personMap.keySet();
        for (Person p : personKeys) {
            System.out.println(p);
        }
        System.out.println();

        System.out.println("Keys with Value");
        Set<Map.Entry<Person, String>> personEntries = personMap.entrySet();
        for (Map.Entry<Person, String> entry : personEntries) {
            System.out.println("Person: " + entry.getKey() + ", Occupation: " + entry.getValue());
        }
        System.out.println();

        System.out.println("Keys with Value in more simpler way");
        for(Map.Entry<Person, String> entry : personMap.entrySet())
        {
            System.out.println("Person Obj : "+entry.getKey()+" ,Occupation : "+entry.getValue());
        }

        /*
        Some important things
         */

        //if you want that if something is not in the hashmap, then it will return something, like 0
        System.out.println();
        HashMap<String, Integer> extraHashMap = new HashMap<>();
        extraHashMap.put("Ram", 1);
        extraHashMap.put("Shyam", 2);
        extraHashMap.put("Vayam", 3);

        Integer available = extraHashMap.getOrDefault("Rohan", 0); //return 0 if key not present in the hashmap
        if(available == 0)
        {
            //logic for not getting the key in hashmap
            System.out.println("Rohan not found in the Hashmap");
        }

        // want to put any entry in the hashmap if the given key is not available
        extraHashMap.putIfAbsent("Saurabh", 4);

        System.out.println("extraHashMap");
        System.out.println();
        Set<Map.Entry<String, Integer>> entriesSet = extraHashMap.entrySet();
        for(Map.Entry<String, Integer> entries : entriesSet)
        {
            System.out.println(entries.getKey() +" : "+ entries.getValue());
        }
    }
}


/*Note - Every class implements the Object class
         And the Object have two simple methods.
            1. hashcode() -> It will generate the hashcode for the given key using which the index is cal. to store the element at
            2. equals() -> It will check the reference type of the two objects,

            By default, the hashcode method use "Memory addresses" to create hashcode, for every object it will be different hashcode coz of random memory address

        We can customize these methods in our class to generate the hashcode according to our requirement
        also to check equality between the objects on some custom condition (like same ID, name etc.)
 */

class Person {
    private String name;
    private int id;

    public Person(String pname, int pid) {
        this.name = pname;
        this.id = pid;
    }

    //created the equals method that will check the ID and name
    //if same name and id, then it will return true
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString(){
        return "ID : "+id+ ", Name : "+name;
    }
}
