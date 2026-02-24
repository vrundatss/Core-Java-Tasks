package com.tss.MethodReferenceAssign;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentTest {
    public static void main(String[] args) {
        Student student1 = new Student(1 , 101 , "Vrunda");
        Student student2 = new Student(2 , 102 , "ABC");
        Student student3 = new Student(3 , 103 , "DEF");

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);

        students.sort(Student::compareByName);

//        students.sort((student1 , student2) -> student1.getId() - student2.getId());
        students.forEach(System.out::println);

    }



}

