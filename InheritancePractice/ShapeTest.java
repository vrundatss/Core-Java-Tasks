package com.tss.InheritancePractice;

import java.util.Scanner;

public class ShapeTest {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Shape shape;

        System.out.print("Enter radius of Circle : ");
        double radius = scanner.nextDouble();

        shape = new Circle(radius);
        System.out.println("Area of Circle is : " + shape.area());

        System.out.println();
        System.out.print("Enter Length of Rectangle : ");
        double length = scanner.nextDouble();
        System.out.print("Enter Width of Rectangle : ");
        double width = scanner.nextDouble();
        shape = new Rectangle(length , width);
        System.out.println("Area of Rectangle is : " + shape.area());

        System.out.println();
        System.out.print("Enter Base of Rectangle : ");
        double base = scanner.nextDouble();
        System.out.print("Enter Height of Rectangle : ");
        double height = scanner.nextDouble();
        shape = new Triangle(base , height);
        System.out.println("Area of Triangle is : " + shape.area());

    }
}
