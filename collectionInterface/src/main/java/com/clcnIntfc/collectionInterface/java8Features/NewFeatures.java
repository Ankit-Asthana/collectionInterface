package com.clcnIntfc.collectionInterface.java8Features;

public class NewFeatures {

    /*
    What were the issue before java 8
        Long code
        No functional programming

    In java8, new features are
        Streams
        Functional Programming features
        Lambda Expression
        Date and Time API
        Function
     */

    public static void main(String[] args) {

        /*
        Lambda Expression
            It is an anonymous function (no name, no return type, no access modifier)
            It is used to implement Functional interface (A interface having single Abstract method and can have multiple Default or SStatic methods)
                For ex:
                    There is a functional interface named Runnable (consist of one abstract method run()), used to create a thread.
                    So we can simply use that like this below.
            () -> {}
         */

        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(100);
                System.out.println("Thread t1 after sleep");
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        });
        t1.start();

        /*
        Another example of Lambda expression
            Created a Functional interface MathOperation with abstract function named operate
                We can use the single function for multiple purpose, like add, sub, divide, mul
                Below is the implementation
         */

        MathOperation sumOperation = ((a, b) -> a + b);
        int sumRes = sumOperation.operate(1, 2);
        System.out.println("Sum is " +sumRes);

        MathOperation subOperation =((a, b) -> a - b);
        int subRes = subOperation.operate(2,1);
        System.out.println("Difference is "+subRes);

        MathOperation mulOperation = ((a, b) -> a * b);
        int mulRes = mulOperation.operate(2, 4);
        System.out.println("Product is "+mulRes);


        /*
        This was before Java 8, that we have to do, long and lengthy code
         */
        Thread t2 = new Thread(new Task());
        t2.start();

        try {
            t1.join();
            t2.join();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);
}

/*
    Instead of doing this much we can simply use the above lambda expression
 */

class Task implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(100);
            System.out.println("Thread t2 after sleep");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
