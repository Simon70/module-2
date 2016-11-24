package ss.week2.hotel;

public class Safe {
	//@ assignable active;
	//@ assignable open;
	//@ assignable this.password;
	public Safe() {
		this.password = new Password();
		this.active = false;
		this.open = false;
	}
    private /*@ spec_public @*/ Password password;
    private /*@ spec_public @*/ Boolean active;
    private /*@ spec_public @*/ Boolean open;

    //@ assignable active;
    public void activate(String password) {
        if (this.password.testWord(password)) {
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
        if (active && this.password.testWord(password)) {
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