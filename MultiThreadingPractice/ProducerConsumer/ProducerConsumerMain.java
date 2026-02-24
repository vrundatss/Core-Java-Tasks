package com.tss.MultiThreadingPractice.ProducerConsumer;

public class ProducerConsumerMain {
    public static void main(String[] args) {
        Q q = new Q();
        new Producer(q);
        new Consumer(q);
    }
}
