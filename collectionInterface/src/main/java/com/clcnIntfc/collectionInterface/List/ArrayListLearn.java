package com.clcnIntfc.collectionInterface.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArrayListLearn {
    public static void main(String[] args) {

        //###########################################################//
        //#################### Basic ArrayList #######################//
        //###########################################################//

        List<Integer> integerList = new ArrayList<>();
        for(int i =0; i < 10; i++) {
            integerList.add(i);
        }

//        System.out.println("integerList class is "+integerList.getClass().getName()); //prints java.util.Arrays$ArrayList
        System.out.println("integerList");
        for(int a: integerList) {
//            System.out.println(a);
        }
        System.out.println();


        //********************************************************************
        //Converting Arrays.asList
        //********************************************************************

        List<String> arraysList = Arrays.asList("Mon", "Tue", "Wed");
//        arraysList.add("Thu"); //this gives exception, coz Arrays.asList() will give the array of static size and we can't add elements to it
        arraysList.set(1, "Thu"); // we can only replace the elements

        System.out.println("arraysList");
//        System.out.println("arraysList class is "+arrayList.getClass().getName()); //prints java.util.Arrays$ArrayList
        for(String a: arraysList) {
            System.out.println(a);
        }
        System.out.println();


        //********************************************************************
        //Using List.of(), which is introduced in java 9
        //********************************************************************

        List<Integer> listof = List.of(1,2,5,8,10,3,3);

//        listof.add(16); //this gives exception, coz List.of() will give the array of static size and we can't add elements to it
//        listof.set(1, 12); //this gives exception as we can't even modify the array

        System.out.println("listof");
        for(int s: listof) {
            System.out.println(s);
        }
        System.out.println();


        //********************************************************************
        //Converting List to Array
        //********************************************************************
        List<Integer> intlist = new ArrayList<>();
        intlist.add(7);
        intlist.add(3);
        intlist.add(5);
        intlist.add(4);

        System.out.println("intlist");
        Integer[] intArr = intlist.toArray(new Integer[0]);
        System.out.println(intArr.length);
        System.out.println();



        //###########################################################//
        //###################### Comparator #########################//
        //###########################################################//



        //********************************************************************
        //First way of using Comparator for sorting List
        //********************************************************************

        ArrayList<String> list = new ArrayList<>();
        list.add("Deck");
        list.add("Douglas");
        list.add("At");

        System.out.println("list");
//        list.sort(new CustomAscendingComaprator()); //Ascending order sorting logic in that class
//        list.sort(new CustomDescendingComparator()); //Descending order sorting logic in that class

        for(String s: list){
//            System.out.println(s); //will compare as Ascending order
        }
        System.out.println();


        //********************************************************************
        //Second way of using Comparator for sorting List for Student class using Lambda expression
        //********************************************************************

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Ankit", 5.9F));
        students.add(new Student("Saurabh", 8.9F));
        students.add(new Student("Aryan", 8.9F));
        students.add(new Student("Shubham", 7.4F));

//        students.sort((a1, a2) -> a1.getGpa() - a2.getGpa());  //error coz. of float casting to int, making it correct below
        students.sort((a1, a2) -> {
            if(a2.getGpa() - a1.getGpa() > 0 ){
                return 1;
            } else if (a2.getGpa() - a1.getGpa() < 0) {
                return -1;
            }
            else {
//                return a2.getName().length() - a1.getName().length(); //on the basis of length of names
                return a1.getName().compareTo(a2.getName()); //basis of name first letter if gpa is same
            }
        });

        System.out.println("students");
        for(Student s : students){
//            System.out.println(s.getName()+ ":" +s.getGpa());
        }
        System.out.println();



        //********************************************************************
        //Third and easiest method of sorting List through comparator using Method reference
        //********************************************************************

        ArrayList<Student> studentsListOne = new ArrayList<>();
        studentsListOne.add(new Student("Ramesh", 8.2F));
        studentsListOne.add(new Student("Suresh", 6.5F));
        studentsListOne.add(new Student("Kuresh", 6.5F));
        studentsListOne.add(new Student("Gukesh", 9.8F));

        System.out.println("studentsListOne");
        //using method reference for sorting
        studentsListOne.sort(Comparator.comparing(Student::getGpa).thenComparing(Student::getName)); //sort the students in natural(Ascending way)
//        studentsListOne.sort(Comparator.comparing(Student::getGpa).reversed().thenComparing(Comparator.comparing(Student::getName).reversed())); //sort the students in descending order and then if different students have same gpa, then sort them in descending order of name

        for(Student s: studentsListOne) {
//            System.out.println(s.getName()+ ":" +s.getGpa());
        }
        System.out.println();
    }
}
