package ss.week7.threads;

import java.util.concurrent.locks.ReentrantLock;

public class TestSyncConsole extends Thread {

	private static ReentrantLock lock = new ReentrantLock();
	
	public TestSyncConsole(String name) {
		super(name);
	}

	public static void main(String[] args) {
		TestSyncConsole testConsole = new TestSyncConsole("Thread A");
		testConsole.start();
		testConsole = new TestSyncConsole("Thread B");
		testConsole.start();
	}

	@Override
	public void run() {
		sum();
	}

	private void sum() {
		lock.lock();
		int frst = SyncConsole.readInt(this.getName() + "  First int");
		int scnd = SyncConsole.readInt(this.getName() + "  Second int");
		SyncConsole.println(this.getName() + ": " + Integer.toString(frst + scnd));
		lock.unlock();
	}
}
