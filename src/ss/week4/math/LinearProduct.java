package ss.week4.math;

/**
 * Created by simon on 28.11.16.
 */
public class LinearProduct extends Product implements Integrandable {

	public LinearProduct(Function func0, Function func1) {
		super(func0, func1);
	}

	@Override
	/**
	 * Override to optimize it and do less calculations.
	 */
	public Function derivative() {
		//Apply 1 to get the double of the constant.{
		return new LinearProduct((Constant) func0, func1.derivative());
	}

	@Override
	public Function integrand() {
		return (func1 instanceof Integrandable)	? new LinearProduct(new Constant(func0.apply(1)),
																	((Integrandable) func1).integrand())
												: null;
	}

	@Override
	public String toString() {
		return func0.toString() + " * " + func1.toString();
	}
}
