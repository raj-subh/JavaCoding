package JavaProject.AirlineReservationSystem;

public class Flight {
    private int flightId;
    private String airline;
    private String departure;
    private String destination;
    private int seatsAvailable;

    public Flight(int flightId, String airline, String departure, String destination, int seatsAvailable) {
        this.flightId = flightId;
        this.airline = airline;
        this.departure = departure;
        this.destination = destination;
        this.seatsAvailable = seatsAvailable;
    }

    public int getFlightId() {
        return flightId;
    }

    public String getAirlin() {
        return airline;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public void bookSeat() {
        this.seatsAvailable--;
    }
}
