package JavaOOPs.JavaImmutability;

// An object is said to be immutable if its state (data/fields) cannot be modified after it is created.

// Immutable class representing configuration setting
final class BankConfiguration {
    private final String bankName;
    private final String branchCode;
    private final double interestRate;

    // Constructor to initialize fields
    public BankConfiguration(String bankName, String branchCode, double interestRate) {
        this.bankName = bankName;
        this.branchCode = branchCode;
        this.interestRate = interestRate;
    }

    // Only getters (no setters)
    public String getBankName() {
        return this.bankName;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public double getInterestRate() {
        return interestRate;
    }
    // No methods to modify fields, making the object immutable
}

public class ImmutableObj {
    public static void main(String[] args) {
        // Create an immutable BankConfiguration object
        BankConfiguration config = new BankConfiguration("SBI", "SBI007", 4.5);

        // Access data using getters
        System.out.println("Bank Name: " + config.getBankName());
        System.out.println("Branch Code: " + config.getBranchCode());
        System.out.println("Interest Rate: " + config.getInterestRate());

        // Attempting to modify the fields is immpossible because:
        // 1. No setters are available
        // 2. Fields are private and final
        // config.bankName = "ABC Bank"; // Compilation error
    }
}
