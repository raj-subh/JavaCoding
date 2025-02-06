
public class Reservation {
    private Movie movie;
    private Seat seat;
    private String userName;
    @SuppressWarnings("unused")
    private String userContact;
    @SuppressWarnings("unused")
    private boolean isConfirmed;

    public Reservation(Movie movie, Seat seat, String userName, String userContact) {
        this.movie = movie;
        this.seat = seat;
        this.userName = userName;
        this.userContact = userContact;
        this.isConfirmed = false;
    }

    public void confirmReservation() {
        if (seat.isAvailable()) {
            seat.bookSeat();
            isConfirmed = true;
        } else {
            System.out.println("Seat is already booked!");
        }
    }

    @Override
    public String toString() {
        return "Reservation for " + movie.getTitle() + " at seat " + seat.getSeatNumber() + " for " + userName;
    }
}