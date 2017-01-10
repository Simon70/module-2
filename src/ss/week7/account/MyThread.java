package ss.week7.account;

/**
 * Created by simon on 09.01.17.
 */
public class MyThread extends Thread {

    private double amount;
    private int frequency;
    private int times;
    private Account account;

    public MyThread(double amount, int frequency, int times, Account account) {
        this.amount = amount;
        this.frequency = frequency;
        this.times = times;
        this.account = account;
    }

    public static void main(String[] args) {

        Account account = new Account();
        System.out.println("Balance: " + account.getBalance());
        MyThread t1 = new MyThread(100d, 1, 10000, account);
        MyThread t2 = new MyThread(-100d, 1, 10000, account);

        System.out.print("Starting...");

        t1.start();
        t2.start();

        System.out.println("DONE!");

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Balance: " + account.getBalance());
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < times; i++) {
                account.transaction(amount);
                Thread.sleep(frequency);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
