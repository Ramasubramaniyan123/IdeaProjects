package JDBC.Exercise1;

import java.sql.*;

public class MyPractice {

    static String url = "jdbc:mysql://localhost:3306/testdb";
    static String user = "root";
    static String password = "Ram@205";
    static String query = "select * from employees";

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            double salary = resultSet.getDouble("salary");
            System.out.println(id+"  "+firstName + " " + lastName + " " + salary);
        }
    }
}
