package com.tss.AccountSystemInheritanceAssign.model;

public class VehicleInsurancePolicy extends InsurancePolicy {

    private double originalSumAssured;

    public VehicleInsurancePolicy(String holderName, double sumAssured,int currentYear ) {
        super(holderName, sumAssured,currentYear);
        this.duration = (int) (sumAssured / (0.03 * sumAssured));
        this.premium = calculatePremium();
        this.originalSumAssured = sumAssured;
    }


    @Override
    public double calculatePremium(){
        return (0.03 * originalSumAssured);
    }

    @Override
    public void claimHandler(int currentYear , double claimAmount) {
        if(currentYear < startYear + duration)
        {
            if(claimAmount > 0 && claimAmount <= sumAssured){
                sumAssured = sumAssured - claimAmount;
                System.out.println("Claim approved for Vehicle Insurance. \n" + claimAmount + " rs. Claimed Successfully. " + " \nPolicy is Active...");
            }
            else {
                System.out.println("Enter Valid amount...");
            }
        }else {
            System.out.println("Claim denied for Vehicle Insurance. \nVehicle Policy is expired...");
        }
    }


}
