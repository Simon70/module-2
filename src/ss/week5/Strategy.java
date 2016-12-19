package ss.week5;

import ss.week5.tictactoe.Board;
import ss.week5.tictactoe.Mark;

public interface Strategy {
    String getName();

    int determineMove(Board b, Mark m);
}
