package ss.week7.threads;

public class SynchronizedIntCell implements IntCell {

	int		value;
	boolean	unconsumedValue;

	public SynchronizedIntCell() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public synchronized void setValue(int val) {
		try {
			while (unconsumedValue) {
				this.wait();
			}
			value = val;
			unconsumedValue = true;
		} catch (InterruptedException e) {
			value = val;
			unconsumedValue = true;
		}
	}

	@Override
	public synchronized int getValue() {
		unconsumedValue = false;
		this.notifyAll();
		return value;
	}

}
