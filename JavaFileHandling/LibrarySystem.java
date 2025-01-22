package JavaFileHandling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LibrarySystem {
    private static final String FILE_NAME = "library_books.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Library Management System ===");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Exit");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newLine

            switch (choice) {
                case 1:
                    addBook(scanner);
                    break;

                case 2:
                    viewBooks();
                    break;

                case 3:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    // Method to add a book to the file
    private static void addBook(Scanner scanner) {
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            System.out.println("Enter Book Name: ");
            String bookName = scanner.nextLine();

            System.out.println("Enter Author Name: ");
            String authorName = scanner.nextLine();

            System.out.println("Enter ISBN: ");
            String isbn = scanner.nextLine();

            System.out.println("Enter Price: ");
            double price = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            // Write book details to file
            writer.write(bookName + ", " + authorName + ", " + isbn + ", " + price + "\n");
            System.out.println("Book added successfully!");

        } catch (IOException e) {
            System.out.println("An error occurred while adding the book.");
            e.printStackTrace();
        }
    }

    // Method to view all books from the file
    private static void viewBooks() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\n=== List of Books ===");

            while ((line = reader.readLine()) != null) {
                String[] bookDetails = line.split(", ");
                System.out.println("Book Name: " + bookDetails[0]);
                System.out.println("Author Name: " + bookDetails[1]);
                System.out.println("ISBN: " + bookDetails[2]);
                System.out.println("Price: " + bookDetails[3]);
                System.out.println("-------------------------------");
            }
        } catch (FileNotFoundException e) {
            System.out.println("No books found. Please add some books first");

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
}
