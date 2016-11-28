package ss.week3.hotel;

import java.util.Random;

/**
 * Created by simon on 28.11.16.
 */
public class StrongChecker extends BasicChecker implements IChecker {
    @Override
    public boolean acceptable(String suggestion) {
        return (super.acceptable(suggestion) &&
                Character.isAlphabetic(suggestion.codePointAt(0)) &&
                Character.isDigit(suggestion.codePointAt(suggestion.length() - 1)));
    }

    @Override
    public String generatePassword() {
        return super.generatePassword() + new Random().nextInt(10000);
    }
}