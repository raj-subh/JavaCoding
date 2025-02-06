package JavaProject.ATM;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Custom exception for insufficient funds
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

// BankAccount class representing an ATM account
class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private String pin;

    public BankAccount(String accountNumber, String accountHolder, double balance, String pin) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.pin = pin;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public boolean validatePin(String enteredPin) {
        return this.pin.equals(enteredPin);
    }

    public void deposite(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds. Current balance: " + balance);
        }
        balance -= amount;
    }

    public void transfer(BankAccount recipient, double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds for transfer. Current balance: " + balance);
        }
        this.withdraw(amount);
        recipient.deposite(amount);
    }
}

// Interface for transaction logging
interface TransactionLogger {
    void log(String message);
}

// Implementation of TransactionLogger that writes logs to a file
class FileTransactionLogger implements TransactionLogger {
    private String fileName;

    public FileTransactionLogger(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void log(String message) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = LocalDateTime.now().format(formatter);

        try (FileWriter fw = new FileWriter(fileName, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {

            out.println(timestamp + ": " + message);

        } catch (IOException e) {
            System.err.println("Logging error: " + e.getMessage());
            e.printStackTrace(); // Provides detailed error information
        }
    }

}

public class ATMSystem {
    // Map to store multiple bank accounts (account number -> BankAccount)
    private static Map<String, BankAccount> accounts = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    private static TransactionLogger logger = new FileTransactionLogger("transaction.log");

    public static void main(String[] args) {
        // Initialize sample accounts
        accounts.put("12345", new BankAccount("12345", "John Doe", 5000.0, "1111"));
        accounts.put("67890", new BankAccount("67890", "Jane Smith", 8000.0, "2222"));

        System.out.println("Welcome to the ATM System");
        System.out.println("Enter account number: ");
        String accountNumber = scanner.nextLine();
        BankAccount currentAccount = accounts.get(accountNumber);

        if (currentAccount == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.println("Enter Pin: ");
        String pin = scanner.nextLine();
        if (!currentAccount.validatePin(pin)) {
            System.out.println("Invalid PIN.");
            return;
        }

        // Menu-driven interface using a loop and swith-case
        int choice = 0;
        do {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("Your balance is: " + currentAccount.getBalance());
                    break;

                case 2:
                    System.out.println("Enter deposite amount: ");
                    double depositeAmount = Double.parseDouble(scanner.nextLine());
                    currentAccount.deposite(depositeAmount);
                    logger.log("Deposit successful. New balance: " + currentAccount.getBalance());
                    break;

                case 3:
                    System.out.println("Enter withradrawl amount: ");
                    double withdrawAmount = Double.parseDouble(scanner.nextLine());
                    try {
                        currentAccount.withdraw(withdrawAmount);
                        logger.log("Withdrawal of " + withdrawAmount + " from account"
                                + currentAccount.getAccountNumber());
                        System.out.println("Withdrawal successful. New balance: " + currentAccount.getBalance());
                    } catch (InsufficientFundsException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("Enter recipient account number: ");
                    String recipientAccNo = scanner.nextLine();
                    BankAccount recipient = accounts.get(recipientAccNo);

                    if (recipient == null) {
                        System.out.println("Recipient account not found.");
                        break;
                    }
                    System.out.println("Enter transfer amount: ");
                    double transferAmount = Double.parseDouble(scanner.nextLine());
                    try {
                        currentAccount.transfer(recipient, transferAmount);
                        logger.log(
                                "Transfer of " + transferAmount + " from account " + currentAccount.getAccountNumber());
                        System.out.println("Transfer successful. New balance: " + currentAccount.getBalance());
                    } catch (InsufficientFundsException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using the ATM System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        } while (choice != 5);
    }
}
