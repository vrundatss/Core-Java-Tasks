package com.tss.InheritancePractice;

public class Rectangle extends Shape{

    private double  length , width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    protected double area() {
        return (length * width);
    }
}
