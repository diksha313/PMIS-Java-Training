import java.sql.*;

public class select {
    public static void main(String[] args) throws ClassNotFoundException {

        String url = "jdbc:mysql://localhost:3306/pmis";
        String username = "root";
        String password = "IchbinDeutscher2022";
        String query = "SELECT * FROM demo";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // or "com.mysql.jdbc.Driver" as in older drivers
            System.out.println("Drivers loaded successfully!!!");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Established Successfully !!");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

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

            rs.close();
            stmt.close();
            con.close();
            System.out.println();
            System.out.println("Connection Closed Successfully!!!!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
