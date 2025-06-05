package com.clcnIntfc.collectionInterface.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class DequeLearn {
    public static void main(String[] args) {
        /*
        Double ended queue
        Addition and removal from both ends of Queue
        Two implementation class
            ArrayDeque -> Internally uses Circular Array, with double-sided head and tail. Increases by double when full
            LinkedList

        Addition Methods:
            1. addFirst(E e)
            2. addLast(E e)
            3. offerFirst(E e)
            4. offerLast(E e)

        Removal Methods:
            1. removeFirst(E e)
            2. removeLast(E e)
            3. pollFirst(E e)
            4. pollLast(E e)

        Examination Methods:
            1. getFirst()
            2. getLast()
            3. peekFirst()
            4. peekLast()

        Stack Methods:
            1. push(E e)   -> add element to the front (same as addFirst(E e))
            2. pop()       -> remove and returns head/first element (same as removeFirst())
         */

        /*
        Always prefer ArrayDeque implementation for Deque unless you have specific use case of LinkedList coz.
            It is faster due contiguous memory
            Low Memory occupancy
            No null value allowed
            When removed an element, no need to shift the whole element, just shift the head and tail of the circular array accordingly
                Ex:
                Insertion at head of ArrayDeque -> head ++
                Removed from head of ArrayDeque -> head --
                Insertion at tail of ArrayDeque -> tail ++
                Removed from tail of ArrayDeque -> tail --
                Accordingly, handling when inserted in somewhere of ArrayDeque

            ArrayDeque is not Thread safe

            LinkedList doesn't have the contiguous memory, it is having nodes that contains the address of other node that makes it slow

            Use LinkedList when you need to insert/delete somewhere in the middle of Deque coz.
                in ArrayDeque, you should have to shift the elements for insertion/deletion in middle
                in LinkedList, no need to shift element, just change the prev and next of the node inserted
         */

        Deque<Integer> integerDeque1 = new ArrayDeque<>();
        integerDeque1.offer(1);
        integerDeque1.offerFirst(2);
        integerDeque1.offerLast(5);
        integerDeque1.offerFirst(7);
        integerDeque1.offerLast(10);
        System.out.println(integerDeque1);

        System.out.println("First element = " +integerDeque1.getFirst());
        System.out.println("Last element = " +integerDeque1.getLast());

        System.out.println("Removed last element " +integerDeque1.pollLast());
        integerDeque1.remove(1);

        for(int i : integerDeque1) {
            System.out.println(i);
        }
        System.out.println();



        Deque<Integer> integerDeque2 = new LinkedList<>();
        integerDeque2.offerFirst(1);
        integerDeque2.offerFirst(2);
        integerDeque2.offerLast(4);


        ((LinkedList<Integer>) integerDeque2).add(2,3); //to insert element in middle
        ((LinkedList<Integer>) integerDeque2).add(4,8); //to insert element in middle

        integerDeque2.offer(6);
        integerDeque2.offer(10);


        ((LinkedList<Integer>) integerDeque2).remove(3); //to remove element from index 3

        System.out.println(integerDeque2);

    }
}
