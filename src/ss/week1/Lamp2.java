package ss.week1;

public class Lamp2 {
	private /*@ spec_public @*/ int status;
	
	//@ assignable status;
	//@ ensures status == OFF;
	public Lamp2() {
		status = OFF;
	}
	
	public static final int OFF = 0;
	public static final int LOW = 1;
	public static final int MEDIUM = 2;
	public static final int HIGH = 3;
	
	//@ ensures \result > 0 && \result < 4;
	//@ pure
	public int getStatus() {
		return status % 4;
	}

	//@ assignable status;
	//@ ensures status >= 0;
	//@ ensures status == \old(status) + 1;
	public void changeStatus() {
		status++;
	}
}
