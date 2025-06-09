package com.clcnIntfc.collectionInterface.java8Features;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsLearn {

    /*
    Feature introduced in Java8
    Process collection of data in a functional and declarative manner
    Simplify Data processing
    Functional programming
    Enable parallelism without using the Multithreading Concept

    Streams
    A sequence of elements supporting functional and declarative programming

    How to use Streams
    Source --> Intermediate operation --> Terminal operation

     */

    public static void main(String[] args) {

        //simple stream operation
        List<Integer> gamesNum = Arrays.asList(97, 81, 75, 85, 94);

        Stream<Integer> streams = gamesNum.stream();

        streams.forEach(x -> {
            System.out.println(x);
        });
        System.out.println();


        //Problem -> Given a list of Integer elements, find the count of even numbers out of it
        List<Integer> elements = Arrays.asList(1, 4, 7, 8, 10, 12, 15, 19, 21);
        int count = Math.toIntExact(elements.stream().filter(x -> x % 2 == 0).count());
        System.out.println("Total count of even elements is "+count);

        //Methods of creating streams
        //1. From collection
        List<Integer> arrElement = Arrays.asList(1, 4, 7, 8, 10, 12, 15, 19, 21);
        Stream<Integer> arrStream = arrElement.stream();

        //2. From Arrays
        String[] strArr = {"Ank", "it", "Asth", "ana"};
        Stream<String> strStream = Arrays.stream(strArr);

        //3. Using Stream.of()
        Stream<String> streamEx = Stream.of("ank", "it");

        //4. Infinite stream
        Stream.generate(() -> 1);
        Stream.iterate(1,  x -> x + 1);

    }
}
