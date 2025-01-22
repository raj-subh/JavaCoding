package JavaOOPs.Oops4Pillars;

// Definition: Hiding implementation details and showing only essential features using abstract classes or interfaces.

// Real-World Example: The bank system has different account types, but the user only sees high-level methods like deposit() and withdraw(). Implementation is hidden.

// Abstract class to represent a Bank Account
abstract class AbstractBankAccount {
    protected String accountNumber;
    protected String accountHolderName;
    protected double balance;

    public AbstractBankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    // Abstract methods to be implemented by subclass
    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);

    // Concrete method
    public void displayBalance() {
        System.out.println("Account Balance: " + balance);
    }
}

// Concrete class for Savings Account
class SavingsAccountWithAbstraction extends AbstractBankAccount {
    public SavingsAccountWithAbstraction(String accountNumber, String accountHolderName, double balance) {
        super(accountNumber, accountHolderName, balance);
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);

        } else {
            System.out.println("Insufficient balance!");
        }
    }
}

// Absrtaction in action
public class Abstraction {
    public static void main(String[] args) {
        AbstractBankAccount savingsAccount = new SavingsAccountWithAbstraction("12345", "Subhash", 5000);

        savingsAccount.deposit(2000);
        savingsAccount.withdraw(1000);
        savingsAccount.displayBalance();
    }
}
