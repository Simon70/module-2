package ss.week3.pw;

import java.util.Random;

/**
 * Created by simon on 28.11.16.
 */
public class StrongChecker extends BasicChecker implements IChecker {
    @Override
    public boolean acceptable(String suggestion) {
        return (super.acceptable(suggestion) &&
                Character.isLetter(suggestion.codePointAt(0)) &&
                Character.isDigit(suggestion.charAt(suggestion.length() - 1)));
    }

    @Override
    //@ pure
    public String generatePassword() {
        return super.generatePassword() + new Random().nextInt(10000);
    }
}
