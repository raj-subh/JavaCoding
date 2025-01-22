package JavaFileHandling;

import java.io.*;
import java.util.*;

class Book implements Serializable {
    private String name;
    private String author;
    private String isbn;
    private double price;

    public Book(String name, String author, String isbn, double price) {
        this.name = name;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return "Book Name: " + name + "\n" +
                "Author: " + author + "\n" +
                "ISBN: " + isbn + "\n" +
                "Price: \u20b9" + price + "\n" +
                "-----------------------------";
    }
}

public class EnhancedSystem {
    private static final String FILE_NAME = "library_books.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Enhanced Library Management System ===");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book by ISBN");
            System.out.println("4. Delete Book by ISBN");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addBook(scanner);
                case 2 -> viewBooks();
                case 3 -> searchBook(scanner);
                case 4 -> deleteBook(scanner);
                case 5 -> {
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to add a book
    private static void addBook(Scanner scanner) {
        try {
            System.out.print("Enter Book Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Author Name: ");
            String author = scanner.nextLine();

            System.out.print("Enter ISBN: ");
            String isbn = scanner.nextLine();

            System.out.print("Enter Price: ");
            double price = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            Book book = new Book(name, author, isbn, price);
            List<Book> books = readBooks();
            books.add(book);
            writeBooks(books);

            System.out.println("Book added successfully!");
        } catch (Exception e) {
            System.out.println("An error occurred while adding the book.");
            e.printStackTrace();
        }
    }

    // Method to view all books
    private static void viewBooks() {
        try {
            List<Book> books = readBooks();
            if (books.isEmpty()) {
                System.out.println("No books found.");
            } else {
                System.out.println("\n=== List of Books ===");
                books.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println("An error occurred while reading the books.");
            e.printStackTrace();
        }
    }

    // Method to search for a book by ISBN
    private static void searchBook(Scanner scanner) {
        try {
            System.out.print("Enter ISBN to search: ");
            String isbn = scanner.nextLine();

            List<Book> books = readBooks();
            boolean found = false;
            for (Book book : books) {
                if (book.getIsbn().equals(isbn)) {
                    System.out.println("\nBook Found:\n" + book);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("No book found with ISBN: " + isbn);
            }
        } catch (Exception e) {
            System.out.println("An error occurred while searching for the book.");
            e.printStackTrace();
        }
    }

    // Method to delete a book by ISBN
    private static void deleteBook(Scanner scanner) {
        try {
            System.out.print("Enter ISBN to delete: ");
            String isbn = scanner.nextLine();

            List<Book> books = readBooks();
            boolean removed = books.removeIf(book -> book.getIsbn().equals(isbn));

            if (removed) {
                writeBooks(books);
                System.out.println("Book deleted successfully!");
            } else {
                System.out.println("No book found with ISBN: " + isbn);
            }
        } catch (Exception e) {
            System.out.println("An error occurred while deleting the book.");
            e.printStackTrace();
        }
    }

    // Helper method to read books from file
    @SuppressWarnings("unchecked")
    private static List<Book> readBooks() {
        List<Book> books = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            books = (List<Book>) ois.readObject();
        } catch (FileNotFoundException e) {
            // Ignore if file does not exist
        } catch (Exception e) {
            System.out.println("An error occurred while reading from file.");
            e.printStackTrace();
        }
        return books;
    }

    // Helper method to write books to file
    private static void writeBooks(List<Book> books) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(books);
        } catch (Exception e) {
            System.out.println("An error occurred while writing to file.");
            e.printStackTrace();
        }
    }
}
