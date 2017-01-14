package ss.week7.threads;

import ss.week7.account.Account;

public class AccountSync {

	private static final double	AMOUNT	= 200;
	private static final int	TIMES	= 100;

	public AccountSync() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Account account1 = new Account();

		MyThread myThread1 = new MyThread(-AMOUNT, TIMES, account1);
		myThread1.start();
		
		MyThread myThread2 = new MyThread(AMOUNT, TIMES, account1);
		myThread2.start();

		try {
			myThread1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			myThread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Balance " + account1.getBalance());
	}

}
