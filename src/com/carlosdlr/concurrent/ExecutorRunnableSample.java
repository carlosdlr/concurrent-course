package com.carlosdlr.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorRunnableSample {


    public static void main(String args []) {
        ExecutorRunnableSample executorSample = new ExecutorRunnableSample();
        executorSample.usingSingleThreadExecutor();
        System.out.println("main thread finish");
    }

    public void usingSingleThreadExecutor()  {
        Runnable task1 = () -> {
            try {

                Thread.sleep(1000);
                System.out.println("long task");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };


        Runnable task2 = () -> {
            try {
                Thread.sleep(3000);
                System.out.println("very long task");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        /**
         *  has a waiting queue to handle multiple requests
         *  a task can be removed from the waiting queue
         */
        ExecutorService singleExecutorService = Executors.newSingleThreadExecutor();
        singleExecutorService.execute(task1);
        singleExecutorService.execute(task2);
        singleExecutorService.shutdown();

    }
}
