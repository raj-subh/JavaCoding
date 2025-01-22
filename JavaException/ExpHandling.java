package JavaException;

import java.util.Scanner;

public class ExpHandling {
    // Method to demonstrate checked exception
    public static void demonstrateCheckedException() throws InterruptedException {
        System.out.println("Simulating a checked exception using Thread.sleep...");
        Thread.sleep(1000); // Throws InterruptedException
        System.out.println("Thread woke up after 1 second!");
    }

    // Method to demonstrate unchecked exception
    public static int demonstrateUncheckedException(int[] arr, int idx) {
        return arr[idx]; // May thros ArrayIndexOutOfBoundsException
    }

    // Method to demonstrate custom exception
    public static void demonstrateCustomException(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above to register.");
        } else {
            System.out.println("Registration Successful!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Example 1: Handling unchecked exception
        System.out.println("Handling ArrayIndexOutOfBoundsException");
        try {
            int[] nums = { 1, 2, 3 };
            System.out.println("Enter an index to access the array: ");

            int idx = scanner.nextInt();
            System.out.println("Value at idx: " + idx + ": " + demonstrateUncheckedException(nums, idx));

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Index out of bounds. Please enter a valid index.");
        }

        // Example 2: Handling checked exception
        System.out.println("Handling InterruptedException");
        try {
            demonstrateCheckedException();
        } catch (InterruptedException e) {
            System.out.println("Error: Thread was Interrupted!");
        }

        // Example 3: using finally block
        System.out.println("Using Finally Block");
        try {
            System.out.println("Enter a number to divide 100: ");
            int divisor = scanner.nextInt();
            System.out.println("Result: " + (100 / divisor));

        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");

        } finally {
            System.out.println("Finally block executed: Cleaning up resources.");
        }

        // Example 4: Throwing a custom exception
        System.out.println("Throwing a custom exception");
        try {
            System.out.println("Enter your age: ");
            int age = scanner.nextInt();

            demonstrateCustomException(age);

        } catch (InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
        System.out.println("Program Execution Completed...");
    }
}

// custom exception class
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}