package JDBC.Exercise2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MyEmployeeStatementDemo {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "Ram@2005";

        String createSql =
                "CREATE TABLE IF NOT EXISTS employees (" +
                        "emp_id INT PRIMARY KEY AUTO_INCREMENT, " +
                        "name VARCHAR(100) NOT NULL, " +
                        "salary DOUBLE NOT NULL" +
                        ")";
        //Table Creation
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(createSql);
            System.out.println("Creation Done");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        //Insert
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {
            String insert1 = "INSERT INTO employees(name, salary) VALUES ('Alice',50000)";
            String insert2 = "INSERT INTO employees(name, salary) VALUES ('Bob',70000)";
            String insert3 = "INSERT INTO employees(name, salary) VALUES ('John',60000)";
            statement.executeUpdate(insert1);
            statement.executeUpdate(insert2);
            statement.executeUpdate(insert3);
            System.out.println("Data Inserted");
        } catch (SQLException e) {
            System.out.println("Insert failed: " + e.getMessage());
        }

        //Update
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {
            String update = "UPDATE employees SET salary=100000 WHERE emp_id=1";
            int updated = statement.executeUpdate(update);
            System.out.println(updated + " row(s) updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Delete
        try (Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement()){
            String delSql="DELETE FROM EMPLOYEES WHERE NAME= 'Bob' ";
            statement.executeUpdate(delSql);
            System.out.println("Bob deleted");
        }
        catch (SQLException e){
            System.out.println("Delete failed: " + e.getMessage());
        }
    }
}
