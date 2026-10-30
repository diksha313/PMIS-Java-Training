import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class test {
    public static void main(String[] args) {
        // Database URL
        String url = "jdbc:mysql://localhost:3306/pmis";

        // Database credentials
        String username = "root";
        String password = "IchbinDeutscher2022";

        // Establish the connection
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the database.");
            System.out.println(connection);

            // Perform database operations here

        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
        }
    }
}


