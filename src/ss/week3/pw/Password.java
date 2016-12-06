package ss.week3.pw;

/**
 * Created by simon on 16.11.16.
 */
public class Password {
    public static String INITIAL;
    private IChecker checker;
    private String factoryPassword;

    private /*@ spec_public @*/ String password;

    public Password(IChecker checker, String factoryPassword) {
        this.checker = checker;
        this.factoryPassword = factoryPassword;
        this.password = factoryPassword;

    }

    //@ ensures password == INITIAL;
    public Password() {
        this(new BasicChecker(), BasicChecker.INITPASS);
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
