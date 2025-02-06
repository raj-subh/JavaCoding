package JavaProject.AirlineReservationSystem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlightService {
    public List<Flight> getAvailableFlights() {
        List<Flight> flights = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM flights WHERE seats_available > 0")) {

            while (rs.next()) {
                flights.add(new Flight(rs.getInt("flight_id"),
                        rs.getString("airline"),
                        rs.getString("departure"),
                        rs.getString("destination"),
                        rs.getInt("seats_available")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flights;
    }
}
