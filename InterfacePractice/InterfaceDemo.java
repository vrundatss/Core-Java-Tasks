package com.tss.InterfacePractice;

interface  A{
    default void show() {
        System.out.println("xyz");
    }

    int a = 10;
}

interface  B{
    default void show() {
        System.out.println("abc");
    }

    private void display() {

    }

    int a = 10;
}

class C implements A , B{

    @Override
    public void show() {
        A.super.show();
    }

}
public class InterfaceDemo {
}
