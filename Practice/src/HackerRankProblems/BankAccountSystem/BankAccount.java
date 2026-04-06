package HackerRankProblems.BankAccountSystem;

class BankAccount {
    private int balance;
    private final TransactionHistory history;
    private final BankAccountCaretaker caretaker;

    public BankAccount(TransactionHistory history, BankAccountCaretaker caretaker) {
        this.balance = 0;
        this.history = history;
        this.caretaker = caretaker;
    }

    //todo : implement
    public void deposit(int amount) {
        BankAccountBalance newBalance = new BankAccountBalance(this.balance);
        caretaker.saveBalance(newBalance);
        this.balance = this.balance + amount;
        Transaction transaction = new Transaction(amount);
        history.addTransaction(transaction);
    }

    //todo : implement
    public void withdraw(int amount) {
        if (this.balance < amount) {
            return;
        }
        BankAccountBalance newBalance = new BankAccountBalance(this.balance);
        caretaker.saveBalance(newBalance);
        this.balance = this.balance - amount;
        Transaction transaction = new Transaction(amount);
        history.addTransaction(transaction);
    }

    //todo : implement
    public void undo() {
        BankAccountBalance previousBalance = caretaker.restoreBalance();
        if (previousBalance == null) {
            return;
        }
        this.balance = previousBalance.getBalance();
    }

    public int getBalance() {
        return this.balance;
    }

}