package ss.week5.tictactoe;

/**
 * Created by simon on 13.12.16.
 */

public interface Strategy {
    //@ pure
    //@ ensures this.getName().isEmpty() == false
    public String getName();

    //@ pure
    //@ requires !board.isFull()
    //@ requires board != null
    //@ ensures 0 <= \result < 9
    public int determineMove(Board board, Mark mark);
}
