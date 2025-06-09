package com.clcnIntfc.collectionInterface.java8Features;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamTerminalOps {

    /*
    Used to get the result from Stream
     */

    public static void main(String[] args) {

        //1. collect
        List<Integer> marks = Arrays.asList(68, 98, 87, 74, 85, 64, 71, 78, 56, 84, 88);
        marks.stream().filter(x -> x % 2 == 0).map(x -> x - 1).collect(Collectors.toList());
        marks.stream().filter(x -> x % 2 == 0).map(x -> x - 1).toList();

        //2. forEach
        marks.stream().forEach( x-> System.out.println(x));

        //3. reduce : combines elements to produce a single result
        List<Integer> intVal = Arrays.asList(1, 7, 4, 6, 10, 12);
        Optional<Integer> reduceVal = intVal.stream().reduce((a, b) -> a + b);   //sum of all the elements
        System.out.println("Yo " +reduceVal.get());

        //4. count
        System.out.println(intVal.stream().count());

        //Below are the terminal ops that stops process when it finds the desired
        //5. anyMatch, allMatch, noneMatch
        boolean b = intVal.stream().anyMatch(x -> x % 2 == 0);    //any of the element matches the condition
        System.out.println(b);

        boolean b1 = intVal.stream().allMatch(x -> x % 2 == 0);    //all element matches the condition
        System.out.println(b1);

        boolean b2 = intVal.stream().noneMatch(x -> x % 2 == 0);    //none of the element matches the condition
        System.out.println(b2);


        //Example 1 -> Names of length smaller than 3
        List<String> names = Arrays.asList("Ankit", "Aryan", "Saurabh", "Omkar", "Deepak", "Gautam");
        System.out.println(names.stream().filter(x -> x.length() < 6).toList());

        //Example2 -> Squaring and Sorting numbers
        List<Integer> nums = Arrays.asList(1, 2, 4, 7, 9, 10, 21);
        System.out.println(nums.stream().map(x -> x * x).sorted().toList());

        //Example 3 -> Summing values
        List<Integer> intVals = Arrays.asList(1, 2, 3, 4, 5, 9, 10, 15, 43, 13);
        System.out.println(intVals.stream().reduce((x, y) -> x + y).get());

        //Example 4 -> Counting occurrence of a character
        String sentence = "Hello world";
        System.out.println(sentence.chars().filter( x -> x == 'l').count());

    }
}
