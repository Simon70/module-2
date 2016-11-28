package ss.week3.hotel;

/**
 * Created by simon on 16.11.16.
 */
public class Password {
    public static final String INITIAL = "123456";

    private /*@ spec_public @*/ String password;

    //@ ensures password == INITIAL;
    public Password() {
        password = INITIAL;
    }

    //@ pure
    public boolean acceptable(String suggestion) {
        return (suggestion.length() > 5 && !suggestion.contains(" "));
    }

    public boolean setWord(String oldPass, String newPass) {
        if (password.equals(oldPass) && acceptable(newPass)) {
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
