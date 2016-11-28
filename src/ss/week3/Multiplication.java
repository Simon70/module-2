package ss.week3;

/**
 * Created by simon on 28.11.16.
 */
public class Multiplication implements OperatorWithIdentity {
    @Override
    public int operate(int left, int right) {
        return left * right;
    }

    @Override
    public int identity() {
        return 1;
    }
}
