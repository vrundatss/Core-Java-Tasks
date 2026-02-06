package com.tss.AccountSystemInheritanceAssign.main;

import com.tss.AccountSystemInheritanceAssign.model.HealthInsurancePolicy;
import com.tss.AccountSystemInheritanceAssign.model.LifeInsurancePolicy;
import com.tss.AccountSystemInheritanceAssign.model.VehicleInsurancePolicy;
import com.tss.InheritancePractice.UtilityAccountMethods;

import com.tss.AccountSystemInheritanceAssign.model.InsurancePolicy;

import java.time.Year;
import java.util.Scanner;

public class InsurancePolicySystemMain {

        static Scanner scanner = new Scanner(System.in);
        public static final int MAX_POLICIES = 100;

        static int policyCount = 0;
        static InsurancePolicy[] policies = new InsurancePolicy[MAX_POLICIES];

        public static void main(String[] args) {
            String input;
            int choice;

            do {
                System.out.println("\n============ Insurance MANAGEMENT SYSTEM ============");
                System.out.println("1. Create an Insurance Policy");
                System.out.println("2. Calculate and Display Premium for a policy");
                System.out.println("3. Apply for policy claim");
                System.out.println("4. Display Details of a Policy");
                System.out.println("5. Display Details of All the Policies");
                System.out.println("6. Exit");

                System.out.print("Enter your choice : ");

                while(true){
                    input = scanner.next();
                    scanner.nextLine();
                    if(input.length() == 1 && (input.charAt(0) >= '1' && input.charAt(0) <= '6' )){
                        choice = Integer.parseInt(input);

                        if (choice != 1 && policyCount == 0) {
                            System.out.print("No policy exists! Please create a policy first (choose option 1).\nEnter Choice Again : ");
                        } else {
                            break;
                        }
                    }else {
                        System.out.print("Enter valid choice (between 1 to 6) : ");
                    }
                }


                switch (choice) {
                    case 1:
                        policyCreation();
                        break;

                    case 2:
                        calculatePremium();
                        break;

                    case 3:
                        applyClaim();
                        break;

                    case 4:
                        displayPolicyDetails();
                        break;

                    case 5:
                        displayAllPolicyDetails();
                        break;

                    case 6:
                        System.out.println("Exiting...");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Enter valid choice (1 to 7)!");
                        break;
                }

            } while (choice != 6);
        }


    private static void policyCreation() {
            if (policyCount >= MAX_POLICIES) {
                System.out.println("Policy limit reached. Cannot create more Policies.");
                return;
            }

            System.out.println("\nChoose Policy Type:");
            System.out.println("a. Life Insurance Policy ");
            System.out.println("b. Health Insurance Policy ");
            System.out.println("c. Vehicle Insurance Policy ");

            String type;
            while (true){
                System.out.print("Enter your choice (a/b/c): ");

                type = scanner.next().toLowerCase();

                if(!type.equals("a") && !type.equals("b") && !type.equals("c")){
                    System.out.println("Invalid choice! Please enter only 'a', 'b', or 'c'.");
                }
                else {
                    break;
                }
            }

            String holderName = UtilityAccountMethods.getValidString("Enter Policy Holder Name: ");

            double sumAssured = UtilityAccountMethods.getValidAmount("Enter Assured Amount: ");

//            System.out.print("Enter Start year of policy:");
            int startYear = UtilityAccountMethods.readValidYear();

//            System.out.print("Enter Duration in years:");
//            int duration = UtilityAccountMethods.readPositiveNumber();

            InsurancePolicy newPolicy = null;

            switch (type) {
                case "a":
                    newPolicy = new LifeInsurancePolicy(holderName , sumAssured , startYear );
                    newPolicy.setType("Life Insurance");
                    System.out.println("Life Insurance Policy Created Successfully!");
                    break;

                case "b":
                    newPolicy = new HealthInsurancePolicy(holderName , sumAssured ,startYear);
                    newPolicy.setType("Health Insurance");
                    break;

                case "c":
                    newPolicy = new VehicleInsurancePolicy(holderName , sumAssured ,startYear );
                    newPolicy.setType("Vehicle Insurance");
                    System.out.println("Vehicle Insurance Policy Created Successfully!");
                    break;

                default:
                    System.out.println("Invalid policy type. Returning to main menu...");
                    return;
            }

            policies[policyCount++] = newPolicy;
            System.out.println("Policy created successfully with Policy Number: " + newPolicy.getPolicyNumber());
            System.out.println("Premium " + newPolicy.calculatePremium() + " rs. for " + newPolicy.getDuration() + " Years.");
        }

        private static void calculatePremium(){
            InsurancePolicy policy = findPolicy();
            if (policy != null)
            {
                System.out.println("Original Assured Amount: " + policy.getOriginalSumAssured());
                System.out.println("Remaining Assured Amount: " + policy.getSumAssured());
                System.out.println("Duration : " + policy.getDuration() + " years");

                String.format("%.2f", policy.calculatePremium());

                System.out.println("Premium Amount (per year): " + policy.calculatePremium());
            }else {
                return;
            }
        }

        private static void applyClaim(){

            InsurancePolicy policy = findPolicy();
            if (policy == null) return;

            int currentYear = Year.now().getValue();
            double claimAmount;

            if(policy.getType().equals("Life Insurance")){
                claimAmount = policy.getSumAssured();
            }
            else{
                claimAmount = UtilityAccountMethods.getValidAmount("Enter Amount to be claim:");
                if (policy.getSumAssured() <= 0) {
                    System.out.println("Life Insurance already claimed...");
                    return;
                }
                if(claimAmount > policy.getSumAssured()){
                    System.out.println("Claim amount exceeds the Assured amount");
                    claimAmount = UtilityAccountMethods.getValidAmount("Enter Amount to be claim:");
                }
            }

            if (policy != null)
                policy.claimHandler(currentYear , claimAmount);
        }

    private static void deactivatePolicy() {
    }

        private static void displayPolicyDetails() {
            InsurancePolicy policy = findPolicy();
            if (policy != null)
            {
                System.out.printf("| %-15s | %-15s | %-10s | %-8s | %-8s | %-15s |\n",
                        "Policy Number", "Holder Name", "Sum Assured" , "Start Year" ,"Duration", "Type");
                System.out.println("---------------------------------------------------------------------------------------");

                policy.displayDetails(policy);

            }
        }

        private static void displayAllPolicyDetails() {
            if (policyCount == 0) {
                System.out.println("No accounts available!");
                return;
            }

            System.out.println("\n------------------------------------ All Accounts ------------------------------------");
            System.out.printf("| %-15s | %-15s | %-10s | %-8s | %-8s | %-15s |\n",
                    "Policy Number", "Holder Name", "Sum Assured" , "Start Year" ,"Duration", "Type");
            System.out.println("---------------------------------------------------------------------------------------");

            for (int i = 0; i < policyCount; i++) {
                policies[i].displayDetails(policies[i]);
                System.out.println("---------------------------------------------------------------------------------------");
            }
        }

    static InsurancePolicy findPolicy() {
        System.out.print("Enter Policy Number : ");
        int number = UtilityAccountMethods.readPositiveNumber();
        for (int i = 0; i < policyCount; i++) {
            if (policies[i] != null && policies[i].getPolicyNumber() == number) {
                return policies[i];
            }
        }
        System.out.println("No Policy found with this Policy number " + number);
        return null;
    }


}

