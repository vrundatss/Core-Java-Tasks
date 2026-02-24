package com.tss.ExecutorTest;
import java.util.*;
import java.util.concurrent.*;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<Callable<String>> tasks = Arrays.asList(
                () -> { Thread.sleep(5000); return "Task 1 done"; },
                () -> { Thread.sleep(2000); return "Task 2 done"; },
                () -> { Thread.sleep(1500); return "Task 3 done"; }
        );

//        List<Future<String>> results = executor.invokeAll(tasks);
        String result1 = executor.invokeAny(tasks);

        System.out.println(result1);

        //        for (Future<String> f : results) {
//            System.out.println(f.get());
//        }


//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//
//        Callable<String> task = () ->{
//            System.out.println(Thread.currentThread().getName() + " is executing the task...");
//            Thread.sleep(2000);
//            return "Result from Callable!!!...";
//        };
//
//        Future<String> future= executorService.submit(task);
//
//        String result = null;
//        try {
//            result = future.get();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        }
//
//        System.out.println("Result received: " + result);
    }
}
