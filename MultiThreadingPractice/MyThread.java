package com.tss.MultiThreadingPractice;

public class MyThread extends Thread{
    @Override
    public void run() {
        for (int i=0; i < 3; i++){
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
