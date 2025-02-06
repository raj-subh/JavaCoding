
// Project Structure
// Classes and Objects:

// Movie: Represents a movie with attributes like title, genre, duration, and showtimes.
// Seat: Represents a seat with attributes like seat number and availability status.
// Theater: Represents a theater with attributes like name, total seats, and a list of Seat objects.
// Reservation: Represents a reservation with attributes like movie, seat, user details, and reservation status.
// User: Represents a user with attributes like name and contact details.
// Core Functionalities:

// Browse Movies: List all available movies with showtimes.
// Select Seats: Display available seats and allow the user to select seats.
// Book Tickets: Confirm and book selected seats for a chosen movie.
import java.util.*;

public class MovieTicketSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sample movies and theaters
        List<Movie> movies = Arrays.asList(
                new Movie("Movie1", "Action", 120, Arrays.asList("10:00 AM", "2:00 PM", "6:00 PM")),
                new Movie("Movie2", "Comedy", 90, Arrays.asList("11:00 AM", "3:00 PM", "7:00 PM")));

        Theater theater = new Theater("Awesome Theater", 10);

        while (true) {
            System.out.println("1. Browse Movies");
            System.out.println("2. Select Seats");
            System.out.println("3. Book Tickets");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    for (Movie movie : movies) {
                        System.out.println(movie);
                    }
                    break;

                case 2:
                    theater.displaySeats();
                    break;

                case 3:
                    System.out.println("Enter movie title: ");
                    scanner.nextLine(); // Consume newline
                    String title = scanner.nextLine();
                    Movie selectedMovie = movies.stream()
                            .filter(movie -> movie.getTitle().equalsIgnoreCase(title))
                            .findFirst()
                            .orElse(null);

                    if (selectedMovie == null) {
                        System.out.println("Movie not found!");
                        break;
                    }

                    System.out.println("Enter seat number: ");
                    int seatNumber = scanner.nextInt();
                    Seat selectedSeat = theater.getSeat(seatNumber);

                    if (selectedSeat == null || !selectedSeat.isAvailable()) {
                        System.out.println("Seat not available!");
                        break;
                    }

                    System.out.println("Enter your name: ");
                    scanner.nextLine(); // Consume newline
                    String userName = scanner.nextLine();
                    System.out.println("Enter your contact: ");
                    String userContact = scanner.nextLine();

                    Reservation reservation = new Reservation(selectedMovie, selectedSeat, userName, userContact);
                    reservation.confirmReservation();
                    System.out.println(reservation);

                    break;

                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}