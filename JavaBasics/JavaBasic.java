package JavaBasics;

import java.util.Scanner;

public class JavaBasic {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. If-Else Example: Real-world analogy - Checking age eligibility
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        if (age >= 18) {
            System.out.println("You are eligible to vote.");
        } else {
            System.out.println("You are not eligible to vote.");
        }

        // 2. Switch-Case Example: Real-world analogy - Coffee shop menu
        System.out.print("\nChoose a drink (1: Coffee, 2: Tea, 3: Juice): ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("You chose Coffee.");
                break;
            case 2:
                System.out.println("You chose Tea.");
                break;
            case 3:
                System.out.println("You chose Juice.");
                break;
            default:
                System.out.println("Invalid choice.");
        }

        // 3. For Loop Example: Real-world analogy - Printing numbers from 1 to 5
        System.out.println("\nCounting from 1 to 5 using a for loop:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Number: " + i);
        }

        // 4. While Loop Example: Real-world analogy - Filling a glass of water
        int waterLevel = 0;
        System.out.println("\nFilling the glass with water (while loop):");
        while (waterLevel < 5) {
            System.out.println("Water level: " + waterLevel);
            waterLevel++;
        }
        System.out.println("Glass is full!");

        // 5. Do-While Loop Example: Real-world analogy - At least one dice roll
        System.out.println("\nRolling a dice until we get 6 (do-while loop):");
        int diceRoll;
        do {
            diceRoll = (int) (Math.random() * 6) + 1; // Generates a random number between 1 and 6
            System.out.println("Rolled: " + diceRoll);
        } while (diceRoll != 6);

        // 6. Arrays Example: Real-world analogy - List of student marks
        System.out.println("\nStudent marks in an array:");
        int[] marks = { 85, 90, 78, 92, 88 };
        for (int mark : marks) { // Enhanced for loop for arrays
            System.out.println("Mark: " + mark);
        }

        // 7. Methods Example: Real-world analogy - Calculator addition
        System.out.print("\nEnter two numbers to add: ");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int sum = addNumbers(num1, num2); // Calling a method
        System.out.println("The sum is: " + sum);

        // 8. Classes and Objects Example: Real-world analogy - Bank account
        BankAccount myAccount = new BankAccount("John Doe", 5000);
        myAccount.deposit(2000);
        myAccount.withdraw(1500);
        myAccount.displayBalance();

        scanner.close();
    }

    // Method to demonstrate addition
    public static int addNumbers(int a, int b) {
        return a + b;
    }
}

// Class to demonstrate classes, objects, and methods
class BankAccount {
    private String accountHolderName;
    private double balance;

    // Constructor
    public BankAccount(String name, double initialBalance) {
        this.accountHolderName = name;
        this.balance = initialBalance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    // Method to display balance
    public void displayBalance() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Current Balance: " + balance);
    }
}
