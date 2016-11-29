package ss.week4.math;

/**
 * Created by simon on 28.11.16.
 */
public class Exponent implements Function {
    private final double value;

    public Exponent(double value) {
        this.value = value;
    }

    @Override
    public double apply(double x) {
        return Math.pow(x, value);
    }

    @Override
    public Function derivative() {
        return new LinearProduct(new Constant(value), new Exponent(value - 1));
    }
}
