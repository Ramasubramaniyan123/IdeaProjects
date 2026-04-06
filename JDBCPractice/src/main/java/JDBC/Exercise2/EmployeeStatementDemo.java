package JDBC.Exercise2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeStatementDemo {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testDB";
        String user = "root";
        String password = "Ram@2005";

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement stmt = con.createStatement()) {

            // Ensure table exists (idempotent)
            String createSql =
                    "CREATE TABLE IF NOT EXISTS employees (" +
                            "emp_id INT PRIMARY KEY AUTO_INCREMENT, " +
                            "name VARCHAR(100) NOT NULL, " +
                            "salary DOUBLE NOT NULL" +
                            ")";
            stmt.executeUpdate(createSql);

            // INSERT
            String insertSql1 =
                    "INSERT INTO employees (name, salary) VALUES ('Alice', 60000)";
            String insertSql2 =
                    "INSERT INTO employees (name, salary) VALUES ('Bob', 55000)";
            stmt.executeUpdate(insertSql1);
            stmt.executeUpdate(insertSql2);

            // SELECT
            String querySql = "SELECT emp_id, name, salary FROM employees";
            try (ResultSet rs = stmt.executeQuery(querySql)) {
                System.out.println("Employees:");
                while (rs.next()) {
                    int id = rs.getInt("emp_id");
                    String name = rs.getString("name");
                    double salary = rs.getDouble("salary");
                    System.out.printf("%d, %s, %.2f%n", id, name, salary);
                }
            }

            // UPDATE
            String updateSql =
                    "UPDATE employees SET salary = 65000 WHERE name = 'Alice'";
            int updated = stmt.executeUpdate(updateSql);
            System.out.println(updated + " row(s) updated.");

            // DELETE
            String deleteSql =
                    "DELETE FROM employees WHERE name = 'Bob'";
            int deleted = stmt.executeUpdate(deleteSql);
            System.out.println(deleted + " row(s) deleted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}