package com.bridgelabz.policymanagement;

public class Policy {
    private int policyNumber;
    private String policyHolderName;
    private String typeOfInsurance; // e.g., health, life, auto
    private double coverageAmount;

    public Policy(int policyNumber, String policyHolderName, String typeOfInsurance, double coverageAmount) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.typeOfInsurance = typeOfInsurance;
        this.coverageAmount = coverageAmount;
    }

    // Getters and Setters
    public int getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyHolderName(String name) {
        this.policyHolderName = name;
    }

    public void setTypeOfInsurance(String type) {
        this.typeOfInsurance = type;
    }

    public void setCoverageAmount(double amount) {
        this.coverageAmount = amount;
    }

    public String getTypeOfInsurance() {
        return typeOfInsurance;
    }

    @Override
    public String toString() {
        return "Policy Number: " + policyNumber + ", Holder: " + policyHolderName +
                ", Type: " + typeOfInsurance + ", Coverage: " + coverageAmount;
    }
}
