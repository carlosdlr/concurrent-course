package com.carlosdlr.concurrent;

import java.util.concurrent.*;

public class PlayingWithExecutorsAndRunnables {

    public static void main(String args []) throws ExecutionException, InterruptedException, TimeoutException {
        //Runnable task = () -> System.out.println("I am in thread " + Thread.currentThread().getName());
        /*Callable<String> task = () -> {
            Thread.sleep(300);
            return  "I am in thread " + Thread.currentThread().getName();
        };*/

        Callable<String> taskThatThrowsException = () -> {
            throw new IllegalStateException("I throw and exception in thread " + Thread.currentThread().getName());
        };

        //ExecutorService service = Executors.newSingleThreadExecutor();
        ExecutorService service = Executors.newFixedThreadPool(4);

        try {
            for(int i = 0; i < 10; i++) {
                //new Thread(task).start();
                Future future = service.submit(taskThatThrowsException);
                System.out.println("i get " + future.get());
            }
        } finally {
            service.shutdown();
        }
    }
}
