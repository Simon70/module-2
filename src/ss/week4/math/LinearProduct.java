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
		//Apply 1 to get the double of the constant.
		return new LinearProduct(new Constant(func0.apply(1)), func1.derivative());
	}

	@Override
	public Function integrand() {
		if (func1 instanceof Integrandable) {
			Integrandable fun1Integrand = (Integrandable) func1;
			return new LinearProduct(new Constant(func0.apply(1)), fun1Integrand.integrand());
		} else {
			return null;
		}
	}

	//	/**
	//	 * Create a function that is the product of two constant functions.
	//	 * 
	//	 * @param func0
	//	 *            First constant function.
	//	 * @param func1
	//	 *            Second constant function.
	//	 */
	//	public LinearProduct(Function func0, Function func1) {
	//		this.func0 = func0;
	//		this.func1 = func1;
	//	}
	//
	//	@Override
	//	public double apply(double x) {
	//		return func0.apply(1) * func1.apply(x);
	//	}
	//
	//	@Override
	//	public Function derivative() {
	//		return new LinearProduct(new Constant(func0.apply(1)), func1.derivative());
	//	}
}
