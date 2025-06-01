package com.clcnIntfc.collectionInterface.map;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ImmutableMapLearn {

    public static void main(String[] args) {
        Map<Integer, String> students = new HashMap<>();
        students.put(1, "Ankit");
        students.put(2, "Saurabh");

        /*
        Way of making the Map immutable, means no addition or deletion in the map after creation
         */
        Map<Integer, String> studentsImmut = Collections.unmodifiableMap(students);

        //other and easier way
        Map<Integer, String> immutableMap = Map.of(1, "Virat", 2, "Rohit", 3, "Dhoni");
//        immutableMap.put(5, "Bumrah"); //throws an error coz the map is immutable

        for(Map.Entry<Integer, String> entry : immutableMap.entrySet()) {
            System.out.println(entry.getKey() +" --> "+ entry.getValue());
        }
    }
}
