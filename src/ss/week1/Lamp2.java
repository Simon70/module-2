package ss.week1;

public class Lamp2 {
	public Lamp2() {
		status = OFF;
	}

	private int status;
	
	public static final int OFF = 0;
	public static final int LOW = 1;
	public static final int MEDIUM = 2;
	public static final int HIGH = 3;
	
	public int getStatus() {
		return status % 4;
	}

	public void changeStatus() {
		status++;
	}
}
