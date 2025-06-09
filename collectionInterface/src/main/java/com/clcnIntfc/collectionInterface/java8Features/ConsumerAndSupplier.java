package com.clcnIntfc.collectionInterface.java8Features;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ConsumerAndSupplier {

    /*
    Consumer consumes -> Used in print statement
    Supplier supplies -> Can be used where you don't want any return, like creating connection with DB

    Predicate -> test(T)
    Function -> apply(T)
    Consumer -> sout()
    Supplier -> get()

     */

    public static void main(String[] args) {
        System.out.println("Consumer");
        Consumer<Integer> consumed = x -> System.out.println(x);
        consumed.accept(10);

        List<Integer> integerList = Arrays.asList(1,2,3,4,5,6);

        Consumer<List<Integer>> printList = x -> {
            for(int i : x) {
                System.out.println(i);
            }
        };

        printList.accept(integerList);
        System.out.println();

        System.out.println("Supplier");
        Supplier<String> stringSupplier= () -> "Supplied String";
        System.out.println(stringSupplier.get());
        System.out.println();


        System.out.println("Combined value of Predicate, Function, Consumer, Supplier");

        Consumer<Integer> consumedVal = x -> System.out.println(x);

        Supplier<Integer> intSuppl= () -> 100;

        Predicate<Integer> abcPred = x -> x % 2 == 0;

        Function<Integer, Integer> addTwo= x -> x + 2;

        if(abcPred.test(intSuppl.get())) {
            consumedVal.accept(addTwo.apply(intSuppl.get()));
        }
        System.out.println();



        //Method reference -> It is a shortcut of writing the lambda expression
        System.out.println("Method reference");
        List<String> names = Arrays.asList("Ankit", "Aryan", "Saurabh");
//        names.forEach( x -> System.out.println(x));                    //consumer use
        names.forEach(System.out::println);                              // Method reference, println will be called for each name and each name will pass in the println method, so it gets printed
        System.out.println();



        //Constructor reference
        System.out.println("Constructor reference");
        List<String> brands = Arrays.asList("Nokia", "OnePlus", "Apple", "Redmi", "Realme");
//        List<MobilePhone> phones = brands.stream().map( x -> new MobilePhone(x)).collect(Collectors.toList());     //Constructor reference
        List<MobilePhone> mobiles = brands.stream().map(MobilePhone::new).collect(Collectors.toList());                  //same as above
        System.out.println(mobiles);

    }
}

class MobilePhone {
    private String mobileName;

    public MobilePhone(String mobName) {
        this.mobileName = mobName;
    }

    @Override
    public String toString() {
        return "MobilePhone{" +
                "mobileName='" + mobileName + '\'' +
                '}';
    }
}