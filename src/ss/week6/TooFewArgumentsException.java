package ss.week6;

/**
 * Created by simon on 20.12.16.
 */
public class TooFewArgumentsException extends WrongArgumentException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TooFewArgumentsException(String s) {
        super(s);
    }

	public TooFewArgumentsException() {
        super("Too few arguments.");
    }
}
