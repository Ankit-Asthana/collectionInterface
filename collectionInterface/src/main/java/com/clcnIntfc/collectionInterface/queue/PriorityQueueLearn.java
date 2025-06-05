package com.clcnIntfc.collectionInterface.queue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.print.attribute.standard.MediaSize;
import javax.swing.*;
import java.util.PriorityQueue;

public class PriorityQueueLearn {
    public static void main(String[] args) {
        /*
            Part of Queue interface
            Order elements based on their natural ordering (for primitive data type ->  Lowest first)
            For class, custom Comparator or Class with implemented Comparable for ordering
            Doesn't allow null element

            Internal working of PriorityQueue
                Implements as a Min-heap by default
                    Min-heap work: The both child elements must be greater than the parent.

                When polled/removed the head, then only the next high priority element will come on head
         */

        PriorityQueue<Integer> integers = new PriorityQueue<>();
        integers.offer(15);
        integers.offer(3);
        integers.offer(2);
        integers.offer(-1);
        System.out.println("Integer priority queue size after adding all is "+ integers.size());

        while(!integers.isEmpty()) {              // remove the head and prints
            System.out.println(integers.poll()); //Prints the sorted order [-1, 2, 3, 15] , coz of the lowest first priority insertion
        }
        System.out.println("Integer priority queue size after polling " +integers.size());
        System.out.println();

        /*
        Using the Comparable for priority based insertion in PriorityQueue
         */
        PriorityQueue<People> peoplePriorityQueue = new PriorityQueue<>();
        peoplePriorityQueue.offer(new People(2, "Ankit"));
        peoplePriorityQueue.offer(new People(1, "Aryan"));
        peoplePriorityQueue.offer(new People(7, "Omkar"));
        System.out.println("peoplePriorityQueue size after adding all is" +integers.size());



        while(!peoplePriorityQueue.isEmpty()) {
            System.out.println(peoplePriorityQueue.poll());  //remove the head and prints, so we can know that what is the order in which the elements were placed
        }
        System.out.println("peoplePriorityQueue size after polling " +peoplePriorityQueue.size());
        System.out.println();


        /*
        Using the comparator for priority based insertion in Priority Queue
         */

        PriorityQueue<Engineer> engineerPriorityQueue = new PriorityQueue<>((a, b) -> b.getEngid() - a.getEngid());  //Desc. order comparator
        engineerPriorityQueue.offer(new Engineer(1, "Employee"));
        engineerPriorityQueue.offer(new Engineer(2,"Lead" ));
        engineerPriorityQueue.offer(new Engineer(3, "TechLead"));
        engineerPriorityQueue.offer(new Engineer(4, "Project Manager"));
        engineerPriorityQueue.offer(new Engineer(5, "Manager"));
        engineerPriorityQueue.offer(new Engineer(6, "CTO"));
        engineerPriorityQueue.offer(new Engineer(7, "COO"));
        engineerPriorityQueue.offer(new Engineer(8, "CEO"));

        System.out.println("engineerPriorityQueue size after adding all " +engineerPriorityQueue.size());

        while (!engineerPriorityQueue.isEmpty()) {
            System.out.println(engineerPriorityQueue.poll());
        }
        System.out.println("engineerPriorityQueue size after polling " +engineerPriorityQueue.size());

    }
}


@Data
class People implements Comparable<People> {

    private int id;
    private String name;

    @Override
    public int compareTo(People o) {
        return (o.getId() - this.getId()); //descending order
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public People(int id, String name) {
        this.id = id;
        this.name = name;
    }
}


@Data
@AllArgsConstructor
@ToString
class Engineer {
    private int engid;
    private String degn;

}