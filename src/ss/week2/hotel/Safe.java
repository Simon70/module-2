package ss.week2.hotel;

public class Safe {

	private /*@ spec_public @*/ String	password;
	private /*@ spec_public @*/ Boolean	active;
	private /*@ spec_public @*/ Boolean open;

	//@ assignable active;
	public void activate(String password) {
		if (password.equals(this.password)) {
			active = true;
		}
	}

	//@ assignable open;
	//@ assignable active;
	public void deactivate() {
		open = false;
		active = false;
	}

	//@ assignable open;
	public void open(String password) {
		if (active && password.equals(this.password)) {
			open = true;
		}
	}

	//@ assignable open;
	public void close() {
		open = false;
	}

	//@ pure
	public Boolean isActive() {
		return active;
	}

	//@ pure
	public Boolean isOpen() {
		return open;
	}
}
