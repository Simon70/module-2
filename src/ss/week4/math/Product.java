package ss.week4.math;

/**
 * Created by simon on 28.11.16.
 */
public class Product implements Function {

    protected Function func0;
    protected Function func1;

    /**
     * Creates a function that is the product of two functions.
     *
     * @param func0 First function.
     * @param func1 Second function.
     */
    public Product(Function func0, Function func1) {
        this.func0 = func0;
        this.func1 = func1;
    }

    @Override
    public double apply(double x) {
        return func0.apply(x) * func1.apply(x);
    }

    @Override
    /**
     * derivative = derivative(func0) * func1 + func0 * derivative(func1)
     */
    public Function derivative() {
        return new Sum(new Product(func0.derivative(), func1), new Product(func0, func1.derivative()));
    }

	@Override
	public String toString() {
		return func0.toString() + " * " + func1.toString();
	}
}
