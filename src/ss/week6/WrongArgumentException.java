package ss.week6;

/**
 * Created by simon on 20.12.16.
 */
public class WrongArgumentException extends Exception {
    public WrongArgumentException() {
        super("Wrong argument.");
    }

    public WrongArgumentException(String s) {
        super(s);
    }
}
