package ss.week5.tictactoe;

import java.util.Random;

/**
 * Created by simon on 17.12.16.
 */
public class SmartStrategy implements Strategy {

    public static final int DIM = 3;
    public static final int[][][] COMBINATIONS = {{{0, 0}, {0, 1}, {0, 2}},
            {{1, 0}, {1, 1}, {1, 2}},
            {{2, 0}, {2, 1}, {2, 2}},
            {{0, 0}, {1, 0}, {2, 0}},
            {{0, 1}, {1, 1}, {2, 1}},
            {{0, 2}, {1, 2}, {2, 2}},
            {{0, 0}, {1, 1}, {2, 2}},
            {{2, 0}, {1, 1}, {0, 2}},};

    @Override
    public String getName() {
        return "Smart";
    }

    @Override
    public int determineMove(Board board, Mark mark) {
        int[][] myBoard = getBoard(board, mark);
        // print field after conversion
//        for (int i = 0; i < DIM; i++) {
//            System.out.println(Arrays.toString(myBoard[i]));
//        }

        // check middle
        if (myBoard[1][1] == 0) {
            return board.index(1, 1);
        }

        // check rows, colmns and diagonals
        for (int[][] row : COMBINATIONS) {
            int score = getScore(myBoard, row);
            if (score == 2 || score == -2) {
                return findFreeSpotInPositions(myBoard, row);
            }
        }

//        System.out.println("Resorting to randomness");
        return new Random().nextInt(9);
    }

    /**
     * Converts the enum-board to a more sensible format.
     *
     * @param board the board to be convered
     * @param mark  the mark your player has (dosn't really matter though)
     * @return a new board that can be understood by my algorithm
     */
    private int[][] getBoard(Board board, Mark mark) {
        int[][] output = new int[DIM][DIM];
        for (int i = 0; i < DIM; i++) {
            for (int k = 0; k < DIM; k++) {
                if (board.getField(i, k).equals(mark)) {
                    output[i][k] = 1;
                } else if (board.getField(i, k).equals(mark.other())) {
                    output[i][k] = -1;
                }
                // else it's gonna be 0 anyway.
            }
        }
        return output;
    }

    /**
     * Determines a score for an array of positions.
     * If this score hits 2 or -2 then this row is almost filled with either firendly or enermy marks.
     *
     * @param board     the board that has to be evaluated
     * @param positions the array of positions on the given board that have to be evaluated
     * @return score for this array of points
     */
    private int getScore(int[][] board, int[][] positions) {
        int score = 0;
        for (int[] position : positions) {
            score += board[position[0]][position[1]];
        }
        return score;
    }

    /**
     * Finds the free spot in the given array of positions for the mark to be inserted.
     *
     * @param board     the board that had to be evaluated
     * @param positions the array of positions on the given board that have to be evaluated
     * @return the free position or -1 if there is no free spot
     */
    private int findFreeSpotInPositions(int[][] board, int[][] positions) {
        for (int[] position : positions) {
            if (board[position[0]][position[1]] == 0) {
                return position[0] * DIM + position[1];
            }
        }
        return -1;
    }

}
































