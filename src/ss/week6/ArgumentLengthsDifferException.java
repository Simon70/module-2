package ss.week6;

/**
 * Created by simon on 20.12.16.
 */
public class ArgumentLengthsDifferException extends WrongArgumentException {
    public ArgumentLengthsDifferException(int length, int length1) {
        super("error: length of command line arguments differs (" + length + ", " + length1 + ")");
    }
}
