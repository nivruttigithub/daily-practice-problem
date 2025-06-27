package com.bridgelabz;

import com.bridgelabz.policymanagement.Policy;
import com.bridgelabz.policymanagement.PolicyManager;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Policy Management Application" );
        PolicyManager manager = new PolicyManager();

        // Adding policies
        manager.addPolicy(new Policy(101, "Nivrutti", "Health", 500000));
        manager.addPolicy(new Policy(102, "Rohit", "Auto", 200000));
        manager.addPolicy(new Policy(103, "Virat", "Life", 1000000));

        // Listing all
        manager.listAllPolicies();

        // Update a policy
        manager.updatePolicy(102, "Rohit Updated", "Auto", 250000);

        // Remove a policy
        manager.removePolicy(101);

        // List by type
        manager.listPoliciesByType("Auto");
    }
}
