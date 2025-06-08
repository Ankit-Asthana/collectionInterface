package com.clcnIntfc.collectionInterface.java8Features;

import java.util.function.Predicate;

public class PredicateLearn {

    /*
    Predicate is Functional interface having the abstract function "test(T t)"
    Used to check anything
    It holds only a condition (stores a condition in variable) as below isEven
     */

    public static void main(String[] args) {

        Predicate<Integer> isEven = x -> x % 2 == 0;   //single input (any kind of)  and output as Boolean type
        Boolean res = isEven.test(5);
        System.out.println(res);

        Predicate<String> strStartsWithA = x -> x.toLowerCase().startsWith("a");
        Predicate<String> strEndsWithT = x -> x.toLowerCase().endsWith("t");
        Predicate<String> and = strStartsWithA.and(strEndsWithT);                   // combining two predicates
        System.out.println(and.test("Ankit"));
        System.out.println(and.test("Akshay"));
    }
}
