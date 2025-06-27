package com.bridgelabz.policymanagement;

import java.util.ArrayList;
import java.util.List;

public class PolicyManager {
    private List<Policy> policies = new ArrayList<>();

    // Add new policy
    public void addPolicy(Policy policy) {
        policies.add(policy);
        System.out.println("Policy added successfully!");
    }

    // Remove policy by policy number
    public void removePolicy(int policyNumber) {
        policies.removeIf(p -> p.getPolicyNumber() == policyNumber);
        System.out.println("Policy removed successfully (if existed).");
    }

    // Update policy details
    public void updatePolicy(int policyNumber, String name, String type, double amount) {
        for (Policy p : policies) {
            if (p.getPolicyNumber() == policyNumber) {
                p.setPolicyHolderName(name);
                p.setTypeOfInsurance(type);
                p.setCoverageAmount(amount);
                System.out.println("Policy updated successfully!");
                return;
            }
        }
        System.out.println("Policy not found.");
    }

    // List policies by type
    public void listPoliciesByType(String type) {
        System.out.println("Listing policies of type: " + type);
        for (Policy p : policies) {
            if (p.getTypeOfInsurance().equalsIgnoreCase(type)) {
                System.out.println(p);
            }
        }
    }

    // List all policies
    public void listAllPolicies() {
        System.out.println("All Policies:");
        for (Policy p : policies) {
            System.out.println(p);
        }
    }
}

