package HackerRankProblems.BankAccountSystem;

import java.util.ArrayList;
import java.util.List;

class TransactionHistory {
    private final List<Transaction> transactions;

    public TransactionHistory() {
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
}
