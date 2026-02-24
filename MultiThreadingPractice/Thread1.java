package com.tss.MultiThreadingPractice;

public class Thread1 extends Thread{
    @Override
    public void run() {
        int i = 0;
        while (i < 100){
            System.out.println(Thread.currentThread().getName() + " is running...");
            i++;
        }
    }
}
