package com.tss.practice;

public class SingletonMain {
    public static void main(String[] args) {
//        Singleton s1 = new Singleton(10);

//        System.out.println(s1.count);
//
//        Singleton s11 = new Singleton(20);
//
//        System.out.println(s11.count);
//        System.out.println(s1.count);

//        Singleton s = new Singleton() ;

//        System.out.println(Singleton.count);

        Singleton s2 = Singleton.getInstance();
        Singleton s3 = Singleton.getInstance();

        System.out.println(s2 == s3);
        System.out.println(s2);
        System.out.println(s3);

        Singleton.displayCount();
//        System.out.println(Singleton.class);

    }

}
