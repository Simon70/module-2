package ss.week7.account;

public class Account {
    private double balance = 0.0;

    public synchronized void transaction(double amount) {
        balance = balance + amount;
    }

    public double getBalance() {
        return balance;

    }
}
