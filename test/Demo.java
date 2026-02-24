package com.tss.test;

import java.io.Serializable;

import java.util.function.Predicate;


class Person {
    String name;

    public boolean equals(Person p) {
        return this.name.equals(p.name);
    }
}

public class Demo {
    public static void main(String[] args) {



//        Predicate<Integer> isOdd = n -> n % 2 != 0;
//        System.out.println(isEven.test(4)); // true
//        System.out.println(isEven.negate().test(4)); // false
    }
}
//
//
//class A {}
//class B extends A {}
//class C extends B {}
//
//public class Demo {
//    public static void main(String[] args) {
//        A a = new C();
//        B b = (B) a;
//        C c = (C) b;
//        System.out.print("OK");
//    }
//}


//class Animal {
//    private void sound() { System.out.print("Animal "); }
//    public void makeSound() { sound(); }
//}
//class Dog extends Animal {
//    private void sound() {
//        System.out.println("Overriding...");
//        System.out.print("Bark "); }
//    public void makeSound() { sound(); }
//}
//public class Demo {
//    public static void main(String[] args) {
//        Animal a = new Dog();
//        a.makeSound();
//    }
//}

//class A { void m1(){ System.out.println("A"); } }
//class B extends A { void m1(){ System.out.println("B"); } void m2(){ System.out.println("B2"); } }
//class CustomException extends Exception { }
//
//public class Demo {
//    public static void main(String[] args) {
//
//
//            public static void main(String[] args) {
//                throw new CustomException();
//        }
//        IDemo demo = () -> {
//            System.out.println("Lambda expression");
//            System.out.println("ABC");
//        };

//        IDemo demo = new IDemo() {
//            @Override
//            public void show() {
//                System.out.println("Anonymous class");
//            }
//
//            @Override
//            public void display() {
//
//            }
//        };
//        demo.show();
//    }
//}

//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.Serializable;

//class Base {
//    void show() throws IOException{
//        System.out.println("Base");
//    }
//}
//class Derived extends Base {
//    void show() throws RuntimeException {
//        System.out.println("Derived");
//    }
//}
//
//public class Demo {
//    public static void main(String[] args) throws  Exception{
//        Base obj = new Derived();
//        obj.show();
//        A a = new B();

//        try {
//            FileInputStream fis = new FileInputStream("C:\\Users\\vrunda.chavada\\Training Projects\\Java projects\\OOP-App-TSS\\src\\com\\tss\\fileHandling\\folder\\Hello.txt");
//        } catch (IOException e) {
//            System.out.println("Error");
//        }

//        int a = 10;
//        int b = 0;
//
//        try{
//            int c = a / b;
//            System.out.println(c);
//        } finally {
//            b = 5;
//            System.out.println(b);
//            System.out.println("Finally block");
////            throw new NullPointerException("Null pointer exception");
//        }

//        String s = "Java";
//        String s1  = s.concat(" Programming");
//        System.out.println(s1);
//        s1 = s;
////        System.out.println(s1);
//
//        String s1 = "Java";
//        String s2 = "java";
//
//        System.out.println(s1.equalsIgnoreCase(s2));
//
//        StringBuilder sb = new StringBuilder("Java");
//        StringBuilder sb1 = new StringBuilder("Java");
//
//         boolean b = sb.equals(sb1);
//        System.out.println(b);
//
//        boolean b1 = sb.toString().equals(sb1.toString());
//
//        System.out.println(b1);
//
//        System.out.println(b);

//        sb.compareTo(new StringBuilder(s));
//    }
//}
