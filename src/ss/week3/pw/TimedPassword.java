package ss.week3.pw;

/**
 * Created by simon on 28.11.16.
 */
public class TimedPassword extends Password {
    public static final int EXTENDED_TIME = 5 * 60 * 1000;
    private /*@ spec_public @*/ long validTime;

    //@ensures this.validTime > 0;
    public TimedPassword(int validTime) {
        super();
        this.validTime = System.currentTimeMillis() + validTime * 1000;
    }

    //@ ensures validTime > 0;
    public boolean setWord(String oldPass, String newPass) {
        validTime = System.currentTimeMillis() + EXTENDED_TIME;
        return super.setWord(oldPass, newPass);
    }

    //@ pure
    public boolean testWord(String test) {
        return !isExpired() && super.testWord(test);
    }

    //@pure
    public boolean isExpired() {
        return System.currentTimeMillis() > validTime;
    }
}
