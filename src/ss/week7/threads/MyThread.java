package ss.week7.threads;

import ss.week7.account.Account;

public class MyThread extends Thread {

	double	am;
	int		freq;
	Account	acc;

	public MyThread(double amount, int frequency, Account account) {
		am = amount;
		freq = frequency;
		acc = account;
	}

	public void run() {
		for (int i = 0; i < freq; i++) {
			acc.transaction(am);
			System.out.println(acc.getBalance());
		}
	}
}
