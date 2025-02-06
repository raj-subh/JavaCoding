
import java.util.ArrayList;
import java.util.List;

public class Movie {
    private String title;
    private String genre;
    private int duration; // in minutes
    private List<String> showtimes;

    public Movie(String title, String genre, int duration, List<String> showtimes) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.showtimes = new ArrayList<>(showtimes);
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getDuration() {
        return duration;
    }

    public List<String> getShowtimes() {
        return new ArrayList<>(showtimes);
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Genre: " + genre + ", Duration: " + duration + " mins, Showtimes: " + showtimes;
    }
}