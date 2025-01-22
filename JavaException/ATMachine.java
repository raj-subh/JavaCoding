package JavaException;

import java.util.Scanner;

// Main class
public class ATMachine {
    private double balance;
    private final String pin;

    // Constructor to initialize balance and PIN
    public ATMachine(double initialBalance, String pin) {
        this.balance = initialBalance;
        this.pin = pin;
    }

    // Method to check balance
    public void checkBalance() {
        System.out.println("Your current balance is: ₹" + balance);
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than zero.");
        }
        balance += amount;
        System.out.println("Successfully deposited ₹" + amount + ". Updated balance: ₹" + balance);
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than zero.");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient balance. Available balance: ₹" + balance);
        }
        balance -= amount;
        System.out.println("Successfully withdrew ₹" + amount + ". Updated balance: ₹" + balance);
    }

    // Method to verify PIN
    public boolean verifyPin(String inputPin) {
        return pin.equals(inputPin);
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize ATM with default balance and PIN
        ATMachine atm = new ATMachine(5000.0, "1234");
        boolean authenticated = false;

        System.out.println("Welcome to the ATM Machine!");

        // Authenticate user
        for (int attempts = 0; attempts < 3; attempts++) {
            System.out.print("Enter your PIN: ");
            String inputPin = scanner.nextLine();

            if (atm.verifyPin(inputPin)) {
                authenticated = true;
                break;
            } else {
                System.out.println("Incorrect PIN. Please try again.");
            }
        }

        if (!authenticated) {
            System.out.println("Too many incorrect attempts. Exiting...");
            System.exit(0);
        }

        // Display menu and handle operations
        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");

            try {
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1: // Check balance
                        atm.checkBalance();
                        break;

                    case 2: // Deposit money
                        System.out.print("Enter the amount to deposit: ₹");
                        double depositAmount = scanner.nextDouble();
                        atm.deposit(depositAmount);
                        break;

                    case 3: // Withdraw money
                        System.out.print("Enter the amount to withdraw: ₹");
                        double withdrawalAmount = scanner.nextDouble();
                        atm.withdraw(withdrawalAmount);
                        break;

                    case 4: // Exit
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InsufficientFundsException e) {
                System.out.println("Error: " + e.getMessage());

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());

            } catch (Exception e) {
                System.out.println("Error: Invalid input. Please try again.");
                scanner.nextLine(); // Clear the invalid input

                scanner.close();
            }
        }
    }
}

// Custom exception for insufficient funds
class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
