package ss.week1;

/**
 * Created by simon on 16.11.16.
 */
public class Password {
<<<<<<< HEAD
=======
    public static final String INITIAL = "123456";

    private String password;

    public Password() {
        password = INITIAL;
    }

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

    public boolean testWord(String test) {
        return password.equals(test);
    }
>>>>>>> branch 'master' of https://github.com/Simon70/module-2.git
}
