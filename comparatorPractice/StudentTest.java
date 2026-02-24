package com.tss.comparatorPractice;

import java.util.*;

public class StudentTest {
    public static void main(String[] args) {
//        List<Student> students = new ArrayList<Student>(20);

        HashSet<Student> students = new HashSet<>();

        students.add(new Student(2 , 101 , "Vrunda"));
        students.add(new Student(3 , 104 , "XYZ"));
        students.add(new Student(4 , 103 , "ABC"));
        students.add(new Student(1 , 106 , "DEF"));

//        Collections.sort(students);
//
        System.out.println("After sorting using Comparable");
        for (Student student : students){
            System.out.println(student);
        }

    }
}
