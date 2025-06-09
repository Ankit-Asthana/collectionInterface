package com.clcnIntfc.collectionInterface.java8Features;

import java.util.function.Function;

public class FunctionLearn {

    /*
    It is a functional interface. (consists of an abstract method {function with no body}
    Predicate are used for conditional check and returns true/false.
    But Function are used for some operations, coz. it also returns the result
     */

    public static void main(String[] args) {

//        Function<T, R>  T is input and R is result
        Function<Integer, Integer> doubleLength = x -> x * 2;
        System.out.println(doubleLength.apply(4));                   // returns the length * 2 value of Ankit

        Function<Integer, Integer> divideBy2 = x -> x/2;

        System.out.println(doubleLength.andThen(divideBy2).apply(4)); //first doublelength runs then divideby2 runs

        System.out.println(doubleLength.compose(divideBy2).apply(4)); //first divideby2 runs then doubleLength runs


        //Identity
        Function<Integer, Integer> identityAns = Function.identity();
        System.out.println(identityAns.apply(5));                   //what you give in input will come in output
    }
}
