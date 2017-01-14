package ss.week7.account;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {

	Lock					lock		= new ReentrantLock();
	protected double		balance		= 0.0;
	final Condition	isAboveMin	= lock.newCondition();

	public void transaction(double amount) {
		while (balance + amount < -1000 && amount < 0) {
			try {
				System.out.println("wait");
				lock.lock();
				isAboveMin.await();
				lock.unlock();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		lock.lock();
		try {
			balance = balance + amount;
			isAboveMin.signal();
		} finally {
			lock.unlock();
		}
	}

	public double getBalance() {
		lock.lock();
		double result = balance;
		lock.unlock();
		return result;
	}
}
