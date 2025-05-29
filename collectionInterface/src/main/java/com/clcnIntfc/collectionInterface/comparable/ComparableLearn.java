package com.clcnIntfc.collectionInterface.comparable;

import java.util.ArrayList;

public class ComparableLearn {

    /*
    It is used to define, how the class elements should be sorted
    It has the method "compareTo(Object o)" in which we write the logic for that.
    The difference between Comparator and Comparable is that
        Comparator -> method compare(Object o1, Object o2), in which we can write the custom or multiple condition logic for sorting
                        This will be written in different class for that class (Ex. CustomAscendingComparator and CustomDescendingComparator for class Student)
                        This would be multiple
                        Here o1 and o2 gets compared

        Comparable -> method compareTo(Object o), in which we can write the default logic in the class for sorting
                       This would be written in the Class itself by implementing the Comparable interface for which we want default sorting order
                       This would be only one.
                       Internally here the calling will be like "object1.compareTo(object2)"
     */

    public static void main(String[] args) {
        ArrayList<Employee> emp = new ArrayList<>();
        emp.add(new Employee("Ankit", 1, "Kochi"));
        emp.add(new Employee("Elvish", 2, "Haryana"));
        emp.add(new Employee("Karan", 3, "Delhi"));

        emp.sort(null);

        for(Employee employee : emp) {
            System.out.println(employee);
        }
    }

}
