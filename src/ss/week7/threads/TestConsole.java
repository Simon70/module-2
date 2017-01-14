package ss.week7.threads;

public class TestConsole extends Thread {

	public TestConsole(String name) {
		super(name);
	}


	public static void main(String[] args) {
		TestConsole testConsole = new TestConsole("Thread A");
		testConsole.start();
		testConsole = new TestConsole("Thread B");
		testConsole.start();
	}
	
	@Override
	public void run() {
		sum();
	}

	private void sum() {
		int frst = Console.readInt(this.getName() + "  First int");
		int scnd = Console.readInt(this.getName() + "  Second int");
		Console.println(this.getName() + ": " + Integer.toString(frst + scnd));
	}
}
