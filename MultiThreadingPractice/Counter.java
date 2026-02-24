package com.tss.MultiThreadingPractice;

public class Counter {
    int count = 0;

    synchronized void increment(){
        count++;
    }

    static synchronized void display() {
        System.out.println(Thread.currentThread().getName());
    }
}
