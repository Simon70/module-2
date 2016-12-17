package ss.week5.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by simon on 13.12.16.
 */
public class NaiveStrategy implements Strategy {

    public static final String NAME = "Naive";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public int determineMove(Board board, Mark mark) {
        List<Integer> fields = new ArrayList<>();
        for (int i = 0; board.isField(i); i++) {
            if (board.isEmptyField(i)) {
                fields.add(i);
            }
        }
        return fields.get(new Random().nextInt(fields.size()));
    }
}
