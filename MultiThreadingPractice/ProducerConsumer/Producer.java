package com.tss.MultiThreadingPractice.ProducerConsumer;

public class Producer implements Runnable {
    Q q;
    Producer(Q q) {
        this.q = q;
        new Thread(this, "Producer").start();
    }
    public void run() {
        int i = 1;
        while(i<10) {
            q.put(i++);
        }
    }
}