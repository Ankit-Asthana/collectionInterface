package com.clcnIntfc.collectionInterface.map;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.*;
import java.util.random.RandomGenerator;

public class SortedMapLearn {

    /*
    The sorted map is an interface, and TreeMap implements it.
    By default, the Map doesn't have the sorting order, but it does.
    So we can sort the Map using this TreeMap<>() on the basis of "keys"

    The TreeSet internally uses Red-Black tree, which is self-balancing tree.

    And if we want to sort the Map on the basis of values, then we have to use the Stream Api's
     */
    public static void main(String[] args) {
        SortedMap<String, Integer> sortedMap = new TreeMap<>();
        sortedMap.put("Saurabh", 80);
        sortedMap.put("Ankit", 81);
        sortedMap.put("Omkar", 85);
        sortedMap.put("Aryan", 98);

        Set<Map.Entry<String, Integer>> entries = sortedMap.entrySet();

        for(Map.Entry<String, Integer> entry : entries)
        {
            System.out.println(
                    entry.getKey() +" : "+ entry.getValue()
            );
        }
        System.out.println();

        //if you want to sort the keys in descending order, then you should pass that in Constructor of TreeMap like this
//        SortedMap<String, Integer> descSortedMap = new TreeMap<>(Comparator.reverseOrder());

        /*
        Issue with the below comparator sorting on length basis
        It only compares string length. So if two strings have the same length, the comparator returns 0,
        meaning the TreeMap treats them as equal keys, and will overwrite the value.

        If you want to put only one Key of same length, then you should use this ;)

        Here Saurabh and Ankit will be print only coz next other Keys are of same length of Ankit (i.e 5)
         */
        SortedMap<String, Integer> descSortedMap = new TreeMap<>((a, b) -> b.length() - a.length()); //Larger String comes first.

        descSortedMap.put("Saurabh", 80);
        descSortedMap.put("Ankit", 81);
        descSortedMap.put("Omkar", 85);
        descSortedMap.put("Aryan", 98);

        for (Map.Entry<String, Integer> entry : descSortedMap.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
        System.out.println();

        /*
        Counter solution of the above issue
         */

        SortedMap<String, Integer> descSolnSortedMap = new TreeMap<>(
                (a, b) -> {
                    int cmp = Integer.compare(b.length(), a.length()); // longer strings first
                    return cmp != 0 ? cmp : a.compareTo(b);            // if same length, sort alphabetically, natural sorting
                }
        );

        descSolnSortedMap.put("Saurabh", 80);
        descSolnSortedMap.put("Ankit", 81);
        descSolnSortedMap.put("Omkar", 85);
        descSolnSortedMap.put("Aryan", 98);

        for (Map.Entry<String, Integer> entry : descSolnSortedMap.entrySet()) {
            System.out.println(entry.getKey() + " --> " + entry.getValue());
        }
        System.out.println();


        int[] arr = {4, 1, 7, 3, 7, 2, 4};

        TreeSet<Integer> set = new TreeSet<>((a,b) -> b - a);

        for (int num : arr) {
            set.add(num);
        }

        StringBuilder sb = new StringBuilder();
        for (int num : set) {
            sb.append(num);
        }

        String result = sb.toString();
        System.out.println("Concatenated descending unique numbers: " + result);
    }
}
