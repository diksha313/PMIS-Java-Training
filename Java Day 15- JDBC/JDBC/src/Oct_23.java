import java.sql.*;

public class Oct_23 {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/pmis";
        String username = "root";
        String password = "IchbinDeutscher2022";
        String query = "SELECT * FROM demo";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Drivers loaded successfully!!!");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver error: " + e.getMessage());
        }

        try (Connection con = DriverManager.getConnection(url, username, password);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("Connection Established Successfully !!");

            while (rs.next()) {
                int id = rs.getInt("EmpID");
                String name = rs.getString("Emp Name");
                double salary = rs.getDouble("Salary");

                System.out.println();
                System.out.println("======================");
                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Salary: " + salary);
            }

            System.out.println();
            System.out.println("Connection Closed Successfully!!!!");

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}