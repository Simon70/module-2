package ss.week4.math;

/**
 * Created by simon on 28.11.16.
 */
public class LinearProduct implements Function {
    private Function func0;
    private Function func1;

    public LinearProduct(Function func0, Function func1) {
        this.func0 = func0;
        this.func1 = func1;
    }

    @Override
    public double apply(double x) {
        return func0.apply(1) * func1.apply(x);
    }

    @Override
    public Function derivative() {
        return new LinearProduct(new Constant(func0.apply(1)), func1.derivative());
    }
}
