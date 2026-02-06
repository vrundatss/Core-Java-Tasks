package com.tss.AccountSystemInheritanceAssign.model;

public class LifeInsurancePolicy extends InsurancePolicy {

    private int claimCount = 0;
    private double originalSumAssured;

    public LifeInsurancePolicy(String holderName, double sumAssured, int startYear ) {
        super(holderName, sumAssured, startYear);
        this.claimCount = 1;
        this.duration = (int) (sumAssured / (0.05 * sumAssured));
        this.premium = calculatePremium();
        this.originalSumAssured = sumAssured;
    }

    @Override
    public double calculatePremium(){
        return (0.05 * originalSumAssured);
    }

    @Override
    public void claimHandler(int currentYear , double claimAmount) {
        if(claimCount == 1) {
            if (currentYear >= startYear + duration) {
                if (claimAmount > 0 && claimAmount <= sumAssured) {
                    sumAssured = sumAssured - claimAmount;
                    System.out.println("Claim approved for Life Insurance. \n" + claimAmount + " rs. Claimed Successfully. " + " \nPolicy matured...");
                } else if (sumAssured <= 0) {
                    System.out.println("Life Insurance already claimed...");
                } else {
                    System.out.println("Enter Valid amount...");
                }
            } else {
                System.out.println("Claim denied for Life Insurance. \nPolicy will mature in " + ((startYear + duration) - currentYear) + " year(s).");
            }
        }else{
            System.out.println("Life Insurance already claimed...");
        }
    }

}
