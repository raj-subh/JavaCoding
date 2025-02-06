package JavaProject.AirlineReservationSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/AirlineDB";
    private static final String USER = "root";
    private static final String PASSWORD = "subhashkumar@2003";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Database connection fialed!");
            e.printStackTrace();
            return null;
        }
    }
}
