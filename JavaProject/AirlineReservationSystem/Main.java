package JavaProject.AirlineReservationSystem;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FlightService flightService = new FlightService();
        BookingService bookingService = new BookingService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Airline Reservation System!");
        System.out.println("Available Flights:");

        List<Flight> flights = flightService.getAvailableFlights();
        for (Flight flight : flights) {
            System.out.println(flight.getFlightId() + " - " + flight.getAirlin() +
                    " | From: " + flight.getDeparture() +
                    " | To: " + flight.getDestination() +
                    " | Seats: " + flight.getSeatsAvailable());
        }

        System.out.println("Enter your User ID: ");
        int userID = scanner.nextInt();
        System.out.println("Enter Flight ID  to book: ");
        int flightId = scanner.nextInt();

        Thread bookingThread = new Thread(() -> {
            boolean success = bookingService.bookFlight(userID, flightId);

            if (success) {
                System.out.println("Booking successful!");
            } else {
                System.out.println("Booking failed!");
            }
        });

        bookingThread.start();
        try {
            bookingThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}
