package com.clcnIntfc.collectionInterface.java8Features;

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
    }
}
