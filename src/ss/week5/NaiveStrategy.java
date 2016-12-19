package ss.week5;

import java.util.HashSet;
import java.util.Set;

import ss.week5.tictactoe.*;

public class NaiveStrategy extends ss.week5.tictactoe.Player implements Strategy{
	public NaiveStrategy(String name, Mark mark) {
		super(name, mark);
		fields =  new HashSet<Mark>();
	}

	Set<Mark> fields;

	@Override
	public String getName() {
		return "Naive";
	}

	@Override
	public int determineMove(Board b, Mark m) {
		return 0;
	}

	@Override
	public int determineMove(Board board) {
		// TODO Auto-generated method stub
		return 0;
	}

}
