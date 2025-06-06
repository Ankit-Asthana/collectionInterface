package com.clcnIntfc.collectionInterface.queue;

import lombok.Data;
import org.hibernate.metamodel.internal.StandardEmbeddableInstantiator;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayBlockingQueueLearn {
    public static void main(String[] args) throws InterruptedException {
        /*
        Thread safe unbounded blocking queue
        Elements can only be taken from queue when their delay has expired
        Useful for scheduling tasks to be executed after a certain delay
        Internally uses PriorityQueue
         */

        BlockingQueue<DelayedTask> delayedQueue = new DelayQueue<>();
        delayedQueue.put(new DelayedTask("Task1", 5L, TimeUnit.SECONDS));
        delayedQueue.put(new DelayedTask("Task2", 3L, TimeUnit.SECONDS));
        delayedQueue.put(new DelayedTask("Task3", 10L, TimeUnit.SECONDS));

        while(!delayedQueue.isEmpty()) {
            DelayedTask task = delayedQueue.take();    //will be blocked until the task's delay has expired  TASK2 will run first, coz of the comparator's logic of putting the lowest delay element to the queue head position
            System.out.println("Executed " + task.getTaskName()+ " at " + System.currentTimeMillis());
        }
    }
}

@Data
class DelayedTask implements Delayed {

    private final String taskName;
    private final long startTime;

    public DelayedTask(String taskName, Long delay, TimeUnit unit) {
        this.taskName = taskName;
        this.startTime = System.currentTimeMillis() + unit.toMillis(delay);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long remainingDelay = startTime - System.currentTimeMillis();
        return unit.convert(remainingDelay, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        if(this.startTime < ( (DelayedTask) o).startTime ) {
            return -1;
        }
        if(this.startTime > ( (DelayedTask) o).startTime ) {
            return 1;
        }
        return  0;
    }
}
