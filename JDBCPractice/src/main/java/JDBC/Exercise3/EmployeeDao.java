package JDBC.Exercise3;

import java.sql.*;

public class EmployeeDao {

    private final String url = "jdbc:mysql://localhost:3306/testdb";
    private final String user = "root";
    private final String password = "Ram@2005";

    public void addEmployee(String name, double salary) {
        if (name == null || !name.matches("[A-Za-z ]+") || salary <= 0) {
            System.out.println("Invalid employee data");
            return;
        }
        String sql = "INSERT INTO employees (name, salary) VALUES (?, ?)";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            preparedStatement.setDouble(2, salary);
            preparedStatement.executeUpdate();
            System.out.println("Employee Added Successfully");
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Employee already exists");
        } catch (SQLException e) {
            System.out.println("Error while adding employee: " + e.getMessage());
        }

    }

    public void updateSalary(int empId, double newSalary) {
        if (empId <= 0 || newSalary <= 0) {
            System.out.println("Invalid input");
            return;
        }
        String sql = "UPDATE employees SET salary = ? WHERE emp_id = ?";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setDouble(1, newSalary);
            preparedStatement.setInt(2, empId);
            int value = preparedStatement.executeUpdate();
            if (value == 0) {
                System.out.println("Employee ID not found");
            } else {
                System.out.println("Employee salary updated");
            }
        } catch (SQLException e) {
            System.out.println("Problem with updating the salary" + e.getMessage());
        }
    }

    public void deleteEmployee(int empId) {
        String sql = "DELETE FROM employees WHERE emp_id = ?";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, empId);
            int rows = ps.executeUpdate();
            if (rows == 0) {
                System.out.println("Employee ID not found");
            } else {
                System.out.println("Employee deleted successfully");
            }
        } catch (SQLException e) {
            System.out.println("Error while deleting employee: " + e.getMessage());
        }
    }

    public void listEmployees() {
        String sql = "SELECT emp_id, name, salary FROM employees";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("EmpID | Name | Salary");
            System.out.println("----------------------");

            while (rs.next()) {
                System.out.printf(
                        "%d | %s | %.2f%n",
                        rs.getInt("emp_id"),
                        rs.getString("name"),
                        rs.getDouble("salary")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error while listing employees: " + e.getMessage());
        }
    }


    public void removeDuplicates() {
        String sql =
                "DELETE e1 FROM employees e1 JOIN employees e2 ON e1.name = e2.name AND e1.emp_id > e2.emp_id";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            int deletedRows = preparedStatement.executeUpdate();
            if (deletedRows == 0) {
                System.out.println("No duplicate records found");
            } else {
                System.out.println("Duplicate records removed: " + deletedRows);
            }

        } catch (SQLException e) {
            System.out.println("Error while removing duplicates: " + e.getMessage());
        }

    }

    public void orderByName() {
        String sql = "SELECT emp_id, name, salary FROM employees ORDER BY name";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            System.out.println("Employees ordered by name:");
            while (rs.next()) {
                System.out.printf(
                        "%d | %s | %.2f%n",
                        rs.getInt("emp_id"),
                        rs.getString("name"),
                        rs.getDouble("salary")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error while ordering employees: " + e.getMessage());
        }
    }


    public void findById(int empId) {
        if (empId <= 0) {
            System.out.println("Invalid employee ID");
            return;
        }
        String sql = "SELECT emp_id, name, salary FROM employees WHERE emp_id = ?";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, empId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    System.out.printf(
                            "Employee Found → %d | %s | %.2f%n",
                            rs.getInt("emp_id"),
                            rs.getString("name"),
                            rs.getDouble("salary")
                    );
                } else {
                    System.out.println("No employee found with ID: " + empId);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error while finding employee: " + e.getMessage());
        }
    }


}