package ss.week2.hotel;

public class Safe {
    private /*@ spec_public @*/ Password password;
    private boolean active;
    private boolean open;

    //@ assignable this.password;
    //@ ensures this.isActive() == false;
    //@ ensures this.isOpen() == false;
    public Safe() {
        this.password = new Password();
        this.active = false;
        this.open = false;
    }

    public static void main(String[] args) {
        Safe safe = new Safe();
        safe.activate(null);
    }

    //@ invariant this.isOpen() ==> this.isActive();
    //@ ensures this.password.testWord(password) ==> this.isActive();
    public void activate(String password) {
        assert password != null : "Password text may not be null.";
        if (this.password.testWord(password)) {
            active = true;
        }
    }

    //@ ensures isOpen() == false;
    //@ ensures isActive() == false;
    //@ requires isActive() == true;
    public void deactivate() {
        if (isActive()) {
            open = false;
            active = false;
        }
    }

    //@ requires isActive();
    //@ ensures (isActive() && this.password.testWord(password)) ==> isOpen();
    public void open(String password) {
        assert password != null : "Password text may not be null.";
        if (active && this.password.testWord(password)) {
            open = true;
        }
    }

    //@ ensures isOpen() == false;
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
