package com.tss.AccountSystemInheritanceAssign.model;

import java.util.Random;
import java.time.Year;


public abstract class InsurancePolicy {

    protected int policyNumber;
    protected String holderName;
    protected double sumAssured;
    protected int startYear;
    protected int currentYear;
    protected int duration;
    protected String type;
    protected double premium;
    private double originalSumAssured;

    public InsurancePolicy(String holderName, double sumAssured, int startYear) {
        Random random = new Random();
        this.policyNumber = 100 + random.nextInt(900);
        this.holderName = holderName;
        this.sumAssured = sumAssured;
        this.startYear = startYear;
        this.currentYear = Year.now().getValue();
        this.premium = calculatePremium();
        this.originalSumAssured  = sumAssured;
    }

    public int getPolicyNumber() {
        return policyNumber;
    }


    public String getHolderName() {
        return holderName;
    }


    public double getSumAssured() {
        return sumAssured;
    }

    public double getOriginalSumAssured() {
        return originalSumAssured;
    }

    public int getStartYear() {
        return startYear;
    }

    public int getDuration() {
        return duration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public abstract double calculatePremium();

    public abstract void claimHandler(int currentYear , double claimAmount);

    public void displayDetails(InsurancePolicy policy) {
        System.out.printf("| %-15s | %-15s | %-10s | %-8s | %-8s | %-15s |\n",
                policyNumber, holderName, sumAssured , startYear ,duration, type);

//        System.out.println("Policy Number : " + policyNumber);
//        System.out.println("Holder Name   : " + holderName);
//        System.out.println("Sum Assured   : " + sumAssured);
//        System.out.println("Start Year    : " + startYear);
//        System.out.println("Duration (in Years): " + duration);
//        System.out.println("Type    : " + type);

    }

}
