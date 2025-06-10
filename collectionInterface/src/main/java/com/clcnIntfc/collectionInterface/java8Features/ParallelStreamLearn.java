package com.clcnIntfc.collectionInterface.java8Features;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class ParallelStreamLearn {

    /*
    A type of stream that enables parallel processing of elements
    Allowing multiple threads to process parts of stream simultaneously
    This can significantly improve performance for large data set
    Most effective for
        CPU-intensive work
        Large dataset
        Independent tasks

    Keep in mind that the ParallelStream are used where the result of one element is not dependent on the other elements of List
    If the result of an element is dependent on other element of same list then you can't achieve parallelism
    For ex. cumulative sum.
     */

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        List<Integer> integerList = Stream.iterate(1, x -> x + 1).limit(10000).toList();
//        List<Long> factorials = integerList.stream().map(x -> factorialCal(x)).toList();
        List<Long> factorials = integerList.stream().map(ParallelStreamLearn::factorialCal).toList();
//        for(long i : factorials) {
//            System.out.println(i);
//        }

        long endTime = System.currentTimeMillis();
        System.out.println("Total time taken through Stream is "+(endTime - startTime) +" ms"); //slow


        //through Parallel stream
        startTime = System.currentTimeMillis();
        List<Long> factorialslist = integerList.parallelStream().map(ParallelStreamLearn::factorialCal).toList();
        endTime = System.currentTimeMillis();

        System.out.println("Total time taken through Parallel Stream is "+(endTime - startTime) +" ms");  //fast
        System.out.println();

        //Cumulative sum using the ParallelStream will give unexpected result coz. elements are dependent on each other
        // [1, 2, 3, 4, 5]  ---> [1, 3, 6, 10, 15]
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        AtomicInteger sum = new AtomicInteger(0);

        List<Integer> cumulativeSum =  numbers.parallelStream().map(sum::addAndGet).toList();

        System.out.println("Expected Result is [1, 3, 6, 10, 15]");
        System.out.println("Actual result is "+cumulativeSum);         //it will not comes as expected coz of elements dependency on each other
    }

    private static long factorialCal(int num) {
        long result = 1;
        for (int i = 2; i <= num; i++) {
            result *= i;
        }
        return result;
    }



}
