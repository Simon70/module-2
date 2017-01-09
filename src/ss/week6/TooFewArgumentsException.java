package ss.week6;

/**
 * Created by simon on 20.12.16.
 */
public class TooFewArgumentsException extends WrongArgumentException {
    public TooFewArgumentsException() {
        super("Too few arguments.");
    }
    public TooFewArgumentsException(String s) {
        super(s);
    }
}
