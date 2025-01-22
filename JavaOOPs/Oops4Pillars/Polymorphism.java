package JavaOOPs.Oops4Pillars;

// Definition: The ability of an object to take many forms. Polymorphism can be compile-time (method overloading) or runtime (method overriding).

// Real-World Example: Different account types (SavingsAccount, CurrentAccount) have different implementations for calculating interest.

// Base class
class Account {
    protected String accountType;

    public Account(String accountType) {
        this.accountType = accountType;
    }

    // Method to calculate interest (overriden in subclass)
    public double calculateInterest(double balance) {
        return 0; // Default implementation
    }
}

// Subclass 1: Savings Account
class SavingsAccount extends Account {
    private static final double INTEREST_RATE = 0.04; // 4% annual interest

    public SavingsAccount() {
        super("Savings");
    }

    @Override
    public double calculateInterest(double balance) {
        return balance * INTEREST_RATE;
    }
}

// Subclass 2: Current Account
class CurrentAccount extends Account {
    private static final double MIN_BALANCE_FEE = 500;

    public CurrentAccount() {
        super("Current");
    }

    @Override
    public double calculateInterest(double balance) {
        return balance >= MIN_BALANCE_FEE ? balance * 0.02 : 0; // 2% interest if balance > 500
    }
}

// Polymorphism in action
public class Polymorphism {
    public static void main(String[] args) {
        Account savings = new SavingsAccount();
        Account current = new CurrentAccount();

        System.out.println("Savings Account Interest: " + savings.calculateInterest(10000));

        System.out.println("Current Account Interest: " + current.calculateInterest(10000));
    }
}
