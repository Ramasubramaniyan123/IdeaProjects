package HackerRankProblems.BankAccountSystem;


import java.util.ArrayList;
import java.util.List;

class BankAccountCaretaker {
    private final List<BankAccountBalance> balanceHistory = new ArrayList<>();

    //todo : implement
    public void saveBalance(BankAccountBalance balance) {
        balanceHistory.add(balance);
    }

    //todo : implement
    public BankAccountBalance restoreBalance() {
        // Write code
        if (balanceHistory.isEmpty()) {
            return null;
        }
        return balanceHistory.remove(balanceHistory.size() - 1);
    }
}