package ss.week3.hotel;

import java.util.Random;

/**
 * Created by simon on 28.11.16.
 */
public class BasicChecker implements IChecker {
    //@ pure
    @Override
    public boolean acceptable(String suggestion) {
        return (suggestion.length() > 5 && !suggestion.contains(" "));
    }

    @Override
    public String generatePassword() {
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            sb.append(getRandomChar(r));
        }
        return sb.toString();
    }

    char getRandomChar(Random random) {
        char x;
        do {
            x = (char) (65 + random.nextInt(122 - 65 + 1));
        } while (!Character.isAlphabetic(x));
        return x;
    }

}
