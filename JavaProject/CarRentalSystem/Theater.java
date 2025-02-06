
import java.util.ArrayList;
import java.util.List;

public class Theater {
    private String name;
    private List<Seat> seats;

    public Theater(String name, int totalSeats) {
        this.name = name;
        this.seats = new ArrayList<>();
        for (int i = 1; i <= totalSeats; i++) {
            seats.add(new Seat(i));
        }
    }

    public String getName() {
        return name;
    }

    public List<Seat> getSeats() {
        return new ArrayList<>(seats);
    }

    public void displaySeats() {
        for (Seat seat : seats) {
            System.out.println(seat);
        }
    }

    public Seat getSeat(int seatNumber) {
        for (Seat seat : seats) {
            if (seat.getSeatNumber() == seatNumber) {
                return seat;
            }
        }
        return null; // or throw an exception
    }
}