package com.clcnIntfc.collectionInterface.java8Features;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamsIntermediateOperation {

    /*
    All intermediate operations of Stream
    The intermediate operation transform a stream into another stream
    They are lazy, meaning they don't execute until a terminal operation is invoked
     */
    public static void main(String[] args) {

        //1. filter (conditional check) -> Use of Predicate
        List<String> kids = Arrays.asList("Ram", "Shyam", "Ghanshyam", "Rahul");

        Stream<String> transformedStream = kids.stream().filter(x -> x.startsWith("R")); //Intermediate ops converting one stream to another
        int kidsNameR = (int) transformedStream.count();                                       // Terminal operation
        System.out.println(kidsNameR);

        //2. map (convert the input into some output) -> Use of Function
        Stream<String> upperCaseStream = kids.stream().map(x -> x.toUpperCase());       //for conversion of elements

        //3. sorted
        Stream<String> sortedString = kids.stream().sorted();                                   //natural order sorting
        Stream<String> comparatorSortedString = kids.stream().sorted((a, b) -> a.length() - b.length());  //for custom order sorting

        //4. distinct
        Stream<String> distinctOnly = kids.stream().filter(x -> x.startsWith("R")).distinct();
        System.out.println(distinctOnly.count());

        //5. limit
        System.out.println(Stream.iterate(1, x -> x + 1).limit(100).count());

        //6. skip
        System.out.println(Stream.iterate(1, x -> x + 1).skip(10).limit(100).count());
        System.out.println();

        //7. flatmap
        //      Used to handle stream of collections, lists or arrays, where each element itself a collection
        //      Flattened nested structure(e.g list within list) so that they can be processed as a single sequence of elements
        //      Transform and flatten element at same time
        List<List<Integer>> intlist = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );

        System.out.println(intlist.get(1).get(1));   //5 will be printed
        System.out.println();

        List<Integer> flatmapPlusOne = intlist.stream().flatMap(x -> x.stream()).map(x -> x + 1).toList();
        System.out.println("Flatmap created of multiple arraylist");
        System.out.println(flatmapPlusOne);
    }
}
