package Practice;

import java.sql.*;

public class UtilityMethods {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/jdbc";
    private static final String USER = "student";
    private static final String PASSWORD = "Ram@2005";

    public void insert(String firstname, String lastname, String email, String department, double salary) {

        String sql = "INSERT INTO employees (firstname, lastname, email, department, salary) " + "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, firstname);
            ps.setString(2, lastname);
            ps.setString(3, email);
            ps.setString(4, department);
            ps.setDouble(5, salary);

            ps.executeUpdate();
            System.out.println("Employee inserted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateSalary(int id, double salary) {

        String sql = "UPDATE employees SET salary = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDouble(1, salary);
            ps.setInt(2, id);

            ps.executeUpdate();
            System.out.println("Employee updated successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {

        String sql = "DELETE FROM employees WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Employee deleted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getFirstName(int id) {
        String sql = "call procedure1(?,?)";
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             CallableStatement callableStatement = connection.prepareCall(sql)) {
            callableStatement.setInt(1, id);
            callableStatement.registerOutParameter(2, Types.VARCHAR);
            callableStatement.execute();
            String name = callableStatement.getString(2);
            System.out.println(name);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printAll() {

        String sql = "SELECT * FROM employees";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.printf("%-5s %-15s %-15s %-30s %-15s %-10s%n", "ID", "FIRST NAME", "LAST NAME", "EMAIL", "DEPARTMENT", "SALARY");
            System.out.println("-----------------------------------------------------------------------------------------------");

            while (rs.next()) {
                System.out.printf("%-5d %-15s %-15s %-30s %-15s %-10.2f%n", rs.getInt("id"), rs.getString("firstname"), rs.getString("lastname"), rs.getString("email"), rs.getString("department"), rs.getDouble("salary"));
            }

            System.out.println("-----------------------------------------------------------------------------------------------");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
