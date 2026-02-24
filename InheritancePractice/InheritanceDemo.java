package com.tss.InheritancePractice;

class A{
    private int a ,b;

    A(int a , int b){
        super();
        System.out.println("A's Constructor");

        this.a = a;
        this.b = b;
    }

    public A() {

    }

    void dis(){
        System.out.println("Show A");
    }

    static {
        System.out.println("static block of A");
    }

    {
        System.out.println("non static block of A");
    }
}

//class B extends A{
//    private int c, d;
//
//    B(){
//        super();
//
//    }
//
//    B( int a  ,int b , int c , int d) {
//        super(a , b);
//        System.out.println("B's Constructor");
//        this.c = c;
//        this.d = d;
//    }
//
//    void show() {
//        System.out.println("Show B");
////        super.show();
//
//    }
//    static{
//        System.out.println("Static block of B");
//    }
//}




public class InheritanceDemo {
    public static void main(String[] args) {

        A b;
//        B b = new B();
//        B b = new B(10 , 20 , 30 , 40);
//        A a = new B(10 ,20 ,30 ,40);
//        a.show();
//        a.dis();
//        a.show();
//        b.show();
    }

}


//class Animal {
//    Animal() {
//        System.out.println("Animal constructor");
//    }
//}
//
//class Dog extends Animal {
//    Dog() {
////        super();
//        System.out.println("Dog constructor");
//    }
//}
//
//public class InheritanceDemo {
//    public static void main(String[] args) {
//        Dog d = new Dog();
//    }
//}