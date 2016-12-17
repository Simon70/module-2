package ss.week5.tictactoe;


/**
 * Created by simon on 13.12.16.
 */
public class ComputerPlayer extends Player {

    public static final Strategy DEFAULT_STRATEGY = new NaiveStrategy();

    private Strategy strategy;

    /**
     * Creates a new Player object.
     *
     * @param mark
     */
    public ComputerPlayer(Mark mark, Strategy strategy) {
        super(strategy.getName() + " - " + mark, mark);
        this.strategy = strategy;
    }

    /**
     * Creates a new Player object.
     *
     * @param mark
     */
    public ComputerPlayer(Mark mark) {
        super(DEFAULT_STRATEGY.getName() + " - " + mark, mark);
        this.strategy = DEFAULT_STRATEGY;
    }

    @Override
    public int determineMove(Board board) {
        return strategy.determineMove(board, getMark());
    }
}
