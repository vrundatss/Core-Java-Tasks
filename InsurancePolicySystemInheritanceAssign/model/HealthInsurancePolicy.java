package com.tss.InsurancePolicySystemInheritanceAssign.model;

public class HealthInsurancePolicy extends InsurancePolicy {

//    private static int MAX_CLAIM_COUNT = 10;
    private int claimCount;
    private double originalSumAssured;

    public HealthInsurancePolicy(String holderName, double sumAssured,int currentYear) {
        super(holderName, sumAssured, currentYear );
        this.claimCount = 0;
        this.duration = (int) (sumAssured / (0.07 * sumAssured));
        this.premium = calculatePremium();
        this.originalSumAssured = sumAssured;
    }

    @Override
    public double calculatePremium() {
        return (0.07 * originalSumAssured);
    }

    @Override
    public void claimHandler(int currentYear , double claimAmount){
        if(claimAmount > 0 && claimAmount <= sumAssured){
            sumAssured = sumAssured - claimAmount;
            claimCount++;

            System.out.println("Claim approved for Health Insurance. \n" + claimAmount + " rs. Claimed Successfully. ");

            System.out.println( "#" + claimCount + " Health Insurance Claimed Successfully..." );
        }
        else {
            System.out.println("Enter Valid amount...");
            return;
        }

    }
}
