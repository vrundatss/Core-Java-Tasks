package com.tss.ExecutorTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//                ExecutorService executorService = Executors.newFixedThreadPool(2);

//            ExecutorService executorService = Executors.newCachedThreadPool();
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService executorService = Executors.newScheduledThreadPool(2);


        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName() + " executing task " + taskId);
            });
        }

//        executorService.submit(() ->{
//            System.out.println("Thread 1...");
//        });
//
//        executorService.submit(() ->{
//            System.out.println("Thread 2...");
//        });
//
//        executorService.submit(() -> {
//            System.out.println("Thread 3...");
//        });
//
//        executorService.submit(() ->{
//            System.out.println("Thread 4...");
//        });
//
//        executorService.submit(() ->{
//            System.out.println("Thread 5...");
//        });


        executorService.shutdown();

    }
}
