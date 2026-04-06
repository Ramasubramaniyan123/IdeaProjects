package JDBC.Exercise1;

import java.sql.*;

public class ReadEmployees {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "Ram@2005";

    private static final String SQL_SELECT_ALL =
            "SELECT id, first_name, last_name, salary FROM employees";

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(SQL_SELECT_ALL)) {

            System.out.println("EMPLOYEE DETAILS");
            System.out.println("----------------------------------------------------");
            System.out.printf("%-5s %-15s %-15s %-10s%n",
                    "ID", "First Name", "Last Name", "Salary");
            System.out.println("----------------------------------------------------");

            while (rs.next()) {
                long id = rs.getLong("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                double salary = rs.getDouble("salary");

                System.out.printf("%-5d %-15s %-15s %-10.2f%n",
                        id, firstName, lastName, salary);
            }

            System.out.println("----------------------------------------------------");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
