package ss.week4.math;

/**
 * Created by simon on 28.11.16.
 */
public class Constant implements Function {
    private double value;

    public Constant(double value) {
        this.value = value;
    }

    @Override
    public double apply(double x) {
        return value;
    }

    @Override
    public Function derivative() {
        return new Constant(0);
    }

}
