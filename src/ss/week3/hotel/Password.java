package ss.week3.hotel;

/**
 * Created by simon on 16.11.16.
 */
public class Password {
    public static final String INITIAL = "123456";

    private /*@ spec_public @*/ String password;

    private IChecker checker;

    //@ ensures password == INITIAL;
    public Password() {
        password = INITIAL;
    }

    public boolean setWord(String oldPass, String newPass) {
        if (password.equals(oldPass) && checker.acceptable(newPass)) {
            password = newPass;
            return true;
        }
        return false;
    }

    //@ pure
    public boolean testWord(String test) {
        return password.equals(test);
    }
}
