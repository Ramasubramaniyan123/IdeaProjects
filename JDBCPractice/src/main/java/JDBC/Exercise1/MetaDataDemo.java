package JDBC.Exercise1;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MetaDataDemo {
    public static void main(String[] args) throws SQLException {
        String url= "jdbc:mysql://localhost:3306/";
        Connection connection= DriverManager.getConnection(url,"root","Ram@2005");
        DatabaseMetaData metaData=connection.getMetaData();
        System.out.println(metaData.getDatabaseProductName());
        System.out.println(metaData.getDatabaseProductVersion());
        System.out.println(metaData.getDriverName());
        System.out.println(metaData.getDriverVersion());
        System.out.println(metaData.getDriverMajorVersion());
        System.out.println(metaData.getDriverMinorVersion());

    }
}
