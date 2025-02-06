
public class Seat {
    private int seatNumber;
    private boolean isAvailable;

    public Seat(int seatNumber) {
        this.seatNumber = seatNumber;
        this.isAvailable = true;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void bookSeat() {
        isAvailable = false;
    }

    public void cancelSeat() {
        isAvailable = true;
    }

    @Override
    public String toString() {
        return "Seat " + seatNumber + (isAvailable ? " (Available)" : " (Booked)");
    }
}