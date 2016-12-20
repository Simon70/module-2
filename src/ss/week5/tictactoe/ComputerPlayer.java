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
     * @ requires mark != null
     * @ requires strategy != null
     * @ ensures this.name == strategy.getName() + " - " + mark.toString()
     * @ ensures this.strategy == strategy
     */
    public ComputerPlayer(Mark mark, Strategy strategy) {
        super(strategy.getName() + " - " + mark, mark);
        this.strategy = strategy;
    }

    /**
     * Creates a new Player object.
     *
     * @ requires mark != null
     * @ ensures this.name == strategy.getName() + " - " + mark.toString()
     * @ ensures this.strategy == DEFAULT_STRATEGY
     */
    public ComputerPlayer(Mark mark) {
        super(DEFAULT_STRATEGY.getName() + " - " + mark, mark);
        this.strategy = DEFAULT_STRATEGY;
    }

    /**
     * @ pure
     * @ requires !board.isFull()
     * @ requires board != null
     * @ ensures 0 <= \result < 9
     */
    @Override
    public int determineMove(Board board) {
        return strategy.determineMove(board, getMark());
    }
}
