package ss.week3.pw;

/**
 * Created by simon on 28.11.16.
 */
public interface IChecker {
    //@ pure
    boolean acceptable(String suggestion);

    String generatePassword();
}
