package com.tss.model;

public class Student {
    private  int id;
    private String name;
    private String course;
    private double feesPaid;
    private double totalFees;

    public Student() {
        this.id = 0;
        this.name = "";
        this.course = "";
        this.feesPaid = 0.0;
        this.totalFees = 0.0;
    }

    public Student(int id, String name, String course, double feesPaid, double totalFees) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.feesPaid = feesPaid;
        this.totalFees = totalFees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception{
        if (name.isEmpty()) {
            throw new Exception("Name cannot be empty!");
        }

        if (!name.matches("[a-zA-Z ]+")) {
            throw new Exception("Name must contain only alphabets!");
        }

        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course)throws Exception {
        if ( course.isEmpty()) {
            throw new Exception("Name cannot be empty!");
        }

        if (!course.matches("[a-zA-Z ]+")) {
            throw new Exception("Name must contain only alphabets!");
        }

        this.course = course;
    }

    public double getFeesPaid() {
        return feesPaid;
    }

    public void setFeesPaid(double feesPaid) {
        this.feesPaid = feesPaid;
    }

    public double getTotalFees() {
        return totalFees;
    }

    public void setTotalFees(double totalFees) {
        this.totalFees = totalFees;
    }

    public void payFees(double amount){

        feesPaid += amount;
    }

    public double getPendingFees(){

        return (totalFees - feesPaid);
    }

    public void displayAllDetails(){
//        System.out.println("Student Details ==> ");
//        System.out.println("Id : " + id + "  |  " + "Name : " + name + "  |  " + "Course : "+ course + "  |  " +"Fees Paid : "+ feesPaid + "  |  " + "Total fees : " + totalFees);

        System.out.println();

        System.out.printf("%-5s %-20s %-20s %-10s %-10s" , id , name , course , feesPaid , totalFees );
        System.out.println();

        //        System.out.println("Id : " + id);
//        System.out.println("Name : " + name);
//        System.out.println("Course : "+ course);
//        System.out.println("Fees Paid : "+ feesPaid);
//        System.out.println("Total fees : " + totalFees);

    }
}
