package JDBC.Exercise5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountService {

    private final String url = "jdbc:mysql://localhost:3306/testdb";
    private final String user = "root";
    private final String password = "Ram@2005";

    public void transfer(int fromAccId, int toAccId, double amount) throws SQLException {
        Connection con = null;
        PreparedStatement checkStmt = null;
        PreparedStatement deductStmt = null;
        PreparedStatement addStmt = null;

        try {
            con = DriverManager.getConnection(url, user, password);
            con.setAutoCommit(false);

            // Step 1: Check balance of source account
            checkStmt = con.prepareStatement("SELECT balance FROM accounts WHERE acc_id = ?");
            checkStmt.setInt(1, fromAccId);
            ResultSet rs = checkStmt.executeQuery();

            if (!rs.next()) {
                System.out.println("Source account not found.");
                con.rollback();
                return;
            }

            double currentBalance = rs.getDouble("balance");
            if (currentBalance < amount) {
                System.out.println("Insufficient funds. Transfer aborted.");
                con.rollback();
                return;
            }

            // Step 2: Deduct from source account
            deductStmt = con.prepareStatement("UPDATE accounts SET balance = balance - ? WHERE acc_id = ?");
            deductStmt.setDouble(1, amount);
            deductStmt.setInt(2, fromAccId);
            int rows1 = deductStmt.executeUpdate();

            // Step 3: Add to destination account
            addStmt = con.prepareStatement("UPDATE accounts SET balance = balance + ? WHERE acc_id = ?");
            addStmt.setDouble(1, amount);
            addStmt.setInt(2, toAccId);
            int rows2 = addStmt.executeUpdate();

            // Step 4: Commit or rollback
            if (rows1 == 1 && rows2 == 1) {
                con.commit();
                System.out.println("Transfer successful.");
            } else {
                con.rollback();
                System.out.println("Transfer failed, rolled back.");
            }
        } catch (SQLException e) {
            if (con != null) {
                try { con.rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
            }
            throw e;
        } finally {
            if (checkStmt != null) checkStmt.close();
            if (deductStmt != null) deductStmt.close();
            if (addStmt != null) addStmt.close();
            if (con != null) {
                con.setAutoCommit(true);
                con.close();
            }
        }
    }

    public void printBalances() throws SQLException {
        String sql = "SELECT acc_id, name, balance FROM accounts";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            System.out.println("Account balances:");
            while (rs.next()) {
                System.out.printf("%d - %s: %.2f%n",
                        rs.getInt("acc_id"),
                        rs.getString("name"),
                        rs.getDouble("balance"));
            }
        }
    }
}