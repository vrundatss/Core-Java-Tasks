package com.tss.practice;

public class Singleton {
    private static Singleton instance;
    public static int count;

    private int a;

    public static void displayCount(){
        Singleton s = new Singleton();
        Singleton s2 = new Singleton();

        System.out.println(s  + "    " + s2);

        System.out.println(s.a);

        s2.a = 30;
        System.out.println(s2.a);

        System.out.println(count);
    }

    private Singleton(){
        System.out.println("Singleton instance created...");
    }
    //we should not define public constructor in this, it violates the singleton purpose
//     public Singleton(int count){
//        this.count = count;
//        this.count++;
//        System.out.println("Inside public constructor");
//    }

    public static Singleton getInstance(){
        if(instance == null){
           instance = new Singleton();
        }
        return instance;
    }

     {
         a = 20;
        System.out.println("Non-Static block executed... ");
    }
//    {
//        System.out.println("Non-Static block-2 executed... ");
//    }
    static{
        count = 10;
        System.out.println("Static block executed... ");
    }

}

