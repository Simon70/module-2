package ss.week5.tictactoe;


/**
 * Executable class for the game Tic Tac Toe. The game can be played against the
 * computer. Lab assignment Module 2
 *
 * @author Theo Ruys
 * @version $Revision: 1.4 $
 */
public class TicTacToe {
    public static void main(String[] args) {
        Player p0 = getPlayerFromArgument(args[0], Mark.OO);
        Player p1 = getPlayerFromArgument(args[1], Mark.XX);

        Game game = new Game(p0, p1);
        game.start();
    }

    private static Player getPlayerFromArgument(String argument, Mark mark) {
        switch (argument) {
            case "-N":
                return new ComputerPlayer(mark, new NaiveStrategy());
            case "-S":
                return new ComputerPlayer(mark, new SmartStrategy());
            default:
                return new HumanPlayer(argument, mark);
        }
    }
}