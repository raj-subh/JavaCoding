package JavaOOPs.JavaImmutability;

import java.util.Date;

// Deep Copying for Mutable Fields
// If the class contains mutable fields (e.g., a Date or List), ensure those are handled properly to maintain immutability.

// Code Example with Mutable Field:
final class ImmutableEmployee {
    private final String empName;
    private final Date joiningDate; // Mutable field

    public ImmutableEmployee(String empName, Date joiningDate) {
        this.empName = empName;
        this.joiningDate = new Date(joiningDate.getTime());
    }

    public String getName() {
        return empName;
    }

    public Date getJoiningDate() {
        // Return a defensive copy to prevent external modification
        return new Date(joiningDate.getTime());
    }
}

public class DefensiveCopy {
    public static void main(String[] args) {
        Date date = new Date();
        ImmutableEmployee employee = new ImmutableEmployee("Ankita Subhash", date);

        System.out.println("Employee Name: " + employee.getName());

        System.out.println("Joining Date: " + employee.getJoiningDate());

        // Attempt to modify the date object
        date.setTime(date.getTime() + 10000000000L);

        // The original joining date remains unaffected
        System.out.println("Modified Date: " + date);

        System.out.println("Employee's Joining Date: " + employee.getJoiningDate());
    }
}
