package com.carlosdlr.concurrent;

import java.util.concurrent.*;

public class CallableFutureSample {

    public static void main(String args[]) throws ExecutionException, InterruptedException {
        Callable<String> task = () -> {
            Thread.sleep(300);
            return "Process done!! in thread " + Thread.currentThread().getName();
        };

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        for(int i = 0; i < 10; i++) {
            Future<String> future = executorService.submit(task);
            System.out.println("I get from future: "+ future.get());
        }

        executorService.shutdown();

        System.out.println("main thread finish");
    }
}



