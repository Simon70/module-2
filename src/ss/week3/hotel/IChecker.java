package ss.week3.hotel;

/**
 * Created by simon on 28.11.16.
 */
public interface IChecker {
    //@ pure
    boolean acceptable(String suggestion);

    String generatePassword();
}
