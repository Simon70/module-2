package ss.week7.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FinegrainedIntCell implements IntCell {

	boolean			unconsumedValue;
	int				value;

	final Lock		lock		= new ReentrantLock();
	final Condition	notFull		= lock.newCondition();
	final Condition	notEmpty	= lock.newCondition();

	public FinegrainedIntCell() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setValue(int val) {
		lock.lock();
		try {
			while (unconsumedValue) {
				try {
					notFull.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			value = val;
			unconsumedValue = true;
			notEmpty.signal();
		} finally {
			lock.unlock();
		}
	}

	@Override
	public int getValue() {
		lock.lock();
		try {
			while (!unconsumedValue) {
				try {
					notEmpty.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			unconsumedValue = false;
			notFull.signal();
			return value;
		} finally {
			lock.unlock();
		}
	}

}
