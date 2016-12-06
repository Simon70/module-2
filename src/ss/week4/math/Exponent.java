package ss.week4.math;

/**
 * Created by simon on 28.11.16.
 */
public class Exponent implements Function, Integrandable {

	private final int value;

	/**
	 * A function x^n where n is the argument.
	 * 
	 * @param value
	 */
	public Exponent(int value) {
		this.value = value;
	}

	@Override
	public double apply(double x) {
		return Math.pow(x, value);
	}

	@Override
	/**
	 * Derivative = n*x^(n-1)
	 */
	public Function derivative() {
		return new LinearProduct(new Constant(value), new Exponent(value - 1));
	}

	@Override
	public Function integrand() {
		LinearProduct lp = new LinearProduct(new Constant(1d / (value + 1d)), new Exponent(value + 1));
		return lp;
	}

	@Override
	public String toString() {
		return "x^" + value;
	}
}
