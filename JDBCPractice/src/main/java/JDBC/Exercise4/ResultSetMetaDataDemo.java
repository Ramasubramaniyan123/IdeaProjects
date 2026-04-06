package JDBC.Exercise4;


import java.sql.*;

public class ResultSetMetaDataDemo {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "Ram@2005";
        String mysqlQuery = "select emp_id,name,salary from employees order by salary > 60000";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(mysqlQuery);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();
            System.out.println("=== Column Information ===");
            customerInformation(columnCount, resultSetMetaData);
            System.out.println("=== Employee Information ===");
            extracted(resultSet, columnCount, resultSetMetaData);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void customerInformation(int columnCount, ResultSetMetaData resultSetMetaData) throws SQLException {
        for (int i = 1; i <= columnCount; i++) {
            System.out.println("Column " + i + ": " + resultSetMetaData.getColumnName(i) + " (Type: " + resultSetMetaData.getColumnTypeName(i) + ")");
        }
    }

    private static void extracted(ResultSet resultSet, int columnCount, ResultSetMetaData resultSetMetaData) throws SQLException {
        while (resultSet.next()) {
            for (int i = 1; i <= columnCount; i++) {
                String columnName = resultSetMetaData.getColumnName(i);
                Object value = resultSet.getObject(i);
                System.out.print(columnName + " = " + value + " | ");
            }
            System.out.println();
        }
    }
}
