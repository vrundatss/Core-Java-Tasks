package com.tss.MultiThreadingPractice;



public class Test {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            Counter.display();

            for(int i=0;i<1000;i++) counter.increment();
        });
        Thread t2 = new Thread(() -> {
            Counter.display();

            for(int i=0;i<1000;i++) counter.increment();
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        Counter.display();

        System.out.println("Count : " + counter.count);

//        MyThread t1  = new MyThread();
//        MyThread t2  = new MyThread();
//
//        Thread1 thread1 = new Thread1();
//        thread1.start();
//
//        t1.start();
////        t1.join();
//        t2.start();

//        Thread1 t1 = new Thread1();
//        Thread2 t2 = new Thread2();
//
//        t1.start();
//        t1.yield();
//        t2.start();
//        try {
//            t1.join();
//            t2.start();
//
//        } catch (InterruptedException e) {
//            System.out.println("Main thread was interrupted while waiting for t1");
//            e.printStackTrace();
//        }
//        t2.start();
//        t1.start();
//        t1.run();     // it shows main is running , no new thread
//        t2.run();     // it shows main is running

    }

}
