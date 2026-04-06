package JDBC.Exercise5;

import java.sql.SQLException;

public class AccountDemo {

    public static void main(String[] args) {
        AccountService service = new AccountService();

        try {
            service.printBalances();
            service.transfer(1, 2, 2000);
            service.printBalances();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}