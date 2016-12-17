package ss.week5.tictactoe;

/**
 * Created by simon on 13.12.16.
 */
public interface Strategy {
    public String getName();

    public int determineMove(Board board, Mark mark);
}
