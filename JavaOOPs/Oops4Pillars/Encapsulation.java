package JavaOOPs.Oops4Pillars;

// Definition: Wrapping data (fields) and methods (operations) into a single unit (class) and restricting direct access to the fields by using access modifiers.

// Real-World Example: Bank Account - A user cannot directly access or modify the account balance but can do so via deposit() or withdraw() methods.

class BankAccount {
    // Private fields to achieve encapsulation
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    // Public getter and setter methods to access private fields
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposted. New balance: " + balance);

        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn. New balance: " + balance);

        } else {
            System.out.println("Invalid withdrawl amount or insufficient balance.");
        }
    }
}

public class Encapsulation {
    public static void main(String[] args) {
        BankAccount bankAccount1 = new BankAccount("12345678910", "Subhash Kumar", 5000);

        System.out.println(bankAccount1.getAccountNumber());

        System.out.println(bankAccount1.getAccountHolderName());

        System.out.println(bankAccount1.getBalance());

        bankAccount1.deposit(1000);
        bankAccount1.withdraw(500);

        System.out.println(bankAccount1.getBalance());
    }
}
