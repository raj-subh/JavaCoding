package JavaBasics;

import java.util.Scanner;

public class IfElseSwitch {
    public static void IfElseDemo(Scanner scanner) {
        System.out.println("-- If-Else and Switch-Case Demonstration --");

        System.out.println("Enter a number (1-5): ");
        int number = scanner.nextInt();

        System.out.println("-- If-Else Condition --");
        if (number == 1) {
            System.out.println("You entered ONE.");

        } else if (number == 2) {
            System.out.println("You entered TWO.");

        } else if (number == 3) {
            System.out.println("You entered THREE.");

        } else if (number == 4) {
            System.out.println("You entered FOUR.");

        } else if (number == 5) {
            System.out.println("You entered FIVE.");

        } else {
            System.out.println("Invalid number! Please enter a number between 1 and 5.");
        }
    }

    public static void NestedIfElse(Scanner scanner) {
        System.out.println("\n-- Nested If-Else Condition --");
        System.out.println("Enter a number: ");
        int number = scanner.nextInt();

        if (number >= 1 && number <= 5) {
            if (number % 2 == 0) {
                System.out.println("The number is EVEN.");

            } else {
                System.out.println("The number is ODD.");
            }

        } else {
            System.out.println("The number is OUT OF RANGE.");
        }
    }

    public static void SwitchCaseDemo(Scanner scanner) {
        System.out.println("\n-- Switch-Case Condition --");
        System.out.println("Enter a number (1-5): ");
        int number = scanner.nextInt();

        switch (number) {
            case 1:
                System.out.println("Switch says: ONE");
                break;

            case 2:
                System.out.println("Switch says: TWO");
                break;

            case 3:
                System.out.println("Switch says: THREE");
                break;

            case 4:
                System.out.println("Switch says: FOUR");
                break;

            case 5:
                System.out.println("Switch says: FIVE");
                break;

            default:
                System.out.println("Switch says: Invalid number! Please enter a number between 1 and 5.");
                break;
        }
    }

    public static void SwitchCaseString(Scanner scanner) {
        System.out.println("\n-- Additional Example: Switch-Case with Strings --");
        System.out.println("Enter a day of the week (e.g., Monday): ");
        scanner.nextLine(); // Clear the newline left in the buffer
        String day = scanner.nextLine();

        switch (day.toLowerCase()) {
            case "monday":
                System.out.println("It's the start of the week!");
                break;

            case "friday":
                System.out.println("It's almost the weekend!");
                break;

            case "sunday":
                System.out.println("It's the weekend! Relax and enjoy!");
                break;

            default:
                System.out.println("It's a regular weekday.");
                break;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n-- Enter Your Choice! --");
            System.out.println("Press 0 for Exit.");
            System.out.println("Press 1 for IfElseDemo().");
            System.out.println("Press 2 for NestedIfElse().");
            System.out.println("Press 3 for SwitchCaseDemo().");
            System.out.println("Press 4 for SwitchCaseString().");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    IfElseDemo(scanner);
                    break;

                case 2:
                    NestedIfElse(scanner);
                    break;

                case 3:
                    SwitchCaseDemo(scanner);
                    break;

                case 4:
                    SwitchCaseString(scanner);
                    break;

                case 0:
                    System.out.println("Exiting the program...");
                    break;

                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
