package com.tss.comparatorPractice;

import java.util.Comparator;

public class Student implements Comparable<Student> {
    private int id;
    private int rollNumber;
    private String name;

    public Student(int id, int rollNumber, String name) {
        this.id = id;
        this.rollNumber = rollNumber;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", rollNumber=" + rollNumber +
                ", name='" + name + '\'' +
                '}';
    }

//    @Override
//    public int compare(Student student1, Student student2) {
//        return student1 - student2;
//    }

    @Override
    public int compareTo(Student student) {
        if(this.rollNumber > student.rollNumber)
            return 1;
        if(this.rollNumber < student.rollNumber)
            return -1;
        return 0;
    }
    
    
}

